package src.Model.Plants.Chomper;

import src.Model.Plants.Plant;

public class Chomper extends Plant {
    // Variables infomation of Chomper
    private final static String PATH = "/Assets/images/Plants/Chomper.gif";
    private final static int HP = 150;
    private final static int COST = 150;
    private static final int DAMAGE = 1000;
    private static final int WIDTH = 60;
    private static final int HEIGHT = 60;
    private static final int SPEED_ATTACK = 0;
    //

    // Constructor of Chomper
    public Chomper() {
        super();
    }
    public Chomper(double x, double y, int col, int row) {
        super(x, y, PATH, WIDTH, HEIGHT, HP, col, row, COST, SPEED_ATTACK, DAMAGE);
        createImageViewInGridPane();
    }
    // TODO chưa code Chomper
}
