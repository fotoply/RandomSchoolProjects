package project.model;

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
    private final StringProperty mailProperty = new SimpleStringProperty(this, "mail");
    // notesProperty
    private final StringProperty notesProperty = new SimpleStringProperty(this, "notes");
    // phoneNumberProperty
    private final StringProperty phoneNumberProperty = new SimpleStringProperty(this, "phoneNumber");

    public Person(String name, String phoneNumber, String email) {
        setName(name);
        setPhoneNumber(phoneNumber);
        setMail(email);
    }

    public final StringProperty notesProperty() {
        return notesProperty;
    }

    public final String getNotes() {
        return notesProperty.get();
    }

    public final void setNotes(String value) {
        notesProperty.set(value);
    }

    public final StringProperty nameProperty() {
        return nameProperty;
    }

    public final String getName() {
        return nameProperty.get();
    }

    public final void setName(String value) {
        nameProperty.set(value);
    }

    public final StringProperty phoneNumberProperty() {
        return phoneNumberProperty;
    }

    public final String getPhoneNumber() {
        return phoneNumberProperty.get();
    }

    public final void setPhoneNumber(String value) {
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
