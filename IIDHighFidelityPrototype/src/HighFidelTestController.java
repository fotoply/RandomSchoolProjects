import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created 11/9/15
 *
 * @author Niels Norberg
 */
public class HighFidelTestController {
    Image imagePlay = new Image(getClass().getResourceAsStream("res/Play button.png"));
    Image imagePause= new Image(getClass().getResourceAsStream("res/Pause button.png"));
    Image imageSkip = new Image(getClass().getResourceAsStream("res/Skip button.png"));
    Image imageBack = new Image(getClass().getResourceAsStream("res/Back button.png"));
    Image imagePlayFilled = new Image(getClass().getResourceAsStream("res/Play button (Filled).png"));
    Image imagePauseFilled= new Image(getClass().getResourceAsStream("res/Pause button (Filled).png"));
    Image imageSkipFilled = new Image(getClass().getResourceAsStream("res/Skip button (Filled).png"));
    Image imageBackFilled = new Image(getClass().getResourceAsStream("res/Back button (Filled).png"));
    Image imageBackground = new Image(getClass().getResourceAsStream("res/Backgroundsquare.png"));
    Stage primaryStage;

    boolean playing = false;

    @FXML
    private void initialize() {
        backButton.setGraphic(new ImageView(imageBack));
        playButton.setGraphic(new ImageView(imagePlay));
        skipButton.setGraphic(new ImageView(imageSkip));
        backgoundAreaView.setImage(imageBackground);

        playButton.setBackground(Background.EMPTY);
        backButton.setBackground(Background.EMPTY);
        skipButton.setBackground(Background.EMPTY);
    }

    public void mouseDragged(MouseEvent e) {
        if(e.getX() > 20 && e.getX() < backgoundAreaView.getFitWidth()) {
            selectionBox.setX(e.getX()-135);
        }
        if(e.getY() > 20 && e.getY() < backgoundAreaView.getFitHeight()-20) {
            selectionBox.setY(e.getY()-175);
        }
        if(e.getX() < 20) {
            selectionBox.setX(-(backgoundAreaView.getFitWidth()/2)+10);
        }
        if(e.getX() > backgoundAreaView.getFitWidth()) {
            selectionBox.setX(backgoundAreaView.getFitWidth()/2-10);
        }
        if(e.getY() < 10) {
            selectionBox.setY(-(backgoundAreaView.getFitHeight()/2)+30);
        }
        if(e.getY() > backgoundAreaView.getFitHeight()-50) {
            selectionBox.setY((backgoundAreaView.getFitHeight())/2-30);
        }
        pauseMusic();
        //getMoodNumbers();
    }

    public ArrayList<Double> getMoodNumbers() {
        ArrayList<Double> mood = new ArrayList<>();
        mood.add((selectionBox.getX())/100);
        mood.add(((selectionBox.getY())*-1)/100);
        //System.out.println(Arrays.toString(mood.toArray()));
        return mood;
    }

    public String getMoodAndSong() {
        String result = "none";
        ArrayList<Double> mood = getMoodNumbers();


        if(mood.get(0) < -0.5) {
            if(mood.get(1) < -0.7) {
                result = "Very sad slow";
            } else if(mood.get(1) < 0) {
                result = "Slow and kinda sad";
            } else if(mood.get(1) < 0.7) {
                result = "Uplifting";
            } else {
                result = "Happy beating";
            }
        } else if(mood.get(0) < 0) {
            if(mood.get(1) < -0.7) {
                result = "Sad beats";
            } else if(mood.get(1) < 0) {
                result = "Neutral beating";
            } else if(mood.get(1) < 0.7) {
                result = "Happy slow tempo";
            } else {
                result = "Slow tempo light";
            }
        } else if(mood.get(0) < 0.5) {
            if(mood.get(1) < -0.7) {
                result = "Upbeat angry";
            } else if(mood.get(1) < 0) {
                result = "Normal paced neutral";
            } else if(mood.get(1) < 0.7) {
                result = "Upbeat happy";
            } else {
                result = "Light pace light";
            }
        } else {
            if(mood.get(1) < -0.7) {
                result = "Very angry";
            } else if(mood.get(1) < 0) {
                result = "Dubstep-like thing";
            } else if(mood.get(1) < 0.7) {
                result = "Neutral mood fast";
            } else {
                result = "Very happy upbeat";
            }
        }


        return result;
    }

    @FXML
    private Text currentSongLabel;

    @FXML
    private ImageView selectionBox;

    @FXML
    private Button backButton;

    @FXML
    private Button playButton;

    @FXML
    private Button skipButton;

    @FXML
    private ImageView backgoundAreaView;

    @FXML
    public void playClicked() {
        if(!playing) {
            startMusic();
        } else {
            pauseMusic();
        }
    }

    public void startMusic() {
        playing = true;
        playButton.setGraphic(new ImageView(imagePause));
        currentSongLabel.setText("Currently playing: " + getMoodAndSong());
    }

    public void pauseMusic() {
        playing = false;
        playButton.setGraphic(new ImageView(imagePlay));
    }

    @FXML
    public void playButtonPressed() {
        if(playing) {
            playButton.setGraphic(new ImageView(imagePauseFilled));
        } else {
            playButton.setGraphic(new ImageView(imagePlayFilled));
        }
    }

    @FXML
    public void playHoverStart() {
        playButton.setBlendMode(BlendMode.HARD_LIGHT);
    }

    @FXML
    public void playHoverEnd() {
        playButton.setBlendMode(BlendMode.SRC_OVER);
    }

    @FXML
    public void skipButtonClicked() {
        skipButton.setGraphic(new ImageView(imageSkipFilled));
    }

    @FXML
    public void skipButtonReleased() {
        skipButton.setGraphic(new ImageView(imageSkip));
    }

    @FXML
    public void backButtonClicked() {
        backButton.setGraphic(new ImageView(imageBackFilled));
    }

    @FXML
    public void backButtonReleased() {
        backButton.setGraphic(new ImageView(imageBack));
    }

}
