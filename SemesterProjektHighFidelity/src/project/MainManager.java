package project;/**
 * Created 11/13/15
 *
 * @author Niels Norberg
 */

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import project.model.House;
import project.view.manager.LeftMenuController;
import project.view.manager.RootPaneController;
import project.view.manager.UpperMenuController;

import java.io.IOException;

public class MainManager extends Application {

    private Stage primaryStage;
    private RootPaneController rootPane;
    private LeftMenuController leftMenu;
    private UpperMenuController upperMenu;

    private ObservableList<House> houses = FXCollections.observableArrayList();

    public static void main(String[] args) {
        launch(args);
    }

    public ObservableList<House> getHouses() {
        return houses;
    }

    public RootPaneController getRootPane() {
        return rootPane;
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;

        loadRoot();
        loadMenus();

        primaryStage.show();

        houses.add(new House("Hejlevej 11"));
        houses.add(new House("Lalaladada vej 11"));
        houses.add(new House("Odensevej ost"));
    }

    private void loadMenus() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("view/manager/LeftMenu.fxml"));
        rootPane.getRootPane().setLeft(loader.load());
        leftMenu = loader.getController();
        leftMenu.root = this;

        loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("view/manager/UpperMenu.fxml"));
        rootPane.getRootPane().setTop(loader.load());
        upperMenu = loader.getController();
        upperMenu.setPrimaryStage(primaryStage);
        upperMenu.root = this;

        loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("view/manager/center/PersonInfo.fxml"));
        rootPane.getRootPane().setCenter(loader.load());

    }

    private void loadRoot() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("view/manager/RootPane.fxml"));
        primaryStage.setScene(new Scene(loader.load()));
        rootPane = loader.getController();
        primaryStage.setResizable(false); // Set to true if resizing is needed for testing
        primaryStage.initStyle(StageStyle.UNDECORATED); // Also set this to any other style to allow resizing
        rootPane.getRootPane().setPadding(Insets.EMPTY);
    }

    public LeftMenuController getLeftMenu() {
        return leftMenu;
    }

    public void setLeftMenu(LeftMenuController leftMenu) {
        this.leftMenu = leftMenu;
    }

    public UpperMenuController getUpperMenu() {
        return upperMenu;
    }

    public void setUpperMenu(UpperMenuController upperMenu) {
        this.upperMenu = upperMenu;
    }
}
