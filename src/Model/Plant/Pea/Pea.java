package src.Model.Plant.Pea;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import src.Model.GameElements;
import src.Model.Zombie.Zombie;

import java.util.List;

// Viên đạn
public class Pea extends GameElements {
    // Var
    private static final String PATH = "Assets/images/items/Pea.png";
    private static final int WIDTH = 20;
    private static final int HEIGHT = 20;
    private int SPEED = 1;
    private int dame = 0;
    private List<Zombie> listZombie = null;
    private List<Timeline> listTimelinePea = null;
    private Timeline timeline;
    // Constructor
    public Pea(double x, double y, int dame, int lane, List<Zombie> listZombie, List<Timeline> listTimelinePea) {
        super(x, y, PATH, WIDTH, HEIGHT, lane);
        this.listZombie = listZombie;
        this.listTimelinePea = listTimelinePea;
        this.dame = dame;
        createImageView();
    }
    // Bắt đầu Animation
    public void startAnimation() {
        timeline = new Timeline(new KeyFrame(Duration.seconds(SPEED), e -> {
            setX(getX() + SPEED);
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        listTimelinePea.add(timeline);
        timeline.play();
    }
    // Stop Animation
    public void stopAnimation() {
        if (timeline != null) {
            timeline.stop();
        }
    }
    // Xử lí di chuyển đạn
    private void move() {
        // Nếu đạn ra khỏi màn hình thì xóa đạn
        if (getX() < 1010) {
            setX(getX() + SPEED);
        }
        else {
            remove();
        }
        //attack();
    }
    // Xử lí va chạm
    private void attack() {
        synchronized (listZombie) {
            for (int i = 0; i < listZombie.size(); i++) {
                Zombie z = listZombie.get(i);
                // Xử lí va chạm
                if (z.getLane() == getLane() && getX() - z.getX() <= 30 && getX() - z.getX() >= 0) {
                    z.setHealth(z.getHealth() - dame);
                    remove();
                    // System.out.println("Zb hp: " +  z.getHp()); // TODO: Để debug xem máu của zombie còn lại bao nhiêu
                }
            }
        }
    }
    // Xoá đạn, dừng timeline
    private void remove() {
        stopAnimation();
        synchronized (listTimelinePea) {
            listTimelinePea.remove(timeline);
        }
        removeImageView();
    }
}
