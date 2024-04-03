package src.Model.Zombies.Conehead;

import src.Controller.GameMainControllerSave;
import src.Model.Act;
import src.Model.Plants.Plant;
import src.Model.Zombies.Zombie;
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
        synchronized (GameMainControllerSave.getListPlant()) {
            for (Plant p : GameMainControllerSave.getListPlant()) {
                if (p.getLane() == zombie.getLane() && zombie.getX() - p.getX() <= 30) {
                    attack(p);
                    flag = false;
                    //System.out.println("Plant hp: " + p.getHp()); // TODO : Để debug xem máu của cây còn lại bao nhiêu
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
        Plant plant = (Plant) object;
        plant.setHp(plant.getHp() - zombie.getDame());
        System.out.println("Plant hp: " + plant.getHp());
        // Xử lí khi cây bị hết máu
        if (plant.getHp() <= 0) {
            plant.removeImageViewInGridPane();
            GameMainControllerSave.getListPlant().remove(plant);
        }
    }
    // Move
    @Override
    public void move() {
        zombie.setX(zombie.getX() - zombie.getMove());
        if (zombie.getX() < 10) {
            zombie.removeImageView();
        }
    }
}
