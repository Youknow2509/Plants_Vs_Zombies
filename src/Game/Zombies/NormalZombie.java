package src.Game.Zombies;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import javafx.util.Pair;
import src.Controller.GamePlayController;
import src.Game.Plants.Plant;

public class NormalZombie extends Zombie {
    private final static int HP = 150;
    private final static int SPEED = 5;
    private final static int DAMAGE = 10;
    private final static String PATH = "Assets/images/Zombies/NormalZombieRun.gif";
    private boolean flag = true; // true : zombie đang di chuyển, false: zombie dừng lại tấn công.

    public NormalZombie(int lane) {
        super(975, laneToLayoutY(lane), PATH, 100, 130, lane, SPEED, HP, DAMAGE);
    }

    @Override
    public void move() {
        TimeLineMove();
        moveZombie.setCycleCount(Timeline.INDEFINITE);
        moveZombie.play();
    }
    @Override
    public void attack() {

    }
    public void TimeLineMove() {
        moveZombie = new Timeline(
                new KeyFrame(Duration.millis(1000), e -> {
                    if (flag) { // xử lí việc di chuyển
                        if (getX() < 0 || getHp() <= 0) {
                            moveZombie.stop();
                            (getImageView()).setVisible(false);
                            (getImageView()).setDisable(true);
                        } else {
                            setX(getX() - getSpeed());
                            eatPlant();
                        }
                    }
                    else { // xử lí ăn khi đi đến gần cây
                        eatPlant();
                    }
                })
        );
    }
    private void eatPlant() {
        synchronized (GamePlayController.plants) {
            for (int i = 0; i < GamePlayController.plants.size(); i++) {
                Plant p = GamePlayController.plants.get(i);
                if (p.getLane() == getLane() && getX() - p.getX() <= 20) {
                    flag = false;
                    p.setHp(p.getHp() - DAMAGE);
                    System.out.println("Plant hp: " + p.getHp());
                    if (p.getHp() <= 0) {
                        p.getImageView().setVisible(false);
                        p.getImageView().setDisable(true);
                        GamePlayController.plants.remove(p);
                        flag = true;
                    }
                    break;
                }
            }
        }
    }
}
