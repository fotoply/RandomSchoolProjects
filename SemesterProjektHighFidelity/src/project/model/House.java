package project.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.util.ArrayList;

/**
 * Created 11/13/15
 *
 * @author Niels Norberg
 */
public class House {

    // locationProperty
    private final StringProperty locationProperty = new SimpleStringProperty(this, "location");
    private ArrayList<Tenant> tenants = new ArrayList<>();
    private ArrayList<Person> managers = new ArrayList<>();
    private ArrayList<Notification> notifications = new ArrayList<>();
    private ArrayList<Message> messages = new ArrayList<>();

    public House(String location) {
        setLocation(location);
    }

    public final StringProperty locationProperty() {
        return locationProperty;
    }

    public final String getLocation() {
        return locationProperty.get();
    }

    public final void setLocation(String value) {
        locationProperty.set(value);
    }

    public void addPerson(Person person) {
        if (person instanceof Tenant) {
            tenants.add((Tenant) person);
        } else {
            managers.add(person);
        }
    }

    public ImageView getNotificationIcon() {
        for (Notification notification : notifications) {
            if (notification.isUnread()) {
                return constructImage("/project/res/notification.png", true);
            }
        }
        return constructImage("/project/res/notification.png", false);
    }

    public ImageView getMessageIcon() {
        for (Message message : messages) {
            if (message.isUnread()) {
                return constructImage("/project/res/mail.png", true);
            }
        }
        return constructImage("/project/res/mail.png", false);
    }

    public ImageView constructImage(String url, boolean applyGlow) {
        Image icon = new Image(getClass().getResourceAsStream(url));
        ImageView imageView = new ImageView(icon);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(30);

        if (applyGlow) {
            DropShadow borderGlow = new DropShadow();
            borderGlow.setOffsetY(0f);
            borderGlow.setOffsetX(0f);
            borderGlow.setColor(Color.YELLOW);
            borderGlow.setWidth(60);
            borderGlow.setHeight(60);
            borderGlow.setBlurType(BlurType.THREE_PASS_BOX);
            borderGlow.setSpread(0.7);
            imageView.setEffect(borderGlow);
        }
        return imageView;
    }

    public void addMessage(Message message) {
        messages.add(message);
    }

    public void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public ArrayList<Tenant> getTenants() {
        return tenants;
    }

    public ArrayList<Person> getManagers() {
        return managers;
    }

    public ArrayList<Notification> getNotifications() {
        return notifications;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }
}
