package src.Model.Plants.Pea.PeaShooter;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import src.Model.StageCharacter;

public class StageCharacterPeaShooter implements StageCharacter {
    // Var
    PeaShooter peaShooter;
    
    // Constructor
    public StageCharacterPeaShooter(PeaShooter peaShooter) {
        this.peaShooter = peaShooter;
    }

    @Override
    public void start() {
        peaShooter.setTimeline(new Timeline(new KeyFrame(Duration.seconds(peaShooter.getSpeedAttack()),
                e -> {
                    peaShooter.getAct().handle();
                }
        )));
        peaShooter.getTimeline().setCycleCount(Timeline.INDEFINITE); // Số lượng đạn bắt ra là vô hạn, cứ có Zombie là bắn
        peaShooter.getTimeline().play();
    }

    @Override
    public void stop() {
        if (peaShooter.getTimeline() != null) {
            peaShooter.getTimeline().stop();
        }
        if (peaShooter.getListTimelinePea() != null) {
            for (Timeline timeline : peaShooter.getListTimelinePea()) {
                timeline.stop();
            }
        }
    }

    @Override
    public void pause() {
        if (peaShooter.getTimeline() != null) {
            peaShooter.getTimeline().pause();
        }
        if (peaShooter.getListTimelinePea() != null) {
            for (Timeline timeline : peaShooter.getListTimelinePea()) {
                timeline.pause();
            }
        }
    }

    @Override
    public void resume() {
        if (peaShooter.getTimeline() != null) {
            peaShooter.getTimeline().play();
        }
        if (peaShooter.getListTimelinePea() != null) {
            for (Timeline timeline : peaShooter.getListTimelinePea()) {
                timeline.play();
            }
        }
    }
}
