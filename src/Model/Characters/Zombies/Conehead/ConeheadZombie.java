package src.Model.Characters.Zombies.Conehead;

import src.Config.DefaultValue;
import src.Config.Path;
import src.Model.ActCharacter.Zombie.ActConeheadZombie;
import src.Model.Characters.Zombies.Zombie;
import src.Model.StageCharacter.Zombie.StageCharacterConeheadZombie;
import src.Utils.LaneToLayoutY;

public class ConeheadZombie extends Zombie {
    // Constructor
    public ConeheadZombie() {
        super();
    }

    // Dùng để khởi tạo lần đầu tiên - chưa di chuyển
    public ConeheadZombie(int lane) {
        super(975, 0, Path.ASSETS_Image_ConeheadZombie_Run, DefaultValue.Conehead_WIDTH
                , DefaultValue.Conehead_HEIGHT, lane, DefaultValue.Conehead_HP
                , DefaultValue.Conehead_DAMAGE, DefaultValue.Conehead_SPEED_MOVE
                , DefaultValue.Conehead_SPEED_ATTACK, DefaultValue.Conehead_MOVE
                , Path.ASSETS_Image_ConeheadZombie_Eat);
        setY(LaneToLayoutY.zombieGetLayoutY(lane));
        setAct(new ActConeheadZombie(this));
        setStageCharacter(new StageCharacterConeheadZombie(this));
    }

    // Dùng để khởi tạo khi có vị trí cụ thể
    public ConeheadZombie(double x, double y, int lane) {
        super(x, y, Path.ASSETS_Image_ConeheadZombie_Run, DefaultValue.Conehead_WIDTH
                , DefaultValue.Conehead_HEIGHT, lane, DefaultValue.Conehead_HP
                , DefaultValue.Conehead_DAMAGE, DefaultValue.Conehead_SPEED_MOVE
                , DefaultValue.Conehead_SPEED_ATTACK, DefaultValue.Conehead_MOVE
                , Path.ASSETS_Image_ConeheadZombie_Eat);

        setAct(new ActConeheadZombie(this));
        setStageCharacter(new StageCharacterConeheadZombie(this));
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
