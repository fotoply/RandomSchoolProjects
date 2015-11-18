package project.view.manager.center;

import javafx.animation.Transition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import project.MainManager;
import project.model.House;
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
        node.setOpacity(0);
        node.setTranslateX(node.prefWidth(-1));
    }

    @Override
    public void openNode() {

    }

    @Override
    public Transition closeNode() {
        return null;
    }
}
