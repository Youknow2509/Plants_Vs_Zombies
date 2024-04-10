package src.Help.CardPlants;

public class FactoryCardPlant {
    public static CardPlant createCardPlant(String name) {
        String path = "Assets/images/Cards/" + name + ".png";
        switch (name) {
            case "SunFlower":
                return new CardPlant(path, name.toUpperCase());
            case "PeaShooter":
                return new CardPlant(path, name.toUpperCase());
            case "WallNut":
                return new CardPlant(path, name.toUpperCase());
            case "CherryBomb":
                return new CardPlant(path, name.toUpperCase());
            case "Repeater":
                return new CardPlant(path, name.toUpperCase());
            case "Chomper":
                return new CardPlant(path, name.toUpperCase());
            default:
                return null;
        }
    }
}
