package src.Game.Plants;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.AnchorPane;
import src.Controller.GamePlayController;
import src.Game.GameElements;

public class Sun extends GameElements {
    private final static String path = "/Assets/images/items/Sun.png";
    private final int value = 25;
    private int lane;
    private Timeline tlSun;
    public Sun(int x, int y, int lane) {
        super(x, y, path, 45, 45, lane);
        this.lane = lane;
    }
    private int layoutYEnd() {
        switch (lane) {
            case 0:
                return 135;
            case 1:
                return 235;
            case 2:
                return 335;
            case 3:
                return 435;
            case 4:
                return 535;
            default:
                return 0;
        }
    }
    @Override
    public void makeImage(AnchorPane root) {
        super.makeImage(root);
        this.getImageView().setOnMouseClicked(e -> {
            GamePlayController.setSun(GamePlayController.getSun() + value);
            rmImage(root);
        });
    }
    private void moveSun() {
        if (this.getY() <= 550) {
            this.setY(this.getY() + 1);
        } else {
            // TODO: viết hàm đếm thời gian xoá sun
        }
    }
    public void dropSun() {
        tlSun = new Timeline(new KeyFrame(javafx.util.Duration.millis(30), e -> {
            moveSun();
        }));
        tlSun.setCycleCount(Timeline.INDEFINITE);
        tlSun.play();
    }
    public void flowerCreateSun() {
        tlSun = new Timeline(new KeyFrame(javafx.util.Duration.seconds(10), e -> {
            // TODO: animation tao sun tu cay hoa
        }));
        tlSun.setCycleCount(1);
        tlSun.play();
    }
    public void CreatSunDrop() {
        // TODO: animation tao sun tu mat troi
    }
}
