package src.Level;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import src.Controller.GamePlayController;
import src.Game.Zombies.Normal;
import src.Game.Zombies.Zombie;

import java.util.Collection;
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
                GamePlayController.zombieSpawners.add(new ZombieSpawner(1, 0, "Normal"));
                GamePlayController.zombieSpawners.add(new ZombieSpawner(10, 1, "Normal"));
                GamePlayController.zombieSpawners.add(new ZombieSpawner(15, 2, "Normal"));
                GamePlayController.zombieSpawners.add(new ZombieSpawner(27, 3, "Normal"));
                GamePlayController.zombieSpawners.add(new ZombieSpawner(19, 4, "Normal"));
                GamePlayController.zombieSpawners.add(new ZombieSpawner(32, 2, "Normal"));
                GamePlayController.zombieSpawners.add(new ZombieSpawner(36, 3, "Normal"));
                GamePlayController.zombieSpawners.add(new ZombieSpawner(40, 0, "Normal"));

                break;
                // TODO: Thêm các level khác sau
            default:
                System.out.println("Level không hợp lệ");
                break;
        }
        sumZombies = GamePlayController.zombieSpawners.size();
        // Sắp xếp lại thứ tự của zombieSpawners theo thời gian
        Collections.sort(GamePlayController.zombieSpawners, new Comparator<ZombieSpawner>() {
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
