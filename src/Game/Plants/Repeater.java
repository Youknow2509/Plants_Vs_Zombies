package src.Game.Plants;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import src.Controller.GamePlayController;
import src.Game.Zombies.Zombie;

public class Repeater extends Plant {
    private final static String path = "/Assets/images/Plants/Repeater.gif";
    private final static int hp = 200;
    private final static int cost = 200;
    public Repeater(int x, int y, int col, int row) {
        super(x, y, path, hp, 60, 60, col, row, cost);
    }
    @Override
    public void attack(AnchorPane lawn) {
        Timeline shoot = new Timeline(new KeyFrame(Duration.seconds(3), e -> {
            synchronized (GamePlayController.zombies) {
                for (int i = 0; i < GamePlayController.zombies.size(); i++) {
                    Zombie z = GamePlayController.zombies.get(i);
                    if (z.getLane() == getLane() && z.getX() > getX() + 2){
                        Pea pea1 = new Pea((int) getX() + 45, (int) getY() + 25, getLane());
                        Pea pea2 = new Pea((int) getX() + 80, (int) getY() + 25, getLane());
                        pea1.makeImage(lawn);
                        pea1.active();
                        pea2.makeImage(lawn);
                        pea2.active();
                    }
                }
            }
        }));
        setTlDame(shoot);
        shoot.setCycleCount(Timeline.INDEFINITE);
        shoot.play();
    }
}
