package project.view.manager.center;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.image.ImageView;
import project.MainManager;
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
    private TableColumn<House, ImageView> messageColumn;

    @FXML
    private TableColumn<House, ImageView> notificationColumn;
    private MainManager root;

    @FXML
    private void initialize() {

    }

    public void setRoot(MainManager root) {
        this.root = root;
    }
}
