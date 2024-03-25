package src.Utils;

import javafx.scene.layout.AnchorPane;
import src.Controller.GameMainController;
import src.Model.GameElements;
import src.Model.Plant.Plant;
import javafx.scene.image.ImageView;

import java.awt.event.MouseEvent;
import java.util.List;

public class Shovel extends GameElements {
    // Variables
    private static final String path = "/Assets/images/items/Shovel.png"; // Đường dẫn ảnh xẻng
    private List<Plant> plants = null; // Danh sách các cây
    private boolean isDisabled = true; // Biến kiểm tra xem xẻng có bị vô hiệu hóa hay không: true là vô hiệu hoá
    // Constructor
    public Shovel(AnchorPane anchorPane, List<Plant> plants, ImageView imageView) {
        super(anchorPane, 500, 10, path, 60, 60, -1);
        setAnchorPane(anchorPane);
        this.plants = plants;
        setImageView(imageView);
    }
    // Lấy ra trạng thái xẻng
    public boolean getIsDisabled() {
        return isDisabled;
    }
    // Hàm xóa cây
    public void remotePlant(int x, int y) {
        // Xóa cây
        synchronized (plants) {
            for (int i = 0; i < plants.size(); i++) {
                Plant p = plants.get(i);
                if (p.getCol() == x && p.getRow() == y) {

                    p.removeImageViewInGridPane();
                    p.stopAttack();

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
        isDisabled = b;
    }
    // Trả về độ mờ khi click
    public double getOpacityBtn(){
        return isDisabled ? 1 : 0.6;
    }
    // Xử lí khi click
    public void handleClick() {

        CardPlants.setCardUnSelected();
        GameMainController.setImageViewClickBefore(getImageView()); // Lưu ImageView được chọn

        helpHandleClick();
    }
    // Hàm hỗ trợ khi click
    public void helpHandleClick() {
        setIsDisabled(
                !getIsDisabled()
        );
        (getImageView()).setOpacity(getOpacityBtn());
    }
}
