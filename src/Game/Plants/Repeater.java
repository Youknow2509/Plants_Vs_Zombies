package src.Game.Plants;

public class Repeater extends Plant {
    private final static String path = "/Assets/images/Plants/Repeater.gif";
    private final static int hp = 200;
    private final static int cost = 200;
    public Repeater(int x, int y, int col, int row) {
        super(x, y, path, hp, 60, 60, col, row, cost);
    }
}