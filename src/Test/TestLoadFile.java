package src.Test;

import src.DataBase.Handle.Handle;
import src.DataBase.Handle.HandleLoadLevel;
import src.Model.GameData;

public class TestLoadFile {

    private static void showGameData(GameData gameData) {
        System.out.println("Sun: " + gameData.getSun());
        System.out.println("Tick: " + gameData.getTick());
        System.out.println("Duration Drop Sun: " + gameData.getDurationDropSun());
        System.out.println("Card Plant List: ");
        gameData.getCardPlantList().forEach(cardPlant -> {
            System.out.println(cardPlant);
        });
        System.out.println("Zombie Spawner List: ");
        gameData.getZombieSpawner().forEach(zombieSpawner -> {
            System.out.println(zombieSpawner.getZombie().getPath() + " " + zombieSpawner.getTime() + " ");
        });
    }
    public static void main(String [] args) {
        System.out.println("Test Load File");
        HandleLoadLevel handleLoadLevel = new HandleLoadLevel(1);
        GameData gameData = handleLoadLevel.loadLevel();

        showGameData(gameData);

        return;

    }
}
