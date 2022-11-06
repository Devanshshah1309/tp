package seedu.address.testutil;

import static seedu.address.logic.parser.CliSyntax.FLAG_COMPLETE_TASKS_STR;
import static seedu.address.logic.parser.CliSyntax.FLAG_INCOMPLETE_TASKS_STR;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import picocli.CommandLine;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.Command;
import seedu.address.logic.parser.Order;
import seedu.address.model.person.Email;
import seedu.address.model.person.EmailContainsKeywordsPredicate;
import seedu.address.model.person.Name;
import seedu.address.model.person.NameContainsKeywordsPredicate;
import seedu.address.model.person.Phone;
import seedu.address.model.team.Description;
import seedu.address.model.team.LinkName;
import seedu.address.model.team.Task;
import seedu.address.model.team.TaskName;
import seedu.address.model.team.TaskNameContainsKeywordsPredicate;
import seedu.address.model.team.TeamName;
import seedu.address.model.team.Url;

/**
 * Utility class that helps to retrieve fields in command objects.
 */
public class ParserHelper {
    public static Name getName(Command command) {
        CommandLine.Model.CommandSpec commandSpec = CommandLine.Model.CommandSpec.forAnnotatedObject(command);
        List<CommandLine.Model.ArgSpec> args = commandSpec.args();
        for (int i = 0; i < args.size(); i++) {
            CommandLine.Model.ArgSpec arg = args.get(i);
            if (arg.paramLabel().equals("<name>")) {
                return arg.getValue();
            }
        }
        return null;
    }

    public static Email getEmail(Command command) {
        CommandLine.Model.CommandSpec commandSpec = CommandLine.Model.CommandSpec.forAnnotatedObject(command);
        List<CommandLine.Model.ArgSpec> args = commandSpec.args();
        for (int i = 0; i < args.size(); i++) {
            CommandLine.Model.ArgSpec arg = args.get(i);
            if (arg.paramLabel().equals("<email>")) {
                return arg.getValue();
            }
        }
        return null;
    }

    public static Phone getPhone(Command command) {
        CommandLine.Model.CommandSpec commandSpec = CommandLine.Model.CommandSpec.forAnnotatedObject(command);
        List<CommandLine.Model.ArgSpec> args = commandSpec.args();
        for (int i = 0; i < args.size(); i++) {
            CommandLine.Model.ArgSpec arg = args.get(i);
            if (arg.paramLabel().equals("<phone>")) {
                return arg.getValue();
            }
        }
        return null;
    }

    public static Index getIndex(Command command) {
        CommandLine.Model.CommandSpec commandSpec = CommandLine.Model.CommandSpec.forAnnotatedObject(command);
        List<CommandLine.Model.ArgSpec> args = commandSpec.args();
        for (int i = 0; i < args.size(); i++) {
            CommandLine.Model.ArgSpec arg = args.get(i);
            if (arg.paramLabel().equals("<index>")) {
                return arg.getValue();
            }
        }
        return null;
    }

    public static LinkName getLinkName(Command command) {
        CommandLine.Model.CommandSpec commandSpec = CommandLine.Model.CommandSpec.forAnnotatedObject(command);
        List<CommandLine.Model.ArgSpec> args = commandSpec.args();
        for (int i = 0; i < args.size(); i++) {
            CommandLine.Model.ArgSpec arg = args.get(i);
            if (arg.paramLabel().equals("<name>")) {
                return arg.getValue();
            }
        }
        return null;
    }

    public static Url getUrl(Command command) {
        CommandLine.Model.CommandSpec commandSpec = CommandLine.Model.CommandSpec.forAnnotatedObject(command);
        List<CommandLine.Model.ArgSpec> args = commandSpec.args();
        for (int i = 0; i < args.size(); i++) {
            CommandLine.Model.ArgSpec arg = args.get(i);
            if (arg.paramLabel().equals("<url>")) {
                return arg.getValue();
            }
        }
        return null;
    }

    public static Task getTask(Command command) {
        CommandLine.Model.CommandSpec commandSpec = CommandLine.Model.CommandSpec.forAnnotatedObject(command);
        List<CommandLine.Model.ArgSpec> args = commandSpec.args();
        for (int i = 0; i < args.size(); i++) {
            CommandLine.Model.ArgSpec arg = args.get(i);
            if (arg.paramLabel().equals("<task>")) {
                return arg.getValue();
            }
        }
        return null;
    }

    public static TaskName getTaskName(Command command) {
        CommandLine.Model.CommandSpec commandSpec = CommandLine.Model.CommandSpec.forAnnotatedObject(command);
        List<CommandLine.Model.ArgSpec> args = commandSpec.args();
        for (int i = 0; i < args.size(); i++) {
            CommandLine.Model.ArgSpec arg = args.get(i);
            if (arg.paramLabel().equals("<taskName>")) {
                return arg.getValue();
            }
        }
        return null;
    }

