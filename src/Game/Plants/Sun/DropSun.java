package src.Game.Plants.Sun;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import src.Config;
import src.Game.GameElements;
import src.Game.Plants.Plant;

import java.util.Random;

public class DropSun extends Plant {
    public DropSun(){
        super();
    }
    // Khởi tạo Sun rơi
    public void initial() {
        // TODO: Để tạm thời 5 sun rơi, hàm for không thể để khi xử dụng trong game
        for (int i = 0; i < 5; i++) {
            CreatSunDrop();
        }
    }
    // Khởi tạo Sun rơi random sau thời gian random và vị trí random
    private void CreatSunDrop() {
        Random rd = Config.getRandom();
        // Random thời gian rơi của sun từ 5 đến 10 giây
        int time = rd.nextInt(5) + 5;

        setTlDame(new Timeline(
                new KeyFrame(Duration.seconds(time), event -> {
                    int x = rd.nextInt(665) + 320;
                    int lane = rd.nextInt(5);
                    Sun sun = new Sun(x, 0, lane);
                    sun.makeImage();
                    sun.CreatSunDrop();
                })
        ));
        getTlDame().play();
    }
}
