package src.Utils;


import src.Controller.GameMainController;
import src.Model.GameElements;
import src.Utils.CardPlants;
import src.Model.Plants.Plant;

import java.util.List;

// Lớp trừu tượng Xẻng
public class Shovel extends GameElements {

    private static boolean isDisabled = true; // Biến kiểm tra xem xẻng có bị vô hiệu hóa hay không: true là vô hiệu hoá
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
                    p.removeImageViewInGridPane();
                    p.getTimelineAttack().stop();
                    plants.remove(p);
                    setIsDisabled(!getIsDisabled());
                    (getImageView()).setOpacity(getOpacityBtn());
                    break;
                }
            }
        }
    }
    // Xét trạng thái xẻng
    public static void setIsDisabled(boolean b) {
        isDisabled = b;
    }
    // Trả về độ mờ khi click
    public double getOpacityBtn(){
        return isDisabled ? 1 : 0.6;
    }
    // Xử lí khi click
    public void handleClick() {

        CardPlants.setCardUnSelected();
        GameMainController.selectedImageView = getImageView(); // Lưu ImageView được chọn

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
