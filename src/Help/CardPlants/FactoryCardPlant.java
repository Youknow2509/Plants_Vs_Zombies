package src.Help.CardPlants;

import src.Config.DefaultValue;
import src.Config.Path;
import src.Model.Characters.Plants.PeaShooter.PeaShooter;
import src.Model.Characters.Plants.Repeater.Repeater;
import src.Model.Characters.Plants.SunFlower.SunFlower;
import src.Model.Characters.Plants.Wallnut.Wallnut;

public class FactoryCardPlant {
    public static CardPlant createCardPlant(String name) {
        name = name.toUpperCase();
        switch (name) {
            case "SUNFLOWER":
                return new CardPlant(Path.ASSETS_Image_Card_SunFlower, name, DefaultValue.SunFlower_COST);
            case "PEASHOOTER":
                return new CardPlant(Path.ASSETS_Image_Card_PeaShooter, name, DefaultValue.PeaShooter_COST);
            case "WALLNUT":
                return new CardPlant(Path.ASSETS_Image_Card_WallNut, name, DefaultValue.Wallnut_COST);
            case "REPEATER":
                return new CardPlant(Path.ASSETS_Image_Card_Repeater, name, DefaultValue.Repeater_COST);
            default:
                return null;
        }
    }
}
