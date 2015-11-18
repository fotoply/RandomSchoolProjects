package project.view.manager;

import javafx.animation.Transition;
import javafx.scene.Node;

/**
 * Created 11/18/15
 *
 * @author Niels Norberg
 */
public interface OpenCloseAnimated {

    Node node = null;

    void openNode();

    Transition closeNode();

}
