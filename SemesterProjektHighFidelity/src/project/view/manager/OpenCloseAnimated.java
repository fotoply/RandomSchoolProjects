package project.view.manager;

import javafx.animation.Transition;
import javafx.fxml.FXML;
import javafx.scene.Node;

/**
 * Created 11/18/15
 *
 * @author Niels Norberg
 */
public interface OpenCloseAnimated {

    @FXML
    Node node = null;

    void openNode();

    Transition closeNode();

}
