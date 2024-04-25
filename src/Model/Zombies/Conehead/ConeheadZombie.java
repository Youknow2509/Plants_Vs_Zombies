package src.Model.Zombies.Conehead;

import src.Config.Path;
import src.Model.Zombies.Zombie;
import src.Utils.LaneToLayoutY;

public class ConeheadZombie extends Zombie { // Todo format lại code
    // Var information of ConeheadZombie
    private static final int HP = 150;
    private static final int DAMAGE = 10;
    private static final int SPEED_MOVE = 1;
    private static final int SPEED_ATTACK = 1;
    private static final int MOVE = 1;
    private static final int WIDTH = 100;
    private static final int HEIGHT = 130;

    // Constructor
    public ConeheadZombie() {
        super();
    }
    public ConeheadZombie(int lane) {
        super(975, 0, Path.ASSETS_Image_ConeheadZombie_Run, WIDTH, HEIGHT, lane, HP, DAMAGE, SPEED_MOVE, SPEED_ATTACK, MOVE, Path.ASSETS_Image_ConeheadZombie_Eat);
        setY(LaneToLayoutY.zombieGetLayoutY(lane));
        setAct(new ActConeheadZombie(this));
        setStageCharacter(new StageCharacterConeheadZombie(this));
    }
    public ConeheadZombie(double x, double y, int lane) {
        super(x, y, Path.ASSETS_Image_ConeheadZombie_Run, WIDTH, HEIGHT, lane, HP, DAMAGE, SPEED_MOVE, SPEED_ATTACK, MOVE, Path.ASSETS_Image_ConeheadZombie_Eat);
        setAct(new ActConeheadZombie(this));
        setStageCharacter(new StageCharacterConeheadZombie(this));
        createImageView();
    }

    // Medthod
    // Start
    @Override
    public void start() {
        super.start();
        getStageCharacter().start();
    }
    // Stop
    @Override
    public void stop() {
        super.stop();
        getStageCharacter().stop();
    }
    // Pause
    @Override
    public void pause() {
        super.pause();
        getStageCharacter().pause();
    }
    // Resume
    @Override
    public void resume() {
        super.resume();
        getStageCharacter().resume();
    }

    // Getter and setter

}
