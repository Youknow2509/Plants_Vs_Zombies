package src.Model.Characters.Plants.PeaShooter;

import src.Config.DefaultValue;
import src.Config.Path;
import src.Model.ActCharacter.Plant.ActPeaShooter;
import src.Model.Characters.Plants.Pea.Pea;
import src.Model.Characters.Plants.Plant;
import src.Model.StageCharacter.Plant.StageCharacterPeaShooter;

import java.util.ArrayList;
import java.util.List;

public class PeaShooter extends Plant {

    // Var
    private List<Pea> listPea = null;
    // Constructor
    public PeaShooter() {
        super();
        listPea = new ArrayList<Pea>();
    }
    public PeaShooter(double x, double y, int col, int row) {
        super(x, y, Path.ASSETS_Image_PeaShooter, DefaultValue.PeaShooter_WIDTH, DefaultValue.PeaShooter_HEIGHT, DefaultValue.PeaShooter_HP
                , col, row, DefaultValue.PeaShooter_COST, DefaultValue.PeaShooter_SPEEDATTACK, DefaultValue.PeaShooter_DAME, DefaultValue.PeaShooter_TIMEBUY);

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
