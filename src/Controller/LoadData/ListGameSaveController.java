package src.Controller.LoadData;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import src.DataBase.Handle.HandleData;
import src.DataBase.Handle.HandleDataFile;
import src.Model.GameProcess;

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
    private HandleData handleData = new HandleDataFile();
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
    }

    @FXML
    public void edit(MouseEvent event) {
    }

    @FXML
    public void back(MouseEvent event) {
    }

    @FXML
    public void delete(MouseEvent event) {

    }
}
