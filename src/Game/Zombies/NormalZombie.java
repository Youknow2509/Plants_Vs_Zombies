package src.Game.Zombies;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import javafx.util.Pair;

public class NormalZombie extends Zombie {
    private final static int HP = 100;
    private final static int SPEED = 5;
    private final static int DAMAGE = 10;
    private final static String PATH = "Assets/images/Zombies/NormalZombieRun.gif";

    public NormalZombie() {
        super();
    }
    public NormalZombie(int lane) {
        super(975, laneToLayoutY(lane), PATH, 100, 130, lane, SPEED, HP, DAMAGE);
    }
    public void e(){
        if (getHp() <= 0 || getImageView().getX() < 0) {
            moveZombie.stop();
        }
        else {
            ImageView imageView = getImageView();
            imageView.setX(imageView.getX() - getSpeed());
        }
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
                    if (getHp() <= 0 || getImageView().getX() < 0) {
                        moveZombie.stop();
                    }
                    else {
                        ImageView imageView = getImageView();
                        imageView.setX(imageView.getX() - getSpeed());
                    }
                })
        );
    }
}
