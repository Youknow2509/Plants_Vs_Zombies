package src.Game.Plants;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import src.Game.GameElements;

// Lớp trừu tượng cây
public abstract class Plant extends GameElements{

    public int col, row;
    protected int hp;
    protected int cost;

    // Constructor
    public Plant(int x, int y, String path, int hp, int width, int height, int col, int row, int cost) {
        super(x, y, path, width, height);
        this.hp = hp;
        this.col = col;
        this.row = row;
        this.cost = cost;
    }

    public int getCost() { return this.cost;}

    public void makeImage(GridPane lawn, int col, int row, String path) {
        // Tạo một hình ảnh từ một tệp hình ảnh trên đĩa
        Image image = new Image(path, 60, 60, false, false);
        // Tạo một ImageView để hiển thị hình ảnh
        ImageView imageView = new ImageView(image);
        imageView.setImage(image);
        // Thêm hình ảnh vào GridPane
        lawn.add(imageView, col, row, 1, 1);
    }
}
