package src.Help.CardPlants;

import src.Config.Path;

public class FactoryCardPlant {
    public static CardPlant createCardPlant(String name) {
        name = name.toUpperCase();
        switch (name) {
            case "SUNFLOWER":
                return new CardPlant(Path.ASSETS_Image_Card_SunFlower, name);
            case "PEASHOOTER":
                return new CardPlant(Path.ASSETS_Image_Card_PeaShooter, name);
            case "WALLNUT":
                return new CardPlant(Path.ASSETS_Image_Card_WallNut, name);
            case "REPEATER":
                return new CardPlant(Path.ASSETS_Image_Card_Repeater, name);
            default:
                return null;
        }
    }
}
