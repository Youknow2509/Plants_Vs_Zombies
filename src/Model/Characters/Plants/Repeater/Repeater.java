package src.Model.Characters.Plants.Repeater;

import src.Config.DefaultValue;
import src.Config.Path;
import src.Model.ActCharacter.Plant.ActRepeater;
import src.Model.Characters.Plants.Pea.Pea;
import src.Model.Characters.Plants.Plant;
import src.Model.StageCharacter.Plant.StageCharacterRepeater;

import java.util.ArrayList;

import java.util.List;

public class Repeater extends Plant {
    // Var
    private List<Pea> listPea;
    // Constructor
    public Repeater() {
        super();
        listPea = new ArrayList<Pea>();
    }
    public Repeater(double x, double y, int col, int row) {
        super(x, y, Path.ASSETS_Image_Repeater, DefaultValue.Repeater_WIDTH, DefaultValue.Repeater_HEIGHT
                , DefaultValue.Repeater_HP, col, row, DefaultValue.Repeater_COST, DefaultValue.Repeater_SPEEDATTACK
                , DefaultValue.Repeater_DAME, DefaultValue.Repeater_TIMEBUY);
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
