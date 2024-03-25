package src.Utils;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import src.Controller.GameMainController;

import java.util.List;

public class CardPlants {
    // Variables
    
    // SnowPea, PuffShroom, SunShroom, FumeShroom
    // "/Assets/images/Cards/" + path + ".png"
    //private String [] pathCards = {"SunFlower", "Peashooter", "Wallnut", "CherryBomb", "PotatoMine", "Chomper", "Repeater"};
    private List<String> pathCards = null;
    private int [] cost = {50, 100, 50, 150, 25, 150, 200}; // Giá của cây
    private int width = 85; // Chiều rộng
    private int height = 50; // Chiều cao
    private double  x = 36; // Tọa độ x 36
    private double [] y = {90, 150, 210, 270, 330, 390, 450}; // Tọa độ y
    private AnchorPane anchorPane; // AnchorPane

    // Constructor
    public CardPlants(AnchorPane anchorPane, List<String> pathCards) {
        super();
        this.pathCards = pathCards;
        this.anchorPane = anchorPane;
    }

    // Tạo thẻ cây ứng với từng level game
    public void getCards() {
        for (int i = 0; i < pathCards.size(); i++) {
            creatImageCardPlant((int)x, (int)y[i], pathCards.get(i));
        }
    }
    // Hàm tạo hình ảnh thẻ cây và thêm sự kiện
    private void creatImageCardPlant(int x, int y, String path) {
        // Tạo một hình ảnh từ một tệp hình ảnh trên đĩa
        Image image = new Image( "/Assets/images/Cards/" + path + ".png", 105, 67, false, false);
        // Tạo một ImageView để hiển thị hình ảnh
        ImageView imageView = new ImageView(image);
        imageView.setImage(image);
        // Đặt vị trí của ImageView trong AnchorPane
        imageView.setLayoutX(x);
        imageView.setLayoutY(y);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        imageView.setId(path);
        // Thêm sự kiện vào ImageView
        imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            setCardSelected(e);
        });
        // Thêm ImageView vào AnchorPane
        anchorPane.getChildren().add(imageView);
    }

    // Xử lí khi click vào thẻ cây
    public void setCardSelected(MouseEvent e) {
        Node source = (Node) e.getSource();
        ImageView select = (ImageView) source;

        GameMainController.getShovel().setIsDisabled(true);

        if (GameMainController.getImageViewClickBefore() == null) {
            disableCard(select);
        }
        else if (GameMainController.getImageViewClickBefore() != select) {
            GameMainController.getImageViewClickBefore().setOpacity(1);
            disableCard(select);
        } else {
            setCardUnSelected();
        }
    }
    // Làm mờ ảnh và thêm sự kiện khi click
    private void disableCard(ImageView select) {
        select.setOpacity(0.2);
        GameMainController.setImageViewClickBefore(select);
        GameMainController.setPath(select.getId());
    }
    // Hàm xử lí thẻ cây khi không được chọn
    public static void setCardUnSelected() {
        if (GameMainController.getImageViewClickBefore() != null) {
            GameMainController.getImageViewClickBefore().setOpacity(1);
            GameMainController.setImageViewClickBefore(null);
        }
        GameMainController.setPath("");
    }
}
