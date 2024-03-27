package src.Model.Zombie;

public class ZombieSpawner {
    // Var
    private int time;
    private int lane;
    private Zombie zombie;

    // Constructor
    public ZombieSpawner() {

    }

    public ZombieSpawner(int time, int lane, String nameZombie) {
        this.time = time;
        this.lane = lane;
        switch (nameZombie) {
            case "Normal":
                this.zombie = new NormalZombie();
                break;
            case "Conehead":
                //this.zombie = new Conehead(lane);;
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

    public void setTime(int time) {
        this.time = time;
    }

    public int getLane() {
        return lane;
    }

    public void setLane(int lane) {
        this.lane = lane;
    }

    public void setZombie(Zombie zombie) {
        this.zombie = zombie;
    }
}
