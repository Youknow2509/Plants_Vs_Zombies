package src.Model.Characters.Plants.Wallnut;

import src.Config.Path;
import src.Model.ActCharacter.Act;
import src.Model.ActCharacter.Plant.ActWallnut;
import src.Model.Characters.Plants.Plant;
import src.Model.StageCharacter.Plant.StageCharacterWallnut;

public class Wallnut extends Plant {
    // Variables infomation of Wallnut
    public static final int HP = 4000;
    public static final int COST = 50;
    public static final int DAMAGE = 0;
    public static final int WIDTH = 60;
    public static final int HEIGHT = 60;
    public static final int SPEED_ATTACK = 0;
    public static final int TIMEBUY = 15;

    //

    // Constructor of Wallnut
    public Wallnut() {
        super();
    }
    public Wallnut(double x, double y, int col, int row) {
        super(x, y, Path.ASSETS_Image_Wallnut, WIDTH, HEIGHT, HP
                , col, row, COST, SPEED_ATTACK, DAMAGE, TIMEBUY);

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
