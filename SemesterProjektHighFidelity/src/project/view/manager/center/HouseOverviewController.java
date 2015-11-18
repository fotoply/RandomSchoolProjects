package project.view.manager.center;

import javafx.animation.Transition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import project.MainManager;
import project.model.House;
import project.view.AnimationHelper;
import project.view.manager.OpenCloseAnimated;

/**
 * Created 11/18/15
 *
 * @author Niels Norberg
 */
public class HouseOverviewController implements OpenCloseAnimated {
    public MainManager root;
    public House house;

    @FXML
    Node node;

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
