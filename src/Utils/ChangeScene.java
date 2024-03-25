package src.Utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChangeScene {
    // Var
    private String path;
    private Stage stage;
    private int width = 1024;
    private int height = 600;
    private String title = "Plants vs Zombies";

    // Constructor
    public ChangeScene(Stage stage, String title, int width, int height, String path) {
        this.path = path;
        this.stage = stage;
        this.width = width;
        this.height = height;
        this.title = title;
    }
    public ChangeScene() {
        super();
    }
    // Method
    public void change() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Parent root = loader.load();
            Scene scene = new Scene(root, width, height);
            stage.setScene(scene);
            stage.setTitle(title);
            stage.show();

        } catch (Exception e) {
            System.out.println("Err: " + e);
            System.exit(0);
        }
    }


    // Getter and setter
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
