package src.Model;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import src.Controller.GameMainController;
import src.Model.Plants.Pea.Pea;
import src.Model.Plants.Plant;
import src.Model.Plants.Sun.DropSun;
import src.Model.Zombies.Zombie;
public class GameProcess {
    // Variables
    private GameData gameData = null;
    private Timeline timelineGame = null;

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
            // Xử lí tạo ra zombie
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
        // Stop timeline
        timelineGame.stop();
        // TODO chua check stop pea cua peashooter
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
        // Stop timeline
        timelineGame.pause();
        // TODO chua check pause pea cua peashooter
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
        // resume timeline
        timelineGame.pause();
        // TODO chua check resume pea cua peashooter
    }

    // Load Game
    public void loadGame() {
        // TODO Load Game
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
