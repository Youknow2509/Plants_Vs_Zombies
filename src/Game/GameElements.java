package src.Game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
public abstract class GameElements {

    protected double x, y;
    protected Image image;
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

    public void makeImage(Pane pane, int x, int y, String path, int width, int height) { // Hàm tạo hình ảnh
        // Tạo một hình ảnh từ một tệp hình ảnh trên đĩa
        Image image = new Image(path, (double) width, (double) height, false, false);
        // Tạo một ImageView để hiển thị hình ảnh
        ImageView imageView = new ImageView(image);
        imageView.setImage(image);
        imageView.setX(x);
        imageView.setY(y);
        pane.getChildren().add(imageView);
    }
}
