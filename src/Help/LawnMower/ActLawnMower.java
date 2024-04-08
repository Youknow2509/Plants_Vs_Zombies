package src.Help.LawnMower;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import src.Controller.GameMainController;
import src.Model.Zombies.Zombie;

public class ActLawnMower {
// Var
    private LawnMower lawnMower;
// Constructor
    public ActLawnMower() {
        super();
    }
    public ActLawnMower(LawnMower lawnMower) {
        super();
        this.lawnMower = lawnMower;
    }
// Method
    // Start
    public void start() {
        lawnMower.setTimeline(new Timeline(new KeyFrame(Duration.seconds(0.2)
                , e -> {
                    handle();
                }
        )));
        lawnMower.getTimeline().setCycleCount(Timeline.INDEFINITE);
        lawnMower.getTimeline().play();
    }

    // Handle
    private void handle() {
        synchronized (GameMainController.getGameData().getZombieAlive()) {
            for (int i = 0; i < GameMainController.getGameData().getZombieAlive().size(); i++) {
                Zombie zombie = GameMainController.getGameData().getZombieAlive().get(i);
                if (zombie.getLane() == lawnMower.getLane()
                        && zombie.getX() - lawnMower.getX() < 35
                        && lawnMower.getX() < zombie.getX())
                {
                    move();
                    break;
                }
            }
        }
    }

    // Move
    private void move() {
        lawnMower.getTimeline().stop();
        lawnMower.changeImageView(lawnMower.getPathImageActive());
        lawnMower.setTimeline(new Timeline(new KeyFrame(Duration.millis(60)
                , e -> {
                    if (lawnMower.getX() < 1010) {
                        lawnMower.setX(lawnMower.getX() + lawnMower.getSpeed());
                    }
                    else {
                        lawnMower.removeImageView();
                        lawnMower.getTimeline().stop();
                    }
                    attack();
                }
        )));
        lawnMower.getTimeline().setCycleCount(Timeline.INDEFINITE);
        lawnMower.getTimeline().play();
    }

    // Attack zombie
    private void attack() {
        synchronized (GameMainController.getGameData().getZombieAlive()) {
            for (int i = 0; i < GameMainController.getGameData().getZombieAlive().size(); i++) {
                Zombie zombie = GameMainController.getGameData().getZombieAlive().get(i);
                if (zombie.getLane() == lawnMower.getLane()
                        && zombie.getX() - lawnMower.getX() > 10
                        && zombie.getX() > lawnMower.getX())
                {
                    // Remove zombie
                    zombie.removeImageView();
                    (GameMainController.getGameData()).getZombieAlive().remove(zombie);
                }
            }
        }
    }

    // Getter and Setter
}
