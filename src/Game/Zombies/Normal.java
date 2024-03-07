package src.Game.Zombies;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import src.Controller.GamePlayController;
import src.Game.Plants.Plant;

public class Normal extends Zombie {
    private final static int HP = 120;
    private final static int SPEED = 5;
    private final static int DAMAGE = 10;
    private final static String PATH = "Assets/images/Zombies/NormalZombieRun.gif";

    public Normal(int lane) {
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
                    if (getFlag()) { // xử lí việc di chuyển
                        if (getX() < 0 || getHp() <= 0) {
                            moveZombie.stop();
                            rmImage((AnchorPane) getImageView().getParent());
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
            boolean checkZombie = false; // true là đang có zombie để ăn, false là không - xử lí khi zombie đang ăn cây thì cây bị xoá
            for (int i = 0; i < GamePlayController.plants.size(); i++) {
                Plant p = GamePlayController.plants.get(i);
                if (p.getLane() == getLane() && getX() - p.getX() <= 30) {
                    checkZombie = true;
                    setFlag(false);
                    p.setHp(p.getHp() - DAMAGE);
                    if (p.getHp() <= 0) {
                        p.rmImage((GridPane) p.getImageView().getParent());
                        p.rmTlDame();
                        GamePlayController.plants.remove(p);
                        setFlag(true);
                    }
                    System.out.println("Plant hp: " + p.getHp());
                    break;
                }
            }
            if (!checkZombie) {
                setFlag(true);
            }
        }
    }
}
