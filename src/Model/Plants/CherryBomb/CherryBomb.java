package src.Model.Plants.CherryBomb;

import src.Model.Plants.Plant;

public class CherryBomb extends Plant {
    // Variables infomation of CherryBomb
    private final static String PATH = "/Assets/images/Plants/CherryBomb.gif";
    private final static int HP = 150;
    private final static int COST = 150;
    private static final int DAMAGE = 1000;
    private static final int WIDTH = 60;
    private static final int HEIGHT = 60;
    private static final int SPEED_ATTACK = 0;
    //

    // Constructor of CherryBomb
    public CherryBomb(double x, double y, int col, int row) {
        super(x, y, PATH, WIDTH, HEIGHT, HP, col, row, COST, SPEED_ATTACK, DAMAGE);
        createImageViewInGridPane();
    }
    // TODO chưa code CherryBomb
}
