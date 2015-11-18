package project.view.manager.center;

import javafx.animation.Transition;
import javafx.fxml.FXML;
import javafx.scene.Node;
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

    @Override
    public void openNode() {
        AnimationHelper.openNodeFromRight(node);
    }

    @Override
    public Transition closeNode() {
        return AnimationHelper.closeNodeToRight(node);
    }

}
