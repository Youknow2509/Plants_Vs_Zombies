package src.Model.Characters.Plants.PeaShooter;

import src.Config.Path;
import src.Model.ActCharacter.Plant.ActPeaShooter;
import src.Model.Characters.Plants.Pea.Pea;
import src.Model.Characters.Plants.Plant;
import src.Model.StageCharacter.Plant.StageCharacterPeaShooter;

import java.util.ArrayList;
import java.util.List;

public class PeaShooter extends Plant {
    // Đặc điểm của PeaShooter
    public final static int HP = 2000;
    public final static int DAME = 20;
    public final static int COST = 100;
    public final static int SPEEDATTACK = 3;
    public final static int WIDTH = 60;
    public final static int HEIGHT = 60;
    public final static int TIMEBUY = 8;
    // Var
    private List<Pea> listPea = null;
    // Constructor
    public PeaShooter() {
        super();
        listPea = new ArrayList<Pea>();
    }
    public PeaShooter(double x, double y, int col, int row) {
        super(x, y, Path.ASSETS_Image_PeaShooter, WIDTH, HEIGHT, HP
                , col, row, COST, SPEEDATTACK, DAME, TIMEBUY);

        listPea = new ArrayList<Pea>();
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
    public List<Pea> getListPea() {
        return listPea;
    }
    public void setListPea(List<Pea> listPea) {
        this.listPea = listPea;
    }
}
