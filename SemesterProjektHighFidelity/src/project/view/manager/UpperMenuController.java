package project.view.manager;

import javafx.fxml.FXML;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;

/**
 * Created 11/13/15
 *
 * @author Niels Norberg
 */
public class UpperMenuController {
    ArrayList<Text> textFields = new ArrayList<>();
    @FXML
    private Text mapText;
    @FXML
    private Text overviewText;
    @FXML
    private Text settingsText;
    @FXML
    private Text logOffText;

    private void textClicked(Text textClicked) {
        for (Text text : textFields) {
            text.setFont(new Font("System", 20));
        }

        textClicked.setFont(new Font("System Bold", 20));

        if (!textFields.contains(textClicked)) {
            textFields.add(textClicked);

        }
    }

    @FXML
    public void mapClicked() {
        textClicked(mapText);
    }

    @FXML
    public void overviewClicked() {
        textClicked(overviewText);
    }

    @FXML
    public void settingsClicked() {
        textClicked(settingsText);
    }

    @FXML
    public void logOutClicked() {
        textClicked(logOffText);
    }

}
