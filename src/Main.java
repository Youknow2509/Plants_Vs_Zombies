package src;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
       System.out.println("Starting Application");
       Parent root = FXMLLoader.load(getClass().getResource("fxml/main.fxml"));
       primaryStage.setTitle("PVZ");
       primaryStage.setScene(new Scene(root, 1024, 600));
       primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
