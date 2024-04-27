package src.Model.Characters;

import src.Model.Characters.Zombies.Zombie;
import src.Model.Characters.Zombies.ZombieFactory;
import src.Model.Characters.Zombies.ZombieType;

import java.io.Serializable;

public class ZombieSpawner implements Serializable {
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

    public void setTime(int time) {
        this.time = time;
    }

    public void setZombie(Zombie zombie) {
        this.zombie = zombie;
    }
}
