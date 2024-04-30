package src.Controller.Level;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import src.Config.Path;
import src.DataBase.Handle.HandleData;
import src.DataBase.Handle.HandleDataFile;
import src.Model.GameProcess;
import src.Utils.ChangeScene;
import src.Utils.RandomListGameData;

public class LevelController {
    // Var fxml
    @FXML
    private AnchorPane anchorPane;
    // Var
    HandleData handleData = new HandleDataFile();
    // Method
    @FXML
    public void clickBack(MouseEvent event) {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        ChangeScene cs = new ChangeScene(stage, "Home", 1024, 576, Path.VIEW_Home);
        cs.change();
    }

    @FXML
    public void clickLevel_1(MouseEvent event) {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        ChangeScene cs = new ChangeScene(stage, "Game", 1024, 600, Path.VIEW_GameMain);

        int level = 1;
        GameProcess gameProcess = new GameProcess(
                RandomListGameData.randomGameData(
                        handleData.getDatalevel(level)
                )
        );
        gameProcess.setLevel(level);

        cs.changeToGame(gameProcess);
    }

    @FXML
    public void clickLevel_2(MouseEvent event) {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        ChangeScene cs = new ChangeScene(stage, "Game", 1024, 600, Path.VIEW_GameMain);

        int level = 2;
        GameProcess gameProcess = new GameProcess(
                RandomListGameData.randomGameData(
                        handleData.getDatalevel(level)
                )
        );
        gameProcess.setLevel(level);

        cs.changeToGame(gameProcess);
    }

    @FXML
    public void clickLevel_3(MouseEvent event) {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        ChangeScene cs = new ChangeScene(stage, "Game", 1024, 600, Path.VIEW_GameMain);

        int level = 3;
        GameProcess gameProcess = new GameProcess(
                RandomListGameData.randomGameData(
                        handleData.getDatalevel(level)
                )
        );
        gameProcess.setLevel(level);

        cs.changeToGame(gameProcess);
    }

    @FXML
    public void clickLevel_4(MouseEvent event) {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        ChangeScene cs = new ChangeScene(stage, "Game", 1024, 600, Path.VIEW_GameMain);

        int level = 4;
        GameProcess gameProcess = new GameProcess(
                RandomListGameData.randomGameData(
                        handleData.getDatalevel(level)
                )
        );
        gameProcess.setLevel(level);

        cs.changeToGame(gameProcess);
    }
}
