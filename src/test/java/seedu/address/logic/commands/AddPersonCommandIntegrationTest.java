package seedu.address.logic.commands;

import static seedu.address.testutil.TypicalPersons.getTypicalTruthTable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

/**
 * Contains integration tests (interaction with the Model) for {@code AddPersonCommand}.
 */
// TODO: Add implementation for tests
public class AddPersonCommandIntegrationTest {

    private Model model;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalTruthTable(), new UserPrefs());
    }

    @Test
    public void execute_newPerson_success() {
    }

    @Test
    public void execute_duplicatePerson_throwsCommandException() {
    }

}
