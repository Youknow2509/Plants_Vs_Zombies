package src.Model.Zombies;

import javafx.animation.Timeline;
import src.Model.Act;
import src.Model.GameElements;
import src.Model.StageCharacter;

public class Zombie extends GameElements {
    // Var
    private int health = 0;
    private int dame = 0;
    private int move = 0;
    private int speedMove = 0;
    private int speedAttack = 0;
    private boolean flag = true; // true : zombie đang di chuyển, false: zombie dừng lại tấn công.
    private Timeline timeline = null;
    private Act act = null;
    private StageCharacter stageCharacter = null;

    // Constructor
    public Zombie() {
        super();
        setX(975);
    }
    public Zombie(double x, double y, String path, int width, int height, int lane
            , int health, int dame, int speedMove, int speedAttack, int move) {
        super(x, y, path, width, height, lane);

        this.health = health;
        this.dame = dame;
        this.speedMove = speedMove;
        this.speedAttack = speedAttack;
        this.move = move;

    }
    // Start
    public void start() {

    }
    // Stop
    public void stop() {

    }
    // Pause tấn công
    public void pause() {
        if (timeline != null) {
            timeline.stop();
        }
        if (timeline != null) {
            timeline.stop();
        }
    }

    // Resume tấn công
    public void resume() {
        if (timeline != null) {
            timeline.play();
        }
        if (timeline != null) {
            timeline.play();
        }
    }

    // Remove image view of zombie
    @Override
    public void removeImageView() {
        super.removeImageView();
        if (timeline != null) {
            timeline.stop();
        }
        if (timeline != null) {
            timeline.stop();
        }
        getImageView().setDisable(true);
        getImageView().setVisible(false);
    }

    // Get và set các thuộc tính
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDame() {
        return dame;
    }

    public void setDame(int dame) {
        this.dame = dame;
    }

    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
    }

    public int getSpeedMove() {
        return speedMove;
    }

    public void setSpeedMove(int speedMove) {
        this.speedMove = speedMove;
    }

    public int getSpeedAttack() {
        return speedAttack;
    }

    public void setSpeedAttack(int speedAttack) {
        this.speedAttack = speedAttack;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

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
}
