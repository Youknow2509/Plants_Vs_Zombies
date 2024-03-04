package src.Game.Plants;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import src.Controller.GamePlayController;
import src.Game.Zombies.Zombie;

import java.sql.Time;

public class PeaShooter extends Plant {

    private final static String path = "/Assets/images/Plants/Peashooter.gif";
    private final static int hp = 100;
    private final static int dame = 20;
    private final static int cost = 100;
    public PeaShooter(int x, int y, int col, int row) {
        super(x, y, path, hp, 60, 60, col, row, cost);
    }
    public PeaShooter() {
        super();
    }
    @Override
    public void attack(AnchorPane lawn) {
        Timeline shoot = new Timeline(new KeyFrame(Duration.seconds(3), e -> {
            synchronized (GamePlayController.zombies) {
                for (int i = 0; i < GamePlayController.zombies.size(); i++) {
                    Zombie z = GamePlayController.zombies.get(i);
                    if (z.getLane() == getLane() && z.getX() > getX() + 2){
                        Pea pea = new Pea((int) getX() + 50, (int) getY() + 25, getLane());
                        pea.makeImage(lawn);
                        pea.active();
                    }
                }
            }
        }));
        setMovePea(shoot);
        shoot.setCycleCount(Timeline.INDEFINITE);
        shoot.play();
    }
}
