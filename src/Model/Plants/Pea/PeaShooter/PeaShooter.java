package src.Model.Plants.Pea.PeaShooter;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import src.Model.Act;
import src.Model.Plants.Plant;
import src.Model.StageCharacter;

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
    // Constructor
    public PeaShooter() {
        super();
    }
    public PeaShooter(double x, double y, int col, int row) {
        super(x, y, PATH, WIDTH, HEIGHT, HP, col, row, COST, SPEEDATTACK, DAME);

        createImageViewInGridPane();
        listTimelinePea = new ArrayList<Timeline>();
        setAct(new ActPeaShooter(this));
        setStageCharacter(new StageCharacterPeaShooter(this));
    }
    // Start tấn công
    @Override
    public void start() {
        getStageCharacter().start();
    }
    // Stop
    @Override
    public void stop() {
        getStageCharacter().stop();
    }
    // Pause tấn công
    @Override
    public void pause() {
        getStageCharacter().pause();
    }
    // Continue tấn công
    @Override
    public void resume() {
        getStageCharacter().resume();
    }
    // Getter and Setter
    public List<Timeline> getListTimelinePea() {
        return listTimelinePea;
    }
    public void setListTimelinePea(List<Timeline> listTimelinePea) {
        this.listTimelinePea = listTimelinePea;
    }
}
