package project.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

/**
 * Created 11/13/15
 *
 * @author Niels Norberg
 */
public class Notification {
    // messageProperty
    private final StringProperty messageProperty = new SimpleStringProperty(this, "message");

    // senderProperty
    private final ObjectProperty<Person> senderProperty = new SimpleObjectProperty<>(this, "sender");
    ArrayList<Person> receivers = new ArrayList<>();

    public final StringProperty messageProperty() {
        return messageProperty;
    }

    public final String getMessage() {
        return messageProperty.get();
    }

    public final void setMessage(String value) {
        messageProperty.set(value);
    }

    public final ObjectProperty<Person> senderProperty() {
        return senderProperty;
    }

    public final Person getSender() {
        return senderProperty.get();
    }

    public final void setSender(Person value) {
        senderProperty.set(value);
    }

    public enum TYPE {INFO, WARNING, DUTY, URGENT}

}
