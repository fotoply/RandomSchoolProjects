package project.view.manager.center;

import javafx.animation.Transition;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import project.MainManager;
import project.model.House;
import project.view.AnimationHelper;
import project.view.manager.HouseOverviewLeftMenuController;
import project.view.manager.OpenCloseAnimated;

import java.io.IOException;

/**
 * Created 11/16/15
 *
 * @author Niels Norberg
 */
public class OverviewController implements OpenCloseAnimated {
    @FXML
    Node node;

    @FXML
    private TableView<House> tableView;

    @FXML
    private TableColumn<House, String> addressColumn;

    @FXML
    private TableColumn<House, ImageView> messageColumn;

    @FXML
    private TableColumn<House, ImageView> notificationColumn;
    private MainManager root;

    @FXML
    private void initialize() {
        AnimationHelper.initializeSlideFadeFromRight(node);
    }

    private void tableClicked(House house) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HouseOverview.fxml"));
        try {
            Node node = loader.load();
            root.setContent(loader.getController(), node);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ((HouseOverviewController) loader.getController()).root = root;
        ((HouseOverviewController) loader.getController()).house = house;

        loader = new FXMLLoader(getClass().getResource("/project/view/manager/HouseOverviewLeftMenu.fxml"));
        try {
            Node node = loader.load();
            ((HouseOverviewLeftMenuController) loader.getController()).root = root;
            ((HouseOverviewLeftMenuController) loader.getController()).selectButton(((HouseOverviewLeftMenuController) loader.getController()).buttons.get(0));
            root.setLeftMenu(loader.getController(), node);
        } catch (IOException e) {
            e.printStackTrace();
        }

        root.getUpperMenu().textClicked(null);
    }

    public void setCells() {
        addressColumn.setCellValueFactory(param -> param.getValue().locationProperty());
        messageColumn.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getMessageIcon()));
        notificationColumn.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getNotificationIcon()));

        tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> tableClicked(newValue));
    }

    public void setRoot(MainManager root) {
        this.root = root;
        tableView.setItems(root.getHouses());
        tableView.setId("my-table");
    }

    @Override
    public void openNode() {
        AnimationHelper.slideFadeInFromRight(node);
    }

    @Override
    public Transition closeNode() {
        return AnimationHelper.slideFadeOutToRight(node);
    }
}
