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

    /**
     * Initializer for a sliding and fading animation on a given node.
     * Should be called in the initialize() function.
     *
     * @param node the node to initialize
     */
    public static void initializeSlideFadeFromRight(Node node) {
        node.setTranslateX(node.prefWidth(-1));
        node.setOpacity(0);
    }

    /**
     * Initializer for playing a sliding animation on a given node.
     * Should be called in the initialize() function.
     * @param node the node to initialize
     */
    public static void initializeSlideFromRight(Node node) {
        node.setTranslateX(node.prefWidth(-1));
    }

    /**
     * Makes a given node slide in from the right. While sliding the object will also fade in.
     * Sliding and fading takes 300 milliseconds.
     * @param node the node to play the animation on
     */
    public static void slideFadeInFromRight(Node node) {
        node.setOpacity(0);
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(300), node);
        translateTransition.setToX(0);

        FadeTransition fadeTransition = new FadeTransition(Duration.millis(300), node);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);

        fadeTransition.play();
        translateTransition.play();
    }

    /**
     * Makes a given node slide out to the right. While sliding the object will also fade out.
     * Sliding and fading takes 300 milliseconds.
     * @param node the node to play the animation on
     * @return the transition object for the slide animation
     */
    public static Transition slideFadeOutToRight(Node node) {
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(300), node);
        translateTransition.setToX(node.prefWidth(-1));

        FadeTransition fadeTransition = new FadeTransition(Duration.millis(300), node);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);

        fadeTransition.play();
        translateTransition.play();
        return translateTransition;
    }

    /**
     * Makes a given node slide in from the left. Sliding takes 250 milliseconds.
     * @param node the node to play the animation on
     */
    public static void slideInFromLeft(Node node) {
        TranslateTransition translateTransition = new TranslateTransition(new Duration(250), node);
        translateTransition.setToX(0);
        translateTransition.play();
    }

    /**
     * Makes a given node slide out to the left. Sliding takes 250 milliseconds.
     * @param node the node to play the animation on
     * @return the transition object
     */
    public static Transition slideOutToLeft(Node node) {
        TranslateTransition translateTransition = new TranslateTransition(new Duration(250), node);
        translateTransition.setToX(-node.prefWidth(-1));
        translateTransition.play();
        return translateTransition;
    }

}
