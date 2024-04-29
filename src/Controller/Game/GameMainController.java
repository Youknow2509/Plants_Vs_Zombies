package src.Controller.Game;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import src.Config.Path;
import src.Help.CardPlants.CardPlant;
import src.Help.CardPlants.FactoryListCardPlant;
import src.Model.GameData;
import src.Model.GameProcess;
import src.Help.Shovel.Shovel;
import src.Model.Characters.Plants.Plant;
import src.Model.Characters.Plants.PlantFactory;
import src.Model.Characters.Plants.PlantType;


import java.io.IOException;
import java.util.List;

public class GameMainController {
    // Variables FXML
    @FXML
    private AnchorPane GamePlayRoot;
    @FXML
    private GridPane lawnGrid; // NodeGridPane bãi cỏ
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
    private static CardPlant cardPlantClicked = null; // CardPlant đang được chọn
    private static int sun = 0;
    private static Label sunDisplay;

    // Variables
    private GameProcess gameProcess;
    private Shovel shovel = new Shovel();
    private FactoryListCardPlant factoryListCardPlant;
    // Initialize
    @FXML
    public void initialize(GameProcess gameProcess) {
        this.gameProcess = gameProcess;
        gameData = gameProcess.getGameData();
        // Gán giá trị cho các biến static nắm giữ các element - để dễ dàng truy cập từ các class khác ( Thêm, xoá hình ảnh, v.v)
        anchorPane = GamePlayRoot;
        gridPane = lawnGrid;
        progressBar = progressbarGame;
        // Tải dữ liệu của Game vào Controller
        gameProcess.startGame();
        // Tải Sun từ Controller vào view và gán sự kiện
        sun = gameData.getSun();
        sunCount.setText(String.valueOf(sun));
        sunDisplay = sunCount;
        // Gắn sự kiện cho NodeGridPane
        addHandleGridPane();
        // Load Shovel to View - Tạo xẻng và gắn sự kiện cho xẻng
        shovel.setImageView(btnShovel);
        btnShovel.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            shovel.handleClick();
        });
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
        if (cardPlantClicked != null) {
            type = PlantType.valueOf(cardPlantClicked.getName());
        }

        if (!shovel.getIsDisabled()) { // Xử lí việc xoá cây
            shovel.rmPlant(gameData.getListPlant(), x, y);
        }
        else if (cardPlantClicked != null
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

                    cardPlantClicked.setTimeOutToBuyPlant(10);
                }
            }
        }
    }

    // Menu handle
    public void menuHandle(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(Path.VIEW_GameMenu));
            Parent root = loader.load();

            MenuGameController menuController = loader.getController();

            menuController.initialize((Stage) anchorPane.getScene().getWindow(), gameProcess);

            Stage popupStage = new Stage();
            // popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setScene(new Scene(root));

            (popupStage.getScene().getWindow()).setOnCloseRequest(e -> {
                gameProcess.resumeGame();
            });

            popupStage.showAndWait();
            popupStage.centerOnScreen();
            popupStage.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public FactoryListCardPlant getFactoryCardPlant() {
        return factoryListCardPlant;
    }

    public void setFactoryCardPlant(FactoryListCardPlant factoryListCardPlant) {
        this.factoryListCardPlant = factoryListCardPlant;
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

    public static CardPlant getCardPlantClicked() {
        return cardPlantClicked;
    }

    public static void setCardPlantClicked(CardPlant cardPlantClicked) {
        GameMainController.cardPlantClicked = cardPlantClicked;
    }
}

