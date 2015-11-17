package project.view.manager.center;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.image.Image;
import project.model.House;

/**
 * Created 11/16/15
 *
 * @author Niels Norberg
 */
public class OverviewController {

    @FXML
    private TableColumn<House, String> addressColumn;

    @FXML
    private TableColumn<House, Image> messageColumn;

    @FXML
    private TableColumn<House, Image> notificationColumn;

    @FXML
    private void initialize() {

    }

}
