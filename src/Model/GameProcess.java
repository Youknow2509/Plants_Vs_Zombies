package src.Model;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import src.Config.Path;
import src.Controller.Game.GameLoseController;
import src.Controller.Game.GameMainController;
import src.Controller.Game.GameWinController;
import src.Help.LawnMower.LawnMower;
import src.Model.Characters.Plants.Plant;
import src.Model.Characters.Zombies.Zombie;

import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;

public class GameProcess implements Serializable {
    // SerialVersionUID
    @Serial
    private static final long serialVersionUID = 1L;
    // Variables
    private int idGame;
    private String nameGame = null;
    private int Level;
    private GameData gameData = null;
    private transient Timeline timelineGame = null;

    // Constructor
    public GameProcess() {
        super();
    }

    public GameProcess(GameData gameData) {
        super();
        this.gameData = gameData;
        gameData.loadSumZombie();
        gameData.creatListPercentFlag();
    }

    public GameProcess(int idGame, String nameGame, int level, GameData gameData) {
        this.idGame = idGame;
        this.nameGame = nameGame;
        Level = level;
        this.gameData = gameData;
    }

    // Start Game
    public void startGame() {
        timelineGame = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            // Xử lí tạo ra zombie sản sinh
            while (gameData.getZombieSpawner().size() > 0 && gameData.getZombieSpawner().get(0).getTime() == gameData.getTick()) {
                ZombieSpawner zombieSpawner = gameData.getZombieSpawner().get(0);
                Zombie zombie = zombieSpawner.getZombie();
                zombie.start();
                gameData.getZombieAlive().add(zombie);
                gameData.getZombieSpawner().remove(0);
            }
            // Xử lí hiển thị phần trăm game
            GameMainController.getProgressBar().setProgress((double) (gameData.getSumZombie() - gameData.getZombieSpawner().size())
                                                                        / gameData.getSumZombie());
            if (GameMainController.getWonGame() == 1 ||
                (gameData.getZombieSpawner().size() == 0 && gameData.getZombieAlive().size() == 0)) {

                stopGame();

                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource(Path.VIEW_GameWin));
                    Parent root = loader.load();

                    GameWinController gameWinController = loader.getController();
                    gameWinController.initialize(GameMainController.getStage());

                    Stage popupStage = new Stage();
                    popupStage.initModality(Modality.APPLICATION_MODAL);
                    popupStage.setScene(new Scene(root));

                    GameMainController.setWonGame(-1);

                    Platform.runLater(() -> {
                        popupStage.showAndWait();
                        popupStage.centerOnScreen();
                        popupStage.setResizable(false);
                    });
                } catch (IOException event) {
                    event.printStackTrace();
                }
            }
            if (GameMainController.getWonGame() == 0) {

                stopGame();

                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource(Path.VIEW_GameLose));
                    Parent root = loader.load();

                    GameLoseController gameLoseController = loader.getController();
                    gameLoseController.initialize(GameMainController.getStage());

                    Stage popupStage = new Stage();
                    popupStage.initModality(Modality.APPLICATION_MODAL);
                    popupStage.setScene(new Scene(root));

                    GameMainController.setWonGame(-1);

                    Platform.runLater(() -> {
                        popupStage.showAndWait();
                        popupStage.centerOnScreen();
                        popupStage.setResizable(false);
                    });
                } catch (IOException event) {
                    event.printStackTrace();
                }
            }
            // Tang tick
            gameData.setTick(gameData.getTick() + 1);
        }
        ));
        timelineGame.setCycleCount(Timeline.INDEFINITE);
        loadGame();
        timelineGame.play();
    }

    // Stop Game
    public void stopGame() {
        // Stop zombie
        for (Zombie zombie : gameData.getZombieAlive()) {
            zombie.stop();
        }
        // Stop dropsun
        gameData.getDropSun().stop();
        // Stop plants
        for (Plant plant : gameData.getListPlant()) {
            plant.stop();
        }
        // Stop LawnMower todo chua check
        for (LawnMower lawnMower : gameData.getLawnMowers()) {
            lawnMower.stop();
        }
        // Stop timeline
        timelineGame.stop();
    }

    // Pause Game
    public void pauseGame() {
        // Pause zombie
        for (Zombie zombie : gameData.getZombieAlive()) {
            zombie.pause();
        }
        // Pause dropsun
        gameData.getDropSun().pause();
        // Pause plants
        for (Plant plant : gameData.getListPlant()) {
            plant.pause();
        }
        // Pause LawnMower todo chua check
        for (LawnMower lawnMower : gameData.getLawnMowers()) {
            lawnMower.pause();
        }
        // Stop timeline
        timelineGame.pause();
    }

    // Resume Game
    public void resumeGame() {
        // resume zombie
        for (Zombie zombie : gameData.getZombieAlive()) {
            zombie.resume();
        }
        // resume dropsun
        gameData.getDropSun().resume();
        // resume plants
        for (Plant plant : gameData.getListPlant()) {
            plant.resume();
        }
        // resume LawnMower todo chua check
        for (LawnMower lawnMower : gameData.getLawnMowers()) {
            lawnMower.resume();
        }
        // resume timeline
        timelineGame.play();
    }

    // Load Game
    public void loadGame() {
        // Tải dropsun
        gameData.getDropSun().start();
        // Tải các thẻ cây
        for (int i = 0; i < gameData.getCardPlantList().size(); i++) {
            gameData.getCardPlantList().get(i).createImage(); // tái tạo lại hình ảnh
        }
        // Tải các zombie đang tồn tại
        for (int i = 0; i < gameData.getZombieAlive().size(); i++) {
            gameData.getZombieAlive().get(i).start();
        }
        // Tải các thực thể cây đang tồn tại
        for (int i = 0; i < gameData.getListPlant().size(); i++) {
            gameData.getListPlant().get(i).start();
        }
        // Xử lí lấy ra LawnMower
        for (int i = 0; i < gameData.getLawnMowers().size(); i++) {
            gameData.getLawnMowers().get(i).start();
        }
    }

    // To String
    @Override
    public String toString() {
        return "GameProcess{" +
                "idGame=" + idGame +
                ", nameGame='" + nameGame + '\'' +
                ", Level=" + Level +
                ", gameData=" + gameData +
                '}';
    }

    // Getters and Setters
    public GameData getGameData() {
        return gameData;
    }

    public void setGameData(GameData gameData) {
        this.gameData = gameData;
    }

    public Timeline getTimelineGame() {
        return timelineGame;
    }

    public void setTimelineGame(Timeline timelineGame) {
        this.timelineGame = timelineGame;
    }

    public int getIdGame() {
        return idGame;
    }

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }

    public String getNameGame() {
        return nameGame;
    }

    public void setNameGame(String nameGame) {
        this.nameGame = nameGame;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        Level = level;
    }

    // Get Zombie Alive
    public int getZombieAlive() {
        return gameData.getZombieAlive().size();
    }

    // Get Zombie Spawner
    public int getZombieSpawner() {
        return gameData.getZombieSpawner().size();
    }

    // Get Plant Alive
    public int getPlantAlive() {
        return gameData.getListPlant().size();
    }
}
