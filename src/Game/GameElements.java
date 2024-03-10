package src.Game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import src.Controller.GamePlayController;

public abstract class GameElements {

    private double x, y; // Lưu toạ độ phần tử
    private Image image; // Lưu hình ảnh
    private ImageView imageView; // Lưu ImageView
    private int width, height; //  chiều rộng và chiều cao phần tử
    private String path; // Đường dẫn ảnh
    private int lane; // Lane của phần tử (dùng cho zombie, plant, và sun khi sinh ra từ cây)

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
    // Tạo ảnh cho phần tử vào AnchorPane
    public void makeImage() { // Hàm tạo hình ảnh
        this.image = new Image(path, width, height, false, false);
        this.imageView = new ImageView(this.image);
        this.imageView.setX(x);
        this.imageView.setY(y);
        (GamePlayController.getRoot()).getChildren().add(this.imageView);
    }
    // Xóa ảnh của phần tử khỏi AnchorPane
    public void rmImage() {
        imageView.setDisable(true);
        imageView.setVisible(false);
        (GamePlayController.getRoot()).getChildren().remove(this.imageView);
    }
    // Set và get các thuộc tính
    public void setPath(String path) {
        this.path = path;
    }
    public String getPath() {
        return this.path;
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
