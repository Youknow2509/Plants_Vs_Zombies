package src.Model.Characters.Plants.Sun;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import src.Config.DefaultValue;
import src.Config.Path;
import src.Controller.Game.GameMainController;
import src.Model.ActCharacter.Act;
import src.Model.ActCharacter.Plant.ActSun;
import src.Model.GameElements;
import src.Model.StageCharacter.Plant.StageSun;
import src.Model.StageCharacter.StageCharacter;
import src.Utils.LaneToLayoutY;

import java.util.List;

public class Sun extends GameElements {

    // Var
    private int layoutXEnd = 0; // Vị trí x của sun sau khi rơi
    private int layoutYEnd = 0; // Vị trí y của sun sau khi rơi
    private int timeout = 0; // Thời gian mờ và xoá sun
    private double dx = 0;
    private double dy = 0;
    private double timeKeyFrame = 0;
    private transient Timeline timeline = null;
    private int sunValue;
    private Act act;
    private StageCharacter stageCharacter;

    // Var list sun
    private List<Sun> listSun;

    // Constructor
    // Xử dụng để tạo Sun từ SunFlower
    public Sun(int x, int y, int lane, int timeOutDisappear, double dx, double dy
            , double timeKeyFrame, List<Sun> listSun)
    {
        super(x, y, Path.ASSETS_Image_Sun, DefaultValue.Sun_WIDTH, DefaultValue.Sun_HEIGHT, lane);
        this.layoutYEnd = LaneToLayoutY.sunGetLayoutY(lane);
        this.layoutXEnd = x - 15;
        this.timeout = timeOutDisappear;
        this.listSun = listSun;
        this.dx = dx;
        this.dy = dy;
        this.timeKeyFrame = timeKeyFrame;
        this.sunValue = DefaultValue.Sun_VALUE;

        act = new ActSun(this);
        stageCharacter = new StageSun(this);
    }
    // Xử dụng để tạo Sun từ Drop Sun
    public Sun(double x, double y, int lane, int layoutXEnd, int layoutYEnd
            , int timeout, double dy, double timeKeyFrame, List<Sun> listSun)
    {
        super(x, y, Path.ASSETS_Image_Sun, DefaultValue.Sun_WIDTH, DefaultValue.Sun_HEIGHT, lane);
        this.layoutXEnd = layoutXEnd;
        this.layoutYEnd = layoutYEnd;
        this.timeout = timeout;
        this.dx = 0;
        this.dy = dy;
        this.listSun = listSun;
        this.timeKeyFrame = timeKeyFrame;
        this.sunValue = DefaultValue.Sun_VALUE;

        act = new ActSun(this);
        stageCharacter = new StageSun(this);
    }

    // Tạo hình ảnh sun và thêm sự kiện click để nhận sun
    @Override
    public void createImageView() {
        if (getImageView() == null) {
            super.createImageView();
            getImageView().setOnMouseClicked((e) -> {
                GameMainController.setSun(GameMainController.getSun() + sunValue);
                removeImageView();
                listSun.remove(this);
            });
        }
    }

    // Làm mờ rồi xoá sun sau một thời gian nhất định
    public void DisappearSun() {
        timeline.stop();
        timeline = new Timeline(new KeyFrame(Duration.millis(timeout), event -> {
            removeImageView();
            listSun.remove(this);
            timeline.stop();
        }));
        timeline.setCycleCount(1);  // Chỉ chạy một lần
        timeline.play();
    }

    public void start1() {
        ((StageSun)stageCharacter).start1();
    }

    public void start2() {
        ((StageSun)stageCharacter).start2();
    }

    public void stop() {
        (stageCharacter).stop();
    }

    public void pause() {
        (stageCharacter).pause();
    }

    public void resume() {
        (stageCharacter).resume();
    }


    // Getter - Setter
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

    public List<Sun> getListSun() {
        return listSun;
    }

    public void setListSun(List<Sun> listSun) {
        this.listSun = listSun;
    }

    public Act getAct() {
        return act;
    }

    public void setAct(Act act) {
        this.act = act;
    }

    public StageCharacter getStageCharacter() {
        return stageCharacter;
    }

    public void setStageCharacter(StageCharacter stageCharacter) {
        this.stageCharacter = stageCharacter;
    }

    public Timeline getTimeline() {
        return timeline;
    }

    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public double getTimeKeyFrame() {
        return timeKeyFrame;
    }

    public void setTimeKeyFrame(double timeKeyFrame) {
        this.timeKeyFrame = timeKeyFrame;
    }

    public int getSunValue() {
        return sunValue;
    }

    public void setSunValue(int sunValue) {
        this.sunValue = sunValue;
    }
}
