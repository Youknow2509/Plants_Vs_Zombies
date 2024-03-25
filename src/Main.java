package src;

import javafx.application.Application;
import src.Utils.ChangeScene;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(javafx.stage.Stage primaryStage) {
        String title = "Plants vs Zombies";
        String path = "/src/View/GameMain.fxml";
        int width = 1024;
        int height = 600;
        ChangeScene changeScene = new ChangeScene(primaryStage, title, width, height, path);
        changeScene.change();
    }
}
