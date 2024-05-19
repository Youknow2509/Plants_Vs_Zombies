package src.Model.ActCharacter.Zombie;

import src.Controller.Game.GameMainController;
import src.Model.ActCharacter.Act;
import src.Model.Characters.Plants.Plant;
import src.Model.Characters.Zombies.Zombie;
public class ActConeheadZombie implements Act {
    // Var
    private Zombie zombie;
    // Constructor

    public ActConeheadZombie() {
        super();
    }

    public ActConeheadZombie(Zombie zombie) {
        super();
        this.zombie = zombie;
    }
    @Override
    // handle chọn trạng thái
    public void handle() {
        boolean flag = true;
        synchronized ((GameMainController.getGameData()).getListPlant()) {
            for (Plant p : (GameMainController.getGameData()).getListPlant()) {
                if (p.getLane() == zombie.getLane() && zombie.getX() - p.getX() <= 30) {
                    attack(p);
                    flag = false;
                    //System.out.println("Plant hp: " + p.getHp()); // Để debug xem máu của cây còn lại bao nhiêu
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
        //System.out.println("Plant hp: " + plant.getHp());
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
        if (zombie.getX() < 10) {
            zombie.removeImageView();
        }
    }
}
