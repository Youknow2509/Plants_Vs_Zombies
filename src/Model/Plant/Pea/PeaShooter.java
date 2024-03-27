package src.Model.Plant.Pea;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import src.Model.Plant.Plant;
import src.Model.Zombie.Zombie;

import java.util.List;

public class PeaShooter extends Plant {

    private static final String path = "/Assets/images/Plants/Peashooter.gif";
    private static final int health = 100;
    private static final int dame = 20;
    private static final int cost = 100;
    private static final int speedAttack = 3;
    private static final int width = 60;
    private static final int height = 60;
    private List<Timeline> listTimelinePea = null;
    public PeaShooter(AnchorPane root, GridPane gridPane, double x, double y, int row, int col , List<Zombie> listZombie) {
        super(root, gridPane, x, y, path, width, height, row, col, listZombie, health, dame, speedAttack, cost);
    }
    // Xử lý tấn công zombie
    private void timelineAttack() {
        setTimelineAttack(new Timeline(new KeyFrame(Duration.seconds(speedAttack), e -> {
            synchronized (getListZombies()) {
                for (int i = 0; i < getListZombies().size(); i++) {
                    Zombie z = getListZombies().get(i);
                    // Xử lí nếu Zombie cùng hàng và trước 2 đơn vị thì tấn công
                    if (z.getLane() == getLane() && z.getX() > getX() + 2){
                        Pea pea = new Pea(getAnchorPane(), getGridPane(), getX(), getY(), getLane(), getCol(), getListZombies());
                        pea.startAnimation();
                    }
                }
            }
        })));
    }
    // Overide Start Attack
    @Override
    public void startAnimation() {
        if (getTimelineAttack() != null) {
            for (Timeline timeline : listTimelinePea) {
                timeline.setCycleCount(Timeline.INDEFINITE);
                timeline.play();
            }
            getTimelineAttack().setCycleCount(Timeline.INDEFINITE);
            getTimelineAttack().play();
        }
    }
    // Overide Stop Attack
    @Override
    public void stopAttack() {
        if (getTimelineAttack() != null) {
            getTimelineAttack().stop();
            for (Timeline timeline : listTimelinePea) {
                timeline.stop();
            }
        }
    }
    // Getter and setter
    public List<Timeline> getListTimelinePea() {
        return listTimelinePea;
    }

    public void setListTimelinePea(List<Timeline> listTimelinePea) {
        this.listTimelinePea = listTimelinePea;
    }
}