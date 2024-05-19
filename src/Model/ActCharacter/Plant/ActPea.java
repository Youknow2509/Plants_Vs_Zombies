package src.Model.ActCharacter.Plant;

import src.Config.DefaultValue;
import src.Controller.Game.GameMainController;
import src.Model.ActCharacter.Act;
import src.Model.Characters.Plants.Pea.Pea;
import src.Model.Characters.Zombies.Zombie;

public class ActPea implements Act {
    // Var
    private Pea pea;

    // Constructor
    public ActPea() {
        super();
    }
    public ActPea(Pea pea) {
        super();
        this.pea = pea;
    }

    @Override
    public void handle() {
        move();
    }

    @Override
    public void move() {
        // Nếu đạn ra khỏi màn hình thì xóa đạn
        if (pea.getX() < 1010) {
            pea.setX(pea.getX() + pea.getSPEED());
        }
        else {
            pea.remove();
        }
        attack();
    }

    @Override
    public void attack(Object object) {

    }
    public void attack() {
        synchronized ((GameMainController.getGameData()).getZombieAlive()) {
            if ((GameMainController.getGameData()).getZombieAlive() != null && (GameMainController.getGameData()).getZombieAlive().size() > 0) {
                for (int i = 0; i < (GameMainController.getGameData()).getZombieAlive().size(); i++) {
                    Zombie z = (GameMainController.getGameData()).getZombieAlive().get(i);
                    if (z.getLane() == pea.getLane() && z.getX() - pea.getX() <= 5 && z.getX() - pea.getX() >= 0) {
                        z.setHealth(z.getHealth() - pea.getDAMAGE());
                        pea.remove();
                        //System.out.println("Zb + " + z +  " hp: " + z.getHealth()); // Để debug xem máu của zombie còn lại bao nhiêu
                        if (z.getHealth() <= 0) {
                            z.removeImageView();
                            (GameMainController.getGameData()).getZombieAlive().remove(z);
                        }
                    }
                }
            }
        }
    }
}
