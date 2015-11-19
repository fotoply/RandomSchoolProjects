package project.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created 11/13/15
 *
 * @author Niels Norberg
 */
public class Manager extends Person {
    ObservableList<House> houses = FXCollections.observableArrayList();

    public Manager(String name, String phoneNumber, String email) {
        super(name, phoneNumber, email);
    }

    public void addHouse(House house) {
        if (!houses.contains(house)) {
            houses.add(house);
        }
    }

}
