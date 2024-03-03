package src.Game.Plants;

public class PeaShooter extends Plant{

    private final static String path = "/Assets/images/Plants/Peashooter.gif";
    private final static int hp = 100;
    private final static int dame = 20;
    private final static int cost = 100;
    public PeaShooter(int x, int y, int col, int row) {
        super(x, y, path, hp, 60, 60, col, row, cost);
    }
}
