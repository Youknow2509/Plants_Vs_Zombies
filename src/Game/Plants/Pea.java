package src.Game.Plants;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import src.Controller.GamePlayController;
import src.Game.GameElements;
import src.Game.Zombies.Zombie;

public class Pea extends GameElements {
    private final static String path = "Assets/images/items/Pea.png";
    private int damage = 20;
    private int speed = 5;
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
        imageView.setVisible(false);
        movePea.stop();
    }
    private void attack() {
        // Xử lí khi đạn chạm vào zombie
        synchronized (GamePlayController.zombies) {
            for (int i = 0; i < GamePlayController.zombies.size(); i++) {
                Zombie z = GamePlayController.zombies.get(i);
                if (Math.abs(z.getX() - imageView.getX()) < 20 && z.getLane() == lane) {
                    // GamePlayController.zombies.get(i).setHp(GamePlayController.zombies.get(i).getHp() - damage);
                    remove();
                    System.out.println("lane zombie: " + z.getLane() + " lane pea: " + lane);
                    break;
                }
            }
        }
    }
    public void active() {
        movePea = new Timeline(new KeyFrame(javafx.util.Duration.millis(5), e -> {movePea();}));
        movePea.setCycleCount(Timeline.INDEFINITE);
        movePea.play();
    }

}
