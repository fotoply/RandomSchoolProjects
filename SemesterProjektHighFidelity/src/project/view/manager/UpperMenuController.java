package project.view.manager;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

    private void textClicked(Text textClicked) {
        for (Text text : textFields) {
            text.setFont(new Font("System", 20));
        }

        textClicked.setFont(new Font("System Bold", 20));

        if (!textFields.contains(textClicked)) {
            textFields.add(textClicked);

        }

        root.getLeftMenu().selectButton(null);
    }

    @FXML
    public void mapClicked() throws IOException {
        if (!mapText.getFont().getName().contains("Bold")) {
            textClicked(mapText);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("center/MapAll.fxml"));
            root.getRootPane().getRootPane().setCenter(loader.load());
            loader = new FXMLLoader(getClass().getResource("LeftMenu.fxml"));
            root.getRootPane().getRootPane().setLeft(loader.load());
            root.setLeftMenu(loader.getController());
            ((LeftMenuController) loader.getController()).root = root;
        }
    }

    @FXML
    public void overviewClicked() throws IOException {
        if (!overviewText.getFont().getName().contains("Bold")) {
            textClicked(overviewText);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("center/Overview.fxml"));
            root.getRootPane().getRootPane().setCenter(loader.load());
            root.getRootPane().getRootPane().setLeft(null);
            ((OverviewController) loader.getController()).setRoot(root);
            ((OverviewController) loader.getController()).setCells();
        }
    }

    @FXML
    public void settingsClicked() throws IOException {
        if (!settingsText.getFont().getName().contains("Bold")) {
            textClicked(settingsText);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("center/Settings.fxml"));
            root.getRootPane().getRootPane().setCenter(loader.load());
            root.getRootPane().getRootPane().setLeft(null);
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
