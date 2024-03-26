package src.Model;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import src.Model.Plant.Plant;
import src.Model.Zombie.Zombie;
import src.Model.Zombie.ZombieSpawner;
import src.Utils.CardPlants;

public class GameProcess {
    // Variables
    private GameData gameData = null;
    private GridPane gridPane = null;
    private AnchorPane anchorPane = null;
    private CardPlants cardPlants = null;
    private Timeline timelineGame = null;
    private int durationDropSun = 0;
    // Constructor
    public GameProcess(GameData gameData, GridPane gridPane, AnchorPane anchorPane) {
        this.gameData = gameData;
        this.gridPane = gridPane;
        this.anchorPane = anchorPane;
        cardPlants = new CardPlants(anchorPane, gameData.getListCardPlant());
    }

    // Start Game
    public void startGame() {
        // Tạo ảnh cây gắn hành động
        for (int i = 0; i < gameData.getListPlant().size(); i++) {
            Plant plant = gameData.getListPlant().get(i);
            plant.setGridPane(gridPane);
            plant.createImageViewInGridPane();

            plant.resumeAttack();
        }
        // Tạo ảnh zombie gắn hành động
        for (int i = 0; i < gameData.getZombieAlive().size(); i++) {
            Zombie zombie = gameData.getZombieAlive().get(i);
            zombie.setAnchorPane(anchorPane);
            zombie.createImageView();

            zombie.resumeAttack();
            zombie.resumeMove();
        }
        // Tạp card
        cardPlants.getCards();
        // Tạo timeline
        timelineGame = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            gameData.setTick(gameData.getTick() + 1);
//            // Xử lí tạo ra dropsun sau một khoảng thời gian
//            if (durationDropSun == 0) {
//                dropSun.CreatSunDrop();
//                durationDropSun = dropSun.getDurationDropSun();
//            }
//            else {
//                durationDropSun--;
//            }
            // Xử lí tạo ra zombie
            while ((gameData.getZombieSpawner()).size() > 0 && (gameData.getZombieSpawner()).get(0).getTime() == gameData.getTick()) {
                ZombieSpawner zombieSpawner = (gameData.getZombieSpawner()).get(0);

                Zombie zombie = zombieSpawner.getZombie();

                zombie.createImageView();

                zombie.move();
                (gameData.getZombieAlive()).add(zombie);
                (gameData.getZombieSpawner()).remove(0);
            }
            // Kiểm tra trạng thái game và cập nhập phần trăm game
            // TODO: Thêm các trạng thái game và timneline game

        }));
        timelineGame.setCycleCount(Timeline.INDEFINITE);
        timelineGame.play();
    }
    // Pause Game
    public void pauseGame() {
        // Tam dung Zombie
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
