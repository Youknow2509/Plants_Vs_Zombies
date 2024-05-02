package src.Help.CardPlants;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import src.Controller.Game.GameMainController;

import java.io.Serializable;

public class HandleCardPlant implements Serializable {
    // Var
    private CardPlant cardPlant;

    // Constructor
    public HandleCardPlant() {
        super();
    }
    public HandleCardPlant(CardPlant cardPlant) {
        super();
        this.cardPlant = cardPlant;
    }

    // Creat ImageView for CardPlant
    public void creatImageView() {
        if (cardPlant == null || cardPlant.getImage() != null || cardPlant.getImageView() != null
        || (GameMainController.getAnchorPane()).getChildren().contains(cardPlant.getImageView())) {
            return;
        }

        cardPlant.setHaveBuy(true);

        // Tạo một hình ảnh từ một tệp hình ảnh trên đĩa
        cardPlant.setImage(new Image(cardPlant.getPath(), cardPlant.getWidth(), cardPlant.getHeight(), false, false));
        // Tạo một ImageView để hiển thị hình ảnh
        cardPlant.setImageView( new ImageView(cardPlant.getImage())) ;
        cardPlant.getImageView().setImage(cardPlant.getImage());
        // Đặt vị trí của ImageView trong AnchorPane
        cardPlant.getImageView().setLayoutX(cardPlant.getX());
        cardPlant.getImageView().setLayoutY(cardPlant.getY());
        cardPlant.getImageView().setFitWidth(cardPlant.getFitWidth());
        cardPlant.getImageView().setFitHeight(cardPlant.getFitHeight());
        // Đặt id cho ImageView
        cardPlant.getImageView().setId(cardPlant.getName());
        // Thêm sự kiện vào ImageView
        cardPlant.getImageView().addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            HandleEventClickToCard(e);
        });
        // Thêm ImageView vào AnchorPane
        (GameMainController.getAnchorPane()).getChildren().add(cardPlant.getImageView());
    }

    // Xu li su kien khi click vao card
    private void HandleEventClickToCard(MouseEvent e) {
        Node source = (Node) e.getSource();
        ImageView imageView = (ImageView) source;
        if (cardPlant.isHaveBuy()) {
            if (GameMainController.getCardPlantClicked() == null) {
                imageView.setOpacity(0.2);
                GameMainController.setCardPlantClicked(cardPlant);
            } else if (GameMainController.getCardPlantClicked().getName() != imageView.getId()) {
                GameMainController.getCardPlantClicked().getImageView().setOpacity(1);
                imageView.setOpacity(0.2);
                GameMainController.setCardPlantClicked(cardPlant);
            } else {
                imageView.setOpacity(1);
                GameMainController.setCardPlantClicked(null);
            }
        }
    }

    // CardPlant set time out buy
    public void setTimeOutBuyPlant(int time) {

        cardPlant.setHaveBuy(false);
        GameMainController.setCardPlantClicked(null);
        double increment = 0.8 / time;

        double [] opacity = {0.2};
        Timeline [] timeline = new Timeline[1];
        // Hai biến được lưu kiểu mảng để sử dụng trong hàm xử lý sự kiện của Timeline và thay đổi giá trị của chúng được.
        timeline[0] = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            if (opacity[0] >= 1) {
                cardPlant.setHaveBuy(true);
                cardPlant.getImageView().setOpacity(1);
                timeline[0].stop();
            } else {
                cardPlant.getImageView().setOpacity(opacity[0]);
                opacity[0] += increment;
            }
        }));
        timeline[0].setCycleCount(Timeline.INDEFINITE);
        timeline[0].play();
    }

    // Getter - Setter
    public CardPlant getCardPlant() {
        return cardPlant;
    }

    public void setCardPlant(CardPlant cardPlant) {
        this.cardPlant = cardPlant;
    }
}
