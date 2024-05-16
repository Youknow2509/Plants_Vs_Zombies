package src.Model;

import src.Model.Characters.Zombies.Zombie;
import src.Model.Characters.Zombies.ZombieFactory;
import src.Model.Characters.Zombies.ZombieType;

import java.io.Serial;
import java.io.Serializable;

public class ZombieSpawner implements Serializable {
    // SerialVersionUID
    @Serial
    private static final long serialVersionUID = 1L;
    // Var
    private int time;
    private int lane;
    private String nameZombie;
    private Zombie zombie;
    // Constructor
    public ZombieSpawner() {
        super();
    }
    public ZombieSpawner(int time, int lane, String nameZombie) {
        super();
        this.time = time;
        this.lane = lane;
        this.nameZombie = nameZombie;
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

    public int getLane() {
        return lane;
    }

    public void setLane(int lane) {
        this.lane = lane;
    }

    public String getNameZombie() {
        return nameZombie;
    }

    public void setNameZombie(String nameZombie) {
        this.nameZombie = nameZombie;
    }
}
