package src.Model.Plants.PeaShooter;

import src.Config.Path;
import src.Model.Plants.Pea.Pea;
import src.Model.Plants.Plant;

import java.util.ArrayList;
import java.util.List;

public class PeaShooter extends Plant {
    // Đặc điểm của PeaShooter
    private static final  int HP = 100;
    private static final  int DAME = 20;
    private static final  int COST = 100;
    private static final  int SPEEDATTACK = 3;
    private static final  int WIDTH = 60;
    private static final  int HEIGHT = 60;
    // Var
    private List<Pea> listPea = null;
    // Constructor
    public PeaShooter() {
        super();
        listPea = new ArrayList<Pea>();

    }
    public PeaShooter(double x, double y, int col, int row) {
        super(x, y, Path.ASSETS_Image_PeaShooter, WIDTH, HEIGHT, HP, col, row, COST, SPEEDATTACK, DAME);

        createImageViewInGridPane();
        listPea = new ArrayList<Pea>();
        setAct(new ActPeaShooter(this));
        setStageCharacter(new StageCharacterPeaShooter(this));
    }
    // Start tấn công
    @Override
    public void start() {
        getStageCharacter().start();
    }
    // Stop
    @Override
    public void stop() {
        getStageCharacter().stop();
    }
    // Pause tấn công
    @Override
    public void pause() {
        getStageCharacter().pause();
    }
    // Continue tấn công
    @Override
    public void resume() {
        getStageCharacter().resume();
    }
    // Getter and Setter
    public List<Pea> getListPea() {
        return listPea;
    }
    public void setListPea(List<Pea> listPea) {
        this.listPea = listPea;
    }
}
