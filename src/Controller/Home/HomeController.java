package src.Controller.Home;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import src.Config.Path;
import src.Utils.ChangeScene;

public class HomeController {
    // Var fxml
    @FXML
    private ImageView exit;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private AnchorPane load;
    @FXML
    private ImageView bg;

    // Var

    // Init

    // Event

    // Load
    public void clickLoad(MouseEvent event) {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        ChangeScene changeScene = new ChangeScene(stage, "Load Data", 1440, 850, Path.VIEW_ListGameSave);
        changeScene.change();
    }
    // Play
    public void clickNewGame(MouseEvent event) {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        ChangeScene changeScene = new ChangeScene(stage, "New Game", 1024, 594, Path.VIEW_Level);
        changeScene.change();
    }
    // Exit
    public void clickExit(MouseEvent event) {
        System.exit(0);
    }
}
