package src.Model.Characters.Zombies.Normal;

import src.Config.Path;
import src.Model.ActCharacter.Zombie.ActNormalZombie;
import src.Model.Characters.Zombies.Zombie;
import src.Model.StageCharacter.Zombie.StageCharacterNormalZombie;
import src.Utils.LaneToLayoutY;

public class NormalZombie extends Zombie {
    // Var information of normal zombie
    private static final int HP = 200;
    private static final int DAMAGE = 200;
    private static final int SPEED_MOVE = 2;
    private static final int SPEED_ATTACK = 1;
    private static final int MOVE = 8;
    private static final int WIDTH = 100;
    private static final int HEIGHT = 130;

    // Constructor
    public NormalZombie() {
        super();
    }
    public NormalZombie(int lane) {
        super(975, 0, Path.ASSETS_Image_NormalZombie_Run, WIDTH, HEIGHT, lane, HP, DAMAGE, SPEED_MOVE, SPEED_ATTACK, MOVE, Path.ASSETS_Image_NormalZombie_Eat);
        setY(LaneToLayoutY.zombieGetLayoutY(lane));
        setAct(new ActNormalZombie(this));
        setStageCharacter(new StageCharacterNormalZombie(this));
    }
    public NormalZombie(double x, double y, int lane) {

        super(x, y, Path.ASSETS_Image_NormalZombie_Run, WIDTH, HEIGHT, lane, HP, DAMAGE, SPEED_MOVE, SPEED_ATTACK, MOVE, Path.ASSETS_Image_NormalZombie_Eat);
        setAct(new ActNormalZombie(this));
        setStageCharacter(new StageCharacterNormalZombie(this));
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
