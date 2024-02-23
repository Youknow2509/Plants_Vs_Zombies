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
    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }

    public void makeImage(AnchorPane root, int x, int y, String path, int width, int height) { // Hàm tạo hình ảnh

    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }
    public ImageView getImageView() {
        return this.imageView;
    }
}
