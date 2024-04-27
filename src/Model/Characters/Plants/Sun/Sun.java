package src.Model.Characters.Plants.Sun;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import src.Config.Path;
import src.Controller.Game.GameMainController;
import src.Model.Characters.GameElements;
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
    private transient Timeline tlSun = null;
    private transient Timeline tlSunDisappearSun;
    private transient List<Timeline> listTlSun;
    private transient List<Timeline> DisappearSunList;

    // Constructor
    public Sun() {
        super();
    }
    public Sun(int x, int y, int lane , List<Timeline> listTlSun, List<Timeline> DisappearSunList) {
        super(x, y, Path.ASSETS_Image_Sun, WIDTH, HEIGHT, lane);
        this.lane = lane;
        this.layoutYEnd = LaneToLayoutY.sunGetLayoutY(lane);
        this.layoutXEnd = x - 15;
        this.listTlSun = listTlSun;
        this.DisappearSunList = DisappearSunList;
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
                listTlSun.remove(tlSun);
                DisappearSun();
            }
        }));
        tlSun.setCycleCount(Timeline.INDEFINITE);
        tlSun.play();
        listTlSun.add(tlSun);
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
                listTlSun.remove(tlSun);
                DisappearSun();
            }
        }));
        tlSun.setCycleCount(Timeline.INDEFINITE);
        tlSun.play();
        listTlSun.add(tlSun);
    }

    // Làm mờ rồi xoá sun sau một thời gian nhất định
    private void DisappearSun() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(timeout), event -> {
            tlSun.stop();
            removeImageView();
            listTlSun.remove(tlSun);
        }));
        timeline.setCycleCount(1);  // Chỉ chạy một lần
        timeline.play();
        DisappearSunList.add(timeline);
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

    public List<Timeline> getListTlSun() {
        return listTlSun;
    }

    public void setListTlSun(List<Timeline> listTlSun) {
        this.listTlSun = listTlSun;
    }

    public List<Timeline> getDisappearSunList() {
        return DisappearSunList;
    }

    public void setDisappearSunList(List<Timeline> disappearSunList) {
        DisappearSunList = disappearSunList;
    }

    public Timeline getTlSunDisappearSun() {
        return tlSunDisappearSun;
    }

    public void setTlSunDisappearSun(Timeline tlSunDisappearSun) {
        this.tlSunDisappearSun = tlSunDisappearSun;
    }
}
