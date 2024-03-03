package src.Game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
public abstract class GameElements {

    protected double x, y;
    protected Image image;
    protected ImageView imageView;
    protected int width, height;
    protected String path;

    public GameElements(double x, double y, String path, int width, int height) {
        this.x = x;
        this.y = y;
        this.path = path;
        this.width = width;
        this.height = height;
    }
    public GameElements() {
        this.x = 0;
        this.y = 0;
        this.path = "";
        this.width = 0;
        this.height = 0;
    }
    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }

    public void makeImage(AnchorPane root) { // Hàm tạo hình ảnh
        this.image = new Image(path, width, height, false, false);
        this.imageView = new ImageView(this.image);
        this.imageView.setX(x);
        this.imageView.setY(y);
        root.getChildren().add(this.imageView);
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }
    public ImageView getImageView() {
        return this.imageView;
    }
}
