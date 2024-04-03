package src.Model;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
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
    }

    // Start Game
    public void startGame() {
        DropSun dropSun = new DropSun();
        timelineGame = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            // Random Sun
            if (gameData.getDurationDropSun() == 0) {
                dropSun.CreatSunDrop();
                gameData.setDurationDropSun(dropSun.getDurationDropSun());
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

            // Tang tick
            gameData.setTick(gameData.getTick() + 1);
        }
        ));
        timelineGame.setCycleCount(Timeline.INDEFINITE);
        timelineGame.play();
    }

    // Stop Game
    public void stopGame() {
        // TODO Stop Game
    }

    // Pause Game
    public void pauseGame() {
        // TODO Pause Game
    }

    // Resume Game
    public void resumeGame() {
        // TODO Resume Game
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
}
