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
    public static int HP = 2000;
    public static int COST = 50;
    public static int WIDTH = 60;
    public static int HEIGHT = 60;
    public static int TIMEOUT_FLOWERSUN = 10000;
    public static int SPEED_ATTACK = 24000;
    public static int DAME = 0;
    public static int TIMEBUY = 8;
    // Var
    private List<Sun> listSun = new ArrayList<Sun>();

    // Constructor
    public SunFlower() {
        super();
        this.setAct(new ActSunFlower(this));
        this.setStageCharacter(new StageFlowerSun(this));
    }
    public SunFlower(double x, double y, int col, int row) {
        //
        super(x, y, Path.ASSETS_Image_SunFlower, WIDTH, HEIGHT, HP
                , col, row, COST, SPEED_ATTACK, DAME, TIMEBUY);
        this.setAct(new ActSunFlower(this));
        this.setStageCharacter(new StageFlowerSun(this));
    }
    // Tạo ra mặt trời - Adapter Pattern
    @Override
    public void start() {
        getStageCharacter().start();
    }
    // Stage
    @Override
    public void stop() {
        getStageCharacter().stop();
    }
    @Override
    public void pause() {
        getStageCharacter().pause();
    }
    @Override
    public void resume() {
        getStageCharacter().resume();
    }

    // Getter - Setter
    public List<Sun> getListSun() {
        return listSun;
    }

    public void setListSun(List<Sun> listSun) {
        this.listSun = listSun;
    }
}
