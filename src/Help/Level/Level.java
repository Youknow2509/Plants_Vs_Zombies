package src.Help.Level;

import src.Controller.GameMainControllerSave;
import src.Model.ZombieSpawner;

import java.util.Collections;
import java.util.Comparator;

public class Level {
    private int level;
    private int sumZombies;
    // Constructor
    public Level() {
    }
    public Level(int level) {
        this.level = level;
    }
    // Lấy ra danh sách zombie sẽ có
    public void getZombieSpawners() {
        switch (level) {
            case 1:
                GameMainControllerSave.getListZombieSpawner().add(new ZombieSpawner(1, 0, "NormalZombie"));
                GameMainControllerSave.getListZombieSpawner().add(new ZombieSpawner(10, 1, "NormalZombie"));
                GameMainControllerSave.getListZombieSpawner().add(new ZombieSpawner(15, 0, "NormalZombie"));
                GameMainControllerSave.getListZombieSpawner().add(new ZombieSpawner(15, 2, "NormalZombie"));
                GameMainControllerSave.getListZombieSpawner().add(new ZombieSpawner(27, 3, "NormalZombie"));
                GameMainControllerSave.getListZombieSpawner().add(new ZombieSpawner(19, 4, "NormalZombie"));
                GameMainControllerSave.getListZombieSpawner().add(new ZombieSpawner(32, 2, "NormalZombie"));
                GameMainControllerSave.getListZombieSpawner().add(new ZombieSpawner(36, 3, "NormalZombie"));
                GameMainControllerSave.getListZombieSpawner().add(new ZombieSpawner(40, 0, "NormalZombie"));

                break;
                // TODO: Thêm các level khác sau
            default:
                System.out.println("Level không hợp lệ");
                break;
        }
        sumZombies = GameMainControllerSave.getListZombieSpawner().size();
        // Sắp xếp lại thứ tự của zombieSpawners theo thời gian
        Collections.sort(GameMainControllerSave.getListZombieSpawner(), new Comparator<ZombieSpawner>() {
            @Override
            public int compare(ZombieSpawner o1, ZombieSpawner o2) {
                return (o1.getTime() - o2.getTime());
            }
        });
    }
    // Getter and Setter
    public int getSumZombies() {
        return sumZombies;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
}
