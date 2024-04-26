package src.Help.LawnMower;

import javafx.animation.Timeline;
import src.Config.Path;
import src.Model.GameElements;
import src.Model.StageCharacter;

import java.io.Serializable;

public class LawnMower extends GameElements implements Serializable {
    // Var infor LawnMower
    private static final int WIDTH = 80;
    private static final int HEIGHT = 80;
    private static final int DAMAGE = 10000;
    private static final int SPEED = 8;
    // Var
    private transient Timeline timeline;
    private ActLawnMower actLawnMower;
    private StageCharacter stageLawnMower;
    // Constructor
    public LawnMower() {
        super();
    }
    public LawnMower(double x, double y, int lane) {
        super(x, y, Path.ASSETS_Image_LawnMower, WIDTH, HEIGHT, lane);
        this.actLawnMower = new ActLawnMower(this);
        this.stageLawnMower = new StageLawnMower(this);
    }
    // Start
    public void start() {
        stageLawnMower.start();
    }

    // Stop
    public void stop() {
        stageLawnMower.stop();
    }

    // Pause
    public void pause() {
        stageLawnMower.pause();
    }

    // Resume
    public void resume() {
        stageLawnMower.resume();
    }

    // Getter and Setter
    public static String getPathImageActive() {
        return Path.ASSETS_Image_LawnMower_Active;
    }
    public static int getSpeed() {
        return SPEED;
    }
    public Timeline getTimeline() {
        return timeline;
    }
    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }
    public ActLawnMower getActLawnMower() {
        return actLawnMower;
    }

    public void setActLawnMower(ActLawnMower actLawnMower) {
        this.actLawnMower = actLawnMower;
    }

    public StageCharacter getStageLawnMower() {
        return stageLawnMower;
    }

    public void setStageLawnMower(StageCharacter stageLawnMower) {
        this.stageLawnMower = stageLawnMower;
    }
}
