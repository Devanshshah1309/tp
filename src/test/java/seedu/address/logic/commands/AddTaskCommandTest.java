package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalPersons.getTypicalTruthTable;

import org.junit.jupiter.api.Test;

import picocli.CommandLine;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.TaskNameConverter;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.team.Task;
import seedu.address.model.team.TaskName;
import seedu.address.testutil.TaskUtil;
import seedu.address.testutil.TypicalPersons;
import seedu.address.testutil.TypicalTasks;

// TODO: Add implementation for tests
class AddTaskCommandTest {

    private Model model = new ModelManager(getTypicalTruthTable(), new UserPrefs());
    private Model expectedModel = model;
    private final Command commandToBeTested = new AddTaskCommand();
    private final CommandLine commandLine = new CommandLine(commandToBeTested)
            .registerConverter(TaskName.class, new TaskNameConverter());

    @Test
    public void execute_allFieldsSpecifiedUnfilteredList_success() {
        model.getTeam().addMember(TypicalPersons.ALICE);
        Task validTask = TypicalTasks.TASK_3;
        commandLine.parseArgs(TaskUtil.convertTaskToArgs(validTask));
        CommandResult expectedResult = new CommandResult(String.format(AddTaskCommand.MESSAGE_ADD_TASK_SUCCESS,
                validTask));
        assertCommandSuccess(commandToBeTested, model, expectedResult, expectedModel);
    }

    @Test
    public void execute_someFieldsSpecifiedUnfilteredList_success() {
        model.getTeam().addMember(TypicalPersons.ALICE);
        Task validTask = TypicalTasks.TASK_3;
        Task validPartialTask = TypicalTasks.TASK_3_NO_DEADLINE;
        commandLine.parseArgs(TaskUtil.convertPartialTaskToArgs(validTask));
        CommandResult expectedResult = new CommandResult(String.format(AddTaskCommand.MESSAGE_ADD_TASK_SUCCESS,
                validPartialTask));
        assertCommandSuccess(commandToBeTested, model, expectedResult, expectedModel);
    }

    @Test
    public void execute_duplicateTask_throwsCommandException() {
    }

    @Test
    public void execute_invalidPersonIndexUnfilteredList_failure() {
        Task validTask = TypicalTasks.TASK_3;
        commandLine.parseArgs(TaskUtil.convertTaskToArgs(validTask));
        assertThrows(CommandException.class, AddTaskCommand.MESSAGE_MEMBER_INDEX_OUT_OF_BOUNDS, ()
                -> commandToBeTested.execute(model));
    }

    @Test
    public void equals() {
    }
}
