package src.Game;


import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import src.Controller.GamePlayController;
import src.Game.Plants.Plant;

import java.util.ArrayList;
import java.util.List;

// Lớp trừu tượng Xẻng
public class Shovel extends GameElements {

    protected boolean isDisabled = true; // Biến kiểm tra xem xẻng có bị vô hiệu hóa hay không
    // Constructor
    public Shovel() {
        super(500, 10, "/Assets/images/items/Shovel.png", 60, 60, -1);
    }
    // Lấy ra trạng thái xẻng
    public boolean getIsDisabled() {
        return isDisabled;
    }
    // Hàm xóa cây
    public void rmPlant(List<Plant> plants, int x, int y) {
        // Xóa cây
        synchronized (plants) {
            for (int i = 0; i < plants.size(); i++) {
                Plant p = plants.get(i);
                if (p.getCol() == x && p.getRow() == y) {
                    p.rmImage();
                    p.rmTlDame();
                    plants.remove(p);
                    setIsDisabled(!getIsDisabled());
                    (getImageView()).setOpacity(getOpacityBtn());
                    break;
                }
            }
        }
    }
    // Xét trạng thái xẻng
    public void setIsDisabled(boolean b) {
        this.isDisabled = b;
    }
    // Trả về độ mờ khi click
    public double getOpacityBtn(){
        return isDisabled ? 1 : 0.6;
    }
    // Xử lí khi click
    public void handleClick() {

        GamePlayController.selectedImageView.setOpacity(1); // Đặt lại độ mờ của ImageView trước đó
        GamePlayController.selectedImageView = getImageView(); // Lưu ImageView được chọn

        setIsDisabled(
                !getIsDisabled()
        );
        (getImageView()).setOpacity(getOpacityBtn());
    }
}
