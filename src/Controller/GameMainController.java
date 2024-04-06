package src.Controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import src.Help.CardPlants.CardPlant;
import src.Help.CardPlants.FactoryCardPlant;
import src.Model.GameData;
import src.Model.GameProcess;
import src.Help.Shovel;
import src.Model.Plants.Plant;
import src.Model.Plants.PlantFactory;
import src.Model.Plants.PlantType;


import java.util.List;

public class GameMainController {
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
    @FXML
    private ProgressBar progressbarGame;

    // Variables static
    private static AnchorPane anchorPane = null;
    private static GridPane gridPane = null;
    private static ProgressBar progressBar = null;
    private static GameData gameData; // Dữ liệu game
    private static int wonGame = -1; // 0: thua, 1: thắng, -1: chưa kết thúc
    public static ImageView selectedImageView = null; // ImageView được chọn trước đó bao gồm Thẻ cây và thẻ xẻng
    public static String pathImageViewSelected = ""; // Đường dẫn ảnh của cây được chọn
    private static int sun = 0;
    private static Label sunDisplay;

    // Variables
    private GameProcess gameProcess;
    private Shovel shovel = new Shovel();
    private FactoryCardPlant factoryCardPlant;
    // Initialize
    @FXML
    public void initialize(GameData g) {
        gameData = g;
        // Tải dữ liệu của Game vào Controller
        gameProcess = new GameProcess(gameData);
        gameProcess.startGame();
        // Tải Sun từ Controller vào view và gán sự kiện
        sun = gameData.getSun();
        sunCount.setText(String.valueOf(sun));
        sunDisplay = sunCount;
        // Gắn sự kiện cho GridPane
        addHandleGridPane();
        // Load Shovel to View - Tạo xẻng và gắn sự kiện cho xẻng
        shovel.setImageView(btnShovel);
        btnShovel.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            shovel.handleClick();
        });
        // Gán giá trị cho các biến static nắm giữ các element - để dễ dàng truy cập từ các class khác ( Thêm, xoá hình ảnh, v.v)
        anchorPane = GamePlayRoot;
        gridPane = lawnGrid;
        progressBar = progressbarGame;
        // Tải các thẻ cây vào View
        for (CardPlant cardPlant : gameData.getCardPlantList()) {
            cardPlant.createImage();
        }
    }
// Handle action in view

    // Them su kien cho cac o trong lawnGrid
    private void addHandleGridPane() {
        List<Node> lNode = lawnGrid.getChildren();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                lNode.get(j * 5 + i).addEventHandler(
                        MouseEvent.MOUSE_CLICKED,
                        (event) -> {
                            handleInLawnGrid(event);
                        }
                );
            }
        }
    }

    // Su kien trong o lawnGrid
    private void handleInLawnGrid(MouseEvent e) {
        Node source = (Node) e.getSource();
        // Lấy ra vị trí ô đang được click
        Integer x = lawnGrid.getColumnIndex(source);
        Integer y = lawnGrid.getRowIndex(source);

        // Lay ra loai cay dang duoc chon
        PlantType type = null;
        if (pathImageViewSelected != "") {
            type = PlantType.valueOf(pathImageViewSelected.toUpperCase());
        }

        if (!shovel.getIsDisabled()) { // Xử lí việc xoá cây
            shovel.rmPlant(gameData.getListPlant(), x, y);
        }
        else if (pathImageViewSelected != ""
                && getSun() >= PlantFactory.getCost(type)) { // Xử lí việc tạo cây TODO: Thêm xét sun >= cost không để có thể mua cây - Hiện tại chưa để để debug và tạo base game
           // ) {
            if (x != null && y != null) {
                boolean flag = true;
                synchronized (gameData.getListPlant()) {
                    for (int i = 0; i < gameData.getListPlant().size(); i++) {
                        if ((gameData.getListPlant().get(i)).getCol() == x && (gameData.getListPlant().get(i)).getRow() == y) {
                            flag = false;
                            break;
                        }
                    }
                }
                // Tạo một cây mới thêm vào game
                if (flag) {

                    Plant newPlant = PlantFactory.createPlant(type, (int) (source.getLayoutX() + source.getParent().getLayoutX())
                            , (int) (source.getLayoutY() + source.getParent().getLayoutY())
                            , y
                            , x);

                    gameData.getListPlant().add(newPlant);
                    newPlant.start();

                    setSun(sun - newPlant.getCost());

                    CardPlant.setCardUnSelected();
                }
            }
        }
    }

    // Menu handle
    public void menuHandle(MouseEvent e) {
        // TODO tạo  menu cho một game
        System.out.println("Menu clicked");
        System.exit(0);
    }

// Getter and setter
    public static int getSun() {
        return sun;
    }
    public static void setSun(int s) {
        sun = s;
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
        GameMainController.anchorPane = anchorPane;
    }

    public static GridPane getGridPane() {
        return gridPane;
    }

    public static void setGridPane(GridPane gridPane) {
        GameMainController.gridPane = gridPane;
    }

    public static GameData getGameData() {
        return gameData;
    }

    public static void setGameData(GameData gameData) {
        GameMainController.gameData = gameData;
    }

    public static ImageView getSelectedImageView() {
        return selectedImageView;
    }

    public static void setSelectedImageView(ImageView selectedImageView) {
        GameMainController.selectedImageView = selectedImageView;
    }

    public static String getPathImageViewSelected() {
        return pathImageViewSelected;
    }

    public static void setPathImageViewSelected(String pathImageViewSelected) {
        GameMainController.pathImageViewSelected = pathImageViewSelected;
    }

    public GameProcess getGameProcess() {
        return gameProcess;
    }

    public void setGameProcess(GameProcess gameProcess) {
        this.gameProcess = gameProcess;
    }

    public Shovel getShovel() {
        return shovel;
    }

    public void setShovel(Shovel shovel) {
        this.shovel = shovel;
    }

    public FactoryCardPlant getFactoryCardPlant() {
        return factoryCardPlant;
    }

    public void setFactoryCardPlant(FactoryCardPlant factoryCardPlant) {
        this.factoryCardPlant = factoryCardPlant;
    }

    public ProgressBar getProgressbarGame() {
        return progressbarGame;
    }

    public void setProgressbarGame(ProgressBar progressbarGame) {
        this.progressbarGame = progressbarGame;
    }

    public static ProgressBar getProgressBar() {
        return progressBar;
    }

    public static void setProgressBar(ProgressBar progressBar) {
        GameMainController.progressBar = progressBar;
    }

    public static Label getSunDisplay() {
        return sunDisplay;
    }

    public static void setSunDisplay(Label sunDisplay) {
        GameMainController.sunDisplay = sunDisplay;
    }

    public static int getWonGame() {
        return wonGame;
    }

    public static void setWonGame(int wonGame) {
        GameMainController.wonGame = wonGame;
    }
}

