package src.Model.Plants;

import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import src.Controller.GameMainController;
import src.Model.GameElements;
import src.Model.Plants.CherryBomb.CherryBomb;
import src.Model.Plants.Chomper.Chomper;
import src.Model.Plants.Pea.PeaShooter;
import src.Model.Plants.Pea.Repeater;
import src.Model.Plants.PotanoMine.PotatoMine;
import src.Model.Plants.Sun.SunFlower;
import src.Model.Plants.Wallnut.Wallnut;

public class Plant extends GameElements {
    // Variables
    private int col = 0, row = 0;
    private int hp = 0;
    private int dame = 0;
    private int cost = 0;
    private int speedAttack = 0;
    private Timeline timelineAttack = null;

    // Constructor
    public Plant() {
        super();
    }

    public Plant(double x, double y, String path, int width, int height, // lane == row
                 int hp, int col, int row, int cost, int speedAttack, int dame) {

        super(x, y, path, width, height, row);

        this.hp = hp;
        this.col = col;
        this.row = row;
        this.cost = cost;
        this.speedAttack = speedAttack;
        this.dame = dame;

    }

    // Start tấn công
    public void start() {
        // Tạo timeline tấn công và chạy
    }

    // Pause tấn công
    public void pause() {
        if (timelineAttack != null) {
            timelineAttack.pause();
        }
    }

    // Resume tấn công
    public void resume() {
        if (timelineAttack != null) {
            timelineAttack.play();
        }
    }

    // Tao anh cay tren GridPane
    public void createImageViewInGridPane() {
        // Tạo một hình ảnh từ một tệp hình ảnh trên đĩa
        Image image = new Image(getPath(), 60, 60, false, false);
        // Tạo một ImageView để hiển thị hình ảnh
        setImageView(new ImageView(image));
        (getImageView()).setImage(image);
        // Thêm hình ảnh vào GridPane
        (GameMainController.getGridPane()).add(getImageView(), col, row, 1, 1);
    }

    // Xoa anh cay tren GridPane
    public void removeImageViewInGridPane() {
        getImageView().setDisable(true);
        getImageView().setVisible(false);
        if (timelineAttack != null) {
            timelineAttack.stop();
        }
        GameMainController.getGridPane().getChildren().remove(getImageView());
    }

    // Trả về cây tương ứng với path và vị trí trên game
    public static Plant getPlant(String path, int layoutX, int layoutY, int col, int row) {
        switch (path) {
            case "SunFlower":
                return new SunFlower(layoutX, layoutY, col, row);
            case "Peashooter":
                return new PeaShooter(layoutX, layoutY, col, row);
            case "Wallnut":
                return new Wallnut(layoutX, layoutY, col, row);
            case "CherryBomb":
                return new CherryBomb(layoutX, layoutY, col, row);
            case "PotatoMine":
                return new PotatoMine(layoutX, layoutY, col, row);
            case "Chomper":
                return new Chomper(layoutX, layoutY, col, row);
            case "Repeater":
                return new Repeater(layoutX, layoutY, col, row);
            default:
                return null;
        }
    }

    // Get và set các thuộc tính
    public int getCost() {
        return this.cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getDame() {
        return dame;
    }

    public void setDame(int dame) {
        this.dame = dame;
    }

    public int getSpeedAttack() {
        return speedAttack;
    }

    public void setSpeedAttack(int speedAttack) {
        this.speedAttack = speedAttack;
    }

    public Timeline getTimelineAttack() {
        return timelineAttack;
    }

    public void setTimelineAttack(Timeline timelineAttack) {
        this.timelineAttack = timelineAttack;
    }
}
