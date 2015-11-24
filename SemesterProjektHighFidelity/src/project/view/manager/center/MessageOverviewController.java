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
    private ObservableList<Message> messages = FXCollections.observableArrayList();

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
        //pane.setBackground(new Background(new BackgroundFill(Paint.valueOf("Black"), CornerRadii.EMPTY, Insets.EMPTY)));

        for (Message message : messages) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/project/view/manager/center/MessageContainer.fxml"));
            AnchorPane subPane = loader.load();
            //subPane.setMinWidth(600);
            pane.getChildren().add(subPane);
            ((MessageContainerController) loader.getController()).init(message);
            if (messages.indexOf(message) != messages.size() - 1) {
                pane.getChildren().add(new Separator(Orientation.HORIZONTAL));
            }
        }

        ((ScrollPane) node).setContent(pane);
    }
}
