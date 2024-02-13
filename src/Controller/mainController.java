package src.Controller;

import javafx.fxml.FXML;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class mainController {

    @FXML
    private GridPane lawnGrid;

    private ImageView img;
    String path = "/Assets/images/Plants/Peashooter.gif";

    @FXML
    public void initialize(){
        System.out.println("Main Controller Initialized");
        System.out.println("GridPane: " + lawnGrid);
    }
    // Ham xu ly khi click vao GridPane bãi cỏ
    public void getGridPosition(MouseEvent e) {
        Node source = (Node) e.getSource();
        // Lấy ra vị trí ô đang được click
        Integer colIndex = lawnGrid.getColumnIndex(source);
        Integer rowIndex = lawnGrid.getRowIndex(source);
        System.out.println("Add plant location col: " + String.valueOf(colIndex) + ", row: " + String.valueOf(rowIndex));

        // Tạo một hình ảnh từ một tệp hình ảnh trên đĩa
        makeImage(lawnGrid, colIndex, rowIndex, path);

    }
    // Hàm tạo một hình ảnh trong GridPane
    public void makeImage(GridPane lawn, int col, int row, String path) {
        // Tạo một hình ảnh từ một tệp hình ảnh trên đĩa
        Image image = new Image(path, 50, 50, false, false);
        // Tạo một ImageView để hiển thị hình ảnh
        ImageView imageView = new ImageView(image);
        imageView.setImage(image);
        // Thêm hình ảnh vào GridPane
        lawn.add(imageView, col, row, 1, 1);
    }
    public void menu(MouseEvent e) {
            System.out.println("Quit Game");
            System.exit(0);
    }
}
