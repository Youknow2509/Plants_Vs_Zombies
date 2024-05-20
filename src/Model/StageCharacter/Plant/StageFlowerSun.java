package src.Model.StageCharacter.Plant;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import src.Model.Characters.Plants.SunFlower.SunFlower;
import src.Model.StageCharacter.StageCharacter;

public class StageFlowerSun implements StageCharacter {
    // Var
    private SunFlower sunFlower;

    // Constructor
    public StageFlowerSun(SunFlower sunFlower) {
        this.sunFlower = sunFlower;
    }

    // Method Implement
    @Override
    public void start() {

        helpStart();

        sunFlower.setTimeline(new Timeline(new KeyFrame(javafx.util.Duration.millis(
                        sunFlower.getSpeedAttack()
                ), e -> {
                    sunFlower.getAct().handle();
                }
        )));
        sunFlower.getTimeline().setCycleCount(Timeline.INDEFINITE);
        sunFlower.getTimeline().play();
    }

    @Override
    public void stop() {
        if (sunFlower.getTimeline() != null) {
            sunFlower.getTimeline().stop();
        }
        for (int i = 0; i < sunFlower.getListSun().size(); i++) {
            sunFlower.getListSun().get(i).stop();
        }
    }

    @Override
    public void pause() {
        if (sunFlower.getTimeline() != null) {
            sunFlower.getTimeline().pause();
        }
        for (int i = 0; i < sunFlower.getListSun().size(); i++) {
            sunFlower.getListSun().get(i).pause();
        }
    }

    @Override
    public void resume() {
        if (sunFlower.getTimeline() != null) {
            sunFlower.getTimeline().play();
        }
        for (int i = 0; i < sunFlower.getListSun().size(); i++) {
            sunFlower.getListSun().get(i).start1();
        }
    }

    // Method help start
    public void helpStart() {
        // Load Image
        if (sunFlower.getImage() == null || sunFlower.getImageView() == null) {
            sunFlower.createImageViewInGridPane();
        }
        // Load list sun
        for (int i = 0; i < sunFlower.getListSun().size(); i++) {
            sunFlower.getListSun().get(i).start1();
        }
    }

    // Getter - Setter
    public SunFlower getSunFlower() {
        return sunFlower;
    }

    public void setSunFlower(SunFlower sunFlower) {
        this.sunFlower = sunFlower;
    }
}
