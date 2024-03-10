package src;

import javafx.animation.Timeline;
import src.Game.Plants.CardPlants;
import src.Game.Plants.Plant;
import src.Game.Plants.Sun.DropSun;
import src.Game.Shovel;
import src.Game.Zombies.Zombie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Config {
    // Variables
    private static Random random;
    private static List<Plant> listPlants;
    private static List<Zombie> listZombies;
    private static Shovel shovel;
    private static CardPlants cardPlants;
    private static DropSun dropSun;

    // Handle the singleton pattern
    public static Random getRandom() {
        if (random == null) {
            random = new Random();
        }
        return random;
    }
    public static List<Plant> getListPlants() {
        if (listPlants == null) {
            listPlants = Collections.synchronizedList(new ArrayList<Plant>());
        }
        return listPlants;
    }
    public static List<Zombie> getListZombies() {
        if (listZombies == null) {
            listZombies = Collections.synchronizedList(new ArrayList<Zombie>());
        }
        return listZombies;
    }
    public static Shovel getShovel() {
        if (shovel == null) {
            shovel = new Shovel();
        }
        return shovel;
    }
    public static CardPlants getCardPlants() {
        if (cardPlants == null) {
            cardPlants = new CardPlants();
        }
        return cardPlants;
    }
    public static DropSun getDropSun() {
        if (dropSun == null) {
            dropSun = new DropSun();
        }
        return dropSun;
    }
}
