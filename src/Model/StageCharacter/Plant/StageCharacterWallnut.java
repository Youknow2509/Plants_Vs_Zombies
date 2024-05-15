package src.Model.StageCharacter.Plant;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import src.Model.Characters.Plants.Wallnut.Wallnut;
import src.Model.StageCharacter.StageCharacter;

public class StageCharacterWallnut implements StageCharacter {
    // Var
    private final Wallnut wallnut;

    // Constructor
    public StageCharacterWallnut(Wallnut wallnut) {
        super();
        this.wallnut = wallnut;
    }
    @Override
    public void start() {

        helpStart();

        wallnut.setTimeline(new Timeline(new KeyFrame(
                Duration.millis(500),
                    e -> {
                        wallnut.getAct().handle();
                }
        )));
        wallnut.getTimeline().setCycleCount(Timeline.INDEFINITE);
        wallnut.getTimeline().play();
    }

    @Override
    public void stop() {
        if (wallnut.getTimeline() != null) {
            wallnut.getTimeline().stop();
        }
    }

    @Override
    public void pause() {
        if (wallnut.getTimeline() != null) {
            wallnut.getTimeline().pause();
        }
    }

    @Override
    public void resume() {
        if (wallnut.getTimeline() != null) {
            wallnut.getTimeline().play();
        }
    }

    // Help Start
    private void helpStart() {
        if (wallnut.getImageView() == null || wallnut.getImageView().getImage() == null) {
            wallnut.createImageViewInGridPane();
        }
    }
}
