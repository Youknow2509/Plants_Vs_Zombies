package src.Help.LawnMower;

import src.Utils.LaneToLayoutY;

public class FactoryLawnMower {
    // Var
    private static final double x = 230;
    public static LawnMower createLawnMower(int lane) {
        double y = LaneToLayoutY.lawnMowerGetLayoutY(lane);
        return new LawnMower(x, y, lane);
    }
}
