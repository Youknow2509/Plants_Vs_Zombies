package src.Controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import src.Model.GameData;
import src.Model.GameProcess;

import javafx.scene.image.ImageView;
import src.Model.Plant.Pea.PeaShooter;
import src.Model.Plant.Plant;
import src.Utils.LoadLevel;
import src.Utils.Shovel;

public class GameMainController { // TODO để tạm thời , sẽ viết lại hết trừ model
    // Variables
    // FXML Variables
    @FXML
    private AnchorPane GamePlayRoot;
    @FXML
    private GridPane lawnGrid;
    @FXML
    private ImageView btnShovel;
    // Static Variables
    private static AnchorPane anchorPane = null;
    private static GridPane gridPane = null;
    private static String path = "";
    private static ImageView imageViewClickBefore = null;
    private static Shovel shovel = null;
    // Game Variables
    private GameProcess gameProcess = null;
    private GameData gameData = null;
    private LoadLevel loadLevel = null;

    // Initialize
    @FXML
    public void initialize() {
        // Load level
        loadLevel = new LoadLevel("/Users/v/code/java/projects/PVZ/src/DataBase/Levels/Level_1/1.txt");
        loadLevel.read();
        gameData = loadLevel.getGameData();
        // init static variables
        anchorPane = GamePlayRoot;
        gridPane = lawnGrid;
        shovel = new Shovel(gameData.getListPlant(), btnShovel);
        shovel.getImageView().addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, e -> {
            shovel.handleClick();
        });
        // Start game
        gameProcess = new GameProcess(gameData);
        gameProcess.startGame();
    }
    // Hàm xử lí khi click vào ô cỏ
    public void getGridPosition(MouseEvent e) {
        Node source = (Node) e.getSource();
        // Lấy ra vị trí ô đang được click
        Integer x = lawnGrid.getColumnIndex(source);
        Integer y = lawnGrid.getRowIndex(source);

        if (!shovel.getIsDisabled()) { // Xử lí việc xoá cây
            shovel.remotePlant(x, y);
        }
        else if (path != "") { // Xử lí việc tạo cây TODO: Thêm xét sun >= cost không để có thể mua cây - Hiện tại chưa để để debug và tạo base game
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
                    Plant newPlant = creatPlant((int) (source.getLayoutX() + source.getParent().getLayoutX())
                                            , (int) (source.getLayoutY() + source.getParent().getLayoutY())
                                            , y, x);

                    gameData.getListPlant().add(newPlant);
                    newPlant.startAnimation();
                    //setSun(sun - newPlant.getCost());

                    imageViewClickBefore.setOpacity(1);
                    path = "";
                }
            }
        }
    }
    // creat Plant with card
    public Plant creatPlant(int x, int y, int row, int col) {
        switch (path) {
            case "Peashooter":
                return new PeaShooter(x, y, row, col, gameData.getZombieAlive());
        }
        return null;
    }
    // Getters and Setters

    public GameProcess getGameProcess() {
        return gameProcess;
    }

    public void setGameProcess(GameProcess gameProcess) {
        this.gameProcess = gameProcess;
    }

    public GameData getGameData() {
        return gameData;
    }

    public void setGameData(GameData gameData) {
        this.gameData = gameData;
    }

    public static String getPath() {
        return path;
    }

    public static void setPath(String path) {
        GameMainController.path = path;
    }

    public static ImageView getImageViewClickBefore() {
        return imageViewClickBefore;
    }

    public static void setImageViewClickBefore(ImageView imageViewClickBefore) {
        GameMainController.imageViewClickBefore = imageViewClickBefore;
    }

    public static Shovel getShovel() {
        return shovel;
    }

    public static void setShovel(Shovel shovel) {
        GameMainController.shovel = shovel;
    }

    public ImageView getBtnShovel() {
        return btnShovel;
    }

    public void setBtnShovel(ImageView btnShovel) {
        this.btnShovel = btnShovel;
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

    public LoadLevel getLoadLevel() {
        return loadLevel;
    }

    public void setLoadLevel(LoadLevel loadLevel) {
        this.loadLevel = loadLevel;
    }
}