package src.Game;


import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import src.Game.Plants.Plant;

import java.util.ArrayList;

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
    // Hàm xóa hình ảnh của cây
    public void rmImageView(GridPane lawn, Plant plant) {
        plant.imageView.setDisable(true);
        plant.imageView.setVisible(false);
        lawn.getChildren().remove(imageView);
    }
    // Hàm xóa cây
    public void rmPlant(GridPane lawn, ArrayList<Plant> plants, int x, int y) {
        // Xóa cây
        for (int i = 0; i < plants.size(); i++) {
            if (plants.get(i).col == x && plants.get(i).row == y) {
                rmImageView(lawn, plants.get(i));
                plants.remove(i);

                setIsDisabled(!getIsDisabled());
                imageView.setOpacity(getOpacityBtn());
                break;
            }
        }
        System.out.println("Da xoa cay vi tri cot: " + x + ", hang: " + y);
    }
    public void setIsDisabled(boolean b) {
        this.isDisabled = b;
    }
    public double getOpacityBtn(){
        return isDisabled ? 1 : 0.6;
    }
}
