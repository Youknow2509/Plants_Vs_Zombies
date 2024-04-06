package src.Model.Zombies.Normal;

import src.Model.Zombies.Zombie;
import src.Utils.LaneToLayoutY;

public class NormalZombie extends Zombie {
    // Var information of normal zombie
    private static final int HP = 120;
    private static final int DAMAGE = 30;
    private static final int SPEED_MOVE = 1;
    private static final int SPEED_ATTACK = 1;
    private static final int MOVE = 8;
    private static final int WIDTH = 100;
    private static final int HEIGHT = 130;
    private static final String PATH = "Assets/images/Zombies/NormalZombieRun.gif";
    //
    // Constructor
    public NormalZombie() {
        super();
    }
    public NormalZombie(int lane) {
        super(975, 0, PATH, WIDTH, HEIGHT, lane, HP, DAMAGE, SPEED_MOVE, SPEED_ATTACK, MOVE);
        setY(LaneToLayoutY.zombieGetLayoutY(lane));
        setAct(new ActNormalZombie(this));
        setStageCharacter(new StageCharacterNormalZombie(this));
    }
    public NormalZombie(double x, double y, int lane) {

        super(x, y, PATH, WIDTH, HEIGHT, lane, HP, DAMAGE, SPEED_MOVE, SPEED_ATTACK, MOVE);
        createImageView();
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