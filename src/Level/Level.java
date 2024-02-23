package src.Level;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import src.Controller.GamePlayController;

public class Level {
    private int level;

    public Level(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void getCardPlant() {
        if (level >= 1) {
            System.out.println("Card Plant have: [Sunflower, Peashooter]");
        }
        if (level >= 2) {
            System.out.println("Card Plant have: [Sunflower, Peashooter, Wallnut]");
        }
        if (level >= 3) {
            System.out.println("Card Plant have: [Sunflower, Peashooter, Wallnut, CherryBomb]");
        }
        if (level >= 4) {
            System.out.println("Card Plant have: [Sunflower, Peashooter, Wallnut, CherryBomb, PotatoMine]");
        }
        if (level >= 5) {
            System.out.println("Card Plant have: [Sunflower, Peashooter, Wallnut, CherryBomb, PotatoMine, SnowPea]");
        }
        if (level >= 6) {
            System.out.println("Card Plant have: [Sunflower, Peashooter, Wallnut, CherryBomb, PotatoMine, SnowPea, Chomper]");
        }
        if (level >= 7) {
            System.out.println("Card Plant have: [Sunflower, Peashooter, Wallnut, CherryBomb, PotatoMine, SnowPea, Chomper, Repeater]");
        }
        if (level >= 8) {
            System.out.println("Card Plant have: [Sunflower, Peashooter, Wallnut, CherryBomb, PotatoMine, SnowPea, Chomper, Repeater, PuffShroom]");
        }
        if (level >= 9) {
            System.out.println("Card Plant have: [Sunflower, Peashooter, Wallnut, CherryBomb, PotatoMine, SnowPea, Chomper, Repeater, PuffShroom, SunShroom]");
        }
        if (level >= 10) {
            System.out.println("Card Plant have: [Sunflower, Peashooter, Wallnut, CherryBomb, PotatoMine, SnowPea, Chomper, Repeater, PuffShroom, SunShroom, FumeShroom]");
        }
        // TO DO ...
    }

    public void getScreenGame(MouseEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/GamePlay.fxml"));
            Parent root = loader.load();

            GamePlayController gamePlayController = loader.getController();

            gamePlayController.initData(level);

            Scene scene = new Scene(root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception err) {
            System.out.println("Err: " + err);
        }


        getCardPlant();
    }
}
