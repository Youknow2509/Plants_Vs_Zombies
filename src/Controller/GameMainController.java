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
    // Game Variables
    private GameProcess gameProcess = null;
    private GameData gameData = null;
    private LoadLevel loadLevel = null;
    private static String path = "";
    private static ImageView imageViewClickBefore = null;
    private static Shovel shovel = null;

    // Initialize
    @FXML
    public void initialize() {
        loadLevel = new LoadLevel("/Users/v/code/java/projects/PVZ/src/DataBase/Levels/Level_1/1.txt");
        loadLevel.read();
        gameData = loadLevel.getGameData();
        gameProcess = new GameProcess(gameData, lawnGrid, GamePlayRoot);
        gameProcess.startGame();

        shovel = new Shovel(GamePlayRoot, gameData.getListPlant(), btnShovel);
        shovel.getImageView().addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, e -> {
            shovel.handleClick();
        });
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
                    newPlant.createImageView();
                    //setSun(sun - newPlant.getCost());

                    //CardPlants.setCardUnSelected();
                }
            }
        }
    }
    // creat Plant with card
    public Plant creatPlant(int x, int y, int row, int col) {
        switch (path) {
            case "Peashooter":
                return new PeaShooter(GamePlayRoot, lawnGrid, x, y, row, col, gameData.getZombieAlive());
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
}