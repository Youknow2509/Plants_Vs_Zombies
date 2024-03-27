package src.Model.Plant;

import javafx.scene.layout.GridPane;
import src.Controller.GameMainController;
import src.Model.GameElements;
import javafx.animation.Timeline;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import src.Model.Zombie.Zombie;

import java.util.List;

public class Plant extends GameElements {
    // Var
    private int row, col; // Lưu hàng và cột của phần tử trong GridPane
    private int health;
    private int dame;
    private int cost;
    private int speedAttack;
    private Timeline timelineAttack;
    private List<Zombie> listZombies;
    // Constructor
    public Plant(double x, double y, String path, int width, int height, int row, int col
            , List<Zombie> listZombies, int health, int dame, int speedAttack, int cost) {
        super(x, y, path, width, height, row);
        this.health = health;
        this.dame = dame;
        this.listZombies = listZombies;
        this.row = row;
        this.col = col;
        this.cost = cost;
        this.speedAttack = speedAttack;
    }
    // Bắt đầu Animation
    public void startAnimation() {
        if (timelineAttack != null) {
            timelineAttack.setCycleCount(Timeline.INDEFINITE);
            timelineAttack.play();
        }
    }
    // Stop Animation
    public void stopAnimation() {
        if (timelineAttack != null) {
            timelineAttack.stop();
        }
    }
    // Timeline tấn công
    private void timelineAttack() {
        // Todo xu li plant tan cong - Override từng loại plant
    }
    // Dung Timeline tan cong cua cay
    public void stopAttack() {
        if (timelineAttack != null) {
            timelineAttack.stop();
        }
    }
    // Tiep tuc Timeline tan cong cua cay
    public void resumeAttack() {
        if (timelineAttack != null) {
            timelineAttack.play();
        }
    }
    // Xoa anh cay tren GridPane
    public void removeImageViewInGridPane() {
        getImageView().setDisable(true);
        getImageView().setVisible(false);
        GameMainController.getGridPane().getChildren().remove(getImageView());
    }
    // Tao anh cay tren GridPane
    public void createImageViewInGridPane() {
        // Tạo một hình ảnh từ một tệp hình ảnh trên đĩa
        setImage(new Image(getPath(), getWidth(), getHeight(), false, false));
        // Tạo một ImageView để hiển thị hình ảnh
        setImageView(new ImageView(getImage()));
        (getImageView()).setImage(getImage());
        // Thêm hình ảnh vào GridPane
        GameMainController.getGridPane().add(getImageView(), col, row, 1, 1);
    }
    // Getter and setter
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDame() {
        return dame;
    }

    public void setDame(int dame) {
        this.dame = dame;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getSpeedAttack() {
        return speedAttack;
    }

    public void setSpeedAttack(int speedAttack) {
        this.speedAttack = speedAttack;
    }

    public Timeline getTimelineAttack() {
        return timelineAttack;
    }

    public void setTimelineAttack(Timeline timelineAttack) {
        this.timelineAttack = timelineAttack;
    }

    public List<Zombie> getListZombies() {
        return listZombies;
    }

    public void setListZombies(List<Zombie> listZombies) {
        this.listZombies = listZombies;
    }
}
