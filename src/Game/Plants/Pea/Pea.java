package src.Game.Plants.Pea;

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
    private Timeline movePea;

    public Pea(int x, int y, int lane) {
        super(x, y, path, 20, 20, lane);
    }
    // Di chuyển đạn
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
    // Xóa đạn
    public void remove() {
        rmImage();
        movePea.stop();
    }
    // Xử lí khi đạn chạm vào zombie
    private void attack() {
        synchronized (GamePlayController.zombies) {
            for (int i = 0; i < GamePlayController.zombies.size(); i++) {
                Zombie z = GamePlayController.zombies.get(i);
                if (z.getLane() == getLane() && getX() - z.getX() <= 30 && getX() - z.getX() >= 0){
                    z.setHp(z.getHp() - damage);
                    remove();
                    // System.out.println("Zb hp: " +  z.getHp()); // TODO: Để debug xem máu của zombie còn lại bao nhiêu
                    if (z.getHp() <= 0) {
                        z.getMoveZombie().stop();
                        z.rmImage();
                        GamePlayController.zombies.remove(z);
                    }
                }
            }
        }
    }
    // Bắt đầu di chuyển đạn
    public void active() {
        movePea = new Timeline(new KeyFrame(Duration.millis(5), e -> {movePea();}));
        movePea.setCycleCount(Timeline.INDEFINITE);
        movePea.play();
    }
    // Get và set các thuộc tính
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
