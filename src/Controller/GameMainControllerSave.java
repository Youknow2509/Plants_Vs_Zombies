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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.util.Duration;
import src.Model.GameElements;
import src.Model.Plants.Plant;
import src.Model.Plants.PlantFactory;
import src.Model.Plants.Sun.DropSun;
import src.Help.Shovel;
import src.Utils.CardPlants;
import src.Model.Zombies.Zombie;
import src.Help.Level.Level;
import src.Model.ZombieSpawner;

public class GameMainControllerSave {
    // Variables FXML
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

    // Var static
    private static AnchorPane anchorPane = null;
    private static GridPane gridPane = null;
    private static List<Plant> listPlant = Collections.synchronizedList(new ArrayList<Plant>()); // Danh sách các cây tồn tại
    private static List<Zombie> listZombieAlive = Collections.synchronizedList(new ArrayList<Zombie>());// Danh sách các zombie tồn tại
    private static List<ZombieSpawner> listZombieSpawner = Collections.synchronizedList(new ArrayList<ZombieSpawner>()); // Danh sách các zombie spawner
    private static int sun = 50; // Giá trị số mặt trời
    private static Label sunDisplay; // Gắn với label hiển thị số mặt trời - để  static để có thể truy cập từ class khác
    // Var static xử lí thẻ cây
    public static ImageView selectedImageView = null; // ImageView được chọn trước đó bao gồm Thẻ cây và thẻ xẻng
    public static String pathImageViewSelected = ""; // Đường dẫn ảnh của cây được chọn

    // Var game
    private Level level = new Level(); // Level
    private Timeline TimelineGame; // Timeline của game
    private Shovel shovel = new Shovel(); // Xẻng
    private CardPlants cardPlants = new CardPlants(); // Danh sách thẻ các loại cây
    private DropSun dropSun = new DropSun(); // Sun rơi
    private int durationDropSun = 0; // Thời gian chờ rơi của sun
    private int tick = 0; // Đếm thời gian để tạo zombie

