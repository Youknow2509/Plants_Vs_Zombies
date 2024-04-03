package src.Utils;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import src.Controller.GameMainControllerSave;
import src.Help.Shovel;

public class CardPlants {

    // SnowPea, PuffShroom, SunShroom, FumeShroom
    private String [] pathCards = {"SunFlower", "Peashooter", "Wallnut", "CherryBomb", "PotatoMine", "Chomper", "Repeater"}; // "/Assets/images/Cards/" + path + ".png"
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
        //
        imageView.setId(path.toUpperCase());
        // Thêm sự kiện vào ImageView
        imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            setCardSelected(e);
        });
        // Thêm ImageView vào AnchorPane
        (GameMainControllerSave.getAnchorPane()).getChildren().add(imageView);
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

        Shovel.setIsDisabled(true);

        if (GameMainControllerSave.selectedImageView == null) {
            disableCard(select);
        }
        else if (GameMainControllerSave.selectedImageView != select) {
            GameMainControllerSave.selectedImageView.setOpacity(1);
            disableCard(select);
        } else {
            setCardUnSelected();
        }
    }
    // Làm mờ ảnh và thêm sự kiện khi click
    private void disableCard(ImageView select) {
        select.setOpacity(0.2);
        GameMainControllerSave.selectedImageView = select;
        GameMainControllerSave.setPathImageViewSelected("select.getId()");
    }
    // Hàm xử lí thẻ cây khi không được chọn
    public static void setCardUnSelected() {
        if (GameMainControllerSave.selectedImageView != null) {
            GameMainControllerSave.selectedImageView.setOpacity(1);
            GameMainControllerSave.selectedImageView = null;
        }
        GameMainControllerSave.setPathImageViewSelected("");
    }
}
