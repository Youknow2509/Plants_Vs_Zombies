package src.Game.Plants.Sun;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import src.Config;
import src.Game.GameElements;
import src.Game.Plants.Plant;

import java.util.Random;

public class DropSun extends Plant {
    private Random rd = Config.getRandom();

    public DropSun(){
        super();
    }
    // Khởi tạo Sun rơi random sau thời gian random và vị trí random
    public void CreatSunDrop() {
        setTlDame(new Timeline(
                new KeyFrame(Duration.seconds(6), event -> {
                    int x = rd.nextInt(665) + 320;
                    int lane = rd.nextInt(5);
                    Sun sun = new Sun(x, 0, lane);
                    sun.makeImage();
                    sun.CreatSunDrop();
                })
        ));
        getTlDame().play();
    }
    // Lấy Duration random drop sun
    public int getDurationDropSun() {
        // Random thời gian rơi của sun từ 5 đến 10 giây
        int time = rd.nextInt(16) + 8;
        return time;
    }
}
