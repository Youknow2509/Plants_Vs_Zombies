package src.Game.Plants;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import src.Game.GameElements;

import java.util.ArrayList;

// Lớp trừu tượng cây
public class Plant extends GameElements{

    public int col, row;
    protected int hp;
    public int lane;
    protected int cost;
    // Constructor
    public Plant(int x, int y, String path, int hp, int width, int height, int col, int row, int cost) {
        super(x, y, path, width, height);
        this.hp = hp;
        this.col = col;
        this.row = row;
        this.cost = cost;
        this.lane = row ;
    }
    public Plant() {
        super();
    }

    public int getCost() { return this.cost;}
    public void makeImage(GridPane lawn, int col, int row) {
        // Tạo một hình ảnh từ một tệp hình ảnh trên đĩa
        Image image = new Image(path, 60, 60, false, false);
        // Tạo một ImageView để hiển thị hình ảnh
        imageView = new ImageView(image);
        imageView.setImage(image);
        // Thêm hình ảnh vào GridPane
        lawn.add(imageView, col, row, 1, 1);
    }
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
    public void attack(AnchorPane lawn) {
        // TODO: Xử lí tấn công
    }
}
