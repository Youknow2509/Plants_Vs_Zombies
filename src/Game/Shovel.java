package src.Game;


// Lớp trừu tượng Xẻng
public  class Shovel extends GameElements {

    protected boolean isDisabled = true; // Biến kiểm tra xem xẻng có bị vô hiệu hóa hay không

    // Constructor
    public Shovel() { super(500, 10, "/Assets/images/items/Shovel.png", 60, 60);}
    public boolean getIsDisabled() { return isDisabled;}
}
