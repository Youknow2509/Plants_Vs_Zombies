package src.Model.StageCharacter.Plant;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import src.Model.Characters.Plants.Pea.Pea;
import src.Model.Characters.Plants.PeaShooter.PeaShooter;
import src.Model.StageCharacter.StageCharacter;

public class StageCharacterPeaShooter implements StageCharacter {
    // Var
    PeaShooter peaShooter;
    
    // Constructor
    public StageCharacterPeaShooter(PeaShooter peaShooter) {
        this.peaShooter = peaShooter;
    }

    @Override
    public void start() {

        helpStart();

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

            helpStart();

            peaShooter.getTimeline().play();
        }
    }

    // Help Start
    private void helpStart() {

        if (peaShooter.getImageView() == null || peaShooter.getImage() == null) {
            peaShooter.createImageViewInGridPane();
        }

        for (int i = 0; i < peaShooter.getListPea().size(); i++) {
            peaShooter.getListPea().get(i).start();
        }
    }
}
