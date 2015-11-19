package project.view.manager;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import project.MainManager;
import project.view.manager.center.MapAllController;
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

    public void textClicked(Text textClicked) {
        for (Text text : textFields) {
            text.setFont(new Font("System", 20));
        }

        if (textClicked != null) {

            textClicked.setFont(new Font("System Bold", 20));

            if (!textFields.contains(textClicked)) {
                textFields.add(textClicked);

            }
        }
    }

    @FXML
    public void mapClicked() throws IOException {
        if (!mapText.getFont().getName().contains("Bold")) {
            textClicked(mapText);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("center/MapAll.fxml"));
            Node node = loader.load();
            root.setContent(loader.getController(), node);
            ((MapAllController) loader.getController()).setRoot(root);
            loader = new FXMLLoader(getClass().getResource("LeftMenu.fxml"));
            node = loader.load();
            root.setLeftMenu(loader.getController(), node);
            ((LeftMenuController) loader.getController()).root = root;
            ((LeftMenuController) loader.getController()).selectButton(((LeftMenuController) loader.getController()).buttons.get(0));
        }
    }

    @FXML
    public void overviewClicked() throws IOException {
        if (!overviewText.getFont().getName().contains("Bold")) {
            textClicked(overviewText);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("center/Overview.fxml"));
            root.setLeftMenu(null, null);
            Node node = loader.load();
            root.setContent(loader.getController(), node);
            ((OverviewController) loader.getController()).setRoot(root);
        }
    }

    @FXML
    public void settingsClicked() throws IOException {
        if (!settingsText.getFont().getName().contains("Bold")) {
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
        primaryStage.close();
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}
