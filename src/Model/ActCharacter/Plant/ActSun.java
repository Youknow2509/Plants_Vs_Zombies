package src.Model.ActCharacter.Plant;

import src.Model.ActCharacter.Act;
import src.Model.Characters.Plants.Sun.Sun;

public class ActSun implements Act {
    // Var
    private Sun sun;

    // Constructor
    public ActSun(Sun sun) {
        this.sun = sun;
    }

    // Method
    // Xử lí của sun khi rơi từ SunFlower
    public void handle1() {
        if (sun.getY() < sun.getLayoutYEnd()) {

            sun.setY(
                    sun.getY() + sun.getDy()
            );

            sun.setX(
                    sun.getX() + sun.getDx()
            );
        } else {
            sun.DisappearSun();
        }
    }
    // Xử lí của sun khi rơi từ DropSun
    public void handle2() {
        if (sun.getY() <= sun.getLayoutYEnd()) {

            sun.setY(
                    sun.getY() + sun.getDy()
            );
        } else {
            sun.DisappearSun();
        }
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
    }

    // Getter and Setter
    public Sun getSun() {
        return sun;
    }
    public void setSun(Sun sun) {
        this.sun = sun;
    }
}
