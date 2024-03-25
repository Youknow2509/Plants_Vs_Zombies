package src.Controller;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import src.Model.GameData;
import src.Model.GameProcess;

import javafx.scene.image.ImageView;
import src.Utils.LoadLevel;
import src.Utils.Shovel;

public class GameMainController {
    // Variables
    // FXML Variables
    @FXML
    private AnchorPane GamePlayRoot;
    @FXML
    private GridPane lawnGrid;
    @FXML
    private ImageView btnShovel;
    // Game Variables
    private GameProcess gameProcess = null;
    private GameData gameData = null;
    private LoadLevel loadLevel = null;
    private static String path = "";
    private static ImageView imageViewClickBefore = null;
    private static Shovel shovel = null;

    // Initialize
    @FXML
    public void initialize() {
        loadLevel = new LoadLevel("/Users/v/code/java/projects/PVZ/src/DataBase/Levels/Level_1/1.txt");
        loadLevel.read();
        gameData = loadLevel.getGameData();
        gameProcess = new GameProcess(gameData, lawnGrid, GamePlayRoot);
        gameProcess.startGame();

        shovel = new Shovel(GamePlayRoot, gameData.getListPlant(), btnShovel);
        shovel.getImageView().addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, e -> {
            shovel.handleClick();
        });
    }

    // Getters and Setters

    public GameProcess getGameProcess() {
        return gameProcess;
    }

    public void setGameProcess(GameProcess gameProcess) {
        this.gameProcess = gameProcess;
    }

    public GameData getGameData() {
        return gameData;
    }

    public void setGameData(GameData gameData) {
        this.gameData = gameData;
    }

    public static String getPath() {
        return path;
    }

    public static void setPath(String path) {
        GameMainController.path = path;
    }

    public static ImageView getImageViewClickBefore() {
        return imageViewClickBefore;
    }

    public static void setImageViewClickBefore(ImageView imageViewClickBefore) {
        GameMainController.imageViewClickBefore = imageViewClickBefore;
    }

    public static Shovel getShovel() {
        return shovel;
    }

    public static void setShovel(Shovel shovel) {
        GameMainController.shovel = shovel;
    }
}