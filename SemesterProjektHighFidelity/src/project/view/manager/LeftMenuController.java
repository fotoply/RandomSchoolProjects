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
        node.setTranslateX(-node.prefWidth(-1)); // Hides the menu so that it can be animated

        buttons.add(allPlacesButton);
        buttons.add(notificationsButton);
        buttons.add(messagesButton); // Adds all the buttons to the list of buttons

        allPlacesButton.setGraphic(allPlacesImage);
        notificationsButton.setGraphic(notificationImage);
        messagesButton.setGraphic(messageImage); // Changes the buttons images to be the correct ones

        allPlacesButton.setBackground(Background.EMPTY);
        notificationsButton.setBackground(Background.EMPTY);
        messagesButton.setBackground(Background.EMPTY);

        allPlacesButton.setPadding(Insets.EMPTY);
        notificationsButton.setPadding(Insets.EMPTY);
        messagesButton.setPadding(Insets.EMPTY); // Hides the background and unnecessary padding.

        allPlacesButton.setScaleX(0.5);
        allPlacesButton.setScaleY(0.5);

        notificationsButton.setScaleX(0.5);
        notificationsButton.setScaleY(0.5); // Scales the images to fit better

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
                button.setEffect(null); // Disables the glow effect on all buttons
            }
        }

        if (b != null) { // IF the selected button is a valid button add glow effect to it
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
    private void allPlacesClicked() throws IOException { // When the first button is clicked
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

