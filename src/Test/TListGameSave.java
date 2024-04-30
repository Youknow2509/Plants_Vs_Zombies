package src.Test;

import javafx.application.Application;
import javafx.stage.Stage;
import src.Utils.ChangeScene;

public class TListGameSave extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        String loc = "/src/View/LoadData/ListGameSave.fxml";
        ChangeScene changeScene = new ChangeScene(stage, "List Game Save", 1440, 850, loc);
        changeScene.change();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
