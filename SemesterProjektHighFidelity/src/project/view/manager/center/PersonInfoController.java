package project.view.manager.center;

import javafx.animation.Transition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
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

    @FXML
    private Text textAddress;

    @FXML
    private Text textKontract;

    @FXML
    private TextArea textAreaNotes;

    @FXML
    private VBox adressText;

    @FXML
    private Text textName;

    @FXML
    private Text textNumber;

    @FXML
    private Text textMail;


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
