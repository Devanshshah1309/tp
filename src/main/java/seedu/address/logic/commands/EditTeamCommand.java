package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.FLAG_DESCRIPTION_LONG;
import static seedu.address.logic.parser.CliSyntax.FLAG_DESCRIPTION_STR;
import static seedu.address.logic.parser.CliSyntax.FLAG_NAME_STR;
import static seedu.address.logic.parser.CliSyntax.FLAG_NAME_STR_LONG;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import picocli.CommandLine;
import seedu.address.commons.util.CollectionUtil;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Person;
import seedu.address.model.team.Link;
import seedu.address.model.team.Task;
import seedu.address.model.team.Team;

/**
 * Edits the currently set team.
 */
@CommandLine.Command(name = "team")
public class EditTeamCommand extends Command {
    public static final String COMMAND_WORD = "edit team";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Edits the current team \n"
            + "Parameters: "
            + "[" + FLAG_NAME_STR + " TEAM_NAME] "
            + "[" + FLAG_DESCRIPTION_STR + " TEAM_DESCRIPTION] \n"
            + "Example:\n"
            + "1. " + COMMAND_WORD + " "
            + FLAG_NAME_STR + " CS2103T "
            + FLAG_DESCRIPTION_STR + " \"A team to manage CS2103T\"\n"
            + "2. " + COMMAND_WORD + " "
            + FLAG_NAME_STR + " CS2102 ";

    public static final String MESSAGE_EDIT_TEAM_SUCCESS = "Edited team: %1$s";

    public static final String MESSAGE_NOT_EDITED = "At least one field to edit must be provided.";

    public static final String MESSAGE_DUPLICATE_TEAM = "This team name already exists in the address book.";
    @CommandLine.ArgGroup(exclusive = false, multiplicity = "1")
    private Arguments arguments;

    private static class Arguments {
        @CommandLine.Option(names = {FLAG_NAME_STR, FLAG_NAME_STR_LONG})
        private String name;

        @CommandLine.Option(names = {FLAG_DESCRIPTION_STR, FLAG_DESCRIPTION_LONG})
        private String description;
    }

    private final EditTeamDescriptor editTeamDescriptor;

    public EditTeamCommand() {
        this.editTeamDescriptor = new EditTeamDescriptor();
    }

    /**
     * Creates and returns a {@code Team} with the details of {@code teamToEdit}
     * edited with {@code editTeamDescriptor}.
     */
    private static Team createEditedTeam(Team teamToEdit, EditTeamDescriptor editTeamDescriptor) {
        assert editTeamDescriptor != null;

        String updatedName = editTeamDescriptor.getName().orElse(teamToEdit.getTeamName());
        String updatedDescription = editTeamDescriptor.getDescription().orElse(teamToEdit.getDescription());
        List<Person> members = teamToEdit.getTeamMembers();
        List<Task> tasks = teamToEdit.getTaskList();
        List<Link> links = teamToEdit.getLinkList();

        return new Team(updatedName, updatedDescription, members, tasks, links);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (arguments.name != null) {
            editTeamDescriptor.name = arguments.name;
        }
        if (arguments.description != null) {
            editTeamDescriptor.description = arguments.description;
        }

        Team currentTeam = model.getTeam();
        Team editedTeam = createEditedTeam(currentTeam, editTeamDescriptor);
        List<Team> teamList = model.getTeamList();
        List<Team> teamListCopy = new ArrayList<>(teamList);

        if ((!editedTeam.isSameTeam(currentTeam)) && (teamListCopy.contains(editedTeam))) {
            throw new CommandException(MESSAGE_DUPLICATE_TEAM);
        }

        int currentIndex = teamListCopy.indexOf(currentTeam);
        teamListCopy.set(currentIndex, editedTeam);
        model.setTeam(editedTeam);
        model.setTeams(teamListCopy);

        return new CommandResult(String.format(MESSAGE_EDIT_TEAM_SUCCESS, editedTeam));
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof EditTeamCommand)) {
            return false;
        }

        // state check
        EditTeamCommand e = (EditTeamCommand) other;
        return editTeamDescriptor.equals(e.editTeamDescriptor);
    }

    /**
     * Stores the details to edit the team with. Each non-empty field value will replace the
     * corresponding field value of the team.
     */
    public static class EditTeamDescriptor {
        private String name;

        private String description;

        public EditTeamDescriptor() {
        }

        /**
         * Copy constructor.
         */
        public EditTeamDescriptor(EditTeamDescriptor toCopy) {
            setName(toCopy.name);
            setDescription(toCopy.description);
        }

        /**
         * Returns true if at least one field is edited.
         */
        public boolean isAnyFieldEdited() {
            return CollectionUtil.isAnyNonNull(name, description);
        }

        public Optional<String> getName() {
            return Optional.ofNullable(name);
        }

        public void setName(String name) {
            this.name = name;
        }

        public Optional<String> getDescription() {
            return Optional.ofNullable(description);
        }

        public void setDescription(String description) {
            this.description = description;
        }

        @Override
        public boolean equals(Object other) {
            // short circuit if same object
            if (other == this) {
                return true;
            }

            // instanceof handles nulls
            if (!(other instanceof EditTeamDescriptor)) {
                return false;
            }

            // state check
            EditTeamDescriptor descriptor = (EditTeamDescriptor) other;

            return getName().equals(descriptor.getName())
                    && getDescription().equals(descriptor.getDescription());
        }

    }
}