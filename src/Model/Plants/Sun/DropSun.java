package src.Model.Plants.Sun;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import src.Model.GameElements;
import src.Model.Plants.Plant;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import src.Config.Config;

public class DropSun extends Plant {
    // Var infomation drop sun
    private static final int TIMEOUT_DROPSUN = 14000;
    // Var of
    private List<Timeline> listTlSun;
    private List<Timeline> DisappearSunList;

    // Constructor
    public DropSun(){
        super();
        listTlSun = new ArrayList<Timeline>();
        DisappearSunList = new ArrayList<Timeline>();
    }
    // Khởi tạo Sun rơi random sau thời gian random và vị trí random
    public void CreatSunDrop() {
        setTimeline(new Timeline(
                new KeyFrame(Duration.seconds(6), event -> {

                    int x = Config.getRandom().nextInt(665) + 320;
                    int lane = Config.getRandom().nextInt(5);

                    Sun sun = new Sun(x, 0, lane, listTlSun, DisappearSunList);

                    sun.CreatSunDrop();
                })
        ));
        getTimeline().play();
    }
    // Lấy Duration random drop sun
    public int getDurationDropSun() {
        // Random thời gian rơi của sun từ 5 đến 10 giây
        int time = Config.getRandom().nextInt(16) + 8;
        return time;
    }

    // Stage
    @Override
    public void start() {
        if (getTimeline() != null) {
            getTimeline().play();
        }
        if (listTlSun != null) {
            for (Timeline tlSun : listTlSun) {
                tlSun.play();
            }
        }
    }
    @Override
    public void stop() {
        if (getTimeline() != null) {
            getTimeline().stop();
        }
        if (listTlSun != null) {
            for (Timeline tlSun : listTlSun) {
                tlSun.stop();
            }
        }
    }
    @Override
    public void pause() {
        if (getTimeline() != null) {
            getTimeline().pause();
        }
        if (listTlSun != null) {
            for (Timeline tlSun : listTlSun) {
                tlSun.pause();
            }
        }
    }
    @Override
    public void resume() {
        if (getTimeline() != null) {
            getTimeline().play();
        }
        if (listTlSun != null) {
            for (Timeline tlSun : listTlSun) {
                tlSun.play();
            }
        }
    }
}
