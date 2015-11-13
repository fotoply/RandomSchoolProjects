package project;/**
 * Created 11/13/15
 *
 * @author Niels Norberg
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.ScatterChart;
import javafx.stage.Stage;
import project.view.udlejer.LeftMenuController;
import project.view.udlejer.RootPaneController;
import project.view.udlejer.UpperMenuController;

import java.io.IOException;

public class MainUdlejer extends Application {

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

        loader.setLocation(getClass().getResource("view/udlejer/LeftMenu.fxml"));
        rootPane.getRootPane().setLeft(loader.load());
        leftMenu = loader.getController();

        loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("view/udlejer/UpperMenu.fxml"));
        rootPane.getRootPane().setTop(loader.load());
        upperMenu = loader.getController();
    }

    private void loadRoot() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/udlejer/RootPane.fxml"));
        primaryStage.setScene(new Scene(loader.load()));
        rootPane = loader.getController();

    }
}
