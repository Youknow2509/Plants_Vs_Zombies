package src.Game;


import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import src.Game.Plants.Plant;

import java.util.ArrayList;
import java.util.List;

// Lớp trừu tượng Xẻng
public class Shovel extends GameElements {

    protected boolean isDisabled = true; // Biến kiểm tra xem xẻng có bị vô hiệu hóa hay không
    // Constructor
    public Shovel() {
        super(500, 10, "/Assets/images/items/Shovel.png", 60, 60);
    }
    public boolean getIsDisabled() {
        return isDisabled;
    }
    // Hàm xóa cây
    public void rmPlant(GridPane lawn, List<Plant> plants, int x, int y) {
        // Xóa cây
        synchronized (plants) {
            for (int i = 0; i < plants.size(); i++) {
                if (plants.get(i).col == x && plants.get(i).row == y) {

                    plants.get(i).removeImage((AnchorPane) lawn.getParent());
                    plants.remove(i);

                    setIsDisabled(!getIsDisabled());
                    imageView.setOpacity(getOpacityBtn());
                    break;
                }
            }
        }
    }
    public void setIsDisabled(boolean b) {
        this.isDisabled = b;
    }
    public double getOpacityBtn(){
        return isDisabled ? 1 : 0.6;
    }


    public void handleClick() {
        setIsDisabled(
                !getIsDisabled()
        );
        imageView.setOpacity(getOpacityBtn());
    }
}
