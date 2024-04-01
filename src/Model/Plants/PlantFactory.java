package src.Model;

import src.Model.GameElements;
import src.Model.Plants.CherryBomb.CherryBomb;
import src.Model.Plants.Chomper.Chomper;
import src.Model.Plants.Pea.Repeater;
import src.Model.Plants.Plant;
import src.Model.Plants.PotanoMine.PotatoMine;
import src.Model.Plants.Sun.SunFlower;
import src.Model.Plants.Pea.PeaShooter;
import src.Model.Plants.Wallnut.Wallnut;

public class PlantFactory {
    public Plant createPlant(GameElements.PlantType type) {
        switch (type) {
            case SUNFLOWER:
                return new SunFlower();
            case PEASHOOTER:
                return new PeaShooter();
            case REPEATER:
                return new Repeater();
            case POTATOMINE:
                return new PotatoMine();
            case CHOMPER:
                return new Chomper();
            case WALLNUT:
                return new Wallnut();
            case CHERRYBOMB:
                return new CherryBomb();
            default:
                return null;
        }
    }
}
