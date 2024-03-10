package src.Game.Plants;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import src.Controller.GamePlayController;
import src.Level.Level;

public class CardPlants {

    // SnowPea, PuffShroom, SunShroom, FumeShroom
    private String [] pathCards = {"SunFlower", "Peashooter", "Wallnut", "CherryBomb", "PotatoMine", "Chomper", "Repeater"}; // "/Assets/images/Cards/" + path + ".png"
    private int [] cost = {50, 100, 50, 150, 25, 150, 200}; // Giá của cây
    private int [] hp = {50, 100, 400, 150, 25, 150, 200}; // Máu của cây
    private double  x = 36; // Tọa độ x 36
    private double [] y = {90, 150, 210, 270, 330, 390, 450}; // Tọa độ y
    // Hàm tạo hình ảnh thẻ cây và thêm sự kiện
    private void makeImage(int x, int y, String path) {
        // Tạo một hình ảnh từ một tệp hình ảnh trên đĩa
        Image image = new Image( "/Assets/images/Cards/" + path + ".png", 105, 67, false, false);
        // Tạo một ImageView để hiển thị hình ảnh
        ImageView imageView = new ImageView(image);
        imageView.setImage(image);
        // Đặt vị trí của ImageView trong AnchorPane
        imageView.setLayoutX(x);
        imageView.setLayoutY(y);
        imageView.setFitWidth(85);
        imageView.setFitHeight(50);
        imageView.setId(path);
        // Thêm sự kiện vào ImageView
        imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            setCardSelected(e);
        });
        // Thêm ImageView vào AnchorPane
        (GamePlayController.getRoot()).getChildren().add(imageView);
    }
    // Tạo thẻ cây ứng với từng level game
    public void getCards(int level) {
        for (int i = 0; i < level; i++) {
            makeImage((int)x, (int)y[i], pathCards[i]);
        }
    }
    // Xử lí khi click vào thẻ cây
    public void setCardSelected(MouseEvent e) {
        Node source = (Node) e.getSource();
        ImageView select = (ImageView) source;
        if (GamePlayController.selectedImageView == null) {
            select.setOpacity(0.2);
            GamePlayController.selectedImageView = select;
            GamePlayController.path =  select.getId();
        }
        else if (GamePlayController.selectedImageView != select) {
            GamePlayController.selectedImageView.setOpacity(1);
            select.setOpacity(0.2);
            GamePlayController.selectedImageView = select;
            GamePlayController.path = select.getId();
        } else {
            select.setOpacity(1);
            GamePlayController.selectedImageView = null;
            GamePlayController.path = "";
        }
    }
}
