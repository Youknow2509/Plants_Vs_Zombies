package src.Game.Zombies;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import src.Controller.GamePlayController;
import src.Game.Plants.Plant;

public class Normal extends Zombie {
    private final static int HP = 120;
    private final static int SPEED = 5;
    private final static int DAMAGE = 10;
    private final static String PATH = "Assets/images/Zombies/NormalZombieRun.gif";

    public Normal(int lane) {
        super(975, laneToLayoutY(lane), PATH, 100, 130, lane, SPEED, HP, DAMAGE);
    }
}
