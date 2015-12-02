package project.view.manager.center;

import javafx.animation.Transition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import project.model.Message;
import project.view.AnimationHelper;
import project.view.manager.OpenCloseAnimated;

import java.io.IOException;

/**
 * Created 11/24/15
 *
 * @author Niels Norberg
 */
public class MessageOverviewController implements OpenCloseAnimated {

    @FXML
    Node node;
    private ObservableList<Message> messages = FXCollections.observableArrayList(); // The list of messages to display

    @FXML
    private void initialize() {
        AnimationHelper.initializeSlideFadeFromRight(node);
    }

    @Override
    public void openNode() {
        AnimationHelper.slideFadeInFromRight(node);
    }

    @Override
    public Transition closeNode() {
        return AnimationHelper.slideFadeOutToRight(node);
    }

    public void setMessages(ObservableList<Message> messages) throws IOException {
        this.messages = messages;

        VBox pane = new VBox();
        pane.setPrefWidth(590);
        pane.setSpacing(0);

        for (Message message : messages) { // For each message in the list of messages, constuct a new message container and put it into the container.
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/view/manager/center/MessageContainer.fxml"));
            AnchorPane subPane = loader.load();
            pane.getChildren().add(subPane);
            ((MessageContainerController) loader.getController()).init(message);
            if (messages.indexOf(message) != messages.size() - 1) { // If this is not the last message add a seperator to the end of it
                pane.getChildren().add(new Separator(Orientation.HORIZONTAL));
            }
        }

        ((ScrollPane) node).setContent(pane); // Set the content window to contain the VBox with all the messages.
    }
}
