package src.Controller.LoadData;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import src.Config.Path;
import src.Controller.Game.GameMainController;
import src.DataBase.Handle.HandleData;
import src.DataBase.Handle.HandleDataFile;
import src.Model.GameProcess;
import src.Utils.ChangeScene;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ListGameSaveController implements Initializable {
    // Var fxml
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TableView<GameProcess> tableView;
    @FXML
    private TableColumn<GameProcess, String> colName;
    @FXML
    private TableColumn<GameProcess, Integer> colLevel;
    @FXML
    private TableColumn<GameProcess, Integer> colPlantAlive;
    @FXML
    private TableColumn<GameProcess, Integer> colZombieAlive;
    @FXML
    private TableColumn<GameProcess, Integer> colZombieSpawner;

    // Var
    private ObservableList<GameProcess> observableList;
    private final HandleData handleData = new HandleDataFile();
    private List<GameProcess> listGameProsess;

    // Init
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listGameProsess = handleData.getDataSave();

        tableView.setPlaceholder(new Label("Không có dữ liệu !!!")); // hoặc bất kỳ nội dung nào bạn muốn

        observableList = FXCollections.observableArrayList(
                listGameProsess
        );

        colName.setCellValueFactory(new PropertyValueFactory<GameProcess, String>("nameGame"));
        colLevel.setCellValueFactory(new PropertyValueFactory<GameProcess, Integer>("Level"));
        colPlantAlive.setCellValueFactory(new PropertyValueFactory<GameProcess, Integer>("plantAlive"));
        colZombieAlive.setCellValueFactory(new PropertyValueFactory<GameProcess, Integer>("zombieAlive"));
        colZombieSpawner.setCellValueFactory(new PropertyValueFactory<GameProcess, Integer>("zombieSpawner"));

        tableView.setItems(observableList);
    }

    @FXML
    public void play(MouseEvent event) {
        GameProcess gameProcess = tableView.getSelectionModel().getSelectedItem();
        if (gameProcess == null) {
            return;
        }
        int width = 1024;
        int height = 600 ;
        String title = "Game Main";
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        ChangeScene changeScene = new ChangeScene(stage, title, width, height, Path.VIEW_GameMain);
        changeScene.changeToGame(gameProcess);
    }

    @FXML
    public void edit(MouseEvent event) {
        GameProcess gameProcess = tableView.getSelectionModel().getSelectedItem();
        if (gameProcess == null) {
            return;
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(Path.VIEW_EditGameSave));
            AnchorPane root = loader.load();

            EditGameSaveController editGameSaveController = loader.getController();
            editGameSaveController.initialize(gameProcess, tableView);

            Stage stage = new Stage();
            stage.setTitle("Edit Game Save");
            stage.setScene(new javafx.scene.Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void back(MouseEvent event) {
        int width = 1024;
        int height = 576 ;
        String title = "Home";
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        ChangeScene changeScene = new ChangeScene(stage, title, width, height, Path.VIEW_Home);
        changeScene.change();
    }

    @FXML
    public void delete(MouseEvent event) {
        GameProcess gameProcess = tableView.getSelectionModel().getSelectedItem();
        if (gameProcess == null) {
            return;
        }
        handleData.deleteDataSave(gameProcess.getNameGame());
        observableList.remove(gameProcess);
    }
}
