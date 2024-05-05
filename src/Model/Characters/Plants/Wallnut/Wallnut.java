package src.Model.Characters.Plants.Wallnut;

import src.Config.Path;
import src.Model.ActCharacter.Act;
import src.Model.ActCharacter.Plant.ActWallnut;
import src.Model.Characters.Plants.Plant;
import src.Model.StageCharacter.Plant.StageCharacterWallnut;

public class Wallnut extends Plant {
    // Variables infomation of Wallnut
    private final static int HP = 4000;
    private final static int COST = 50;
    private static final int DAMAGE = 0;
    private static final int WIDTH = 60;
    private static final int HEIGHT = 60;
    private static final int SPEED_ATTACK = 0;
    private static final int TIMEBUY = 15;

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
