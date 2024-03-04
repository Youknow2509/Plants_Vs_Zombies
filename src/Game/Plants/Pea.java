package src.Game.Plants;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import src.Controller.GamePlayController;
import src.Game.GameElements;
import src.Game.Zombies.Zombie;

public class Pea extends GameElements {
    private final static String path = "Assets/images/items/Pea.png";
    private int damage = 20;
    private int speed = 1;
    private Timeline movePea;

    public Pea(int x, int y, int lane) {
        super(x, y, path, 20, 20, lane);
        //getImageView().setX(x + 42);
        //getImageView().setY(y + 25);
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
    public void remove() {
        //rmImage((AnchorPane) getImageView().getParent());
        movePea.stop();
    }
    private void attack() {
        // Xử lí khi đạn chạm vào zombie
        synchronized (GamePlayController.zombies) {
            for (int i = 0; i < GamePlayController.zombies.size(); i++) {
                Zombie z = GamePlayController.zombies.get(i);
                if (z.getLane() == getLane() && getX() - z.getX() <= 30 && getX() > z.getX()) {
                    z.setHp(z.getHp() - damage);
                    remove();
                    if (z.getHp() <= 0) {
                        GamePlayController.zombies.remove(z);
                    }
                }
            }
        }
    }
    public void active() {
        movePea = new Timeline(new KeyFrame(Duration.millis(5), e -> {movePea();}));
        movePea.setCycleCount(Timeline.INDEFINITE);
        movePea.play();
    }
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Timeline getMovePea() {
        return movePea;
    }

    public void setMovePea(Timeline movePea) {
        this.movePea = movePea;
    }
}
