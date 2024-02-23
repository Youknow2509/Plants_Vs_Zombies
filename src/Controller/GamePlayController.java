package src.Controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import java.util.ArrayList;

import src.Game.Plants.Plant;
import src.Game.Plants.*;
import src.Game.Zombies.Zombie;
import src.Game.Zombies.*;
import src.Game.Shovel;
import src.Game.Plants.CardPlants;

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
    private String path = "";
    private ArrayList<Plant> plants = new ArrayList<Plant>();
    // private ArrayList<Zombie> zombie = new ArrayList<Zombie>();
    private Shovel shovel = new Shovel(); // Xẻng
    private CardPlants cardPlants = new CardPlants();

    private ImageView selectedCardPlant = null;
    @FXML
    public void initialize() {
        System.out.println("Main Controller Initialized");
        System.out.println("GridPane: " + lawnGrid);
        menu.setOnMouseClicked(e -> { // Xử lí tạm thời - "Hiện tại dùng để thoát "
            System.out.println("Quit Game");
            System.exit(0);
        });
        btnShovel.setOnMouseClicked(e -> { // Xử lí khi bấm vào xẻng
            shovel.setIsDisabled(
                    !shovel.getIsDisabled()
            );
            btnShovel.setOpacity(shovel.getOpacityBtn());
            if (!shovel.getIsDisabled()) {
                System.out.println("Dang thuc hien xoa cay");
            }
        });
        shovel.setImageView(btnShovel);
        initData(3);
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

        System.out.println("Click col" + x + " row" + y);

        if (!shovel.getIsDisabled()) { // Xử lí việc xoá cây
            System.out.println("Thuc hien xoa");
            shovel.rmPlant(lawnGrid, plants, x, y);
        }
        if (path != "" ) { // Kiểm tra xem đã chọn cây chưa
            if (x != null && y != null) {
                boolean flag = true;
                for (int i = 0; i < plants.size(); i++) {
                    if (plants.get(i).col == x && plants.get(i).row == y) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    // Tạo một cây mới
                    Plant newPlant = new PeaShooter((int)(source.getLayoutX()), (int)(source.getLayoutY()), x, y);
                    plants.add(newPlant);
                    // Tạo một hình ảnh từ một tệp hình ảnh trên đĩa
                    newPlant.makeImage(lawnGrid, x, y, path);
                    sunCount.setText(String.valueOf(Integer.parseInt(sunCount.getText()) - newPlant.getCost()));
                    System.out.println("Add plant location col: " + String.valueOf(x) + ", row: " + String.valueOf(y));

                    selectedCardPlant.setOpacity(1);
                    path = "";
                }
            }
        }


    }

    // Hàm xử lí khi click vào Card Plant
    public void setCardSelected(MouseEvent e) {
        Node source = (Node) e.getSource();
        ImageView select = (ImageView) source;
        // Nếu chưa đc chọn hoặc

        // System.out.println("Click card id: " + selectedCardPlant.getId());
        // path ="/Assets/images/Plants/" + selectedCardPlant.getId() + ".gif";
        // System.out.println("Path: " + path);
        if (selectedCardPlant == null) {
            select.setOpacity(0.2);
            selectedCardPlant = select;
            path = "/Assets/images/Plants/" + select.getId() + ".gif";
        }
        else if (selectedCardPlant != select) {
            selectedCardPlant.setOpacity(1);
            select.setOpacity(0.2);
            selectedCardPlant = select;
            path = "/Assets/images/Plants/" + select.getId() + ".gif";
        } else {
            select.setOpacity(1);
            selectedCardPlant = null;
            path = "";
        }
    }

    public void menuHandle(MouseEvent e) {
        System.out.println("Menu clicked");
    }
}
