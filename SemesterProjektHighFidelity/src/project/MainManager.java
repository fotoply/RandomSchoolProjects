package project;/**
 * Created 11/13/15
 *
 * @author Niels Norberg
 */

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import project.model.House;
import project.model.Message;
import project.model.Tenant;
import project.view.manager.OpenCloseAnimated;
import project.view.manager.RootPaneController;
import project.view.manager.UpperMenuController;

import java.io.IOException;

public class MainManager extends Application {

    private Stage primaryStage;
    private RootPaneController rootPane;
    private OpenCloseAnimated leftMenu;
    private UpperMenuController upperMenu;
    private OpenCloseAnimated contentController;

    private ObservableList<House> houses = FXCollections.observableArrayList();

    public static void main(String[] args) {
        launch(args);
    }

    public ObservableList<House> getHouses() {
        return houses;
    }

    private RootPaneController getRootPane() {
        return rootPane;
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;

        loadRoot();
        primaryStage.show();
        loadMenus();

        House tempHouse = new House("Hejlevej 11");
        Tenant tenant = new Tenant("Kaj", 66, "Ost@ost.ost");
        tempHouse.addPerson(tenant);
        tempHouse.addMessage(new Message("Hallo", tenant, Message.TYPE.DUTY));

        houses.add(tempHouse);
        houses.add(new House("Lalaladada vej 11"));
        houses.add(new House("Odensevej ost"));
    }

    private void loadMenus() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        /*loader.setLocation(getClass().getResource("view/manager/LeftMenu.fxml"));
        Node node = loader.load();
        setLeftMenu(loader.getController(), node);
        ((LeftMenuController) leftMenu).root = this;*/

        loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("view/manager/UpperMenu.fxml"));
        rootPane.getRootPane().setTop(loader.load());
        upperMenu = loader.getController();
        upperMenu.setPrimaryStage(primaryStage);
        upperMenu.root = this;

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

    public OpenCloseAnimated getLeftMenu() {
        return leftMenu;
    }

    public void setLeftMenu(OpenCloseAnimated controller, Node leftMenu) {
        if (rootPane.getRootPane().getLeft() != null) {
            getLeftMenu().closeNode().setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    rootPane.getRootPane().setLeft(null);
                    setLeftMenu(controller, leftMenu);
                }
            });
            return;
        }
        if (leftMenu == null) {
            this.leftMenu = null;
            this.rootPane.getRootPane().setLeft(null);
            return;
        }
        this.leftMenu = controller;
        this.rootPane.getRootPane().setLeft(leftMenu);
        controller.openNode();
    }

    public UpperMenuController getUpperMenu() {
        return upperMenu;
    }

    public void setUpperMenu(UpperMenuController upperMenu) {
        this.upperMenu = upperMenu;
    }

    public OpenCloseAnimated getContentController() {
        return contentController;
    }

    public void setContent(OpenCloseAnimated controller, Node content) {
        if (rootPane.getRootPane().getCenter() != null && getContentController() != null) {
            getContentController().closeNode().setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    rootPane.getRootPane().setCenter(null);
                    contentController = null;
                    setContent(controller, content);
                }
            });
            return;
        }
        if (content == null) {
            this.contentController = null;
            this.getRootPane().getRootPane().setCenter(null);
        } else {
            this.contentController = controller;
            this.rootPane.getRootPane().setCenter(content);
            if (controller != null) {
                controller.openNode();
            }
        }
    }
}
