package project.view.manager.center;

import javafx.animation.FadeTransition;
import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.util.Duration;
import project.MainManager;
import project.model.House;
import project.model.Person;
import project.view.AnimationHelper;
import project.view.manager.HouseOverviewLeftMenuController;
import project.view.manager.OpenCloseAnimated;

import java.io.IOException;

/**
 * Created 11/18/15
 *
 * @author Niels Norberg
 */
public class PersonInfoController implements OpenCloseAnimated {
    @FXML
    Node node;
    private Person person;
    private MainManager root;
    private House house;
    @FXML
    private Text textAddress;
    @FXML
    private Text textKontract;
    @FXML
    private TextArea textAreaNotes;
    @FXML
    private TextField textName;
    @FXML
    private TextField textNumber;
    @FXML
    private TextField textMail;
    @FXML
    private Text textInfoSaved;

    /**
     * Sets the house to be displayed address for.
     *
     * @param house the house object
     */
    public void setHouse(House house) { // Sets the house and changes the title text.
        this.house = house;
        textAddress.setText(house.getAddress());
    }

    /**
     * Sets the person to be displayed and updates the text on the node
     * @param person the person object
     */
    public void setPerson(Person person) {
        // Sets the person to display information for and also saves the reference so that information can be propagated back if anything is changed.
        this.person = person;
        textMail.setText(person.getMail());
        textName.setText(person.getName());
        textNumber.setText(person.getPhoneNumber() + "");
        textAreaNotes.setText(person.getNotes());
    }

    @FXML
    public void textChanged() {

        // Whenever any information is changed, save it back to the person object and show text to the user.
        // Later on this would instead save it to a server, while currently it is only kept in memory.
        try {
            person.setName(textName.getText());
            person.setPhoneNumber(textNumber.getText());
            person.setMail(textMail.getText());
            person.setNotes(textAreaNotes.getText());
            FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), textInfoSaved);
            fadeTransition.setFromValue(0);
            fadeTransition.setToValue(1);
            fadeTransition.setAutoReverse(true);
            fadeTransition.setCycleCount(2);
            fadeTransition.play();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Noget gik galt i forsøget på at gemme data");
            alert.show();
        }

    }

    @FXML
    void removeTenantClicked(ActionEvent event) throws IOException {
        ((HouseOverviewLeftMenuController) root.getLeftMenu()).infoButtonClicked(); // Change the selected window in the left menu
        house.removeTenant(person);
    }


    public void setRoot(MainManager root) {
        this.root = root;
    }

    @FXML
    private void initialize() {
        AnimationHelper.initializeSlideFadeFromRight(node);
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
