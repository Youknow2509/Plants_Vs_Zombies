package src.Controller.Game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import src.DataBase.Handle.HandleData;
import src.DataBase.Handle.HandleDataFile;
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
    @FXML
    private HBox box_Input_Name_Game;
    @FXML
    private TextField textNameGame;
    @FXML
    private ImageView btn_InputName;
    // Var
    Stage stageBefore;
    GameData gameData;
    GameProcess gameProcess;
    HandleData handleData;


    // Initialize
    public void initialize(Stage stage, GameProcess gameProcess) {
        //
        this.stageBefore = stage;
        this.gameProcess = gameProcess;
        this.gameData = gameProcess.getGameData();
        //
        gameProcess.pauseGame();
        //
        handleData = new HandleDataFile();
    }


    @FXML
    public void tiepTuc(ActionEvent event) {
        Stage stage = (Stage) hBox.getScene().getWindow();
        stage.close();
        gameProcess.resumeGame();
    }

    @FXML
    public void luu(ActionEvent event) {
        String nameGameData = gameData.getNameGameData();
        if (nameGameData == null || nameGameData.equals("")) {
            changeInputNameGame_save();
        } else {
            handleData.updateDataSave(gameData, nameGameData);
        }
    }

    @FXML
    public void quayLaiHome(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    public void inputNameGame(MouseEvent event) {
        String nameInput = textNameGame.getText();
        if (nameInput != null && !nameInput.equals("")) {
            gameData.setNameGameData(nameInput);
            handleData.addDataSave(gameData, nameInput);
            changeInputNameGame_save();
        }
    }

    // change input name game and save view
    private void changeInputNameGame_save() {
        if (luu.isVisible()) {
            box_Input_Name_Game.setVisible(true);
            luu.setVisible(false);
        } else {
            box_Input_Name_Game.setVisible(false);
            luu.setVisible(true);
        }
    }
}
