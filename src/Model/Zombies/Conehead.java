package src.Model.Zombies;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import src.Controller.GameMainController;
import src.Model.Plants.Plant;

public class Conehead extends Zombie {
    // Var information of Conehead
    private static final int HP = 150;
    private static final int DAMAGE = 10;
    private static final int SPEED_MOVE = 1;
    private static final int SPEED_ATTACK = 1;
    private static final int MOVE = 1;
    private static final int WIDTH = 100;
    private static final int HEIGHT = 130;
    private static final String PATH = "Assets/images/Zombies/ConeheadZombie.gif";

    // Constructor
    public Conehead() {
        super();
    }
    public Conehead(int lane) {
        super(0, 0, PATH, WIDTH, HEIGHT, lane, HP, DAMAGE, SPEED_MOVE, SPEED_ATTACK, MOVE);
        laneToLayoutY(lane);
        createImageView();
    }
    public Conehead(double x, double y, int lane) {

        super(x, y, PATH, WIDTH, HEIGHT, lane, HP, DAMAGE, SPEED_MOVE, SPEED_ATTACK, MOVE);
        createImageView();
    }

    // Start
    @Override
    public void start() {
        super.start();
        setTimelineMove(new Timeline(new KeyFrame(Duration.seconds(SPEED_MOVE),
                e -> {
                    // xử lí việc di chuyển
                    if (isFlag()) {
                        // xử lí khi zombie đi hết đường hoặc hết máu
                        if (getX() < 0 || getHealth() <= 0) {
                            removeImageView();
                        } else {
                            setX(getX() - MOVE);
                            attack();
                        }
                    }
                    // xử lí ăn khi đi đến gần cây
                    else {
                        attack();
                    }
                }
        )));
        getTimelineMove().setCycleCount(Timeline.INDEFINITE);
        getTimelineMove().play();
    }
    // Attack plant
    private void attack() {
        boolean havePlant = false;
        synchronized (GameMainController.getListPlant()) {
            for (Plant p : GameMainController.getListPlant()) {
                if (p.getLane() == getLane() && getX() - p.getX() <= 30) {
                    havePlant = true;
                    setFlag(false);

                    p.setHp(p.getHp() - DAMAGE);
                    // Xử lí khi cây bị hết máu
                    if (p.getHp() <= 0) {
                        p.removeImageViewInGridPane();
                        GameMainController.getListPlant().remove(p);

                        setFlag(true);
                    }
                    //System.out.println("Plant hp: " + p.getHp()); // TODO : Để debug xem máu của cây còn lại bao nhiêu
                    break;
                }
            }
        }
        if (!havePlant) {
            setFlag(true);
        }
    }
}
