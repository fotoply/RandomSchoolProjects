package project.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
    // unreadProperty
    private final BooleanProperty unreadProperty = new SimpleBooleanProperty(this, "unread");
    // typeProperty
    private final ObjectProperty<TYPE> typeProperty = new SimpleObjectProperty<>(this, "type");
    ObservableList<House> receivers = FXCollections.observableArrayList();
    public Notification(String message, Person sender, TYPE type) {
        setMessage(message);
        setSender(sender);
        setUnread(true);
        setType(type);
    }

    public final ObjectProperty<TYPE> typeProperty() {
        return typeProperty;
    }

    public final TYPE getType() {
        return typeProperty.get();
    }

    public final void setType(TYPE value) {
        typeProperty.set(value);
    }

    public final BooleanProperty unreadProperty() {
        return unreadProperty;
    }

    public final boolean isUnread() {
        return unreadProperty.get();
    }

    public final void setUnread(boolean value) {
        unreadProperty.set(value);
    }

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
