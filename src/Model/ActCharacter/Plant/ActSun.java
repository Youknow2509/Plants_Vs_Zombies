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
    public void handle1() {
        if (sun.getY() < sun.getLayoutYEnd()) {
            sun.setY(sun.getY() + 1);
            sun.setX(sun.getX() - 0.2);
        } else {
            sun.DisappearSun();
        }
    }

    public void handle2() {
        if (sun.getY() <= sun.getLayoutYEnd()) {
            sun.setY(sun.getY() + 1);
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
