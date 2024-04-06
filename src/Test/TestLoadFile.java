package src.Test;

import src.DataBase.Handle.Handle;
import src.DataBase.Handle.HandleLoadLevel;
import src.Model.GameData;

import java.util.Scanner;

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
        int level = 0;
        Scanner scanner = new Scanner(System.in);
        level = scanner.nextInt();
        HandleLoadLevel handleLoadLevel = new HandleLoadLevel(level);
        GameData gameData = handleLoadLevel.loadLevel();

        showGameData(gameData);

        scanner.close();
        return;
    }
}
