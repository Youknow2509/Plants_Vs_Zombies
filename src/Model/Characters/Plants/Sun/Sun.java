package src.Model.Characters.Plants.Sun;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import src.Config.Path;
import src.Controller.Game.GameMainController;
import src.Model.ActCharacter.Act;
import src.Model.ActCharacter.Plant.ActSun;
import src.Model.Characters.GameElements;
import src.Model.StageCharacter.Plant.StageSun;
import src.Model.StageCharacter.StageCharacter;
import src.Utils.LaneToLayoutY;

import java.util.List;

public class Sun extends GameElements {
    // Var infomation of sun
    private static final int VALUE = 25;
    private static final int WIDTH = 45;
    private static final int HEIGHT = 45;

    // Var
    private int lane = 0;
    private int layoutXEnd = 0; // Vị trí x của sun sau khi rơi
    private int layoutYEnd = 0; // Vị trí y của sun sau khi rơi
    private int timeout = 0; // Thời gian mờ và xoá sun
    private transient Timeline timeline = null;
    private Act act;
    private StageCharacter stageCharacter;

    // Var list sun
    private List<Sun> listSun;

    // Constructor
    public Sun() {
        super();
        act = new ActSun(this);
        stageCharacter = new StageSun(this);
    }
    public Sun(int x, int y, int lane, int timeOutDisappear , List<Sun> listSun) {
        super(x, y, Path.ASSETS_Image_Sun, WIDTH, HEIGHT, lane);
        this.lane = lane;
        this.layoutYEnd = LaneToLayoutY.sunGetLayoutY(lane);
        this.layoutXEnd = x - 15;
        this.timeout = timeOutDisappear;
        this.listSun = listSun;

        act = new ActSun(this);
        stageCharacter = new StageSun(this);
    }

    // Tạo hình ảnh sun và thêm sự kiện click để nhận sun
    @Override
    public void createImageView() {
        if (getImageView() == null) {
            super.createImageView();
            getImageView().setOnMouseClicked((e) -> {
                GameMainController.setSun(GameMainController.getSun() + VALUE);
                removeImageView();
                listSun.remove(this);
            });
        }
    }

    // Làm mờ rồi xoá sun sau một thời gian nhất định
    public void DisappearSun() {
        timeline = new Timeline(new KeyFrame(Duration.millis(timeout), event -> {
            removeImageView();
            timeline.stop();
            listSun.remove(this);
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
}
