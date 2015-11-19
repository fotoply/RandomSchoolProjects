package project.view.manager;

import javafx.animation.Transition;

/**
 * Created 11/18/15
 *
 * @author Niels Norberg
 */
public interface OpenCloseAnimated {

    /**
     * Is called when the node is opened and should play the opening animation.
     */
    void openNode();

    /**
     * Is called when the node is closed and should trigger a closing animation
     *
     * @return should return a transition so that the main thread can wait for the animation to finish
     */
    Transition closeNode();

}
