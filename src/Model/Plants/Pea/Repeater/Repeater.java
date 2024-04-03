package src.Model.Plants.Pea.Repeater;

import javafx.animation.Timeline;
import src.Model.Plants.Plant;

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
    public Repeater(double x, double y, int col, int row) {
        super(x, y, PATH, WIDTH, HEIGHT, HP, col, row, COST, SPEEDATTACK, DAME);

        createImageViewInGridPane();
        listTimelinePea = new ArrayList<Timeline>();
        setAct(new ActRepeater(this));
        setStageCharacter(new StageCharacterRepeater(this));
    }
    // Start tấn công
    @Override
    public void start() {
        getStageCharacter().start();
    }
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
