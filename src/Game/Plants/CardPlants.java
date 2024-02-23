package src.Game.Plants;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import src.Level.Level;

public class CardPlants {

    private String [] path = {"sunflower", "Peashooter", "walnut_full_life", "cherrybomb", "PotatoMine", "Chomper", "Repeater"}; // "/Assets/images/Plants/" + path + ".gif"
    // SnowPea, PuffShroom, SunShroom, FumeShroom
    private String [] pathCards = {"sunflowerCard", "peashooterCard", "wallnutCard", "cherrybombCard", "PotatoMineCard", "ChomperCard", "repeaterCard"}; // "/Assets/images/Cards/" + path + ".png"
    private int [] cost = {50, 100, 50, 150, 25, 150, 200}; // Giá của cây
    private int [] hp = {50, 100, 400, 150, 25, 150, 200}; // Máu của cây

    private double  x = 150; // Tọa độ x 36

    private double [] y = {90, 150, 210, 270, 330, 390, 450}; // Tọa độ y

    private void makeImage(AnchorPane root, int x, int y, String path) { // Hàm tạo hình ảnh
        // Tạo một hình ảnh từ một tệp hình ảnh trên đĩa
        Image image = new Image(path, 60, 60, false, false);
        // Tạo một ImageView để hiển thị hình ảnh
        ImageView imageView = new ImageView(image);
        imageView.setImage(image);
        // Đặt vị trí của ImageView trong AnchorPane
        imageView.setLayoutX(x);
        imageView.setLayoutY(y);
        imageView.setFitWidth(85);
        imageView.setFitHeight(50);

        // Thêm ImageView vào AnchorPane
        root.getChildren().add(imageView);
    }
    public void getCards(AnchorPane GamePlayRoot, int level) {
        for (int i = 0; i < level; i++) {
            makeImage(GamePlayRoot, (int)x, (int)y[i], "/Assets/images/Cards/" + pathCards[i] + ".png");
        }
    }
}
