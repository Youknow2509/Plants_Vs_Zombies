package src.Game.Plants;

import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import src.Game.GameElements;
import src.Game.Plants.Pea.PeaShooter;
import src.Game.Plants.Pea.Repeater;
import src.Game.Plants.Sun.SunFlower;

// Lớp trừu tượng cây
public class Plant extends GameElements {

    private int col, row;
    private int hp;
    private int cost;
    private Timeline tlDame;
    // Constructor
    public Plant(int x, int y, String path, int hp, int width, int height, int col, int row, int cost) {
        super(x, y, path, width, height, row);
        this.hp = hp;
        this.col = col;
        this.row = row;
        this.cost = cost;
    }
    public Plant() {
        super();
    }
    // Tạo hình ảnh cây
    public void makeImage(GridPane lawn, int col, int row) {
        // Tạo một hình ảnh từ một tệp hình ảnh trên đĩa
        Image image = new Image(getPath(), 60, 60, false, false);
        // Tạo một ImageView để hiển thị hình ảnh
        setImageView(new ImageView(image));
        (getImageView()).setImage(image);
        // Thêm hình ảnh vào GridPane
        lawn.add(getImageView(), col, row, 1, 1);
    }
    // Xóa hình ảnh cây ra khỏi bãi cỏ
    public void rmImage(GridPane lawn) {
        getImageView().setDisable(true);
        getImageView().setVisible(false);
        lawn.getChildren().remove(getImageView());
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
    // Tấn công zombie - khởi tạo phương thức để ghi đè cho từng cây
    public void attack() {
        // TODO: Xử lí tấn công
    }
    // Dừng lại hành động của cây
    public void rmTlDame() {
        if (tlDame != null) {
            tlDame.stop();
        }
    }
    // Get và set các thuộc tính
    public int getCost() { return this.cost;}
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
    public Timeline getTlDame() {
        return tlDame;
    }
    public void setTlDame(Timeline tlDame) {
        this.tlDame = tlDame;
    }
}
