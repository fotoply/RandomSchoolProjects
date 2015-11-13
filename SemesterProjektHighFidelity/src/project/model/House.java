package project.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

/**
 * Created 11/13/15
 *
 * @author Niels Norberg
 */
public class House {

    // locationProperty
    private final StringProperty locationProperty = new SimpleStringProperty(this, "location");
    ArrayList<Person> tenants = new ArrayList<>();
    ArrayList<Person> managers = new ArrayList<>();
    ArrayList<Notification> notifications = new ArrayList<>();
    ArrayList<Message> messages = new ArrayList<>();

    public final StringProperty locationProperty() {
        return locationProperty;
    }

    public final String getLocation() {
        return locationProperty.get();
    }

    public final void setLocation(String value) {
        locationProperty.set(value);
    }

}
