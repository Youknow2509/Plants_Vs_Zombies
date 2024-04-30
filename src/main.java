package src;

import javafx.application.Application;

import javafx.stage.Stage;
import src.Config.Path;
import src.Utils.ChangeScene;

public class main extends Application {

    @Override
    public void start(Stage primaryStage) {
        String title = "Plants vs Zombies";
        int width = 1024;
        int height = 576;
        String path = Path.VIEW_Home;
        ChangeScene changeScene = new ChangeScene(primaryStage, title, width, height, path);

        changeScene.change();
    }

    public static void main(String[] args) {
        launch(args);
    }
}