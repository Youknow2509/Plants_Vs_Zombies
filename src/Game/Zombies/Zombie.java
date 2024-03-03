package src.Game.Zombies;

import javafx.animation.Timeline;
import javafx.util.Pair;
import src.Game.GameElements;

public class Zombie extends GameElements {
    private int lane;
    private int speed;
    private int hp;
    private int dame;
    public Timeline moveZombie;

    public Zombie() {
        super();
    }
    public Zombie(int x, int y, String path, int width, int height, int lane, int speed, int hp, int dame) {
        super(x, y, path, width, height);
        this.lane = lane;
        this.speed = speed;
        this.hp = hp;
        this.dame = dame;
    }

    public int getLane() {
        return lane;
    }
    public void setLane(int lane) {
        this.lane = lane;
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
    public void move() {
    }
    public void attack() {
    }
    public static int laneToLayoutY(int l) {
        int LayoutY = 0;
        switch (l) {
            case 1:
                LayoutY = 35;
                break;
            case 2:
                LayoutY = 135;
                break;
            case 3:
                LayoutY = 235;
                break;
            case 4:
                LayoutY = 335;
                break;
            case 5:
                LayoutY = 435;
                break;
            default:
                break;
        }
        return LayoutY;
    }
}
