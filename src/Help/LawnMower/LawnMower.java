package src.Help.LawnMower;

import javafx.animation.Timeline;
import src.Model.GameElements;

public class LawnMower extends GameElements {
    // Var infor LawnMower
    private static final int WIDTH = 80;
    private static final int HEIGHT = 80;
    private static final int DAMAGE = 10000;
    private static final int SPEED = 8;
    private static final String PATH_IMAGE = "Assets/images/items/lawnMower_Idle.gif";
    private static final String PATH_IMAGE_ACTIVE = "Assets/images/items/lawnMower_Active.gif";
    // Var
    private Timeline timeline;
    private ActLawnMower actLawnMower;
    // Constructor
    public LawnMower() {
        super();
    }
    public LawnMower(double x, double y, int lane) {
        super(x, y, PATH_IMAGE, WIDTH, HEIGHT, lane);
        this.actLawnMower = new ActLawnMower(this);
        createImageView();
        actLawnMower.start();
    }
    // Getter and Setter
    public static String getPathImageActive() {
        return PATH_IMAGE_ACTIVE;
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
}
