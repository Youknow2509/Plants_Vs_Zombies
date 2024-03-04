package src.Game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
public abstract class GameElements {

    private double x, y;
    private Image image;
    private ImageView imageView;
    private int width, height;
    private String path;
    private int lane;

    public GameElements(double x, double y, String path, int width, int height, int lane) {
        this.x = x;
        this.y = y;
        this.path = path;
        this.width = width;
        this.height = height;
        this.lane = lane;
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
    public void rmImage(AnchorPane root) {
        imageView.setDisable(true);
        imageView.setVisible(false);
        root.getChildren().remove(this.imageView);
    }
    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }
    public ImageView getImageView() {
        return this.imageView;
    }
    public double getX() {
        return this.x;
    }
    public void setX(double x) {
        this.x = x;
        imageView.setX(x);
    }
    public double getY() {
        return this.y;
    }
    public void setY(double y) {
        this.y = y;
        imageView.setY(y);
    }

    public Image getImage() {
        return image;
    }
    public void setImage(Image image) {
        this.image = image;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLane() {
        return lane;
    }

    public void setLane(int lane) {
        this.lane = lane;
    }
}
