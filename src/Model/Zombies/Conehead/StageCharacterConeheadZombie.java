package src.Model.Zombies.Conehead;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import src.Model.StageCharacter;

public class StageCharacterConeheadZombie implements StageCharacter {
    private ConeheadZombie coneheadZombie ;
    // Constructor
    public StageCharacterConeheadZombie(ConeheadZombie coneheadZombie ) {
        this.coneheadZombie = coneheadZombie ;
    }
    @Override
    public void start() {
        coneheadZombie.setTimeline(new Timeline(new KeyFrame(Duration.seconds(coneheadZombie.getSpeedAttack()),
                e -> {
                    coneheadZombie.getAct().handle();
                }
        )));
        coneheadZombie.getTimeline().setCycleCount(Timeline.INDEFINITE);
        coneheadZombie.getTimeline().play();
    }

    @Override
    public void stop() {
        if (coneheadZombie.getTimeline() != null) {
            coneheadZombie.getTimeline().stop();
        }
    }

    @Override
    public void pause() {
        if (coneheadZombie.getTimeline() != null) {
            coneheadZombie.getTimeline().pause();
        }
    }

    @Override
    public void resume() {
        if (coneheadZombie.getTimeline() != null) {
            coneheadZombie.getTimeline().play();
        }
    }
}