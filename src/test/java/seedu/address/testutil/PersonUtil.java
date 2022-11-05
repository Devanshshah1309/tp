package seedu.address.testutil;

import static seedu.address.logic.parser.CliSyntax.FLAG_EMAIL_STR;
import static seedu.address.logic.parser.CliSyntax.FLAG_NAME_STR;
import static seedu.address.logic.parser.CliSyntax.FLAG_PHONE_STR;
import static seedu.address.logic.parser.CliSyntax.FLAG_TAG_STR;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import seedu.address.logic.commands.AddPersonCommand;
import seedu.address.logic.commands.EditPersonCommand.EditPersonDescriptor;
import seedu.address.model.person.Person;
import seedu.address.model.tag.Tag;

/**
 * A utility class for Person.
 */
public class PersonUtil {

    /**
     * Returns an add command string for adding the {@code person}.
     */
    public static String getAddPersonCommand(Person person) {
        return AddPersonCommand.COMMAND_WORD + " " + getPersonDetails(person);
    }

    /**
     * Returns the part of command string for the given {@code person}'s details.
     */
    public static String getPersonDetails(Person person) {
        StringBuilder sb = new StringBuilder();
        sb.append("-" + FLAG_NAME_STR + "\"").append(person.getName().fullName).append("\" ");
        sb.append("-" + FLAG_PHONE_STR + "\"").append(person.getPhone().value).append("\" ");
        sb.append("-" + FLAG_EMAIL_STR + "\"").append(person.getEmail().value).append("\" ");
        person.getTags().stream().forEach(
                s -> sb.append("-" + FLAG_TAG_STR + "\"").append(s.tagName).append("\" ")
        );
        return sb.toString();
    }

    /**
     * @param person
     * @return String array containing person fields
     */
    public static String[] convertPersonToArgs(Person person) {
        List<String> argList = new ArrayList<>();
        argList.add(FLAG_NAME_STR);
        argList.add(person.getName().fullName);
        argList.add(FLAG_PHONE_STR);
        argList.add(person.getPhone().value);
        argList.add(FLAG_EMAIL_STR);
        argList.add(person.getEmail().value);
        if (!person.getTags().isEmpty()) {
            argList.add(FLAG_TAG_STR);
            for (Tag t : person.getTags()) {
                argList.add(t.tagName);
            }
        }
        return argList.toArray(new String[0]);
    }

    /**
     * @param person
     * @return String array containing person fields
     */
    public static String[] convertEditPersonToArgs(Person person) {
        List<String> argList = new ArrayList<>();
        argList.add("2");
        argList.add(FLAG_NAME_STR);
        argList.add(person.getName().fullName);
        argList.add(FLAG_PHONE_STR);
        argList.add(person.getPhone().value);
        argList.add(FLAG_EMAIL_STR);
        argList.add(person.getEmail().value);
        if (!person.getTags().isEmpty()) {
            argList.add(FLAG_TAG_STR);
            for (Tag t : person.getTags()) {
                argList.add(t.tagName);
            }
        }
        return argList.toArray(new String[0]);
    }

    /**
     * @param person
     * @return String array containing person fields
     */
    public static String[] convertEditFirstPersonPartialToArgs(Person person) {
        List<String> argList = new ArrayList<>();
        argList.add("1");
        argList.add(FLAG_NAME_STR);
        argList.add(person.getName().fullName);
        argList.add(FLAG_PHONE_STR);
        argList.add(person.getPhone().value);
        return argList.toArray(new String[0]);
    }

    /**
     * @param person
     * @return String array containing person fields
     */
    public static String[] convertEditSecondPersonPartialToArgs(Person person) {
        List<String> argList = new ArrayList<>();
        argList.add("2");
        argList.add(FLAG_NAME_STR);
        argList.add(person.getName().fullName);
        argList.add(FLAG_PHONE_STR);
        argList.add(person.getPhone().value);
        return argList.toArray(new String[0]);
    }

    /**
     * @param person
     * @return String array containing person fields
     */
    public static String[] convertEditPersonOutOfBoundsToArgs(Person person) {
        List<String> argList = new ArrayList<>();
        argList.add("20");
        argList.add(FLAG_NAME_STR);
        argList.add(person.getName().fullName);
        argList.add(FLAG_PHONE_STR);
        argList.add(person.getPhone().value);
        return argList.toArray(new String[0]);
    }

    /**
     * Returns the part of command string for the given {@code EditPersonDescriptor}'s details.
     */
    public static String getEditPersonDescriptorDetails(EditPersonDescriptor descriptor) {
        StringBuilder sb = new StringBuilder();
        descriptor.getName().ifPresent(name -> sb.append(
                "-" + FLAG_NAME_STR).append(" \"").append(name.fullName).append("\"").append(" "));
        descriptor.getPhone().ifPresent(phone -> sb.append(
                "-" + FLAG_PHONE_STR).append(" \"").append(phone.value).append("\"").append(" "));
        descriptor.getEmail().ifPresent(email -> sb.append(
                "-" + FLAG_EMAIL_STR).append(" \"").append(email.value).append("\"").append(" "));
        if (descriptor.getTags().isPresent()) {
            Set<Tag> tags = descriptor.getTags().get();
            if (tags.isEmpty()) {
                sb.append("-" + FLAG_TAG_STR);
            } else {
                tags.forEach(s -> sb.append("-" + FLAG_TAG_STR + " ").append(s.tagName).append(" "));
            }
        }
        return sb.toString();
    }
}
