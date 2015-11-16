package project.view.manager;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;

import java.util.ArrayList;

/**
 * Created 11/13/15
 *
 * @author Niels Norberg
 */
public class LeftMenuController {
    ImageView allPlacesImage = new ImageView(new Image(getClass().getResourceAsStream("/project/res/button_all_places_icon.png")));
    ImageView notificationImage = new ImageView(new Image(getClass().getResourceAsStream("/project/res/button_notification_icon.png")));
    ImageView messageImage = new ImageView(new Image(getClass().getResourceAsStream("/project/res/button_message_icon.png")));

    ArrayList<Button> buttons = new ArrayList<>();

    @FXML
    private Button allPlacesButton;
    @FXML
    private Button notificationsButton;
    @FXML
    private Button messagesButton;

    @FXML
    private void initialize() {
        buttons.add(allPlacesButton);
        buttons.add(notificationsButton);
        buttons.add(messagesButton);

        allPlacesButton.setGraphic(allPlacesImage);
        notificationsButton.setGraphic(notificationImage);
        messagesButton.setGraphic(messageImage);

        allPlacesButton.setBackground(Background.EMPTY);
        notificationsButton.setBackground(Background.EMPTY);
        messagesButton.setBackground(Background.EMPTY);

        allPlacesButton.setPadding(Insets.EMPTY);
        notificationsButton.setPadding(Insets.EMPTY);
        messagesButton.setPadding(Insets.EMPTY);

        allPlacesButton.setScaleX(0.5);
        allPlacesButton.setScaleY(0.5);

        notificationsButton.setScaleX(0.5);
        notificationsButton.setScaleY(0.5);

        messagesButton.setScaleX(0.5);
        messagesButton.setScaleY(0.5);

    }

    private void selectButton(Button b) {
        for (Button button : buttons) {
            if (button != b && button.getEffect() != null) {
                button.setEffect(null);
            }
        }

        DropShadow borderGlow = new DropShadow();
        borderGlow.setOffsetY(0f);
        borderGlow.setOffsetX(0f);
        borderGlow.setColor(Color.YELLOW);
        borderGlow.setWidth(80);
        borderGlow.setHeight(80);

        b.setEffect(borderGlow);
    }

    @FXML
    private void allPlacesClicked() {
        selectButton(allPlacesButton);
    }

    @FXML
    private void notificationsClicked() {
        selectButton(notificationsButton);
    }

    @FXML
    private void messagesClicked() {
        selectButton(messagesButton);
    }

}

