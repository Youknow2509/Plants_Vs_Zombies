package src.Model.StageCharacter.Plant;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import src.Model.Characters.Plants.Pea.Pea;
import src.Model.Characters.Plants.Repeater.Repeater;
import src.Model.StageCharacter.StageCharacter;

public class StageCharacterRepeater implements StageCharacter {
    // Var
    Repeater repeater;

    // Constructor
    public StageCharacterRepeater(Repeater repeater) {
        this.repeater = repeater;
    }

    @Override
    public void start() {
        helpStart();
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
            helpStart();
            repeater.getTimeline().play();
        }
    }

    // Help start
    private void helpStart() {
        if (repeater.getImage() == null || repeater.getImageView() == null) {
            repeater.createImageViewInGridPane();
        }

        for (int i = 0 ; i < repeater.getListPea().size(); i++) {
            repeater.getListPea().get(i).start();
        }
    }

}
