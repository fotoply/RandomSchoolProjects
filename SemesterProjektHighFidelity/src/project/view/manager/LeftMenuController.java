package project.view.manager;

import com.sun.istack.internal.Nullable;
import javafx.animation.Transition;
import javafx.fxml.FXML;
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
public class LeftMenuController implements OpenCloseAnimated {
    public MainManager root;
    ImageView allPlacesImage = new ImageView(new Image(getClass().getResourceAsStream("/project/res/house.png")));
    ImageView notificationImage = new ImageView(new Image(getClass().getResourceAsStream("/project/res/house_notification.png")));
    ImageView messageImage = new ImageView(new Image(getClass().getResourceAsStream("/project/res/house_mail.png")));
    ArrayList<Button> buttons = new ArrayList<>();
    @FXML
    private Node node;
    @FXML
    private Button allPlacesButton;
    @FXML
    private Button notificationsButton;
    @FXML
    private Button messagesButton;

    @FXML
    private void initialize() {
        node.setTranslateX(-node.prefWidth(-1));

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

    /**
     * Selects a given button, and deselects all others. If the given button is null then all buttons will just be unselected.
     *
     * @param b the button to select
     */
    public void selectButton(@Nullable Button b) {
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
    private void allPlacesClicked() throws IOException {
        /*FXMLLoader loader = new FXMLLoader(getClass().getResource("center/MapAll.fxml"));
        Node node = loader.load();
        ((MapAllController) loader.getController()).setRoot(root);
        root.setContent(loader.getController(), node);*/
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

    @Override
    public void openNode() {
        AnimationHelper.slideInFromLeft(node);
    }

    @Override
    public Transition closeNode() {
        return AnimationHelper.slideOutToLeft(node);
    }

    public ArrayList<Button> getButtons() {
        return buttons;
    }
}

