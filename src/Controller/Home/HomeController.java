package src.Controller.Home;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

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

    }
    // Play
    public void clickNewGame(MouseEvent event) {

    }
    // Exit
    public void clickExit(MouseEvent event) {
        System.exit(0);
    }
}
