package src.Controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import src.Game.Plants.Plant;
import src.Game.Plants.Sun;
import src.Game.Shovel;
import src.Game.Plants.CardPlants;
import src.Game.Zombies.Conehead;
import src.Game.Zombies.Normal;
import src.Game.Zombies.Zombie;

public class GamePlayController {

    @FXML
    private AnchorPane GamePlayRoot;
    @FXML
    private GridPane lawnGrid; // GridPane bãi cỏ
    @FXML
    private ImageView menu;
    @FXML
    private ImageView btnShovel;
    @FXML
    private Label sunCount;
    private static AnchorPane root = null;
    // Lưu các biến
    public static List<Plant> plants = Collections.synchronizedList(new ArrayList<Plant>()); // Danh sách các cây tồn tại
    public static List<Zombie> zombies = Collections.synchronizedList(new ArrayList<Zombie>());// Danh sách các zombie tồn tại
    private static int sun = 50; // Giá trị số mặt trời
    private static Label sunDisplay; // Gắn với label hiển thị số mặt trời - để  static để có thể truy cập từ class khác
    private Shovel shovel = new Shovel(); // Xẻng
    private CardPlants cardPlants = new CardPlants(); // Danh sách thẻ các loại cây
    public static ImageView selectedImageView = null; // ImageView được chọn trước đó bao gồm Thẻ cây và thẻ xẻng
    public static String path = ""; // Đường dẫn ảnh của cây được chọn

    // Khởi tạo game
    @FXML
    public void initialize() {

        menu.setOnMouseClicked(e -> { //TODO Xử lí tạm thời - "Hiện tại dùng để thoát "
            System.exit(0);
        });
        // Tạo xẻng và gắn sự kiện cho xẻng
        shovel.setImageView(btnShovel);
        btnShovel.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            shovel.handleClick();
        });
        // Gán các giá trị về tĩnh để có thể truy cập từ class khác
        root = GamePlayRoot;
        sunDisplay = sunCount;

        initData(3);

        // Test TODO: Xóa sau khi test xong
        Normal normalZombie = new Normal(3);
        normalZombie.makeImage();
        normalZombie.move();
        zombies.add(normalZombie);
    }
    public void initData(int level) {
        cardPlants.getCards(level); // Khởi tạo thẻ cây
    }
    // Hàm xử lí khi click vào ô cỏ
    public void getGridPosition(MouseEvent e) {
        Node source = (Node) e.getSource();
        // Lấy ra vị trí ô đang được click
        Integer x = lawnGrid.getColumnIndex(source);
        Integer y = lawnGrid.getRowIndex(source);

        if (!shovel.getIsDisabled()) { // Xử lí việc xoá cây
            shovel.rmPlant(plants, x, y);
        }
        else if (path != "") { // Xử lí việc tạo cây
            if (x != null && y != null) {
                boolean flag = true;
                synchronized (plants) {
                    for (int i = 0; i < plants.size(); i++) {
                        if ((plants.get(i)).getCol() == x && (plants.get(i)).getRow() == y) {
                            flag = false;
                            break;
                        }
                    }
                }
                // Tạo một cây mới thêm vào game
                if (flag) {
                    Plant newPlant = Plant.getPlant(path, (int) (source.getLayoutX() + source.getParent().getLayoutX()), (int) (source.getLayoutY() + source.getParent().getLayoutY()), x, y);
                    newPlant.makeImage(lawnGrid, x, y);
                    plants.add(newPlant);
                    newPlant.attack();

                    setSun(sun - newPlant.getCost());

                    CardPlants.setCardUnSelected();
                }
            }
        }
    }
    // Hàm xử lí khi click vào menu
    public void menuHandle(MouseEvent e) {
        // TODO tạo  menu cho một game
        System.out.println("Menu clicked");
    }
    // Get và set các biến
    public static int getSun() {
        return sun;
    }
    public static void setSun(int sun) {
        GamePlayController.sun = sun;
        sunDisplay.setText(String.valueOf(sun));
    }
    public static AnchorPane getRoot() {
        return root;
    }
    public static void setRoot(AnchorPane root) {
        GamePlayController.root = root;
    }
}

