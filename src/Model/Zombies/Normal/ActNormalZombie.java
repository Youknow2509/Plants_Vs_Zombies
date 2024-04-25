package src.Model.Zombies.Normal;

import src.Controller.Game.GameMainController;
import src.Model.Act;
import src.Model.Plants.Plant;
import src.Model.Zombies.Zombie;
public class ActNormalZombie implements Act {
    // Var
    private Zombie zombie;
    // Constructor

    public ActNormalZombie() {
        super();
    }

    public ActNormalZombie(Zombie zombie) {
        super();
        this.zombie = zombie;
    }
    @Override
    // handle chọn trạng thái
    public void handle() {
        boolean flag = true;
        synchronized ((GameMainController.getGameData()).getListPlant()) {
            for (Plant p : (GameMainController.getGameData()).getListPlant()) {
                if (p.getLane() == zombie.getLane() && zombie.getX() - p.getX() <= 30 && zombie.getX() > p.getX()) {
                    attack(p);
                    flag = false;
                    break;
                }
            }
        }
        if (flag) {
            move();
        }
    }

    // Attack
    @Override
    public void attack(Object object) {
        if (zombie.getPath() != zombie.getPath_eat()) { // Fix load lai nhieu anh bi giat
            zombie.changeImageView(zombie.getPath_eat());
        }
        Plant plant = (Plant) object;
        plant.setHp(plant.getHp() - zombie.getDame());
        System.out.println("Plant hp: " + plant.getHp());
        // Xử lí khi cây bị hết máu
        if (plant.getHp() <= 0) {
            plant.removeImageViewInGridPane();
            (GameMainController.getGameData()).getListPlant().remove(plant);
        }
    }
    // Move
    @Override
    public void move() {
        if (zombie.getPath() != zombie.getPath_run()) { // Fix load lai nhieu anh bi giat
            zombie.changeImageView(zombie.getPath_run());
        }
        zombie.setX(zombie.getX() - zombie.getMove());
        if (zombie.getX() < 195) {
            zombie.removeImageView();
            GameMainController.setWonGame(0);
        }
    }
}
