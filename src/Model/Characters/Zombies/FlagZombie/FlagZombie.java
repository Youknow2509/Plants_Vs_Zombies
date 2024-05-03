package src.Model.Characters.Zombies.FlagZombie;

import src.Config.Path;
import src.Model.ActCharacter.Zombie.ActFlagZombie;
import src.Model.Characters.Zombies.Zombie;
import src.Model.StageCharacter.Zombie.StageCharacterFlagZombie;
import src.Utils.LaneToLayoutY;

public class FlagZombie extends Zombie {
    // Var information of normal zombie
    private static final int HP = 120;
    private static final int DAMAGE = 30;
    private static final int SPEED_MOVE = 2;
    private static final int SPEED_ATTACK = 1;
    private static final int MOVE = 10;
    private static final int WIDTH = 100;
    private static final int HEIGHT = 130;

    // Constructor
    public FlagZombie() {
        super();
    }
    public FlagZombie(int lane) {
        super(975, 0, Path.ASSETS_Image_FlagZombie_Run, WIDTH, HEIGHT, lane, HP, DAMAGE, SPEED_MOVE, SPEED_ATTACK, MOVE, Path.ASSETS_Image_FlagZombie_Eat);
        setY(LaneToLayoutY.zombieGetLayoutY(lane));
        setAct(new ActFlagZombie(this));
        setStageCharacter(new StageCharacterFlagZombie(this));
    }
    public FlagZombie(double x, double y, int lane) {

        super(x, y, Path.ASSETS_Image_FlagZombie_Run, WIDTH, HEIGHT, lane, HP, DAMAGE, SPEED_MOVE, SPEED_ATTACK, MOVE, Path.ASSETS_Image_FlagZombie_Eat);
        setAct(new ActFlagZombie(this));
        setStageCharacter(new StageCharacterFlagZombie(this));
    }

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
