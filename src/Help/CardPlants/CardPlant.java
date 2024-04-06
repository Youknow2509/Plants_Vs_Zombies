package src.Help.CardPlants;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import src.Controller.GameMainController;
import src.Help.Shovel.Shovel;

public class CardPlant {
    // Var
    private final static int width = 105;
    private final static int height = 67;
    private final static int fitWidth = 85;
    private final static int fitHeight = 50;

    private double x, y;
    private String path;
    // Constructor
    public CardPlant() {
        super();
    }
    public CardPlant(double x, double y, String path) {
        super();
        this.x = x;
        this.y = y;
        this.path = path;
    }
    // Method
    public void createImage() {
        // Tạo một hình ảnh từ một tệp hình ảnh trên đĩa
        Image image = new Image( "/Assets/images/Cards/" + path + ".png", width, height, false, false);
        // Tạo một ImageView để hiển thị hình ảnh
        ImageView imageView = new ImageView(image);
        imageView.setImage(image);
        // Đặt vị trí của ImageView trong AnchorPane
        imageView.setLayoutX(x);
        imageView.setLayoutY(y);
        imageView.setFitWidth(fitWidth);
        imageView.setFitHeight(fitHeight);
        // Đặt id cho ImageView
        imageView.setId(path.toUpperCase());
        // Thêm sự kiện vào ImageView
        imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            setCardSelected(e);
        });
        // Thêm ImageView vào AnchorPane
        (GameMainController.getAnchorPane()).getChildren().add(imageView);
    }
    // Xử lí khi click vào thẻ cây
    public void setCardSelected(MouseEvent e) {
        Node source = (Node) e.getSource();
        ImageView select = (ImageView) source;

        Shovel.setIsDisabled(true);

        if (GameMainController.selectedImageView == null) {
            disableCard(select);
        }
        else if (GameMainController.selectedImageView != select) {
            GameMainController.selectedImageView.setOpacity(1);
            disableCard(select);
        } else {
            setCardUnSelected();
        }
    }
    private void disableCard(ImageView select) {
        select.setOpacity(0.2);
        GameMainController.selectedImageView = select;
        GameMainController.setPathImageViewSelected(select.getId());
    }
    public static void setCardUnSelected() {
        if (GameMainController.selectedImageView != null) {
            GameMainController.selectedImageView.setOpacity(1);
            GameMainController.selectedImageView = null;
        }
        GameMainController.setPathImageViewSelected("");
    }
    // To string

    @Override
    public String toString() {
        return "CardPlant{" +
                "x=" + x +
                ", y=" + y +
                ", path='" + path + '\'' +
                '}';
    }

    // Getter and Setter
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
