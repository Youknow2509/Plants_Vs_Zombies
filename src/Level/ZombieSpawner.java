package src.Level;

import src.Game.Zombies.Conehead;
import src.Game.Zombies.Normal;
import src.Game.Zombies.Zombie;

public class ZombieSpawner {
    private int time;
    private Zombie zombie;
    // Constructor
    public ZombieSpawner() {

    }
    public ZombieSpawner(int time, int lane, String nameZombie) {
        this.time = time;
        switch (nameZombie) {
            case "Normal":
                this.zombie = new Normal(lane);;
                break;
            case "Conehead":
                this.zombie = new Conehead(lane);;
                break;
                // TODO: Thêm các loại zombie khác sau
            default:
                System.out.println("Ten zombie khong hop le");
                break;
        }
    }
    // Getter and Setter
    public int getTime() {
        return time;
    }
    public Zombie getZombie() {
        return zombie;
    }
}
