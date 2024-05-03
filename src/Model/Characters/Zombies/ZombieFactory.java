package src.Model.Characters.Zombies;

import src.Model.Characters.Zombies.Conehead.ConeheadZombie;
import src.Model.Characters.Zombies.FlagZombie.FlagZombie;
import src.Model.Characters.Zombies.Normal.NormalZombie;

public class ZombieFactory {
    public static Zombie createZombie(ZombieType type, int lane) {
        switch (type) {
            case NORMALZOMBIE:
                return new NormalZombie(lane);
            case CONEHEADZOMBIE:
                return new ConeheadZombie(lane);
            case FLAGZOMBIE:
                return new FlagZombie(lane);
            default:
                return null;
        }
    }
}
