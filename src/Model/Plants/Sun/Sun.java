package src.Model.Plants.Sun;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.util.Duration;
import src.Controller.GameMainController;
import src.Model.GameElements;
public class Sun extends GameElements {
    // Var infomation of sun
    private static final String PATH = "/Assets/images/items/Sun.png";
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

    // Constructor
    public Sun(int x, int y, int lane) {
        super(x, y, PATH, WIDTH, HEIGHT, lane);
        this.lane = lane;
        this.layoutYEnd = getLayoutYEnd();
        this.layoutXEnd = x - 15;
    }
    // Lấy ra vị trí điểm rơi y khi sun rơi xuống từ cây
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
    public void flowerCreateSun() {
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
        final Thread[] th = new Thread[1];
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
}
