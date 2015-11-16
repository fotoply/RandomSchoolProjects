package project;/**
 * Created 11/13/15
 *
 * @author Niels Norberg
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import project.view.manager.LeftMenuController;
import project.view.manager.RootPaneController;
import project.view.manager.UpperMenuController;

import java.io.IOException;

public class MainManager extends Application {

    private Stage primaryStage;
    private RootPaneController rootPane;
    private LeftMenuController leftMenu;
    private UpperMenuController upperMenu;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;

        loadRoot();
        loadMenus();

        primaryStage.show();
    }

    private void loadMenus() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("view/manager/LeftMenu.fxml"));
        rootPane.getRootPane().setLeft(loader.load());
        leftMenu = loader.getController();

        loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("view/manager/UpperMenu.fxml"));
        rootPane.getRootPane().setTop(loader.load());
        upperMenu = loader.getController();
        upperMenu.setPrimaryStage(primaryStage);

        loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("view/manager/center/PersonInfo.fxml"));
        rootPane.getRootPane().setCenter(loader.load());

    }

    private void loadRoot() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/manager/RootPane.fxml"));
        primaryStage.setScene(new Scene(loader.load()));
        rootPane = loader.getController();
        primaryStage.setResizable(false); // Set to true if resizing is needed for testing
        primaryStage.initStyle(StageStyle.UNDECORATED); // Also set this to any other style to allow resizing
        rootPane.getRootPane().setPadding(Insets.EMPTY);
    }
}
