package src.Model.Plants.Sun;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import src.Config.Path;
import src.Model.Plants.Plant;
import src.Model.Plants.Sun.Sun;

import java.util.ArrayList;
import java.util.List;

public class SunFlower extends Plant {
    // Var infomation of SunFlower
    private static final  int HP = 100;
    private static final  int COST = 50;
    private static final  int WIDTH = 60;
    private static final  int HEIGHT = 60;
    private static final int TIMEOUT_FLOWERSUN = 6000;
    private static final int SPEED_ATTACK = 4500;
    private static final int DAME = 0;
    // Var
    private transient List<Timeline> timelineList = new ArrayList<Timeline>();
    private transient List<Timeline> DisappearSunList = new ArrayList<Timeline>();

    // Constructor
    public SunFlower() {
        super();
    }
    public SunFlower(double x, double y, int col, int row) {
        super(x, y, Path.ASSETS_Image_SunFlower, WIDTH, HEIGHT, HP, col, row, COST, SPEED_ATTACK, DAME);
        createImageViewInGridPane();
    }
    // Tạo ra mặt trời - Adapter Pattern
    @Override
    public void start() {
        setTimeline(new Timeline(new KeyFrame(javafx.util.Duration.millis(SPEED_ATTACK), e -> {
            Sun sun = new Sun((int)this.getX() - 5,(int)this.getY() + 30, this.getRow(), timelineList, DisappearSunList);
            sun.flowerCreateSun();
        })));
        getTimeline().setCycleCount(Timeline.INDEFINITE);
        getTimeline().play();
    }
    // Stage
    @Override
    public void stop() {
        if (getTimeline() != null) {
            getTimeline().stop();
        }
        if (timelineList != null) {
            for (Timeline tlSun : timelineList) {
                tlSun.stop();
            }
        }
        if (DisappearSunList != null) {
            for (Timeline tlSun : DisappearSunList) {
                tlSun.stop();
            }
        }
    }
    @Override
    public void pause() {
        if (getTimeline() != null) {
            getTimeline().pause();
        }
        if (timelineList != null) {
            for (Timeline tlSun : timelineList) {
                tlSun.pause();
            }
        }
        if (DisappearSunList != null) {
            for (Timeline tlSun : DisappearSunList) {
                tlSun.pause();
            }
        }
    }
    @Override
    public void resume() {
        if (getTimeline() != null) {
            getTimeline().play();
        }
        if (timelineList != null) {
            for (Timeline tlSun : timelineList) {
                tlSun.play();
            }
        }
        if (DisappearSunList != null) {
            for (Timeline tlSun : DisappearSunList) {
                tlSun.pause();
            }
        }
    }

}
