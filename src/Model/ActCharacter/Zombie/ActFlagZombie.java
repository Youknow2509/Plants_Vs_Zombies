package src.Model.ActCharacter.Zombie;

import src.Controller.Game.GameMainController;
import src.Model.ActCharacter.Act;
import src.Model.Characters.Plants.Plant;
import src.Model.Characters.Zombies.Zombie;

public class ActFlagZombie implements Act {
    // Var
    private Zombie zombie;
    // Constructor

    public ActFlagZombie() {
        super();
    }

    public ActFlagZombie(Zombie zombie) {
        super();
        this.zombie = zombie;
    }
    @Override
    // handle chọn trạng thái - Tìm plant trước mặt khoảng cách thoã mãn thì tấn công, không thì di chuyển
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

    // Attack - xử lí tấn công của plant - 1 lần tấn công chỉ tấn công 1 plant
    @Override
    public void attack(Object object) {
        if (zombie.getPath() != zombie.getPath_eat()) { // Fix load lai nhieu anh bi giat
            zombie.changeImageView(zombie.getPath_eat());
        }
        Plant plant = (Plant) object;
        plant.setHp(plant.getHp() - zombie.getDame());
        //System.out.println("Plant hp: " + plant.getHp());
        // Xử lí khi cây bị hết máu
        if (plant.getHp() <= 0) {
            plant.removeImageViewInGridPane();
            (GameMainController.getGameData()).getListPlant().remove(plant);
        }
    }
    // Move - xử lí di chuyển của zombie - 1 lần di chuyển
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
