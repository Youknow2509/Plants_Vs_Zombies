package src.Model.Characters.Plants.Pea;

import javafx.animation.Timeline;
import src.Config.DefaultValue;
import src.Config.Path;
import src.Model.ActCharacter.Act;
import src.Model.ActCharacter.Plant.ActPea;
import src.Model.GameElements;
import src.Model.StageCharacter.Plant.StageCharacterPea;
import src.Model.StageCharacter.StageCharacter;

import java.util.List;

public class Pea extends GameElements {

    // Var
    private int DAMAGE = 20;
    private int SPEED = 1;
    private int SPEED_ATTACK = 5;
    private transient Timeline timeline;
    private List<Pea> listPea = null; // Danh sách đạn của đối tượng đang xử dụng nó
    private Act act;
    private StageCharacter stageCharacter;
    // Constructor
    public Pea(double x, double y, int lane,
               List<Pea> listPea) {
        super(x, y, Path.ASSETS_Image_Pea, DefaultValue.Pea_WIDTH, DefaultValue.Pea_HEIGHT, lane);
        this.listPea = listPea;
        this.DAMAGE = DefaultValue.Pea_DAMAGE;
        this.SPEED = DefaultValue.Pea_SPEED;
        this.SPEED_ATTACK = DefaultValue.Pea_SPEED_ATTACK;
        act = new ActPea(this);
        stageCharacter = new StageCharacterPea(this);
    }
    
    public void start() {
        getStageCharacter().start();
    }
    // Stop
    
    public void stop() {
        getStageCharacter().stop();
    }
    // Pause tấn công
    
    public void pause() {
        getStageCharacter().pause();
    }
    // Continue tấn công
    
    public void resume() {
        getStageCharacter().resume();
    }
    
    // Xóa đạn
    public void remove() {
        removeImageView();
        listPea.remove(this);
        timeline.stop();
    }

    // Getter - Setter

    public Timeline getTimeline() {
        return timeline;
    }

    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }

    public Act getAct() {
        return act;
    }

    public void setAct(Act act) {
        this.act = act;
    }

    public StageCharacter getStageCharacter() {
        return stageCharacter;
    }

    public void setStageCharacter(StageCharacter stageCharacter) {
        this.stageCharacter = stageCharacter;
    }

    public int getDAMAGE() {
        return DAMAGE;
    }

    public void setDAMAGE(int DAMAGE) {
        this.DAMAGE = DAMAGE;
    }

    public int getSPEED() {
        return SPEED;
    }

    public void setSPEED(int SPEED) {
        this.SPEED = SPEED;
    }

    public int getSPEED_ATTACK() {
        return SPEED_ATTACK;
    }

    public void setSPEED_ATTACK(int SPEED_ATTACK) {
        this.SPEED_ATTACK = SPEED_ATTACK;
    }

    public List<Pea> getListPea() {
        return listPea;
    }

    public void setListPea(List<Pea> listPea) {
        this.listPea = listPea;
    }
}
