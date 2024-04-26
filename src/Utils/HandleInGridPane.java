package src.Utils;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import src.Controller.Game.GameMainController;
import src.Model.Plants.Plant;

import java.io.Serializable;

public class HandleInGridPane implements Serializable {
    // Var
    private Plant p;

    // Constructor
    public HandleInGridPane() {
        super();
        p = new Plant();
    }
    public HandleInGridPane(Plant p) {
        super();
        this.p = p;
    }
    // Method
    public void createImageViewInGridPane() {
        // Tạo một hình ảnh từ một tệp hình ảnh trên đĩa
        Image image = new Image(p.getPath(), p.getWidth(), p.getHeight(), false, false);
        // Tạo một ImageView để hiển thị hình ảnh
        p.setImageView(new ImageView(image));
        (p.getImageView()).setImage(image);
        // Thêm hình ảnh vào NodeGridPane
        (GameMainController.getGridPane()).add(p.getImageView(), p.getCol(), p.getRow(), 1, 1);
    }

    // Xoa anh cay tren NodeGridPane
    public void removeImageViewInGridPane() {
        p.getImageView().setDisable(true);
        p.getImageView().setVisible(false);
        if (p.getTimeline() != null) {
            p.getTimeline().stop();
        }
        GameMainController.getGridPane().getChildren().remove(p.getImageView());
    }
}
