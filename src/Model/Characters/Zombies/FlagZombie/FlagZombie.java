package src.Model.Characters.Zombies.FlagZombie;

import src.Config.DefaultValue;
import src.Config.Path;
import src.Model.ActCharacter.Zombie.ActFlagZombie;
import src.Model.Characters.Zombies.Zombie;
import src.Model.StageCharacter.Zombie.StageCharacterFlagZombie;
import src.Utils.LaneToLayoutY;

public class FlagZombie extends Zombie {

    // Constructor
    public FlagZombie() {
        super();
    }

    // Dùng để khởi tạo lần đầu tiên - chưa di chuyển
    public FlagZombie(int lane) {
        super(975, 0, Path.ASSETS_Image_FlagZombie_Run, DefaultValue.FlagZombie_WIDTH
                , DefaultValue.FlagZombie_HEIGHT, lane, DefaultValue.FlagZombie_HP
                , DefaultValue.FlagZombie_DAMAGE, DefaultValue.FlagZombie_SPEED_MOVE
                , DefaultValue.FlagZombie_SPEED_ATTACK, DefaultValue.FlagZombie_MOVE
                , Path.ASSETS_Image_FlagZombie_Eat);
        setY(LaneToLayoutY.zombieGetLayoutY(lane));
        setAct(new ActFlagZombie(this));
        setStageCharacter(new StageCharacterFlagZombie(this));
    }

    // Dùng để khởi tạo khi có vị trí cụ thể
    public FlagZombie(double x, double y, int lane) {

        super(x, y, Path.ASSETS_Image_FlagZombie_Run, DefaultValue.FlagZombie_WIDTH
                , DefaultValue.FlagZombie_HEIGHT, lane, DefaultValue.FlagZombie_HP
                , DefaultValue.FlagZombie_DAMAGE, DefaultValue.FlagZombie_SPEED_MOVE
                , DefaultValue.FlagZombie_SPEED_ATTACK, DefaultValue.FlagZombie_MOVE
                , Path.ASSETS_Image_FlagZombie_Eat);
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
