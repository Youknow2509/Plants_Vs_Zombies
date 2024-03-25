package src.Model.Plant.Pea;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import src.Model.Plant.Plant;
import src.Model.Zombie.Zombie;

import java.util.List;

public class PeaShooter extends Plant {

    private static final String path = "/Assets/images/Plants/Peashooter.gif";
    private static final int health = 100;
    private static final int dame = 20;
    private static final int cost = 100;
    private static final int speedAttack = 1;
    private static final int width = 60;
    private static final int height = 60;
    public PeaShooter(AnchorPane root, GridPane gridPane, double x, double y, int row, int col , List<Zombie> listZombie) {
        super(root, gridPane, x, y, path, width, height, row, col, listZombie, health, dame, speedAttack, cost);
    }
    // Tấn công zombie

}