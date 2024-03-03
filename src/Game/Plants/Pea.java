package src.Game.Plants;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import src.Controller.GamePlayController;
import src.Game.GameElements;
import src.Game.Zombies.Zombie;

public class Pea extends GameElements {
    private final static String path = "Assets/images/items/Pea.png";
    private int damage = 20;
    private int speed = 1;
    public int lane;

    private Timeline movePea;

    public Pea(int x, int y, int lane) {
        super(x, y, path, 20, 20);
        this.lane = lane;
    }
    private void movePea() {
        // Nếu đạn ra khỏi màn hình thì xóa đạn
        if (getX() < 1010) {
            setX(getX() + speed);
        }
        else {
            remove();
        }
        attack();
    }
    private void remove() {
        //imageView.setVisible(false);
        //imageView.setDisable(true);
        movePea.stop();
    }
    private void attack() {
        // Xử lí khi đạn chạm vào zombie
        synchronized (GamePlayController.zombies) {
            for (int i = 0; i < GamePlayController.zombies.size(); i++) {
                Zombie z = GamePlayController.zombies.get(i);
                if (z.getLane() == lane && Math.abs(z.getX() - getX()) <= 3) {
                    z.setHp(z.getHp() - damage);
                    System.out.println(z.getHp());
                    remove();
                }
            }
        }
    }
    public void active() {
        movePea = new Timeline(new KeyFrame(Duration.millis(5), e -> {movePea();}));
        movePea.setCycleCount(Timeline.INDEFINITE);
        movePea.play();
    }

}
