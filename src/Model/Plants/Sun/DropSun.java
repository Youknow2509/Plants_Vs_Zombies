package src.Model.Plants.Sun;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import src.Model.GameElements;
import src.Model.Plants.Plant;

import java.util.Random;
import src.Config.Config;

public class DropSun extends Plant {
    // Var infomation drop sun
    private static final int TIMEOUT_DROPSUN = 14000;
    // Var of

    // Constructor
    public DropSun(){
        super();
    }
    // Khởi tạo Sun rơi random sau thời gian random và vị trí random
    public void CreatSunDrop() {
        setTimelineAttack(new Timeline(
                new KeyFrame(Duration.seconds(6), event -> {

                    int x = Config.getRandom().nextInt(665) + 320;
                    int lane = Config.getRandom().nextInt(5);

                    Sun sun = new Sun(x, 0, lane);

                    sun.CreatSunDrop();
                })
        ));
        getTimelineAttack().play();
    }
    // Lấy Duration random drop sun
    public int getDurationDropSun() {
        // Random thời gian rơi của sun từ 5 đến 10 giây
        int time = Config.getRandom().nextInt(16) + 8;
        return time;
    }
}
