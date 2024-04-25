package src.Model.Plants.Wallnut;

import src.Config.Path;
import src.Model.Plants.Plant;

public class Wallnut extends Plant {
    // Variables infomation of Wallnut
    private final static int HP = 400;
    private final static int COST = 50;
    private static final int DAMAGE = 0;
    private static final int WIDTH = 60;
    private static final int HEIGHT = 60;
    private static final int SPEED_ATTACK = 0;
    //

    // Constructor of Wallnut
    public Wallnut() {
        super();
    }
    public Wallnut(double x, double y, int col, int row) {
        super(x, y, Path.ASSETS_Image_Wallnut, WIDTH, HEIGHT, HP, col, row, COST, SPEED_ATTACK, DAMAGE);
        createImageViewInGridPane();
    }
    // TODO chưa code Wallnut
}
