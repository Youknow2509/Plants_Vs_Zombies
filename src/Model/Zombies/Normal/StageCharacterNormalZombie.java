package src.Model.Zombies.Normal;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import src.Model.StageCharacter;

public class StageCharacterNormalZombie implements StageCharacter {
    private NormalZombie normalZombie;
    // Constructor
    public StageCharacterNormalZombie(NormalZombie normalZombie) {
        this.normalZombie = normalZombie;
    }
    @Override
    public void start() {
        normalZombie.setTimeline(new Timeline(new KeyFrame(Duration.seconds(normalZombie.getSpeedAttack()),
                e -> {
                    normalZombie.getAct().handle();
                }
        )));
        normalZombie.getTimeline().setCycleCount(Timeline.INDEFINITE);
        normalZombie.getTimeline().play();
    }

    @Override
    public void stop() {
        if (normalZombie.getTimeline() != null) {
            normalZombie.getTimeline().stop();
            // todo thay gif to png
            System.out.println("Stop NormalZombie");
        }
    }

    @Override
    public void pause() {
        if (normalZombie.getTimeline() != null) {
            normalZombie.getTimeline().pause();
            // todo thay gif to png
            System.out.println("Pause NormalZombie");
        }
    }

    @Override
    public void resume() {
        if (normalZombie.getTimeline() != null) {
            normalZombie.getTimeline().play();
        }
    }
}
