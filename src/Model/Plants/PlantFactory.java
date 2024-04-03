package src.Model.Plants;

import src.Model.GameElements;
import src.Model.Plants.CherryBomb.CherryBomb;
import src.Model.Plants.Chomper.Chomper;
import src.Model.Plants.Pea.Repeater.Repeater;
import src.Model.Plants.PotanoMine.PotatoMine;
import src.Model.Plants.Sun.SunFlower;
import src.Model.Plants.Pea.PeaShooter.PeaShooter;
import src.Model.Plants.Wallnut.Wallnut;

public class PlantFactory {
    public static Plant createPlant(GameElements.PlantType type, double x, double y, int col, int row) {
        switch (type) {
            case SUNFLOWER:
                return new SunFlower(x, y, row, col);
            case PEASHOOTER:
                return new PeaShooter(x, y, row, col);
            case REPEATER:
                return new Repeater(x, y, row, col);
            case POTATOMINE:
                return new PotatoMine(x, y, row, col);
            case CHOMPER:
                return new Chomper(x, y, row, col);
            case WALLNUT:
                return new Wallnut(x, y, row, col);
            case CHERRYBOMB:
                return new CherryBomb(x, y, row, col);
            default:
                return null;
        }
    }
}
