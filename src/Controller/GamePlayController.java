package src.Controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.util.Duration;
import src.Config;
import src.Game.Plants.Plant;
import src.Game.Plants.Sun.DropSun;
import src.Game.Shovel;
import src.Game.Plants.CardPlants;
import src.Game.Zombies.Normal;
import src.Game.Zombies.Zombie;
import src.Level.Level;
import src.Level.ZombieSpawner;

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
    public static List<Plant> plants = Config.getListPlants(); // Danh sách các cây tồn tại
    public static List<Zombie> zombies = Config.getListZombies();// Danh sách các zombie tồn tại
    public static List<ZombieSpawner> zombieSpawners = Config.getListZombieSpawner(); // Danh sách các zombie spawner
    private Level level = Config.getLevel(); // Level
    private Timeline TimelineGame; // Timeline của game
    private static int sun = 50; // Giá trị số mặt trời
    private static Label sunDisplay; // Gắn với label hiển thị số mặt trời - để  static để có thể truy cập từ class khác
    private Shovel shovel = Config.getShovel(); // Xẻng
    private CardPlants cardPlants = Config.getCardPlants(); // Danh sách thẻ các loại cây
    private DropSun dropSun = Config.getDropSun(); // Sun rơi
    private int durationDropSun = 0; // Thời gian chờ rơi của sun
    public static ImageView selectedImageView = null; // ImageView được chọn trước đó bao gồm Thẻ cây và thẻ xẻng
    public static String path = ""; // Đường dẫn ảnh của cây được chọn
    private int tick = 0; // Đếm thời gian để tạo zombie

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
        // Test TODO: Chinh lại sau khi code xong

        initData(3);
        level.setLevel(1);
        level.getZombieSpawners();
        GameProcess();
    }
    public void initData(int level) {
        cardPlants.getCards(level); // Khởi tạo thẻ cây
    }
    // Xử lí game
    public void GameProcess() {
        TimelineGame = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            tick++;
            // Xử lí tạo ra dropsun sau một khoảng thời gian
            if (durationDropSun == 0) {
                dropSun.CreatSunDrop();
                durationDropSun = dropSun.getDurationDropSun();
            }
            else {
                durationDropSun--;
            }
            // Xử lí tạo ra zombie
            while (zombieSpawners.size() > 0 && zombieSpawners.get(0).getTime() == tick) {
                ZombieSpawner zombieSpawner = zombieSpawners.get(0);
                Zombie zombie = zombieSpawner.getZombie();
                zombie.makeImage();
                zombie.move();
                zombies.add(zombie);
                zombieSpawners.remove(0);
            }
            // Kiểm tra trạng thái game và cập nhập phần trăm game
            // TODO: Thêm các trạng thái game và timneline game
            if (zombieSpawners.size() == 0) {
                System.out.println("Game win");
                TimelineGame.stop();
                System.exit(0);
            }
        }));
        TimelineGame.setCycleCount(Timeline.INDEFINITE);
        TimelineGame.play();
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
        else if (path != "") { // Xử lí việc tạo cây TODO: Thêm xét sun >= cost không để có thể mua cây - Hiện tại chưa để để debug và tạo base game
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

