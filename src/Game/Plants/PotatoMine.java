package src.Game.Plants;

public class PotatoMine extends Plant {
    private final static String path = "/Assets/images/Plants/PotatoMine.gif";
    private final static int hp = 25;
    private final static int cost = 25;
    public PotatoMine(int x, int y, int col, int row) {
        super(x, y, "/Assets/images/Plants/PotatoMine.gif", hp, 60, 60, col, row, cost);
    }
}
