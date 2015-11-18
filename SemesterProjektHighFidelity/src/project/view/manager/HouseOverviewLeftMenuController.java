package project.view.manager;

import javafx.animation.Transition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import project.MainManager;
import project.view.AnimationHelper;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created 11/13/15
 *
 * @author Niels Norberg
 */
public class HouseOverviewLeftMenuController implements OpenCloseAnimated {
    @FXML
    public Node node;

    public MainManager root;
    public ArrayList<Button> buttons = new ArrayList<>();
    ImageView allPlacesImage = new ImageView(new Image(getClass().getResourceAsStream("/project/res/house.png")));
    ImageView notificationImage = new ImageView(new Image(getClass().getResourceAsStream("/project/res/notification.png")));
    ImageView messageImage = new ImageView(new Image(getClass().getResourceAsStream("/project/res/mail.png")));
    @FXML
    private Button infoButton;
    @FXML
    private Button notificationsButton;
    @FXML
    private Button messagesButton;

    @FXML
    private void initialize() {
        node.setTranslateX(-node.prefWidth(-1));

        buttons.add(infoButton);
        buttons.add(notificationsButton);
        buttons.add(messagesButton);

        infoButton.setGraphic(allPlacesImage);
        notificationsButton.setGraphic(notificationImage);
        messagesButton.setGraphic(messageImage);

        infoButton.setBackground(Background.EMPTY);
        notificationsButton.setBackground(Background.EMPTY);
        messagesButton.setBackground(Background.EMPTY);

        infoButton.setPadding(Insets.EMPTY);
        notificationsButton.setPadding(Insets.EMPTY);
        messagesButton.setPadding(Insets.EMPTY);

        infoButton.setScaleX(0.5);
        infoButton.setScaleY(0.5);

        /*notificationsButton.setScaleX(0.5);
        notificationsButton.setScaleY(0.5);*/

        messagesButton.setScaleX(0.9);
        messagesButton.setScaleY(0.9);

    }

    public void selectButton(Button b) {
        for (Button button : buttons) {
            if (button.getEffect() != null) {
                button.setEffect(null);
            }
        }

        if (b != null) {
            DropShadow borderGlow = new DropShadow();
            borderGlow.setOffsetY(0f);
            borderGlow.setOffsetX(0f);
            borderGlow.setColor(Color.YELLOW);
            borderGlow.setWidth(80);
            borderGlow.setHeight(80);

            b.setEffect(borderGlow);
        }
    }

    @FXML
    private void infoButtonClicked() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("center/HouseOverview.fxml"));
        Node node = loader.load();
        root.setContent(loader.getController(), node);
        selectButton(infoButton);
    }

    @FXML
    private void notificationsClicked() {
        selectButton(notificationsButton);
    }

    @FXML
    private void messagesClicked() {
        selectButton(messagesButton);
    }

    @Override
    public void openNode() {
        AnimationHelper.slideInFromLeft(node);
    }

    @Override
    public Transition closeNode() {
        return AnimationHelper.slideOutToLeft(node);
    }
}

