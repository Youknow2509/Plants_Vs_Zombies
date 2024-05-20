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
import src.Config.Path;
import src.DataBase.Handle.HandleData;
import src.DataBase.Handle.HandleDataFile;
import src.Model.GameData;
import src.Model.GameProcess;
import src.Utils.ChangeScene;
import src.Utils.FindFileinFolder;

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

    // Xử lí tiếp tục game - Khi game đã được lưu
    @FXML
    public void tiepTuc(ActionEvent event) {
        Stage stage = (Stage) hBox.getScene().getWindow();
        stage.close();
        gameProcess.resumeGame();
    }

    // Xử lí lưu game
    @FXML
    public void luu(ActionEvent event) {
        String nameGameData = gameProcess.getNameGame();
        if (nameGameData == null || nameGameData.equals("")) {
            changeInputNameGame_save();
        } else {
            handleData.updateDataSave(gameProcess);
        }
    }

    @FXML
    public void quayLaiHome(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
        gameProcess.stopGame();
        ChangeScene changeScene = new ChangeScene(stageBefore, "Home", 1024, 576, Path.VIEW_Home);
        changeScene.change();
    }

    // Xử lí input name game - Khi chưa có tên game ( Sự kiện tiếp theo chỉ diễn ra khi tên không tồn tại, không phải khoảng trắng, ... )
    @FXML
    public void inputNameGame(MouseEvent event) {
        String nameInput = textNameGame.getText();
        if ((nameInput != null || !nameInput.equals("")) &&
                FindFileinFolder.findFile(Path.PATH_GameSave, nameInput + ".ser") == null
        ) {
            gameProcess.setNameGame(nameInput);
            handleData.addDataSave(gameProcess);
            changeInputNameGame_save();
            System.out.println("Đã lưu game: " + nameInput);
        } else {
            System.out.println("Tên game đã tồn tại hoặc không hợp lệ");
            textNameGame.setStyle("-fx-border-color: red;");
            textNameGame.setText("");
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
