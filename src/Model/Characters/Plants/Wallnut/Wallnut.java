package src.Model.Characters.Plants.Wallnut;

import src.Config.DefaultValue;
import src.Config.Path;
import src.Model.ActCharacter.Act;
import src.Model.ActCharacter.Plant.ActWallnut;
import src.Model.Characters.Plants.Plant;
import src.Model.StageCharacter.Plant.StageCharacterWallnut;

public class Wallnut extends Plant {

    //

    // Constructor of Wallnut
    public Wallnut() {
        super();
    }
    public Wallnut(double x, double y, int col, int row) {
        super(x, y, Path.ASSETS_Image_Wallnut, DefaultValue.Wallnut_WIDTH, DefaultValue.Wallnut_HEIGHT
                , DefaultValue.Wallnut_HP, col, row, DefaultValue.Wallnut_COST
                , DefaultValue.Wallnut_SPEED_ATTACK, DefaultValue.Wallnut_DAMAGE
                , DefaultValue.Wallnut_TIMEBUY);

        setAct(new ActWallnut(this));
        setStageCharacter(new StageCharacterWallnut(this));
    }

    // Start tấn công
    @Override
    public void start() {
        getStageCharacter().start();
    }
    // Stop
    @Override
    public void stop() {

    }
    // Pause tấn công
    @Override
    public void pause() {

    }

    // Resume tấn công
    @Override
    public void resume() {

    }

}
