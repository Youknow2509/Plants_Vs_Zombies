package src.Model.Characters.Zombies;

import src.Model.Characters.Zombies.Conehead.ConeheadZombie;
import src.Model.Characters.Zombies.Normal.NormalZombie;

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
