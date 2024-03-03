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
import src.Game.Shovel;
import src.Game.Plants.CardPlants;
import src.Game.Zombies.NormalZombie;
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
    // Lưu các biến
    public static List<Plant> plants = Collections.synchronizedList(new ArrayList<Plant>());
    public static List<Zombie> zombies = Collections.synchronizedList(new ArrayList<Zombie>());
    private Shovel shovel = new Shovel(); // Xẻng
    private CardPlants cardPlants = new CardPlants();
    public static ImageView selectedCardPlant = null;
    public static String path = "";
    @FXML
    public void initialize() {
        menu.setOnMouseClicked(e -> { // Xử lí tạm thời - "Hiện tại dùng để thoát "
            System.exit(0);
        });
        shovel.setImageView(btnShovel);
        btnShovel.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            shovel.handleClick();
        });
        initData(7);
        // Test TODO: Xóa sau khi test xong
        NormalZombie normalZombie = new NormalZombie(3);
        normalZombie.makeImage(GamePlayRoot);
        normalZombie.move();
        zombies.add(normalZombie);

    }
    // Ham xu ly khi click vao GridPane bãi cỏ
    public void initData(int level) {
        cardPlants.getCards(GamePlayRoot, level); //
    }

    public void getGridPosition(MouseEvent e) {
        Node source = (Node) e.getSource();
        // Lấy ra vị trí ô đang được click
        Integer x = lawnGrid.getColumnIndex(source);
        Integer y = lawnGrid.getRowIndex(source);

        if (!shovel.getIsDisabled()) { // Xử lí việc xoá cây
            shovel.rmPlant(lawnGrid, plants, x, y);
        }
        if (path != "") { // Kiểm tra xem đã chọn cây chưa
            if (x != null && y != null) {
                boolean flag = true;
                synchronized (plants) {
                    for (int i = 0; i < plants.size(); i++) {
                        if (plants.get(i).col == x && plants.get(i).row == y) {
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag) {
                    // Tạo một cây mới
                    Plant newPlant = Plant.getPlant(path, (int) (source.getLayoutX() + source.getParent().getLayoutX()), (int) (source.getLayoutY() + source.getParent().getLayoutY()), x, y);
                    newPlant.makeImage(lawnGrid, x, y);
                    plants.add(newPlant);
                    newPlant.attack(GamePlayRoot);
                    sunCount.setText(String.valueOf(Integer.parseInt(sunCount.getText()) - newPlant.getCost()));

                    selectedCardPlant.setOpacity(1);
                    path = "";
                }

            }
        }
    }

    // Hàm xử lí khi click vào Card Plant
    public void menuHandle(MouseEvent e) {
        System.out.println("Menu clicked");
    }
}

