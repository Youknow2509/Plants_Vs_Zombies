package src.Game.Zombies;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import javafx.util.Pair;
import src.Controller.GamePlayController;
import src.Game.GameElements;
import src.Game.Plants.Plant;

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
        TimeLineMove();
        moveZombie.setCycleCount(Timeline.INDEFINITE);
        moveZombie.play();
    }
    // Tấn công plant
    public void attack() {
        synchronized (GamePlayController.plants) {
            boolean checkZombie = false; // true là đang có zombie để ăn, false là không - xử lí khi zombie đang ăn cây thì cây bị xoá
            for (int i = 0; i < GamePlayController.plants.size(); i++) {
                Plant p = GamePlayController.plants.get(i);
                if (p.getLane() == getLane() && getX() - p.getX() <= 30) {
                    checkZombie = true;
                    setFlag(false);
                    p.setHp(p.getHp() - dame);
                    if (p.getHp() <= 0) {
                        p.rmImage((GridPane) p.getImageView().getParent());
                        p.rmTlDame();
                        GamePlayController.plants.remove(p);
                        setFlag(true);
                    }
                    //System.out.println("Plant hp: " + p.getHp()); // TODO : Để debug xem máu của cây còn lại bao nhiêu
                    break;
                }
            }
            if (!checkZombie) {
                setFlag(true);
            }
        }
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
    // Xử lí animatoin di chuyển của zombie
    private void TimeLineMove() {
        moveZombie = new Timeline(
                new KeyFrame(Duration.seconds(1), e -> {
                    // xử lí việc di chuyển
                    if (getFlag()) {
                        // xử lí khi zombie đi hết đường hoặc hết máu
                        if (getX() < 0 || getHp() <= 0) {
                            moveZombie.stop();
                            rmImage();
                        } else {
                            setX(getX() - speed);
                            attack();
                        }
                    }
                    // xử lí ăn khi đi đến gần cây
                    else {
                        attack();
                    }
                })
        );
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
