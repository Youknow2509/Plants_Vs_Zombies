package src;

import javafx.application.Application;

import javafx.stage.Stage;
import src.DataBase.Handle.HandleLoadLevel;
import src.Utils.ChangeScene;

public class main extends Application {

    @Override
    public void start(Stage primaryStage) {
        String title = "Plants vs Zombies";
        int width = 1024;
        int height = 600;
        String path = "/src/View/GameMain.fxml";
        ChangeScene changeScene = new ChangeScene(primaryStage, title, width, height, path);
        HandleLoadLevel handleLoadLevel = new HandleLoadLevel(1);
        changeScene.changeToGame(handleLoadLevel.loadLevel());
    }

    public static void main(String[] args) {
        launch(args);
    }
}