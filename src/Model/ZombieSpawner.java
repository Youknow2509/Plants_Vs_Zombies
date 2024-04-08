package src.Model;

import src.Model.Zombies.Conehead.ConeheadZombie;
import src.Model.Zombies.Normal.NormalZombie;
import src.Model.Zombies.Zombie;
import src.Model.Zombies.ZombieFactory;
import src.Model.Zombies.ZombieType;

public class ZombieSpawner {
    // Var
    private int time;
    private Zombie zombie;
    // Constructor
    public ZombieSpawner() {
        super();
    }
    public ZombieSpawner(int time, int lane, String nameZombie) {
        super();
        this.time = time;
        ZombieType zombieType = ZombieType.valueOf(nameZombie.toUpperCase());
        zombie = ZombieFactory.createZombie(zombieType, lane);
    }
    // Getter and Setter
    public int getTime() {
        return time;
    }
    public Zombie getZombie() {
        return zombie;
    }
}
