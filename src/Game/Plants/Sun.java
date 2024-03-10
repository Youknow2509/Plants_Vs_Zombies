package src.Game.Plants;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.layout.AnchorPane;
import src.Controller.GamePlayController;
import src.Game.GameElements;
public class Sun extends GameElements {
    private final static String path = "/Assets/images/items/Sun.png";
    private final int value = 25;
    private int lane;
    private int layoutXEnd;
    private int layoutYEnd;
    private int timeout;
    private Timeline tlSun;
    public Sun(int x, int y, int lane) {
        super(x, y, path, 45, 45, lane);
        this.lane = lane;
        this.layoutYEnd = getLayoutYEnd();
        this.layoutXEnd = x - 15;
    }
    // Lấy ra vị trí y cuối cùng khi sun rơi xuống
    private int getLayoutYEnd() {
        switch (lane) {
            case 0:
                return 140; // x0 : 315  320 - 85
            case 1:
                return 240;
            case 2:
                return 340;
            case 3:
                return 440;
            case 4:
                return 540;
            default:
                return 0;
        }
    }
    @Override
    public void makeImage() {
        super.makeImage();
        getImageView().setOnMouseClicked((e) -> {
            GamePlayController.setSun(GamePlayController.getSun() + value);
            rmImage();
        });
    }
    private void moveSun() {
        if (this.getY() <= 550) {
            this.setY(this.getY() + 1);
        } else {
            tlSun.stop();
            DisappearSun();
        }
    }
    // Tạo sun từ sunflower
    public void flowerCreateSun() {
        timeout = 6000;
        tlSun = new Timeline(new KeyFrame(javafx.util.Duration.millis(30), e -> {
            if (this.getY() < layoutYEnd) {
                this.setY(this.getY() + 1);
                this.setX(this.getX() - 0.2);
            } else {
                tlSun.stop();
                DisappearSun();
            }
        }));
        tlSun.setCycleCount(Timeline.INDEFINITE);
        tlSun.play();
    }
    // Rơi sun random
    public void CreatSunDrop() {
        timeout = 14000;
        tlSun = new Timeline(new KeyFrame(javafx.util.Duration.millis(30), e -> {
            moveSun();
        }));
        tlSun.setCycleCount(Timeline.INDEFINITE);
        tlSun.play();
    }
    // Làm mờ rồi xoá sun
    private void DisappearSun() {
        Thread th = new Thread(() -> {
            try {
                Thread.sleep(timeout);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Platform.runLater(() -> {
                rmImage();
                tlSun.stop();
            });
        });
        th.start();
    }
}
