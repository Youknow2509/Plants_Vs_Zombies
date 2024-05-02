package src.Model.Characters.Plants.SunFlower;

import javafx.animation.Timeline;
import src.Config.Path;
import src.Model.ActCharacter.Act;
import src.Model.ActCharacter.Plant.ActSunFlower;
import src.Model.Characters.Plants.Plant;
import src.Model.Characters.Plants.Sun.Sun;
import src.Model.StageCharacter.Plant.StageFlowerSun;
import src.Model.StageCharacter.StageCharacter;

import java.util.ArrayList;
import java.util.List;

public class SunFlower extends Plant {
    // Var infomation of SunFlower
    public static final  int HP = 100;
    public static final  int COST = 50;
    public static final  int WIDTH = 60;
    public static final  int HEIGHT = 60;
    public static final int TIMEOUT_FLOWERSUN = 6000;
    public static final int SPEED_ATTACK = 10000;
    public static final int DAME = 0;
    // Var
    private List<Sun> listSun = new ArrayList<Sun>();
    private StageCharacter stageCharacter;
    private Act act;
    // Constructor
    public SunFlower() {
        super();
        this.act = new ActSunFlower(this);
        this.stageCharacter = new StageFlowerSun(this);
    }
    public SunFlower(double x, double y, int col, int row) {
        super(x, y, Path.ASSETS_Image_SunFlower, WIDTH, HEIGHT, HP, col, row, COST, SPEED_ATTACK, DAME);
        this.act = new ActSunFlower(this);
        this.stageCharacter = new StageFlowerSun(this);
    }
    // Tạo ra mặt trời - Adapter Pattern
    @Override
    public void start() {
        stageCharacter.start();
    }
    // Stage
    @Override
    public void stop() {
        stageCharacter.stop();
    }
    @Override
    public void pause() {
        stageCharacter.pause();
    }
    @Override
    public void resume() {
        stageCharacter.resume();
    }

    // Getter - Setter
    public List<Sun> getListSun() {
        return listSun;
    }

    public void setListSun(List<Sun> listSun) {
        this.listSun = listSun;
    }
    public StageCharacter getStageCharacter() {
        return stageCharacter;
    }

    public void setStageCharacter(StageCharacter stageCharacter) {
        this.stageCharacter = stageCharacter;
    }

    @Override
    public Act getAct() {
        return act;
    }

    @Override
    public void setAct(Act act) {
        this.act = act;
    }
}
