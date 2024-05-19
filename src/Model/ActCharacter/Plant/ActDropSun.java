package src.Model.ActCharacter.Plant;

import src.Config.Config;
import src.Config.DefaultValue;
import src.Model.ActCharacter.Act;
import src.Model.Characters.Plants.Sun.Sun;
import src.Model.Characters.Plants.SunDrop.DropSun;

public class ActDropSun implements Act {
    // Var
    private DropSun dropSun;

    // Constructor
    public ActDropSun(DropSun dropSun) {
        this.dropSun = dropSun;
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
        int x = Config.getRandom().nextInt(665) + 320;
        int lane = Config.getRandom().nextInt(5);
        Sun sun = new Sun(x, 0, lane, dropSun.getTimeOut_Drop(), dropSun.getListSun());
        synchronized (dropSun.getListSun()) {
            sun.start2();
            dropSun.getListSun().add(sun);
        }
    }

    // Getter
    public DropSun getDropSun() {
        return dropSun;
    }

    public void setDropSun(DropSun dropSun) {
        this.dropSun = dropSun;
    }
}