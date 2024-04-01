package src.Model.Plants.Pea.Repeater;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import src.Model.Plants.Pea.Repeater.Repeater;
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
        repeater.getTimeline().play();
    }

    @Override
    public void stop() {
        if (repeater.getTimeline() != null) {
            repeater.getTimeline().stop();
        }
        if (repeater.getListTimelinePea() != null) {
            for (Timeline timeline : repeater.getListTimelinePea()) {
                timeline.stop();
            }
        }
    }

    @Override
    public void pause() {
        if (repeater.getTimeline() != null) {
            repeater.getTimeline().pause();
        }
        if (repeater.getListTimelinePea() != null) {
            for (Timeline timeline : repeater.getListTimelinePea()) {
                timeline.pause();
            }
        }
    }

    @Override
    public void resume() {
        if (repeater.getTimeline() != null) {
            repeater.getTimeline().play();
        }
        if (repeater.getListTimelinePea() != null) {
            for (Timeline timeline : repeater.getListTimelinePea()) {
                timeline.play();
            }
        }
    }
}
