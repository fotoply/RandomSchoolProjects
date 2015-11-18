package project.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * Created 11/13/15
 *
 * @author Niels Norberg
 */
public class Tenant extends Person {
    // houseProperty
    private final ObjectProperty<House> houseProperty = new SimpleObjectProperty<>(this, "house");

    public Tenant(String name, int phoneNumber, String email) {
        super(name, phoneNumber, email);
    }

    public final ObjectProperty<House> houseProperty() {
        return houseProperty;
    }

    public final House getHouse() {
        return houseProperty.get();
    }

    public final void setHouse(House value) {
        houseProperty.set(value);
    }

}
