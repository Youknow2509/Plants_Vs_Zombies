package src.Model.ActCharacter.Plant;

import src.Controller.Game.GameMainController;
import src.Model.ActCharacter.Act;
import src.Model.Characters.Plants.Pea.Pea;
import src.Model.Characters.Plants.Plant;
import src.Model.Characters.Plants.Repeater.Repeater;
import src.Model.Characters.Zombies.Zombie;

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
        synchronized ((GameMainController.getGameData()).getZombieAlive()) {
            if ((GameMainController.getGameData()).getZombieAlive() != null && (GameMainController.getGameData()).getZombieAlive().size() > 0)
                for (int i = 0; i < (GameMainController.getGameData()).getZombieAlive().size(); i++) {
                    Zombie z = (GameMainController.getGameData()).getZombieAlive().get(i);
                    if (z.getLane() == plant.getLane() && z.getX() > plant.getX() + 2) {
                        attack(z);
                        break;
                    }
                }
        }
    }
    @Override
    public void move() {
    }

    @Override
    public void attack(Object object) {
        Pea pea1 = new Pea((int) plant.getX() + 45, (int) plant.getY() + 25, plant.getLane(), ((Repeater)plant).getListPea());
        Pea pea2 = new Pea((int) plant.getX() + 80, (int) plant.getY() + 25, plant.getLane(), ((Repeater)plant).getListPea());
        ((Repeater)plant).getListPea().add(pea1);
        ((Repeater)plant).getListPea().add(pea2);
        pea1.start();
        pea2.start();
    }
}
