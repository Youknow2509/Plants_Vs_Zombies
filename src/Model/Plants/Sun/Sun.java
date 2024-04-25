package src.Model.Plants.Sun;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.util.Duration;
import src.Config.Path;
import src.Controller.Game.GameMainController;
import src.Model.GameElements;
import src.Utils.LaneToLayoutY;

import java.util.List;

public class Sun extends GameElements {
    // Var infomation of sun
    private static final int VALUE = 25;
    private static final int WIDTH = 45;
    private static final int HEIGHT = 45;
    private static final int TIMEOUT_DROPSUN = 14000;
    private static final int TIMEOUT_FLOWERSUN = 6000;
    // Var of sun
    private int lane = 0;
    private int layoutXEnd = 0;
    private int layoutYEnd = 0;
    private int timeout = 0;
    private Timeline tlSun = null;
    private List<Timeline> listTlSun;
    // Constructor
    public Sun() {
        super();
    }
    public Sun(int x, int y, int lane , List<Timeline> listTlSun) {
        super(x, y, Path.ASSETS_Image_Sun, WIDTH, HEIGHT, lane);
        this.lane = lane;
        this.layoutYEnd = LaneToLayoutY.sunGetLayoutY(lane);
        this.layoutXEnd = x - 15;
    }

    // Tạo hình ảnh sun và thêm sự kiện click để nhận sun
    @Override
    public void createImageView() {
        super.createImageView();
        getImageView().setOnMouseClicked((e) -> {
            GameMainController.setSun(GameMainController.getSun() + VALUE);
            removeImageView();
        });
    }

    // Tạo sun từ cây
    public void flowerCreateSun() { // todo stop drop sun
        timeout = TIMEOUT_FLOWERSUN;
        createImageView();

        tlSun = new Timeline(new KeyFrame(Duration.millis(30), e -> {
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

    // Tạo sun ngẫu nhiên rơi xuống
    public void CreatSunDrop() {
        timeout = TIMEOUT_DROPSUN;
        setY(0);    // Đặt lại vị trí y của sun về 0 để rơi từ trên xuống
        createImageView();

        tlSun = new Timeline(new KeyFrame(javafx.util.Duration.millis(30), e -> {
            if (this.getY() <= layoutYEnd) { // TODO: Lưu tạm this.getY() <= 550 để sun rơi đến cuối màn hình
                this.setY(this.getY() + 1);
            } else {
                tlSun.stop();
                DisappearSun();
            }
        }));
        tlSun.setCycleCount(Timeline.INDEFINITE);
        tlSun.play();
    }

    // Làm mờ rồi xoá sun sau một thời gian nhất định
    private void DisappearSun() {
        final Thread[] th = new Thread[1]; // Dùng mảng để thay đổi được

        th[0] = new Thread(() -> {
            try {
                Thread.sleep(timeout);
                th[0].interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Sử dụng để tác động lên giao diện
            Platform.runLater(() -> {
                tlSun.stop();
                removeImageView();
            });
        });

        th[0].start();
    }

    // Getter - Setter
    @Override
    public int getLane() {
        return lane;
    }

    @Override
    public void setLane(int lane) {
        this.lane = lane;
    }

    public int getLayoutXEnd() {
        return layoutXEnd;
    }

    public void setLayoutXEnd(int layoutXEnd) {
        this.layoutXEnd = layoutXEnd;
    }

    public int getLayoutYEnd() {
        return layoutYEnd;
    }

    public void setLayoutYEnd(int layoutYEnd) {
        this.layoutYEnd = layoutYEnd;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public Timeline getTlSun() {
        return tlSun;
    }

    public void setTlSun(Timeline tlSun) {
        this.tlSun = tlSun;
    }
}
