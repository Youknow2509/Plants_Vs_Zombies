package src.Controller.Game;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import src.Config.Path;
import src.Utils.ChangeScene;

public class GameLoseController {
    // Var fxml
    @FXML
    private AnchorPane anchorPane;

    // Var
    private Stage stageBefore;

    // Init
    @FXML
    public void initialize(Stage stageBefore) {
        this.stageBefore = stageBefore;

        timeOutChangeToHome();
    }
    // Method
    @FXML
    public void back(MouseEvent event) {
        helpChangToHome();
    }

    // Time out change to home - If dont click back
    private void timeOutChangeToHome() {
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.seconds(5),
                    event -> {
                        helpChangToHome();
                }
        ));
        timeline.setCycleCount(1);
        timeline.play();
    }

    // Help change to home
    public void helpChangToHome() {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        if (stage != null) {
            stage.close();
        }

        ChangeScene changeScene = new ChangeScene(stageBefore, "Home", 1024, 576, Path.VIEW_Home);
        changeScene.change();
    }

    // Getter - Setter
    public void setAnchorPane(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
    }

    public Stage getStageBefore() {
        return stageBefore;
    }

    public void setStageBefore(Stage stageBefore) {
        this.stageBefore = stageBefore;
    }
}
