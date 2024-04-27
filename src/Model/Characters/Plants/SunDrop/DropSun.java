package src.Model.Characters.Plants.SunDrop;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
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
    // Var infomation drop sun
    public static final int TIMEOUT_DROPSUN = 14000;
    // Var of
    private List<Sun> listSun = new ArrayList<Sun>();
    private StageCharacter stageCharacter;
    private Act act;
    private int durationDropSun = 0;
    // Constructor
    public DropSun(){
        super();
        this.act = new ActDropSun(this);
        this.stageCharacter = new StageDropSun(this);

        durationDropSun = randomDurationDropSun();
    }
    // Lấy Duration random drop sun
    public int randomDurationDropSun() {
        return (Config.getRandom().nextInt(20) + 6);
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
}
