package src.Game.Plants;

public class SunFlower extends Plant {
    private final static String path = "/Assets/images/Plants/sunflower.gif";
    private final static int hp = 100;
    private final static int cost = 50;
    public SunFlower(int x, int y, int col, int row) {
        super(x, y, "/Assets/images/Plants/sunflower.gif", 100, 60, 60, col, row, 50);
    }
}
