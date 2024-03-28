package src;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import src.Utils.ChangeScene;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        String title = "Plants vs Zombies";
        int width = 1024;
        int height = 600;
        String path = "/src/View/GameMain.fxml";
        ChangeScene changeScene = new ChangeScene(primaryStage, title, width, height, path);
        changeScene.change();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
