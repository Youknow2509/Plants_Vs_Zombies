package src.Model.Plants.Pea;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import src.Controller.GameMainController;
import src.Model.GameElements;
import src.Model.Zombies.Zombie;

import java.util.List;

public class Pea extends GameElements {
    // Đặc điểm của đạn
    private static final String PATH = "Assets/images/items/Pea.png";
    private static int DAMAGE = 20;
    private static int SPEED = 1;
    private static int SPEED_ATTACK = 5;
    private static int WIDTH = 20;
    private static int HEIGHT = 20;
    private Timeline timeline;
    // Var
    private List<Timeline> listTimelinePea = null;
    private Zombie z;

    // Constructor
    public Pea(double x, double y, int lane,
               List<Timeline> listTimelinePea) {
        super(x, y, PATH, WIDTH, HEIGHT, lane);

        createImageView();
        
        this.listTimelinePea = listTimelinePea;
    }
    // Start tấn công
    public void start() {
        timeline = new Timeline(new KeyFrame(Duration.millis(SPEED_ATTACK),
                e -> {
                    movePea();
                }
        ));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        listTimelinePea.add(timeline);
    }
    // Di chuyển đạn
    private void movePea() {
        // Nếu đạn ra khỏi màn hình thì xóa đạn
        if (getX() < 1010) {
            setX(getX() + SPEED);
        }
        else {
            remove();
        }
        attack();
    }
    // Xử lí khi đạn chạm vào zombie
    private void attack() {
        synchronized ((GameMainController.getGameData()).getZombieAlive()) {
            if ((GameMainController.getGameData()).getZombieAlive() != null && (GameMainController.getGameData()).getZombieAlive().size() > 0) {
                for (int i = 0; i < (GameMainController.getGameData()).getZombieAlive().size(); i++) {
                    Zombie z = (GameMainController.getGameData()).getZombieAlive().get(i);
                    if (z.getLane() == getLane() && getX() - z.getX() <= 30 && getX() - z.getX() >= 0) {
                        z.setHealth(z.getHealth() - DAMAGE);
                        remove();
                        System.out.println("Zb + " + z +  " hp: " + z.getHealth()); // TODO: Để debug xem máu của zombie còn lại bao nhiêu
                        if (z.getHealth() <= 0) {
                            z.removeImageView();
                            (GameMainController.getGameData()).getZombieAlive().remove(z);
                        }
                    }
                }
            }
        }
    }
    // Xóa đạn
    public void remove() {
        removeImageView();
        timeline.stop();
        listTimelinePea.remove(timeline);
    }

    // Get và set các thuộc tính
    public int getDAMAGE() {
        return DAMAGE;
    }
    public void setDAMAGE(int DAMAGE) {
        this.DAMAGE = DAMAGE;
    }
    public int getSPEED() {
        return SPEED;
    }
    public void setSPEED(int SPEED) {
        this.SPEED = SPEED;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static void setWIDTH(int WIDTH) {
        Pea.WIDTH = WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static void setHEIGHT(int HEIGHT) {
        Pea.HEIGHT = HEIGHT;
    }

    public Timeline getTimeline() {
        return timeline;
    }

    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }

    public List<Timeline> getListTimelinePea() {
        return listTimelinePea;
    }

    public void setListTimelinePea(List<Timeline> listTimelinePea) {
        this.listTimelinePea = listTimelinePea;
    }
}
