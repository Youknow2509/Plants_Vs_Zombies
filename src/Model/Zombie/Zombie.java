package src.Model.Zombie;

import javafx.animation.Timeline;
import javafx.scene.layout.AnchorPane;
import src.Model.GameElements;
import src.Model.Plant.Plant;

import java.util.List;

public class Zombie extends GameElements {
    // Var
    private int health;
    private int dame;
    private int speedMove;
    private int speedAttack;
    private boolean flag = true; // true : zombie đang di chuyển, false: zombie dừng lại tấn công.
    private Timeline timelineAttack;
    private Timeline timelineMove;
    private List<Plant> listPlants; // Danh sách các cây tồn tại, để kiểm tra, tấn công cây
    // Constructor
    public Zombie(AnchorPane root, double x, double y, String path, int width, int height
            , int lane, List<Plant> listPlants, int health, int dame, int speedMove, int speedAttack) {
        super(root, x, y, path, width, height, lane);
        this.health = health;
        this.dame = dame;
        this.speedMove = speedMove;
        this.speedAttack = speedAttack;
        this.listPlants = listPlants;
    }
    // Tấn công
    public void attack(List<Plant> listPlants) {
        // Attack ovreride in subclass
    }
    // Di chuyển
    public void move() {
        // Move ovreride in subclass
    }
    // Chuyển trang thái của Zombie
    public void changeState() {
        if (flag) {
            stopMove();
            resumeAttack();
        } else {
            stopAttack();
            resumeMove();
        }
        flag = !flag;
    }
    // Dừng hanh dong di chuyen
    public void stopMove() {
        if (timelineMove != null) {
            timelineMove.stop();
        }
    }
    // Dừng hanh dong tan cong
    public void stopAttack() {
        if (timelineAttack != null) {
            timelineAttack.stop();
        }
    }
    // Tiep tuc hanh dong tan cong
    public void resumeAttack() {
        if (timelineAttack != null) {
            timelineAttack.play();
        }
    }
    // Tiep tuc hanh dong di chuyen
    public void resumeMove() {
        if (timelineMove != null) {
            timelineMove.play();
        }
    }

    // Getter and setter
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDame() {
        return dame;
    }

    public void setDame(int dame) {
        this.dame = dame;
    }

    public int getSpeedMove() {
        return speedMove;
    }

    public void setSpeedMove(int speedMove) {
        this.speedMove = speedMove;
    }

    public int getSpeedAttack() {
        return speedAttack;
    }

    public void setSpeedAttack(int speedAttack) {
        this.speedAttack = speedAttack;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Timeline getTimelineAttack() {
        return timelineAttack;
    }

    public void setTimelineAttack(Timeline timelineAttack) {
        this.timelineAttack = timelineAttack;
    }

    public Timeline getTimelineMove() {
        return timelineMove;
    }

    public void setTimelineMove(Timeline timelineMove) {
        this.timelineMove = timelineMove;
    }

    public List<Plant> getListPlants() {
        return listPlants;
    }

    public void setListPlants(List<Plant> listPlants) {
        this.listPlants = listPlants;
    }
}
