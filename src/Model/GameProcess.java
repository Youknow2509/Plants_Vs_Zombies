package src.Model;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import src.Controller.Game.GameMainController;
import src.Help.LawnMower.LawnMower;
import src.Model.Plants.Plant;
import src.Model.Zombies.Zombie;
public class GameProcess {
    // Variables
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
    }

    // Start Game
    public void startGame() {
        timelineGame = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            // Random Sun
            if (gameData.getDurationDropSun() == 0) {
                gameData.getDropSun().CreatSunDrop();
                gameData.setDurationDropSun(gameData.getDropSun().getDurationDropSun());
            } else {
                gameData.setDurationDropSun(gameData.getDurationDropSun() - 1);
            }
            // Xử lí tạo ra zombie sản sinh
            while (gameData.getZombieSpawner().size() > 0 && gameData.getZombieSpawner().get(0).getTime() == gameData.getTick()) {
                ZombieSpawner zombieSpawner = gameData.getZombieSpawner().get(0);
                Zombie zombie = zombieSpawner.getZombie();
                zombie.createImageView();
                zombie.start();
                gameData.getZombieAlive().add(zombie);
                gameData.getZombieSpawner().remove(0);
            }
            // Xử lí hiển thị phần trăm game
            GameMainController.getProgressBar().setProgress((double) (gameData.getSumZombie() - gameData.getZombieSpawner().size())
                                                                        /gameData.getSumZombie());
            if (GameMainController.getWonGame() == 1 ||
                (gameData.getZombieSpawner().size() == 0 && gameData.getZombieAlive().size() == 0)) {
                // todo xử lí thắng
                System.out.println("You win");
                System.exit(0);
            }
            if (GameMainController.getWonGame() == 0) {
                // todo xử lí thua
                System.out.println("You loss");
                System.exit(0);
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
        // Tải các thẻ cây
        for (int i = 0; i < gameData.getCardPlantList().size(); i++) {
            gameData.getCardPlantList().get(i).createImage(); // tái tạo lại hình ảnh
        }
        // Tải các zombie đang tồn tại
        for (int i = 0; i < gameData.getZombieAlive().size(); i++) {
            gameData.getZombieAlive().get(i).createImageView();
            gameData.getZombieAlive().get(i).start();
        }
        // Tải các thực thể cây đang tồn tại
        for (int i = 0; i < gameData.getListPlant().size(); i++) {
            gameData.getListPlant().get(i).createImageView();
            gameData.getListPlant().get(i).start();
        }
        // Xử lí lấy ra LawnMower
        for (int i = 0; i < gameData.getLawnMowers().size(); i++) {
            gameData.getLawnMowers().get(i).createImageView();
            gameData.getLawnMowers().get(i).start();
        }
    }

    // Save Game
    public void saveGame() {
        // TODO Save Game
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
}
