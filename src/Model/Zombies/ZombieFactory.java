package src.Model.Zombies;

import src.Model.Zombies.Conehead.ConeheadZombie;
import src.Model.Zombies.Normal.NormalZombie;

public class ZombieFactory {
    public static Zombie createZombie(ZombieType type, int lane) {
        switch (type) {
            case NORMALZOMBIE:
                return new NormalZombie(lane);
            case CONEZOMBIE:
                return new ConeheadZombie(lane);
            default:
                return null;
        }
    }
}
