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
public class Pea extends PeaShooter {
    // Var
    private final String path = "Assets/images/items/Pea.png";
    private final int width = 20;
    private final int height = 20;
    private int dame = 20;
    private int speed = 1;
    private Timeline timeline;
    // Constructor
    public Pea(AnchorPane root, GridPane gridPane, double x, double y, int row, int col, List<Zombie> listZombie) {
        super(root, gridPane, x, y, row, col, listZombie);
        createImageView();
    }
    // Bắt đầu Animation
    public void startAnimation() {
        timeline = new Timeline(new KeyFrame(Duration.seconds(speed), e -> {
            // TODO: Xử lí viên đạn
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        getListTimelinePea().add(timeline);
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
            setX(getX() + speed);
        }
        else {
            remove();
        }
        attack();
    }
    // Xử lí va chạm
    private void attack() {
        synchronized (getListZombies()) {
            for (int i = 0; i < getListZombies().size(); i++) {
                Zombie z = getListZombies().get(i);
                // Xử lí va chạm
                if (z.getLane() == getLane() && getX() - z.getX() <= 30 && getX() - z.getX() >= 0) {
                    z.setHealth(z.getHealth() - getDame());
                    remove();
                    // System.out.println("Zb hp: " +  z.getHp()); // TODO: Để debug xem máu của zombie còn lại bao nhiêu
                }
            }
        }
    }
    // Xoá đạn, dừng timeline
    private void remove() {
        stopAnimation();
        synchronized (getListTimelinePea()) {
            getListTimelinePea().remove(timeline);
        }
        removeImageView();
    }
}
