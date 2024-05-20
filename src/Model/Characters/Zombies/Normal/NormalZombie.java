package src.Model.Characters.Zombies.Normal;

import src.Config.DefaultValue;
import src.Config.Path;
import src.Model.ActCharacter.Zombie.ActNormalZombie;
import src.Model.Characters.Zombies.Zombie;
import src.Model.StageCharacter.Zombie.StageCharacterNormalZombie;
import src.Utils.LaneToLayoutY;

public class NormalZombie extends Zombie {

    // Constructor
    public NormalZombie() {
        super();
    }

    // Dùng để khởi tạo lần đầu tiên - chưa di chuyển
    public NormalZombie(int lane) {
        super(975, 0, Path.ASSETS_Image_NormalZombie_Run, DefaultValue.NormalZombie_WIDTH
                , DefaultValue.NormalZombie_HEIGHT, lane, DefaultValue.NormalZombie_HP
                , DefaultValue.NormalZombie_DAMAGE, DefaultValue.NormalZombie_SPEED_MOVE
                , DefaultValue.NormalZombie_SPEED_ATTACK, DefaultValue.NormalZombie_MOVE
                , Path.ASSETS_Image_NormalZombie_Eat);
        setY(LaneToLayoutY.zombieGetLayoutY(lane));
        setAct(new ActNormalZombie(this));
        setStageCharacter(new StageCharacterNormalZombie(this));
    }

    // Dùng để khởi tạo khi có vị trí cụ thể
    public NormalZombie(double x, double y, int lane) {

        super(x, y, Path.ASSETS_Image_NormalZombie_Run, DefaultValue.NormalZombie_WIDTH
                , DefaultValue.NormalZombie_HEIGHT, lane, DefaultValue.NormalZombie_HP
                , DefaultValue.NormalZombie_DAMAGE, DefaultValue.NormalZombie_SPEED_MOVE
                , DefaultValue.NormalZombie_SPEED_ATTACK, DefaultValue.NormalZombie_MOVE
                , Path.ASSETS_Image_NormalZombie_Eat);
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
