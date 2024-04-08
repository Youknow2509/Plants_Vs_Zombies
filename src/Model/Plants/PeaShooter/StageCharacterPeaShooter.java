package src.Model.Plants.PeaShooter;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import src.Model.Plants.Pea.Pea;
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
        playPeaBefore();
        peaShooter.getTimeline().play();
    }

    @Override
    public void stop() {
        if (peaShooter.getTimeline() != null) {
            peaShooter.getTimeline().stop();
        }
        if (peaShooter.getListPea() != null) {
            for (Pea pea : peaShooter.getListPea()) {
                pea.stop();
            }
        }
    }

    @Override
    public void pause() {
        if (peaShooter.getTimeline() != null) {
            peaShooter.getTimeline().pause();
        }
        if (peaShooter.getListPea() != null) {
            for (Pea pea : peaShooter.getListPea()) {
                pea.pause();
            }
        }
    }

    @Override
    public void resume() {
        if (peaShooter.getTimeline() != null) {
            peaShooter.getTimeline().play();
        }
        playPeaBefore();
    }
    // Play pea before
    private void playPeaBefore() {
        if (peaShooter.getListPea() != null) {
            for (Pea pea : peaShooter.getListPea()) {
                pea.start();
            }
        }
    }
}
