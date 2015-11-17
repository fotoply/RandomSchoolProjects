package project.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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
                return applyGlowToImage("/project/res/notification.png");
            }
        }
        return new ImageView(new Image(getClass().getResourceAsStream("/project/res/notification.png")));
    }

    public ImageView getMessageIcon() {
        for (Message message : messages) {
            if (message.isUnread()) {
                return applyGlowToImage("/project/res/mail.png");
            }
        }
        return new ImageView(new Image(getClass().getResourceAsStream("/project/res/mail.png")));
    }

    public ImageView applyGlowToImage(String url) {
        Image icon = new Image(getClass().getResourceAsStream(url));
        ImageView glowIcon = new ImageView(icon);

        DropShadow borderGlow = new DropShadow();
        borderGlow.setOffsetY(0f);
        borderGlow.setOffsetX(0f);
        borderGlow.setColor(Color.YELLOW);
        borderGlow.setWidth(40);
        borderGlow.setHeight(40);
        glowIcon.setEffect(borderGlow);
        return glowIcon;
    }

}
