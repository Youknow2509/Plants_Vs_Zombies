package src.Model;

import javafx.scene.layout.AnchorPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class GameElements {
    // Var
    private double x, y; // Lưu toạ độ phần tử
    private Image image; // Lưu hình ảnh
    private ImageView imageView; // Lưu ImageView
    private int width, height; //  chiều rộng và chiều cao phần tử
    private String path; // Đường dẫn ảnh
    private int lane; // Lane của phần tử
    private AnchorPane root; // Root của game - Để thêm, sửa xoá, chỉnh hình ảnh phần tử
    // Constructor
    public GameElements() {
        super();
        this.x = 0;
        this.y = 0;
        this.path = "";
        this.width = 0;
        this.height = 0;
    }
    public GameElements(AnchorPane root, double x, double y, String path, int width, int height, int lane) {
        super();
        this.x = x;
        this.y = y;
        this.path = path;
        this.width = width;
        this.height = height;
        this.lane = lane;
        this.root = root;
    }
    // Tạo hình ảnh
    public void createImageView() {
        this.image = new Image(path, width, height, false, false);
        this.imageView = new ImageView(this.image);
        this.imageView.setX(x);
        this.imageView.setY(y);
        root.getChildren().add(this.imageView);
    }
    // Xoá hình ảnh
    public void removeImageView() {
        imageView.setDisable(true);
        imageView.setVisible(false);
        root.getChildren().remove(this.imageView);
    }
    // Getter and setter
    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public Image getImage() {
        return image;
    }
    public void setImage(Image image) {
        this.image = image;
    }
    public ImageView getImageView() {
        return imageView;
    }
    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
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
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public int getLane() {
        return lane;
    }
    public void setLane(int lane) {
        this.lane = lane;
    }
    public AnchorPane getAnchorPane() {
        return root;
    }
    public void setAnchorPane(AnchorPane root) {
        this.root = root;
    }
}
