package src.Config;

import java.util.Random;

// Singleton class
public class Config {
    // Variables
    private static Random random = null;

    //
    public static Random getRandom() {
        if (random == null) {
            random = new Random();
        }
        return random;
    }
}
