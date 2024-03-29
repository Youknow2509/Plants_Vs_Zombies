package src.Model.Plants.Pea;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import src.Controller.GameMainController;
import src.Model.Plants.Plant;
import src.Model.Zombies.Zombie;
import src.Model.Plants.Pea.Pea;
import java.util.ArrayList;

import java.util.List;

public class Repeater extends Plant {
    // Var information of Repeater
    private static final String PATH = "/Assets/images/Plants/Repeater.gif";
    private static final int HP = 200;
    private static final int COST = 200;
    private static final int DAME = 20;
    private static final  int SPEEDATTACK = 3;
    private static final  int WIDTH = 60;
    private static final  int HEIGHT = 60;
    // Var
    private List<Timeline> listTimelinePea = null;
    // Constructor
    public Repeater() {
        super();
        listTimelinePea = new ArrayList<Timeline>();
    }
    public Repeater(int x, int y, int col, int row) {
        super(x, y, PATH, WIDTH, HEIGHT, HP, col, row, COST, SPEEDATTACK, DAME);

        createImageViewInGridPane();
        listTimelinePea = new ArrayList<Timeline>();
    }
    // Start tấn công
    @Override
    public void start() {
        setTimelineAttack(new Timeline(new KeyFrame(Duration.seconds(SPEEDATTACK),
                e -> {
                    synchronized (GameMainController.getListZombieAlive()) {
                        for (int i = 0; i < GameMainController.getListZombieAlive().size(); i++) {
                            Zombie z = GameMainController.getListZombieAlive().get(i);
                            if (z.getLane() == getLane() && z.getX() > getX() + 2){
                                Pea pea1 = new Pea((int) getX() + 45, (int) getY() + 25, getLane(), listTimelinePea);
                                Pea pea2 = new Pea((int) getX() + 80, (int) getY() + 25, getLane(), listTimelinePea);
                                pea1.start();
                                pea2.start();
                            }
                        }
                    }
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
