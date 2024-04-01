package src.Utils.Game.Level;

import src.Model.Zombies.Conehead;
import src.Model.Zombies.Normal.NormalZombie;
import src.Model.Zombies.Zombie;

public class ZombieSpawner {
    // Var
    private int time;
    private Zombie zombie;
    // Constructor
    public ZombieSpawner() {

    }
    public ZombieSpawner(int time, int lane, String nameZombie) {
        this.time = time;
        switch (nameZombie) {
            case "NormalZombie":
                this.zombie = new NormalZombie(lane);;
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
