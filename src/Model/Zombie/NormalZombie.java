package src.Model.Zombie;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import src.Model.Plant.Plant;

import java.util.List;

public class NormalZombie extends Zombie {
    // Var
    private static final int HEALTH = 100;
    private static final int DAME = 10;
    private static final int SPEED_MOVE = 1;
    private static final int SPEED_ATTACK = 1;
    private static final int SPEED = 5;
    private static final int WIDTH = 60;
    private static final int HEIGHT = 100;
    private static final String PATH = "Assets/images/Zombies/NormalZombieRun.gif";

    // Constructor
    public NormalZombie() {
        super();
    }
    public NormalZombie(double x, double y, int lane, List<Plant> listPlants) {
        super(x, y, PATH, WIDTH, HEIGHT, lane, listPlants, HEALTH, DAME, SPEED_MOVE, SPEED_ATTACK, SPEED);
    }
    // Timline move
    @Override
    public void timelineMove() {
        setTimelineMove(new Timeline(new KeyFrame(Duration.seconds(SPEED_MOVE), e -> {
            if (isFlag()) {
                if (getX() < 0 || getHealth() <= 0) {
                    // Todo: xử lý zombie chết hoac đi hết đường
                } else {
                    setX(getX() - SPEED);

                }
            }
        })));
    }
    // Timeline tấn công
}
