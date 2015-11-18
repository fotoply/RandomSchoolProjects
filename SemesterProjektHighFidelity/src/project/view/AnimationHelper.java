package project.view;

import javafx.animation.FadeTransition;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

/**
 * Created 11/18/15
 *
 * @author Niels Norberg
 */
public class AnimationHelper {

    public static void openNodeFromRight(Node node) {
        node.setOpacity(0);
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(300), node);
        translateTransition.setToX(0);

        FadeTransition fadeTransition = new FadeTransition(Duration.millis(300), node);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);

        fadeTransition.play();
        translateTransition.play();
    }

    public static Transition closeNodeToRight(Node node) {
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(300), node);
        translateTransition.setToX(node.prefWidth(-1));

        FadeTransition fadeTransition = new FadeTransition(Duration.millis(200), node);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);

        fadeTransition.play();
        translateTransition.play();
        return translateTransition;
    }

}
