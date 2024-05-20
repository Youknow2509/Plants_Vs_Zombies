package src.Model.StageCharacter.Plant;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import src.Model.Characters.Plants.Pea.Pea;
import src.Model.StageCharacter.StageCharacter;

public class StageCharacterPea implements StageCharacter {
    // Var
    private Pea pea;
    // Constructor
    public StageCharacterPea() {
        super();
    }
    public StageCharacterPea(Pea pea) {
        super();
        this.pea = pea;
    }

    @Override
    public void start() {

        helpStart();

        pea.setTimeline(new Timeline((new KeyFrame(Duration.millis(pea.getSPEED_ATTACK())
                , e -> {
                    pea.getAct().handle();
                }
        ))));
        pea.getTimeline().setCycleCount(Timeline.INDEFINITE);
        pea.getTimeline().play();
    }

    @Override
    public void stop() {
        if (pea.getTimeline() != null) {
            pea.getTimeline().stop();
        }
    }

    @Override
    public void pause() {
        if (pea.getTimeline() != null) {
            pea.getTimeline().pause();
        }
    }

    @Override
    public void resume() {
        if (pea.getTimeline() != null) {
            pea.getTimeline().play();
        }
    }

    // Help Start
    private void helpStart() {
        pea.createImageView();
    }
}
