package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import picocli.CommandLine;
import seedu.address.model.person.Name;
import seedu.address.model.person.NameContainsKeywordsPredicate;
import seedu.address.model.tag.Tag;

/**
 * Converter from {@code String} to {@code NameContainsKeywordsPredicate}.
 */
public class NameContainsKeywordsPredicateConverter implements
        CommandLine.IParameterConsumer {

    public static final String VALIDATION_REGEX = Name.VALIDATION_REGEX;
    @Override
    public void consumeParameters(Stack<String> args, CommandLine.Model.ArgSpec argSpec,
                                  CommandLine.Model.CommandSpec commandSpec) {
        List<String> keywords = new ArrayList<>();
        while (!args.isEmpty()) {
            String keyword = args.peek();
            if (!keyword.matches(VALIDATION_REGEX)) {
                break;
            }
            args.pop();
            keywords.add(keyword);
        }

        argSpec.setValue(new NameContainsKeywordsPredicate(keywords));
    }
}
