package src.Model.Zombies;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import src.Controller.GameMainController;
import src.Model.GameElements;
import src.Model.Plants.Plant;

import java.util.List;

public class Zombie extends GameElements {
    // Var
    private int health = 0;
    private int dame = 0;
    private int move = 0;
    private int speedMove = 0;
    private int speedAttack = 0;
    private boolean flag = true; // true : zombie đang di chuyển, false: zombie dừng lại tấn công.
    private Timeline timelineAttack = null;
    private Timeline timelineMove = null;

    // Constructor
    public Zombie() {
        super();
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
    // Pause tấn công
    public void pause() {
        if (timelineAttack != null) {
            timelineAttack.stop();
        }
        if (timelineMove != null) {
            timelineMove.stop();
        }
    }

    // Resume tấn công
    public void resume() {
        if (timelineAttack != null) {
            timelineAttack.play();
        }
        if (timelineMove != null) {
            timelineMove.play();
        }
    }

    // Remove image view of zombie
    @Override
    public void removeImageView() {
        super.removeImageView();
        if (timelineAttack != null) {
            timelineAttack.stop();
        }
        if (timelineMove != null) {
            timelineMove.stop();
        }
        getImageView().setDisable(true);
        getImageView().setVisible(false);
    }


    // Help Functions
    // Help - Chuyển từ lane sang layoutY
    public void laneToLayoutY(int l) {
        setX(975);
        switch (l) {
            case 0:
                setY(35);
                break;
            case 1:
                setY(135);
                break;
            case 2:
                setY(235);
                break;
            case 3:
                setY(335);
                break;
            case 4:
                setY(435);
                break;
            default:
                break;
        }
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

    public Timeline getTimelineAttack() {
        return timelineAttack;
    }

    public void setTimelineAttack(Timeline timelineAttack) {
        this.timelineAttack = timelineAttack;
    }

    public Timeline getTimelineMove() {
        return timelineMove;
    }

    public void setTimelineMove(Timeline timelineMove) {
        this.timelineMove = timelineMove;
    }
}
