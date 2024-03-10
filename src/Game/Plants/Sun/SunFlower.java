package src.Game.Plants.Sun;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import src.Game.Plants.Plant;
import src.Game.Plants.Sun.Sun;

public class SunFlower extends Plant {
    private final static String path = "/Assets/images/Plants/SunFlower.gif";
    private final static int hp = 100;
    private final static int cost = 50;
    public SunFlower(int x, int y, int col, int row) {
        super(x, y, path, hp, 60, 60, col, row, cost);
    }
    // Tạo ra mặt trời
    @Override
    public void attack() { // TODO: Cho thời gian tạo ra Sun random
        setTlDame(new Timeline(new KeyFrame(javafx.util.Duration.millis(4500), e -> {
            Sun sun = new Sun((int)this.getX() - 5,(int)this.getY() + 30, this.getRow());
            sun.makeImage();
            sun.flowerCreateSun();
        })));
        getTlDame().setCycleCount(Timeline.INDEFINITE);
        getTlDame().play();
    }
}
