package project.model;

/**
 * Created 11/13/15
 *
 * @author Niels Norberg
 */
public class Notification extends Message {

    public Notification(String message, String title, Person sender, TYPE type) {
        super(message, title, sender, type);
    }
}
