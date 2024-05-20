package src.Controller.LoadData;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import src.Config.Path;
import src.DataBase.Handle.HandleData;
import src.DataBase.Handle.HandleDataFile;
import src.Model.GameProcess;
import src.Utils.FindFileinFolder;

public class EditGameSaveController {
    // Var fxml
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Text nameGame;
    @FXML
    private Text zombieSpqwner;
    @FXML
    private Text level;
    @FXML
    private ImageView save;
    @FXML
    private ImageView back;
    @FXML
    private Text plantAlive;
    @FXML
    private TextField nameEdit;
    @FXML
    private Text zombieAlive;
    // Var
    private GameProcess gameProcess;
    private TableView<GameProcess> tableView;
    private HandleData handleData;
    // Init
    public void initialize(GameProcess gameProcess, TableView<GameProcess> tableView) {

        this.gameProcess = gameProcess;
        this.tableView = tableView;

        setValueDefault();

        handleData = new HandleDataFile();
    }
    @FXML
    public void backToGameUser(MouseEvent event) {
        closePopup();
    }

    @FXML
    public void updateGameUser(MouseEvent event) {
        String nameNew = nameEdit.getText();
        if (nameNew.equals("") ||
                FindFileinFolder.findFile(Path.PATH_GameSave, nameNew + ".ser") != null
        ) {
            nameEdit.setStyle("-fx-border-color: red;");
            nameEdit.setText("");
            return;
        }
        String nameOld = gameProcess.getNameGame();
        gameProcess.setNameGame(nameNew);

        tableView.refresh();

        handleData.deleteDataSave(nameOld);
        handleData.addDataSave(gameProcess);

        closePopup();
    }

    // Set value default
    public void setValueDefault() {
        nameGame.setText(String.valueOf(gameProcess.getNameGame()));
        level.setText(String.valueOf(gameProcess.getLevel()));
        plantAlive.setText(String.valueOf(gameProcess.getPlantAlive()));
        zombieAlive.setText(String.valueOf(gameProcess.getZombieAlive()));
        zombieSpqwner.setText(String.valueOf(gameProcess.getZombieSpawner()));
    }

    // Help close popup
    private void closePopup() {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();
    }
}
