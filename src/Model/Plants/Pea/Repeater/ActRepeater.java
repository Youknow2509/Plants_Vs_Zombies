package src.Model.Plants.Pea.Repeater;

import src.Controller.GameMainControllerSave;
import src.Model.Act;
import src.Model.Plants.Pea.Pea;
import src.Model.Plants.Plant;
import src.Model.Zombies.Zombie;

public class ActRepeater implements Act {
    // Var
    Plant plant;
    // Constructor
    public ActRepeater() {
        super();
    }
    public ActRepeater(Plant plant) {
        super();
        this.plant = plant;
    }
    @Override
    public void handle() {
        synchronized (GameMainControllerSave.getListZombieAlive()) {
            if (GameMainControllerSave.getListZombieAlive() != null && GameMainControllerSave.getListZombieAlive().size() > 0)
                for (int i = 0; i < GameMainControllerSave.getListZombieAlive().size(); i++) {
                    Zombie z = GameMainControllerSave.getListZombieAlive().get(i);
                    if (z.getLane() == plant.getLane() && z.getX() > plant.getX() + 2) {
                        attack(z);
                    }
                }
        }
    }
    @Override
    public void move() {
    }

    @Override
    public void attack(Object object) {
        Pea pea1 = new Pea((int) plant.getX() + 45, (int) plant.getY() + 25, plant.getLane(), ((Repeater)plant).getListTimelinePea());
        Pea pea2 = new Pea((int) plant.getX() + 80, (int) plant.getY() + 25, plant.getLane(), ((Repeater)plant).getListTimelinePea());
        pea1.start();
        pea2.start();
    }
}
