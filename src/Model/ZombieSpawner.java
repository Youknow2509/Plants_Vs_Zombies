package src.Model;

import src.Model.Zombies.Conehead.ConeheadZombie;
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
            case "NORMALZOMBIE": // NormalZombie
                this.zombie = new NormalZombie(lane);;
                break;
            case "CONEHEADZOMBIE": // ConeheadZombie
                this.zombie = new ConeheadZombie(lane);;
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
