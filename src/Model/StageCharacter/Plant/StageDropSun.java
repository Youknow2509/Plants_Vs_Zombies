package src.Model.StageCharacter.Plant;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import src.Model.Characters.Plants.SunDrop.DropSun;
import src.Model.StageCharacter.StageCharacter;

public class StageDropSun implements StageCharacter {
    // Var
    private DropSun dropSun;

    // Constructor
    public StageDropSun(DropSun dropSun) {
        this.dropSun = dropSun;
    }

    // Method Implement
    @Override
    public void start() {

        helpStart();

        dropSun.setTimeline(new Timeline(new KeyFrame(
                 Duration.seconds(1),
                    event -> {
                        if (dropSun.getDurationDropSun() <= 0) {
                            dropSun.getAct().handle();
                            dropSun.setDurationDropSun(dropSun.randomDurationDropSun());
                        } else {
                            dropSun.setDurationDropSun(dropSun.getDurationDropSun() - 1);
                        }
                }
        )));
        dropSun.getTimeline().setCycleCount(Animation.INDEFINITE);

        dropSun.getTimeline().play();
    }

    @Override
    public void stop() {
        if (dropSun.getTimeline() != null) {
            dropSun.getTimeline().stop();
        }
        synchronized (dropSun.getListSun()) {
            for (int i = 0; i < dropSun.getListSun().size(); i++) {
                dropSun.getListSun().get(i).stop();
            }
        }
    }

    @Override
    public void pause() {
        if (dropSun.getTimeline() != null) {
            dropSun.getTimeline().pause();
        }
        synchronized (dropSun.getListSun()) {
            for (int i = 0; i < dropSun.getListSun().size(); i++) {
                dropSun.getListSun().get(i).pause();
            }
        }
    }

    @Override
    public void resume() {
        if (dropSun.getTimeline() != null) {
            dropSun.getTimeline().play();
        }
        synchronized (dropSun.getListSun()) {
            for (int i = 0; i < dropSun.getListSun().size(); i++) {
                dropSun.getListSun().get(i).start2();
            }
        }
    }

    // Help function

    private void helpStart() {
        // Tao lai nhung sun cu trong danh sach
        synchronized (dropSun.getListSun()) {
            for (int i = 0; i < dropSun.getListSun().size(); i++) {
                dropSun.getListSun().get(i).start2();
            }
        }
    }

    // Getter - Setter
    public DropSun getDropSun() {
        return dropSun;
    }

    public void setDropSun(DropSun dropSun) {
        this.dropSun = dropSun;
    }
}
