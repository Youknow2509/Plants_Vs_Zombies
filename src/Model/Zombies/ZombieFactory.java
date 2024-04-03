package src.Model.Zombies;

import src.Model.Zombies.Conehead.ConeheadZombie;
import src.Model.Zombies.Normal.NormalZombie;

public class ZombieFactory {
    public Zombie createZombie(ZombieType type) {
        switch (type) {
            case NORMMALZOMBIE:
                return new NormalZombie();
            case CONEZOMBIE:
                return new ConeheadZombie();
            default:
                return null;
        }
    }
}
