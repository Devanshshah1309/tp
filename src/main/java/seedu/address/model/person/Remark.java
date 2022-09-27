package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

/**
 * Represents a Remark for a person in the address book.
 */
public class Remark {
    public final String value;

    /**
     * Creates a Remark object with the given value.
     *
     * @param remark
     */
    public Remark(String remark) {
        requireNonNull(remark);
        value = remark;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof Remark && value.equals(((Remark) other).value));
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
