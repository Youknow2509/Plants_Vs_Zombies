package src.Model.Characters.Plants.SunFlower;

import src.Config.DefaultValue;
import src.Config.Path;
import src.Model.ActCharacter.Plant.ActSunFlower;
import src.Model.Characters.Plants.Plant;
import src.Model.Characters.Plants.Sun.Sun;
import src.Model.StageCharacter.Plant.StageFlowerSun;

import java.util.ArrayList;
import java.util.List;

public class SunFlower extends Plant {

    // Var
    private int timeOut;
    private double timeKeyFrame;
    private double dx;
    private double dy;
    private List<Sun> listSun = new ArrayList<Sun>();

    // Constructor
    public SunFlower(double x, double y, int col, int row) {
        //
        super(x, y, Path.ASSETS_Image_SunFlower, DefaultValue.SunFlower_WIDTH, DefaultValue.SunFlower_HEIGHT
                , DefaultValue.SunFlower_HP, col, row
                , DefaultValue.SunFlower_COST, DefaultValue.SunFlower_TIME_CREAT_SUN
                , DefaultValue.SunFlower_DAME, DefaultValue.SunFlower_TIMEBUY);

        helpConstructor();
    }

    // Help Constructor
    private void helpConstructor() {
        this.timeOut = DefaultValue.SunFlower_SUN_TIMEOUT;
        this.timeKeyFrame = DefaultValue.SunFlower_SUN_TIME_KEYFRAME;
        this.dx = DefaultValue.SunFlower_SUN_DX;
        this.dy = DefaultValue.SunFlower_SUN_DY;
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
    public int getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

    public double getTimeKeyFrame() {
        return timeKeyFrame;
    }

    public void setTimeKeyFrame(double timeKeyFrame) {
        this.timeKeyFrame = timeKeyFrame;
    }

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public List<Sun> getListSun() {
        return listSun;
    }

    public void setListSun(List<Sun> listSun) {
        this.listSun = listSun;
    }

}
