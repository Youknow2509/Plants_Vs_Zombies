package src.Model.Plants.Pea;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import src.Model.Act;
import src.Model.Plants.Plant;

import java.util.ArrayList;
import java.util.List;

public class PeaShooter extends Plant {
    // Đặc điểm của PeaShooter
    private static final String PATH = "/Assets/images/Plants/Peashooter.gif";
    private static final  int HP = 100;
    private static final  int DAME = 20;
    private static final  int COST = 100;
    private static final  int SPEEDATTACK = 3;
    private static final  int WIDTH = 60;
    private static final  int HEIGHT = 60;
    // Var
    private List<Timeline> listTimelinePea = null;
    private Act act = null;
    // Constructor
    public PeaShooter() {
        super();
    }
    public PeaShooter(double x, double y, int col, int row) {
        super(x, y, PATH, WIDTH, HEIGHT, HP, col, row, COST, SPEEDATTACK, DAME);

        createImageViewInGridPane();
        listTimelinePea = new ArrayList<Timeline>();
        act = new ActPeaShooter(this);
    }
    // Start tấn công
    @Override
    public void start() {
        setTimelineAttack(new Timeline(new KeyFrame(Duration.seconds(SPEEDATTACK),
                e -> {
//                    synchronized (GameMainController.getListZombieAlive()) {
//                        if (GameMainController.getListZombieAlive() != null && GameMainController.getListZombieAlive().size() > 0)
//                            for (int i = 0; i < GameMainController.getListZombieAlive().size(); i++) {
//                                Zombie z = GameMainController.getListZombieAlive().get(i);
//                                if (z.getLane() == getLane() && z.getX() > getX() + 2) {
//                                    Pea pea = new Pea((int) getX() + 50, (int) getY() + 25, getLane(), listTimelinePea);
//                                    pea.start();
//                                }
//                            }
//                    }
                    act.handle();
                }
        )));
        getTimelineAttack().setCycleCount(Timeline.INDEFINITE);
        getTimelineAttack().play();
    }
    // Pause tấn công
    @Override
    public void pause() {
        if (getTimelineAttack() != null) {
            getTimelineAttack().pause();
        }
        if (listTimelinePea != null) {
            for (Timeline timeline : listTimelinePea) {
                timeline.pause();
            }
        }
    }
    // Continue tấn công
    @Override
    public void resume() {
        if (getTimelineAttack() != null) {
            getTimelineAttack().play();
        }
        if (listTimelinePea != null) {
            for (Timeline timeline : listTimelinePea) {
                timeline.play();
            }
        }
    }
    // Getter and Setter
    public List<Timeline> getListTimelinePea() {
        return listTimelinePea;
    }
    public void setListTimelinePea(List<Timeline> listTimelinePea) {
        this.listTimelinePea = listTimelinePea;
    }
}
