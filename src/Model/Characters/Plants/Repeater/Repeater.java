package src.Model.Characters.Plants.Repeater;

import src.Config.Path;
import src.Model.ActCharacter.Plant.ActRepeater;
import src.Model.Characters.Plants.Pea.Pea;
import src.Model.Characters.Plants.Plant;
import src.Model.StageCharacter.Plant.StageCharacterRepeater;

import java.util.ArrayList;

import java.util.List;

public class Repeater extends Plant {
    // Var information of Repeater
    private static final String PATH = "/Assets/images/Plants/Repeater.gif";
    private static final int HP = 22000;
    private static final int COST = 200;
    private static final int DAME = 40;
    private static final int SPEEDATTACK = 3;
    private static final int WIDTH = 60;
    private static final int HEIGHT = 60;
    private static final int TIMEBUY = 8;
    // Var
    private List<Pea> listPea;
    // Constructor
    public Repeater() {
        super();
        listPea = new ArrayList<Pea>();
    }
    public Repeater(double x, double y, int col, int row) {
        super(x, y, Path.ASSETS_Image_Repeater, WIDTH, HEIGHT, HP
                    , col, row, COST, SPEEDATTACK, DAME, TIMEBUY);
        listPea = new ArrayList<Pea>();
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

    public List<Pea> getListPea() {
        return listPea;
    }

    public void setListPea(List<Pea> listPea) {
        this.listPea = listPea;
    }
}
