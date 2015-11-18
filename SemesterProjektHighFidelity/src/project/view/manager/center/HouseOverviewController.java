package project.view.manager.center;

import javafx.animation.Transition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import project.MainManager;
import project.model.House;
import project.model.Tenant;
import project.view.AnimationHelper;
import project.view.manager.OpenCloseAnimated;

/**
 * Created 11/18/15
 *
 * @author Niels Norberg
 */
public class HouseOverviewController implements OpenCloseAnimated {
    @FXML
    Node node;
    private MainManager root;
    private House house;
    @FXML
    private Text textAddress;

    @FXML
    private TextArea textAreaNotes;

    @FXML
    private TableView<Tenant> tenantInfo;

    @FXML
    private TableColumn<Tenant, String> nameColumn;

    @FXML
    private TableColumn<Tenant, Integer> phoneColumn;

    @FXML
    private TableColumn<Tenant, String> emailColumn;

    @FXML
    private void initialize() {
        AnimationHelper.initializeSlideFadeFromRight(node);

        nameColumn.setCellValueFactory(param -> param.getValue().nameProperty());
        phoneColumn.setCellValueFactory(param -> param.getValue().phoneNumberProperty().asObject());
        emailColumn.setCellValueFactory(param -> param.getValue().mailProperty());
    }

    @Override
    public void openNode() {
        AnimationHelper.slideFadeInFromRight(node);
    }

    @Override
    public Transition closeNode() {
        return AnimationHelper.slideFadeOutToRight(node);
    }

    public void setHouse(House house) {
        this.house = house;
        tenantInfo.setItems(this.house.getTenants());
        textAddress.setText(house.getLocation());
    }

    public void setRoot(MainManager root) {
        this.root = root;
    }
}
