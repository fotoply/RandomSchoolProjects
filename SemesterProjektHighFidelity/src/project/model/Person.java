package project.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created 11/13/15
 *
 * @author Niels Norberg
 */
public class Person {
    // nameProperty - Used for storing and getting the name
    private final StringProperty nameProperty = new SimpleStringProperty(this, "name");
    // phoneNumberProperty - Used for storing and getting the phone number
    private final IntegerProperty phoneNumberProperty = new SimpleIntegerProperty(this, "phoneNumber");
    // mailProperty - Used for storing and getting the email address of a person
    private final StringProperty mailProperty = new SimpleStringProperty(this, "mail");

    public final StringProperty nameProperty() {
        return nameProperty;
    }

    public final String getName() {
        return nameProperty.get();
    }

    public final void setName(String value) {
        nameProperty.set(value);
    }

    public final IntegerProperty phoneNumberProperty() {
        return phoneNumberProperty;
    }

    public final int getPhoneNumber() {
        return phoneNumberProperty.get();
    }

    public final void setPhoneNumber(int value) {
        phoneNumberProperty.set(value);
    }

    public final StringProperty mailProperty() {
        return mailProperty;
    }

    public final String getMail() {
        return mailProperty.get();
    }

    public final void setMail(String value) {
        mailProperty.set(value);
    }

}
