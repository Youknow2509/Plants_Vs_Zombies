package src;

import javafx.application.Application;

import javafx.stage.Stage;
import src.Config.Path;
import src.DataBase.Handle.HandleData;
import src.DataBase.Handle.HandleDataFile;

import src.Utils.ChangeScene;
import src.Utils.RandomListGameData;

public class main extends Application {

    @Override
    public void start(Stage primaryStage) {
        String title = "Plants vs Zombies";
        int width = 1024;
        int height = 600;
        String path = Path.VIEW_GameMain;
        ChangeScene changeScene = new ChangeScene(primaryStage, title, width, height, path);
        HandleData handleData = new HandleDataFile();
        int level = 1;
        changeScene.changeToGame(RandomListGameData.random(handleData.getDatalevel(level)));
    }

    public static void main(String[] args) {
        launch(args);
    }
}