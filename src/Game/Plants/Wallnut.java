package src.Game.Plants;

public class Wallnut extends Plant {
    private final static String path = "/Assets/images/Plants/Wallnut.gif";
    private final static int hp = 400;
    private final static int cost = 50;
    public Wallnut(int x, int y, int col, int row) {
        super(x, y, path, hp, 60, 60, col, row, cost);
    }
}
