package seedu.address.logic.commands;

import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

// TODO: Add implementation for tests
class EditLinkCommandTest {

    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    void execute_linkNothingEdited_throwsCommandException() {
    }

    @Test
    void testEquals() {
    }
}