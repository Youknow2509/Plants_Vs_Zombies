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

import java.io.Serial;
import java.io.Serializable;

public class HandleCardPlant implements Serializable {
    // SerialVersionUID
    @Serial
    private static final long serialVersionUID = 1L;
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
        cardPlant.setImage(new Image(cardPlant.getPath(), CardPlant.getWidth(), CardPlant.getHeight(), false, false));
        // Tạo một ImageView để hiển thị hình ảnh
        cardPlant.setImageView(new ImageView(cardPlant.getImage()));
        cardPlant.getImageView().setImage(cardPlant.getImage());
        // Đặt vị trí của ImageView trong AnchorPane
        cardPlant.getImageView().setLayoutX(cardPlant.getX());
        cardPlant.getImageView().setLayoutY(cardPlant.getY());
        cardPlant.getImageView().setFitWidth(CardPlant.getFitWidth());
        cardPlant.getImageView().setFitHeight(CardPlant.getFitHeight());
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
                cardPlant.setOpacity(0.1);
                GameMainController.setCardPlantClicked(cardPlant);
            } else if (GameMainController.getCardPlantClicked().getName() != imageView.getId()) {

                if (GameMainController.getCardPlantClicked().isHaveBuy()) {
                    GameMainController.getCardPlantClicked().setOpacity(1);
                } else {
                    GameMainController.getCardPlantClicked().setOpacity(0.6);
                }

                cardPlant.setOpacity(0.1);
                GameMainController.setCardPlantClicked(cardPlant);
            } else {

                if (GameMainController.getCardPlantClicked().isHaveBuy()) {
                    GameMainController.getCardPlantClicked().setOpacity(1);
                } else {
                    GameMainController.getCardPlantClicked().setOpacity(0.6);
                }

                GameMainController.setCardPlantClicked(null);
            }
        }
    }

    // CardPlant set time out buy
    public void setTimeOutBuyPlant(int time) {

        GameMainController.setCardPlantClicked(null);
        cardPlant.setHaveBuy(false);

        cardPlant.setOpacity(0);
        double opacityEnd = 0.6;

        double increment = (opacityEnd - cardPlant.getOpacity()) / time;

        // Hai biến được lưu kiểu mảng để sử dụng trong hàm xử lý sự kiện của Timeline và thay đổi giá trị của chúng được.
        double[] opacity = {cardPlant.getOpacity()};
        Timeline[] timeline = new Timeline[1];

        //
        timeline[0] = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            if (opacity[0] >= opacityEnd) {

                cardPlant.setHaveBuy(true);
                cardPlant.setTimeBuy(0);

                cardPlant.setOpacity(opacityEnd);

                timeline[0].stop();

                return;
            } else {
                opacity[0] += increment;
                cardPlant.setOpacity(opacity[0]);
            }
            cardPlant.setTimeBuy(cardPlant.getTimeBuy() - 1);
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
