package src.Model.Characters.Plants.SunDrop;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import src.Config.DefaultValue;
import src.Model.ActCharacter.Act;
import src.Model.ActCharacter.Plant.ActDropSun;
import src.Model.Characters.Plants.Plant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import src.Config.Config;
import src.Model.Characters.Plants.Sun.Sun;
import src.Model.StageCharacter.Plant.StageDropSun;
import src.Model.StageCharacter.StageCharacter;

public class DropSun extends Plant implements Serializable { // todo
    // Var of
    private List<Sun> listSun = new ArrayList<Sun>();
    private StageCharacter stageCharacter;
    private Act act;
    private int durationDropSun = 0;
    private int min_timeDrop;
    private int max_timeDrop;
    private int timeOut_Drop;
    private double speed;
    // Constructor
    public DropSun(){
        super();

        this.min_timeDrop = DefaultValue.DropSun_MIN_TIME_DROP;
        this.max_timeDrop = DefaultValue.DropSun_MAX_TIME_DROP;
        this.timeOut_Drop = DefaultValue.DropSun_TIMEOUT_DROPSUN;
        this.speed = DefaultValue.DropSun_SPEED;

        this.act = new ActDropSun(this);
        this.stageCharacter = new StageDropSun(this);

        durationDropSun = randomDurationDropSun();
    }
    // Lấy Duration random drop sun
    public int randomDurationDropSun() {
        return (Config.getRandom().nextInt(min_timeDrop) + (max_timeDrop - min_timeDrop));
    }

    // Stage
    @Override
    public void start() {
        stageCharacter.start();
    }
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
    public Act getAct() {
        return act;
    }
    public void setAct(Act act) {
        this.act = act;
    }
    public void setDurationDropSun(int durationDropSun) {
        this.durationDropSun = durationDropSun;
    }

    public int getDurationDropSun() {
        return durationDropSun;
    }

    public int getMin_timeDrop() {
        return min_timeDrop;
    }

    public void setMin_timeDrop(int min_timeDrop) {
        this.min_timeDrop = min_timeDrop;
    }

    public int getMax_timeDrop() {
        return max_timeDrop;
    }

    public void setMax_timeDrop(int max_timeDrop) {
        this.max_timeDrop = max_timeDrop;
    }

    public int getTimeOut_Drop() {
        return timeOut_Drop;
    }

    public void setTimeOut_Drop(int timeOut_Drop) {
        this.timeOut_Drop = timeOut_Drop;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
