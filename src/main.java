package src;

import javafx.application.Application;

import javafx.stage.Stage;
import src.Config.Path;
import src.DataBase.Handle.HandleData;
import src.DataBase.Handle.HandleDataFile;

import src.Model.GameData;
import src.Model.GameProcess;
import src.Utils.ChangeScene;
import src.Utils.RandomListGameData;

public class main extends Application {

    private static GameData getGameDataLevel(int level) {
        HandleData handleData = new HandleDataFile();
        return RandomListGameData.randomGameData(handleData.getDatalevel(level));
    }

    private static GameProcess getGameDataSave() {
        HandleData handleData = new HandleDataFile();
        return RandomListGameData.randomGameProcess(handleData.getDataSave());
    }

    @Override
    public void start(Stage primaryStage) {
        String title = "Plants vs Zombies";
        int width = 1024;
        int height = 600;
        String path = Path.VIEW_GameMain;
        ChangeScene changeScene = new ChangeScene(primaryStage, title, width, height, path);

        //GameProcess gameProcess = getGameDataSave();
        GameProcess gameProcess = new GameProcess(getGameDataLevel(1));

        changeScene.changeToGame(gameProcess);
    }

    public static void main(String[] args) {
        launch(args);
    }
}