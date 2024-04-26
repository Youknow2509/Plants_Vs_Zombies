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

    // Methods

    // Creat ImageView for CardPlant
    public void creatImageView() {
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
        Thread [] threads = new Thread[1];
        threads[0] = new Thread(() -> {
            Platform.runLater(() -> {
                Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
                    if (opacity[0] >= 1) {
                        cardPlant.setHaveBuy(true);
                        threads[0].stop();
                    } else {
                        cardPlant.getImageView().setOpacity(opacity[0]);
                        opacity[0] += increment;
                    }
                }));
                timeline.setCycleCount(Timeline.INDEFINITE);
                timeline.play();
            });
        });
        threads[0].start();
    }

    // Getter - Setter
    public CardPlant getCardPlant() {
        return cardPlant;
    }

    public void setCardPlant(CardPlant cardPlant) {
        this.cardPlant = cardPlant;
    }
}
