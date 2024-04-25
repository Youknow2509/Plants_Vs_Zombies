package src.Controller.Game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import src.Model.GameData;
import src.Model.GameProcess;

public class MenuGameController {
    // Var fxml
    @FXML
    private Button tiepTuc;
    @FXML
    private HBox hBox;
    @FXML
    private Button luu;
    @FXML
    private Button quayLaiHome;

    // Var
    Stage stageBefore;
    GameData gameData;
    GameProcess gameProcess;
    // Initialize
    public void initialize(Stage stage, GameProcess gameProcess) {
        //
        this.stageBefore = stage;
        this.gameProcess = gameProcess;
        //
        gameProcess.pauseGame();
    }

    //

    public void tiepTuc(ActionEvent event) {
        Stage stage = (Stage) hBox.getScene().getWindow();
        stage.close();
        gameProcess.resumeGame();
    }

    public void luu(ActionEvent event) {
        // todo
        System.out.println("Clicked Luu");
    }

    public void quayLaiHome(ActionEvent event) {
        // todo
        System.out.println("Clicked Quay Lai Home");
        System.exit(0);
    }
}
