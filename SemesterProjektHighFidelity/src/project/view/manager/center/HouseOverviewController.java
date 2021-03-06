package project.view.manager.center;

import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import project.MainManager;
import project.model.House;
import project.model.Tenant;
import project.view.AnimationHelper;
import project.view.manager.HouseOverviewLeftMenuController;
import project.view.manager.OpenCloseAnimated;

import java.io.IOException;

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
    private TableColumn<Tenant, String> phoneColumn;

    @FXML
    private TableColumn<Tenant, String> emailColumn;

    @FXML
    private void initialize() {
        //Initialize the overview and set the cell factory values to display the correct information for each person
        AnimationHelper.initializeSlideFadeFromRight(node);

        nameColumn.setCellValueFactory(param -> param.getValue().nameProperty());
        phoneColumn.setCellValueFactory(param -> param.getValue().phoneNumberProperty());
        emailColumn.setCellValueFactory(param -> param.getValue().mailProperty());

        tenantInfo.getSelectionModel().select(-1);
        tenantInfo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> tableClicked(newValue));
    }

    @Override
    public void openNode() {
        AnimationHelper.slideFadeInFromRight(node);
    }

    @Override
    public Transition closeNode() {
        return AnimationHelper.slideFadeOutToRight(node);
    }

    public void tableClicked(Tenant tenant) {
        // When any part of the table is clicked, open information for that specific person.
        ((HouseOverviewLeftMenuController) root.getLeftMenu()).selectButton(null);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("PersonInfo.fxml"));
        try {
            Node node = loader.load();
            ((PersonInfoController) loader.getController()).setRoot(root);
            ((PersonInfoController) loader.getController()).setPerson(tenant);
            ((PersonInfoController) loader.getController()).setHouse(house);
            root.setContent(loader.getController(), node);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setHouse(House house) {
        this.house = house;
        tenantInfo.setItems(this.house.getTenants());
        textAddress.setText(house.getAddress());
        textAreaNotes.setText(house.getNotes());
    }

    @FXML
    void addTenantClicked(ActionEvent event) {
        Tenant tenant = new Tenant("Indtast navn", "Indtast telefon nummer", "Indtast email");
        house.addPerson(tenant);
        tableClicked(tenant);
    }

    public void setRoot(MainManager root) {
        this.root = root;
    }
}
