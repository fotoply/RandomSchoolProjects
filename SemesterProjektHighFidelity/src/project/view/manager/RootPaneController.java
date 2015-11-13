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
    private BorderPane rootPane;

    @FXML
    public void initialize() {

    }

    public BorderPane getRootPane() {
        return rootPane;
    }
}
