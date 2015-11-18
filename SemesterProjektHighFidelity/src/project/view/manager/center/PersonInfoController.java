package project.view.manager.center;

import javafx.animation.Transition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import project.MainManager;
import project.model.House;
import project.model.Person;
import project.view.AnimationHelper;
import project.view.manager.OpenCloseAnimated;

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
    private Text textName;
    @FXML
    private Text textNumber;
    @FXML
    private Text textMail;

    public void setHouse(House house) {
        this.house = house;
        textAddress.setText(house.getLocation());
    }

    public void setPerson(Person person) {
        this.person = person;
        textMail.setText(person.getMail());
        textName.setText(person.getName());
        textNumber.setText(person.getPhoneNumber() + "");
        textAreaNotes.setText(person.getNotes());
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
