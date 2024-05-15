package src.Model.StageCharacter.Zombie;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import src.Model.Characters.Zombies.Conehead.ConeheadZombie;
import src.Model.StageCharacter.StageCharacter;

public class StageCharacterConeheadZombie implements StageCharacter {
    private final ConeheadZombie coneheadZombie ;
    // Constructor
    public StageCharacterConeheadZombie(ConeheadZombie coneheadZombie ) {
        this.coneheadZombie = coneheadZombie ;
    }
    @Override
    public void start() {

        helpStart();

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

            helpStart();

            coneheadZombie.getTimeline().play();
        }
    }

    // Help start
    private void helpStart() {
        coneheadZombie.createImageView();
    }
}
