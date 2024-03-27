package src.Model.Plant.Pea;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import src.Model.Plant.Plant;
import src.Model.Zombie.Zombie;

import java.util.ArrayList;
import java.util.List;

public class PeaShooter extends Plant {

    private static final String PATH = "/Assets/images/Plants/Peashooter.gif";
    private static final int HEALTH = 100;
    private static final int DAME = 20;
    private static final int COST = 100;
    private static final int SPEED_ATTACK = 3;
    private static final int WIDTH = 60;
    private static final int HEIGHT = 60;
    private List<Timeline> listTimelinePea = null;
    public PeaShooter(double x, double y, int row, int col , List<Zombie> listZombie) {
        super(x, y, PATH, WIDTH, HEIGHT, row, col, listZombie, HEALTH, DAME, SPEED_ATTACK, COST);
        createImageView();
        listTimelinePea = new ArrayList<Timeline>();
        timelineAttack();
    }
    // Xử lý tấn công zombie
    private void timelineAttack() {
        setTimelineAttack(new Timeline(new KeyFrame(Duration.seconds(SPEED_ATTACK), e -> {
            synchronized (getListZombies()) {
//                for (int i = 0; i < getListZombies().size(); i++) {
//                    Zombie z = getListZombies().get(i);
//                    // Xử lí nếu Zombie cùng hàng và trước 2 đơn vị thì tấn công
//                    if (z.getLane() == getLane() && z.getX() > getX() + 2){
//                        Pea pea = new Pea((int) getX() + 50, (int) getY() + 25, DAME , getLane(), getListZombies(), getListTimelinePea());
//                        pea.startAnimation();
//                    }
//                }
                Pea pea = new Pea((int) getX() + 50, (int) getY() + 25, DAME , getLane(), getListZombies(), getListTimelinePea());
                pea.startAnimation();
            }
        })));
    }
    // Overide Start Attack
    @Override
    public void startAnimation() {
        if (getTimelineAttack() != null) {
            if (listTimelinePea != null) {
                for (Timeline timeline : listTimelinePea) {
                    timeline.setCycleCount(Timeline.INDEFINITE);
                    timeline.play();
                }
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