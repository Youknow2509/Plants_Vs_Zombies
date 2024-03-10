package src.Game.Zombies;

import javafx.animation.Timeline;
import javafx.util.Pair;
import src.Game.GameElements;

public class Zombie extends GameElements {
    private int speed; // Tốc độ di chuyển của zombie
    private int hp;  // Máu của zombie
    private int dame; // Sát thương của zombie
    public Timeline moveZombie; // Hành động di chuyển của zombie
    private boolean flag = true; // true : zombie đang di chuyển, false: zombie dừng lại tấn công.
    public Zombie() {
        super();
    }
    public Zombie(int x, int y, String path, int width, int height, int lane, int speed, int hp, int dame) {
        super(x, y, path, width, height, lane);
        this.speed = speed;
        this.hp = hp;
        this.dame = dame;
    }
    // Di chuyển zombie
    public void move() {
    }
    // Tấn công plant
    public void attack() {
    }
    // Chuyển từ lane sang layoutY
    public static int laneToLayoutY(int l) {
        int LayoutY = 0;
        switch (l) {
            case 0:
                LayoutY = 35;
                break;
            case 1:
                LayoutY = 135;
                break;
            case 2:
                LayoutY = 235;
                break;
            case 3:
                LayoutY = 335;
                break;
            case 4:
                LayoutY = 435;
                break;
            default:
                break;
        }
        return LayoutY;
    }
    // Get và set các thuộc tính
    public Timeline getMoveZombie() {
        return moveZombie;
    }
    public void setMoveZombie(Timeline moveZombie) {
        this.moveZombie = moveZombie;
    }
    public boolean getFlag() {
        return flag;
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getDame() {
        return dame;
    }
    public void setDame(int dame) {
        this.dame = dame;
    }
}
