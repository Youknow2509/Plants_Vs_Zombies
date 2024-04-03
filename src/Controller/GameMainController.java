package src.Controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import src.DataBase.Handle.HandleLoadLevel;
import src.Help.CardPlants.FactoryCardPlant;
import src.Model.GameData;
import src.Model.GameProcess;
import src.Help.Shovel;
import src.Model.GameElements;
import src.Model.Plants.Plant;
import src.Model.Plants.PlantFactory;
import src.Model.Plants.Sun.DropSun;
import src.Utils.CardPlants;

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

    // Variables
    private GameData gameData;
    private GameProcess gameProcess;
    private static AnchorPane anchorPane;
    private static GridPane gridPane;
    private Shovel shovel = new Shovel(); // Xẻng
    private DropSun dropSun = new DropSun(); // Sun rơi
    private static int sun = 50; // Giá trị số mặt trời
    private static Label sunDisplay; // Gắn với label hiển thị số mặt trời - để  static để có thể truy cập từ class khác
    public static ImageView selectedImageView = null; // ImageView được chọn trước đó bao gồm Thẻ cây và thẻ xẻng
    public static String pathImageViewSelected = ""; // Đường dẫn ảnh của cây được chọn

    // Init
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

        HandleLoadLevel handleLoadLevel = new HandleLoadLevel(1);
        FactoryCardPlant factoryCardPlant = new FactoryCardPlant();
        gameData = handleLoadLevel.loadLevel();
        gameProcess = new GameProcess(gameData);

        gameProcess.startGame();
        // todo fix add card plant
    }
    // Hàm xử lí khi click vào ô cỏ
    public void getGridPosition(MouseEvent e) {
        Node source = (Node) e.getSource();
        // Lấy ra vị trí ô đang được click
        Integer x = lawnGrid.getColumnIndex(source);
        Integer y = lawnGrid.getRowIndex(source);

        if (!shovel.getIsDisabled()) { // Xử lí việc xoá cây
            shovel.rmPlant(gameData.getListPlant(), x, y);
        }
        else if (pathImageViewSelected != "") { // Xử lí việc tạo cây TODO: Thêm xét sun >= cost không để có thể mua cây - Hiện tại chưa để để debug và tạo base game
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
                    GameElements.PlantType type = GameElements.PlantType.valueOf(pathImageViewSelected.toUpperCase());
                    Plant newPlant = PlantFactory.createPlant(type, (int) (source.getLayoutX() + source.getParent().getLayoutX())
                            , (int) (source.getLayoutY() + source.getParent().getLayoutY())
                            , y
                            , x);

                    gameData.getListPlant().add(newPlant);
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

    // Getter and Setter
    public static int getSun() {
        return sun;
    }
    public static void setSun(int sun) {
        GameMainController.sun = sun;
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

    public GameData getGameData() {
        return gameData;
    }

    public void setGameData(GameData gameData) {
        this.gameData = gameData;
    }

    public GameProcess getGameProcess() {
        return gameProcess;
    }

    public void setGameProcess(GameProcess gameProcess) {
        this.gameProcess = gameProcess;
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

    public Shovel getShovel() {
        return shovel;
    }

    public void setShovel(Shovel shovel) {
        this.shovel = shovel;
    }

    public DropSun getDropSun() {
        return dropSun;
    }

    public void setDropSun(DropSun dropSun) {
        this.dropSun = dropSun;
    }

    public static Label getSunDisplay() {
        return sunDisplay;
    }

    public static void setSunDisplay(Label sunDisplay) {
        GameMainController.sunDisplay = sunDisplay;
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
}

