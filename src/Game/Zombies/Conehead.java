package src.Game.Zombies;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import src.Controller.GamePlayController;

public class Conehead extends Zombie {
    private final static int HP = 150;
    private final static int SPEED = 5;
    private final static int DAMAGE = 10;
    private final static String PATH = "Assets/images/Zombies/ConeheadZombie.gif";

    public Conehead(int lane) {
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
                    if (getHp() <= 0 || getX() < 0) {
                        moveZombie.stop();
                        (getImageView()).setVisible(false);
                        (getImageView()).setDisable(true);
                        GamePlayController.zombies.remove(this);
                    }
                    else {
                        setX(getX() - getSpeed());
                    }
                })
        );
    }
}
