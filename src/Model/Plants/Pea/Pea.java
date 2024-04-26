package src.Model.Plants.Pea;

import javafx.animation.Timeline;
import src.Config.Path;
import src.Model.Act;
import src.Model.GameElements;
import src.Model.StageCharacter;

import java.util.List;

public class Pea extends GameElements {
    // Đặc điểm của đạn
    private static int DAMAGE = 20;
    private static int SPEED = 1;
    private static int SPEED_ATTACK = 5;
    private static int WIDTH = 20;
    private static int HEIGHT = 20;
    private transient Timeline timeline;
    // Var
    private List<Pea> listPea = null; // Danh sách đạn của đối tượng đang xử dụng nó
    private Act act;
    private StageCharacter stageCharacter;
    // Constructor
    public Pea(double x, double y, int lane,
               List<Pea> listPea) {
        super(x, y, Path.ASSETS_Image_Pea, WIDTH, HEIGHT, lane);

        createImageView();
        
        this.listPea = listPea;
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

    // Get và set các thuộc tính
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

    public static int getWIDTH() {
        return WIDTH;
    }

    public static void setWIDTH(int WIDTH) {
        Pea.WIDTH = WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static void setHEIGHT(int HEIGHT) {
        Pea.HEIGHT = HEIGHT;
    }

    public Timeline getTimeline() {
        return timeline;
    }

    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }

    public static int getSpeedAttack() {
        return SPEED_ATTACK;
    }

    public static void setSpeedAttack(int speedAttack) {
        SPEED_ATTACK = speedAttack;
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
}
