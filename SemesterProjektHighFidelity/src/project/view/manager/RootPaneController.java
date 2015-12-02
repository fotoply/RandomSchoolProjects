package project.view.manager;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

/**
 * Created 11/13/15
 *
 * @author Niels Norberg
 */
public class RootPaneController {

    @FXML
    private BorderPane rootPane; // The main root BorderPane. Is used for accessing other parts of the program

    @FXML
    public void initialize() {
        /*Image bckImage = new Image(getClass().getResourceAsStream("/project/res/background.png"));
        BackgroundImage bck = new BackgroundImage(bckImage,null,null,null, BackgroundSize);

        rootPane.setBackground(new Background(bck));*/

    }

    public BorderPane getRootPane() {
        return rootPane;
    }
}
