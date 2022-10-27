package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.FLAG_DESCRIPTION_LONG;
import static seedu.address.logic.parser.CliSyntax.FLAG_DESCRIPTION_STR;
import static seedu.address.logic.parser.CliSyntax.FLAG_HELP_DESCRIPTION;
import static seedu.address.logic.parser.CliSyntax.FLAG_HELP_STR;
import static seedu.address.logic.parser.CliSyntax.FLAG_HELP_STR_LONG;
import static seedu.address.logic.parser.CliSyntax.FLAG_NAME_STR;
import static seedu.address.logic.parser.CliSyntax.FLAG_NAME_STR_LONG;
import static seedu.address.logic.parser.CliSyntax.FLAG_TEAM_DESCRIPTION_DESCRIPTION;
import static seedu.address.logic.parser.CliSyntax.FLAG_TEAM_NAME_DESCRIPTION;

import java.util.List;

import picocli.CommandLine;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.team.Team;

/**
 * Adds a new team to the address book.
 */
@CommandLine.Command(name = "team", mixinStandardHelpOptions = true)
public class AddTeamCommand extends Command {
    public static final String COMMAND_WORD = "add team";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Adds a new team \n"
            + "Parameters: "
            + FLAG_NAME_STR + " TEAM_NAME "
            + "[" + FLAG_DESCRIPTION_STR + " TEAM_DESCRIPTION] \n"
            + "Example:\n"
            + "1. " + COMMAND_WORD + " "
            + FLAG_NAME_STR + " CS2103T "
            + FLAG_DESCRIPTION_STR + " \"A team to manage CS2103T\"\n"
            + "2. " + COMMAND_WORD + " "
            + FLAG_NAME_STR + " CS2102 ";

    public static final String MESSAGE_ADD_TEAM_SUCCESS = "Added team: %1$s";

    public static final String MESSAGE_TEAM_EXISTS = "There is already an existing team with the same name!";

    @CommandLine.Option(names = {FLAG_NAME_STR, FLAG_NAME_STR_LONG}, required = true,
            description = FLAG_TEAM_NAME_DESCRIPTION)
    private String teamName;

    @CommandLine.Option(names = {FLAG_DESCRIPTION_STR, FLAG_DESCRIPTION_LONG}, defaultValue =
            Team.DEFAULT_DESCRIPTION, description = FLAG_TEAM_DESCRIPTION_DESCRIPTION)
    private String description;

    @CommandLine.Option(names = {FLAG_HELP_STR, FLAG_HELP_STR_LONG}, usageHelp = true,
            description = FLAG_HELP_DESCRIPTION)
    private boolean help;

    @CommandLine.Spec
    private CommandLine.Model.CommandSpec commandSpec;

    public AddTeamCommand() {
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        if (commandSpec.commandLine().isUsageHelpRequested()) {
            return new CommandResult(commandSpec.commandLine().getUsageMessage());
        }
        requireNonNull(model);
        Team team = new Team(teamName, description);
        List<Team> teamList = model.getTeamList();
        if (teamList.contains(team)) {
            throw new CommandException(MESSAGE_TEAM_EXISTS);
        }

        model.addTeam(team);
        return new CommandResult(String.format(MESSAGE_ADD_TEAM_SUCCESS, team));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddTeamCommand // instanceof handles nulls
                && teamName.equals(((AddTeamCommand) other).teamName)); // state check
    }

}
