package src.Help.CardPlants;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import src.Controller.Game.GameMainController;
import src.Help.Shovel.Shovel;

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
        // Đặt opacity cho ImageView
        cardPlant.getImageView().setOpacity(cardPlant.getOpacity());
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

        Object object = GameMainController.getObjectClicked();

        if (!cardPlant.isLock() && cardPlant.isHaveBuy()) {
            if (object == null) {
                // Nếu chưa có thẻ nào được chọn
                cardPlant.setOpacity(0.1);
                GameMainController.setObjectClicked(cardPlant);
            } else if (object instanceof CardPlant c) {
                // Nếu đã có thẻ được chọn
                if (c.getName() == cardPlant.getName()) {
                    // Nếu thẻ được chọn là thẻ đang được chọn
                    cardPlant.setOpacity(1);
                    GameMainController.setObjectClicked(null);
                } else {
                    // Nếu thẻ được chọn là thẻ khác
                    c.setOpacity(1);
                    cardPlant.setOpacity(0.1);
                    GameMainController.setObjectClicked(cardPlant);
                }
            } else if (object instanceof Shovel) {
                // Nếu thẻ trc đó được chọn là xẻng

                ((Shovel) object).helpHandleClick();

                cardPlant.setOpacity(0.1);
                GameMainController.setObjectClicked(cardPlant);
                System.out.println(GameMainController.getObjectClicked());
            }
        }

    }

    // CardPlant set time out buy
    public void setTimeOutBuyPlant(int time) {

        GameMainController.setObjectClicked(null);
        cardPlant.setHaveBuy(false);

        double increment = (0.6 - cardPlant.getOpacity()) / time;

        // Hai biến được lưu kiểu mảng để sử dụng trong hàm xử lý sự kiện của Timeline và thay đổi giá trị của chúng được.
        double[] opacity = {cardPlant.getOpacity()};

        //
        cardPlant.setTimelineBuyPlant(new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            if (cardPlant.getTimeBuy() <= 0) {

                cardPlant.setHaveBuy(true);

                if (cardPlant.isLock()) {
                    cardPlant.setOpacity(0.6);
                } else {
                    cardPlant.setOpacity(1);
                }

                cardPlant.getTimelineBuyPlant().stop();
                cardPlant.setTimelineBuyPlant(null);

                return;
            } else {
                opacity[0] += increment;
                cardPlant.setOpacity(opacity[0]);
            }
            cardPlant.setTimeBuy(cardPlant.getTimeBuy() - 1);
        })));
        cardPlant.getTimelineBuyPlant().setCycleCount(Timeline.INDEFINITE);
        cardPlant.getTimelineBuyPlant().play();
    }

    // Getter - Setter
    public CardPlant getCardPlant() {
        return cardPlant;
    }

    public void setCardPlant(CardPlant cardPlant) {
        this.cardPlant = cardPlant;
    }
}
