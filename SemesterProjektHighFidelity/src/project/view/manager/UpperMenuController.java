package project.view.manager;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import project.MainManager;
import project.view.manager.center.OverviewController;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created 11/13/15
 *
 * @author Niels Norberg
 */
public class UpperMenuController {
    public MainManager root;
    ArrayList<Text> textFields = new ArrayList<>();
    @FXML
    private Text mapText;
    @FXML
    private Text overviewText;
    @FXML
    private Text settingsText;
    @FXML
    private Text logOffText;
    @FXML
    private ImageView iconImage;
    private Stage primaryStage;

    @FXML
    void initialize() {
    }

    public void textClicked(Text textClicked) { // Is triggered when any of the text is clicked, in the upper menu
        for (Text text : textFields) {
            text.setFont(new Font("System", 20)); // Reset all the text to not be bold
        }

        if (textClicked != null) { // If the text exists which was clicked on

            textClicked.setFont(new Font("System Bold", 20)); // Set it to bold

            if (!textFields.contains(textClicked)) {
                textFields.add(textClicked); // IF it does not exist in the list of button texts, add it

            }
        }
    }

    @FXML
    public void mapClicked() throws IOException {
        if (!mapText.getFont().getName().contains("Bold")) { // IF it is not already selected and therefor bold
            textClicked(mapText); // Select it
            root.openMap();
        }
    }

    @FXML
    public void overviewClicked() throws IOException {
        if (!overviewText.getFont().getName().contains("Bold")) { // IF it is not already selected and therefor bold
            textClicked(overviewText); // Select it and load the correct center thing
            FXMLLoader loader = new FXMLLoader(getClass().getResource("center/Overview.fxml"));
            root.setLeftMenu(null, null);
            Node node = loader.load();
            root.setContent(loader.getController(), node);
            ((OverviewController) loader.getController()).setRoot(root);
        }
    }

    @FXML
    public void settingsClicked() throws IOException {
        if (!settingsText.getFont().getName().contains("Bold")) { // Same as the above two
            textClicked(settingsText);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("center/Settings.fxml"));
            root.setLeftMenu(null, null);
            Node node = loader.load();
            root.setContent(loader.getController(), node);
        }
    }

    @FXML
    public void logOutClicked() {
        textClicked(logOffText);
        primaryStage.close(); // Close the program. textClicked call is kinda unnecessary except if the program hangs unexpectedly
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}
