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

        //Initializes the cells to format the person they get in in the following way.
        //For example, for the first one this means that it takes a CellData, where the value is a house object.
        //Then from that house object it will display the location property, AKA the address.
        addressColumn.setCellValueFactory(param -> param.getValue().locationProperty());
        messageColumn.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getMessageIcon()));
        notificationColumn.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getNotificationIcon()));

        //Listens for if any of the cells is selected
        tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> tableClicked(newValue));

        AnimationHelper.initializeSlideFadeFromRight(node);
    }

    private void tableClicked(House house) { // When any element in the overview table is clicked, load that specific house
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HouseOverview.fxml")); // Load the layout
        try {
            Node node = loader.load();
            root.setContent(loader.getController(), node);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ((HouseOverviewController) loader.getController()).setRoot(root); // Then set some values in the layout controller
        ((HouseOverviewController) loader.getController()).setHouse(house);

        loader = new FXMLLoader(getClass().getResource("/project/view/manager/HouseOverviewLeftMenu.fxml")); // Also load the layout for the new left menu
        try {
            Node node = loader.load();
            ((HouseOverviewLeftMenuController) loader.getController()).root = root; // And set data for it's controller
            ((HouseOverviewLeftMenuController) loader.getController()).selectButton(((HouseOverviewLeftMenuController) loader.getController()).buttons.get(0));
            ((HouseOverviewLeftMenuController) loader.getController()).setHouse(house);
            root.setLeftMenu(loader.getController(), node);
        } catch (IOException e) {
            e.printStackTrace();
        }

        root.getUpperMenu().textClicked(null); // Reset what text is bold in the upper menu to none.
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
