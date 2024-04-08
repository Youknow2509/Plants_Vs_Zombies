package src.Model.Plants.Repeater;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import src.Model.Plants.Pea.Pea;
import src.Model.StageCharacter;

public class StageCharacterRepeater implements StageCharacter {
    // Var
    Repeater repeater;

    // Constructor
    public StageCharacterRepeater(Repeater repeater) {
        this.repeater = repeater;
    }

    @Override
    public void start() {
        repeater.setTimeline(new Timeline(new KeyFrame(Duration.seconds(repeater.getSpeedAttack()),
                e -> {
                    repeater.getAct().handle();
                }
        )));
        repeater.getTimeline().setCycleCount(Timeline.INDEFINITE);
        playPeaBefore();
        repeater.getTimeline().play();
    }

    @Override
    public void stop() {
        if (repeater.getTimeline() != null) {
            repeater.getTimeline().stop();
        }
        if (repeater.getListPea() != null) {
            for (Pea p : repeater.getListPea()) {
                p.stop();
            }
        }
    }

    @Override
    public void pause() {
        if (repeater.getTimeline() != null) {
            repeater.getTimeline().pause();
        }
        if (repeater.getListPea() != null) {
            for (Pea p : repeater.getListPea()) {
                p.pause();
            }
        }
    }

    @Override
    public void resume() {
        if (repeater.getTimeline() != null) {
            repeater.getTimeline().play();
        }
        playPeaBefore();
    }
    // Play pea before
    private void playPeaBefore() {
        if (repeater.getListPea() != null) {
            for (Pea p : repeater.getListPea()) {
                p.start();
            }
        }
    }
}
