package src.Model.Characters.Plants;

import src.Model.Characters.Plants.Repeater.Repeater;
import src.Model.Characters.Plants.SunFlower.SunFlower;
import src.Model.Characters.Plants.PeaShooter.PeaShooter;
import src.Model.Characters.Plants.Wallnut.Wallnut;

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
}
