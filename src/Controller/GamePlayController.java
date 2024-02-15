package src.Controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import java.util.ArrayList;

import src.Game.Plants.Plant;
import src.Game.Plants.*;
import src.Game.Zombies.Zombie;
import src.Game.Zombies.*;
import src.Game.Shovel;

public class GamePlayController {

    @FXML
    private GridPane lawnGrid; // GridPane bãi cỏ
    @FXML
    private ImageView menu;
    @FXML
    private Label sunCount;

    // Lưu các biến
    private String path = "";
    private ArrayList<Plant> plant = new ArrayList<Plant>();
    // private ArrayList<Zombie> zombie = new ArrayList<Zombie>();
    private Shovel shovel; // Xẻng

    private ImageView selectedCardPlant = null;
    @FXML
    public void initialize() {
        System.out.println("Main Controller Initialized");
        System.out.println("GridPane: " + lawnGrid);
        menu.setOnMouseClicked(e -> {
            System.out.println("Quit Game");
            System.exit(0);
        });
    }
    // Ham xu ly khi click vao GridPane bãi cỏ
    public void getGridPosition(MouseEvent e) {
        Node source = (Node) e.getSource();
        // Lấy ra vị trí ô đang được click
        Integer x = lawnGrid.getColumnIndex(source);
        Integer y = lawnGrid.getRowIndex(source);
        if (true || !shovel.getIsDisabled()) { // Loaddind ....
            // Xử lí việc xoá cây
        }
        if (path != "" ) { // Kiểm tra xem đã chọn cây chưa
            if (x != null && y != null) {
                boolean flag = true;
                for (int i = 0; i < plant.size(); i++) {
                    if (plant.get(i).col == x && plant.get(i).row == y) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {

                    // Loadding ... hiển thị thì là đúng nhưng bên trong đang chỉ chỉ peashooter

                    // Tạo một cây mới
                    Plant newPlant = new PeaShooter((int)(source.getLayoutX()), (int)(source.getLayoutY()), x, y);
                    plant.add(newPlant);
                    // Tạo một hình ảnh từ một tệp hình ảnh trên đĩa
                    makeImage(lawnGrid, x, y, path);
                    sunCount.setText(String.valueOf(Integer.parseInt(sunCount.getText()) - newPlant.getCost()));
                    System.out.println("Add plant location col: " + String.valueOf(x) + ", row: " + String.valueOf(y));
                }
            }
        }


    }
    // Hàm tạo một hình ảnh trong GridPane
    public void makeImage(GridPane lawn, int col, int row, String path) {
        // Tạo một hình ảnh từ một tệp hình ảnh trên đĩa
        Image image = new Image(path, 60, 60, false, false);
        // Tạo một ImageView để hiển thị hình ảnh
        ImageView imageView = new ImageView(image);
        imageView.setImage(image);
        // Thêm hình ảnh vào GridPane
        lawn.add(imageView, col, row, 1, 1);
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
