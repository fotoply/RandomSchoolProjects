package project.view.manager.center;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import project.model.Message;

/**
 * Created 11/23/15
 *
 * @author Niels Norberg
 */
public class MessageContainerController extends AnchorPane {

    @FXML
    private Text titleText;

    @FXML
    private Text senderNameText;

    @FXML
    private TextArea messageArea;

    public void init(Message message) { // Display the data from the message by setting the correct labels.
        titleText.setText(message.getTitle());
        senderNameText.setText(message.getSender().getName());
        messageArea.setText(message.getMessage());
    }


}