    public static TeamName getTeamName(Command command) {
        CommandLine.Model.CommandSpec commandSpec = CommandLine.Model.CommandSpec.forAnnotatedObject(command);
        List<CommandLine.Model.ArgSpec> args = commandSpec.args();
        for (int i = 0; i < args.size(); i++) {
            CommandLine.Model.ArgSpec arg = args.get(i);
            if (arg.paramLabel().equals("<teamName>")) {
                return arg.getValue();
            }
        }
        return null;
    }

    public static Description getDescription(Command command) {
        CommandLine.Model.CommandSpec commandSpec = CommandLine.Model.CommandSpec.forAnnotatedObject(command);
        List<CommandLine.Model.ArgSpec> args = commandSpec.args();
        for (int i = 0; i < args.size(); i++) {
            CommandLine.Model.ArgSpec arg = args.get(i);
            if (arg.paramLabel().equals("<description>")) {
                return arg.getValue();
            }
        }
        return null;
    }

    public static Order getOrder(Command command) {
        CommandLine.Model.CommandSpec commandSpec = CommandLine.Model.CommandSpec.forAnnotatedObject(command);
        List<CommandLine.Model.ArgSpec> args = commandSpec.args();
        for (int i = 0; i < args.size(); i++) {
            CommandLine.Model.ArgSpec arg = args.get(i);
            if (arg.paramLabel().equals("<order>")) {
                return arg.getValue();
            }
        }
        return null;
    }

    public static ArrayList<Index> getAssignees(Command command) {
        CommandLine.Model.CommandSpec commandSpec = CommandLine.Model.CommandSpec.forAnnotatedObject(command);
        List<CommandLine.Model.ArgSpec> args = commandSpec.args();
        for (int i = 0; i < args.size(); i++) {
            CommandLine.Model.ArgSpec arg = args.get(i);
            if (arg.paramLabel().equals("<assignees>")) {
                return arg.getValue();
            }
        }
        return null;
    }

    public static LocalDateTime getDeadline(Command command) {
        CommandLine.Model.CommandSpec commandSpec = CommandLine.Model.CommandSpec.forAnnotatedObject(command);
        List<CommandLine.Model.ArgSpec> args = commandSpec.args();
        for (int i = 0; i < args.size(); i++) {
            CommandLine.Model.ArgSpec arg = args.get(i);
            if (arg.paramLabel().equals("<deadline>")) {
                return arg.getValue();
            }
        }
        return null;
    }

    public static NameContainsKeywordsPredicate getNameContainsKeywordsPredicate(Command command) {
        CommandLine.Model.CommandSpec commandSpec = CommandLine.Model.CommandSpec.forAnnotatedObject(command);
        List<CommandLine.Model.ArgSpec> args = commandSpec.args();
        for (int i = 0; i < args.size(); i++) {
            CommandLine.Model.ArgSpec arg = args.get(i);
            if (arg.paramLabel().equals("nameKeywords")) {
                return arg.getValue();
            }
        }
        return null;
    }
    public static TaskNameContainsKeywordsPredicate getTaskNameContainsKeywordsPredicate(Command command) {
        CommandLine.Model.CommandSpec commandSpec = CommandLine.Model.CommandSpec.forAnnotatedObject(command);
        List<CommandLine.Model.ArgSpec> args = commandSpec.args();
        for (int i = 0; i < args.size(); i++) {
            CommandLine.Model.ArgSpec arg = args.get(i);
            if (arg.paramLabel().equals("nameKeywords")) {
                return arg.getValue();
            }
        }
        return null;
    }

    public static EmailContainsKeywordsPredicate getEmailContainsKeywordsPredicate(Command command) {
        CommandLine.Model.CommandSpec commandSpec = CommandLine.Model.CommandSpec.forAnnotatedObject(command);
        List<CommandLine.Model.ArgSpec> args = commandSpec.args();
        for (int i = 0; i < args.size(); i++) {
            CommandLine.Model.ArgSpec arg = args.get(i);
            if (arg.paramLabel().equals("emailKeywords")) {
                return arg.getValue();
            }
        }
        return null;
    }


    public static boolean getIsComplete(Command command) {
        CommandLine.Model.CommandSpec commandSpec = CommandLine.Model.CommandSpec.forAnnotatedObject(command);
        boolean value = commandSpec.findOption(FLAG_COMPLETE_TASKS_STR).getValue();
        return value;
    }

    public static boolean getIsIncomplete(Command command) {
        CommandLine.Model.CommandSpec commandSpec = CommandLine.Model.CommandSpec.forAnnotatedObject(command);
        boolean value = commandSpec.findOption(FLAG_INCOMPLETE_TASKS_STR).getValue();
        return value;
    }
}
