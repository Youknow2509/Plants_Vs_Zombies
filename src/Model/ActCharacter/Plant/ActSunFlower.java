package src.Model.ActCharacter.Plant;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import src.Model.ActCharacter.Act;
import src.Model.Characters.Plants.Sun.Sun;
import src.Model.Characters.Plants.SunFlower.SunFlower;

public class ActSunFlower implements Act {
    // Var
    private SunFlower sunFlower;

    // Constructor
    public ActSunFlower(SunFlower sunFlower) {
        this.sunFlower = sunFlower;
    }

    // Method Implement
    @Override
    public void move() {

    }

    @Override
    public void attack(Object object) {

    }

    @Override
    public void handle() {
        Sun sun = new Sun((int)sunFlower.getX() - 5, (int)sunFlower.getY() + 30
                , sunFlower.getLane(), sunFlower.getTimeOut(), sunFlower.getDx()
                , sunFlower.getDy(), sunFlower.getTimeKeyFrame()
                , sunFlower.getListSun());
        sun.start1();
        sunFlower.getListSun().add(sun);
    }

    // Getter
    public SunFlower getSunFlower() {
        return sunFlower;
    }

    public void setSunFlower(SunFlower sunFlower) {
        this.sunFlower = sunFlower;
    }
}
