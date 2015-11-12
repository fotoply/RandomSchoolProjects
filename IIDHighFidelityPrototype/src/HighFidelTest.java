/**
 * Created 11/9/15
 *
 * @author Niels Norberg
 */

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class HighFidelTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    Stage primaryStage;
    Scene primaryScene;
    HighFidelTestController controller;

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        loadStage();
    }

    public void loadStage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HighFidelTest.fxml"));
        primaryScene = new Scene(loader.load());
        primaryStage.setScene(primaryScene);
        controller = loader.getController();
        controller.primaryStage = primaryStage;

        primaryStage.show();
    }
}
