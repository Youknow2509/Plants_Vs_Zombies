package src.Model.StageCharacter.Plant;

import src.Model.ActCharacter.Plant.ActSun;
import src.Model.Characters.Plants.Sun.Sun;
import src.Model.StageCharacter.StageCharacter;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;


public class StageSun implements StageCharacter {
    // Var
    private Sun sun;

    // Constructor
    public StageSun(Sun sun) {
        this.sun = sun;
    }

    // Method Implement
    @Override
    public void start() {

    }

    public void start1() {

        helpStart();

        this.sun.setTimeline(new Timeline(new KeyFrame(Duration.millis(30),
                e -> {
                    ((ActSun)sun.getAct()).handle1();
                }
        )));
        (this.sun.getTimeline()).setCycleCount(Timeline.INDEFINITE);
        (this.sun.getTimeline()).play();
    }

    public void start2() {

        helpStart();

        this.sun.setTimeline(new Timeline(new KeyFrame(Duration.millis(30),
                e -> {
                    ((ActSun)sun.getAct()).handle2();
                }
        )));
        (this.sun.getTimeline()).setCycleCount(Timeline.INDEFINITE);
        (this.sun.getTimeline()).play();
    }
    @Override
    public void stop() {
        if (sun.getTimeline() != null) {
            (sun.getTimeline()).stop();
        }
    }

    @Override
    public void pause() {
        if (sun.getTimeline() != null) {
            (sun.getTimeline()).pause();
        }
    }

    @Override
    public void resume() {
        if (sun.getTimeline() != null) {
            (sun.getTimeline()).play();
        }
    }

    // Help start
    public void helpStart() {
        // Load Image
        sun.createImageView();
    }

    // Getter and Setter
    public Sun getSun() {
        return sun;
    }

    public void setSun(Sun sun) {
        this.sun = sun;
    }
}