    // Khởi tạo game
    @FXML
    public void initialize() {

        // Gán các giá trị static
        anchorPane = GamePlayRoot;
        gridPane = lawnGrid;
        sunDisplay = sunCount;

        //

        menu.setOnMouseClicked(e -> { //TODO Xử lí tạm thời - "Hiện tại dùng để thoát "
            System.exit(0);
        });
        // Tạo xẻng và gắn sự kiện cho xẻng
        shovel.setImageView(btnShovel);
        btnShovel.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            shovel.handleClick();
        });

        // Test TODO: Chinh lại sau khi code xong

        initData(7);
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
            while (listZombieSpawner.size() > 0 && listZombieSpawner.get(0).getTime() == tick) {
                ZombieSpawner zombieSpawner = listZombieSpawner.get(0);
                Zombie zombie = zombieSpawner.getZombie();
                zombie.createImageView();
                zombie.start();
                listZombieAlive.add(zombie);
                listZombieSpawner.remove(0);
            }
            // Kiểm tra trạng thái game và cập nhập phần trăm game
            // TODO: Thêm các trạng thái game và timneline game

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
            shovel.rmPlant(listPlant, x, y);
        }
        else if (pathImageViewSelected != "") { // Xử lí việc tạo cây TODO: Thêm xét sun >= cost không để có thể mua cây - Hiện tại chưa để để debug và tạo base game
            if (x != null && y != null) {
                boolean flag = true;
                synchronized (listPlant) {
                    for (int i = 0; i < listPlant.size(); i++) {
                        if ((listPlant.get(i)).getCol() == x && (listPlant.get(i)).getRow() == y) {
                            flag = false;
                            break;
                        }
                    }
                }
                // Tạo một cây mới thêm vào game
                if (flag) {
                    GameElements.PlantType type = GameElements.PlantType.valueOf(pathImageViewSelected.toUpperCase());
                    Plant newPlant = PlantFactory.createPlant(type, (int) (source.getLayoutX() + source.getParent().getLayoutX())
                            , (int) (source.getLayoutY() + source.getParent().getLayoutY())
                            , y
                            , x);

                    listPlant.add(newPlant);
                    newPlant.start();

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
        GameMainControllerSave.sun = sun;
        sunDisplay.setText(String.valueOf(sun));
    }

    public AnchorPane getGamePlayRoot() {
        return GamePlayRoot;
    }

    public void setGamePlayRoot(AnchorPane gamePlayRoot) {
        GamePlayRoot = gamePlayRoot;
    }

    public GridPane getLawnGrid() {
        return lawnGrid;
    }

    public void setLawnGrid(GridPane lawnGrid) {
        this.lawnGrid = lawnGrid;
    }

    public ImageView getMenu() {
        return menu;
    }

    public void setMenu(ImageView menu) {
        this.menu = menu;
    }

    public ImageView getBtnShovel() {
        return btnShovel;
    }

    public void setBtnShovel(ImageView btnShovel) {
        this.btnShovel = btnShovel;
    }

    public Label getSunCount() {
        return sunCount;
    }

    public void setSunCount(Label sunCount) {
        this.sunCount = sunCount;
    }

    public static AnchorPane getAnchorPane() {
        return anchorPane;
    }

    public static void setAnchorPane(AnchorPane anchorPane) {
        GameMainControllerSave.anchorPane = anchorPane;
    }

    public static GridPane getGridPane() {
        return gridPane;
    }

    public static void setGridPane(GridPane gridPane) {
        GameMainControllerSave.gridPane = gridPane;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Timeline getTimelineGame() {
        return TimelineGame;
    }

    public void setTimelineGame(Timeline timelineGame) {
        TimelineGame = timelineGame;
    }

    public static Label getSunDisplay() {
        return sunDisplay;
    }

    public static void setSunDisplay(Label sunDisplay) {
        GameMainControllerSave.sunDisplay = sunDisplay;
    }

    public Shovel getShovel() {
        return shovel;
    }

    public void setShovel(Shovel shovel) {
        this.shovel = shovel;
    }

    public CardPlants getCardPlants() {
        return cardPlants;
    }

    public void setCardPlants(CardPlants cardPlants) {
        this.cardPlants = cardPlants;
    }

    public DropSun getDropSun() {
        return dropSun;
    }

    public void setDropSun(DropSun dropSun) {
        this.dropSun = dropSun;
    }

    public int getDurationDropSun() {
        return durationDropSun;
    }

    public void setDurationDropSun(int durationDropSun) {
        this.durationDropSun = durationDropSun;
    }

    public static ImageView getSelectedImageView() {
        return selectedImageView;
    }

    public static void setSelectedImageView(ImageView selectedImageView) {
        GameMainControllerSave.selectedImageView = selectedImageView;
    }

    public static String getPathImageViewSelected() {
        return pathImageViewSelected;
    }

    public static void setPathImageViewSelected(String pathImageViewSelected) {
        GameMainControllerSave.pathImageViewSelected = pathImageViewSelected;
    }

    public int getTick() {
        return tick;
    }

    public void setTick(int tick) {
        this.tick = tick;
    }

    public static List<Plant> getListPlant() {
        return listPlant;
    }

    public static void setListPlant(List<Plant> listPlant) {
        GameMainControllerSave.listPlant = listPlant;
    }

    public static List<Zombie> getListZombieAlive() {
        return listZombieAlive;
    }

    public static void setListZombieAlive(List<Zombie> listZombieAlive) {
        GameMainControllerSave.listZombieAlive = listZombieAlive;
    }

    public static List<ZombieSpawner> getListZombieSpawner() {
        return listZombieSpawner;
    }

    public static void setListZombieSpawner(List<ZombieSpawner> listZombieSpawner) {
        GameMainControllerSave.listZombieSpawner = listZombieSpawner;
    }
}

