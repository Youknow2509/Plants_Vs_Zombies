package src.Model.Plants;

import src.Model.Plants.Repeater.Repeater;
import src.Model.Plants.Sun.SunFlower;
import src.Model.Plants.PeaShooter.PeaShooter;
import src.Model.Plants.Wallnut.Wallnut;

public class PlantFactory {
    // Factory method to create Plant
    public static Plant createPlant(PlantType type, double x, double y, int col, int row) {
        switch (type) {
            case SUNFLOWER:
                return new SunFlower(x, y, row, col);
            case PEASHOOTER:
                return new PeaShooter(x, y, row, col);
            case REPEATER:
                return new Repeater(x, y, row, col);
            case WALLNUT:
                return new Wallnut(x, y, row, col);
            default:
                return null;
        }
    }
    // Factory get Cost
    public static int getCost(PlantType type) {
        switch (type) {
            case SUNFLOWER:
                return 50;
            case PEASHOOTER:
                return 100;
            case REPEATER:
                return 200;
            case POTATOMINE:
                return 25;
            case CHOMPER:
                return 150;
            case WALLNUT:
                return 50;
            case CHERRYBOMB:
                return 150;
            default:
                return 0;
        }
    }
}
