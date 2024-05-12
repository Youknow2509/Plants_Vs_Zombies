package src.Model.ActCharacter.Plant;

import src.Controller.Game.GameMainController;
import src.Model.ActCharacter.Act;
import src.Model.Characters.Plants.Pea.Pea;
import src.Model.Characters.Plants.PeaShooter.PeaShooter;
import src.Model.Characters.Plants.Plant;
import src.Model.Characters.Zombies.Zombie;

public class ActPeaShooter implements Act {
    // Var
    Plant plant;
    // Constructor
    public ActPeaShooter() {
        super();
    }
    public ActPeaShooter(Plant plant) {
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
                        break; // 1 lan tan cong chi tan cong 1 zombie
                    }
                }
        }
    }
    @Override
    public void move() {
    }

    @Override
    public void attack(Object object) {
        Pea pea = new Pea((int) plant.getX() + 3, (int) plant.getY() + 25, plant.getLane(), ((PeaShooter)plant).getListPea());
        pea.start();
        ((PeaShooter)plant).getListPea().add(pea);
    }
}
