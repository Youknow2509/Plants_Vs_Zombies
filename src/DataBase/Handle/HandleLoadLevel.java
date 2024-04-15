package src.DataBase.Handle;

import src.Help.CardPlants.FactoryListCardPlant;
import src.Help.LawnMower.FactoryLawnMower;
import src.Model.GameData;
import src.Model.ZombieSpawner;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class HandleLoadLevel {
    // Var
    private int level;
    // Constructor
    public HandleLoadLevel() {
        super();
    }
    public HandleLoadLevel(int level) {
        super();
        this.level = level;
    }
    // Method
    // Load Level
    public GameData loadLevel() {

        String path = "src/DataBase/Levels/Level_" + level;
        GameData gameData = new GameData();
        BufferedReader bufferedReader = null;
        FileReader fileReader = null;
        File folder = null;
        File file = null;
        try {
            folder = new File(path);
            file = randomFile(folder);
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = null;
            String [] lLine = null;
            // Load Sun, Tick, DurationDropSun
            line = bufferedReader.readLine();
            lLine = line.split(", ");
            if (lLine.length == 3) {
                gameData.setSun(Integer.parseInt(lLine[0]));
                gameData.setTick(Integer.parseInt(lLine[1]));
                gameData.setDurationDropSun(Integer.parseInt(lLine[2]));
            }
            // Load CardPlant
            line = bufferedReader.readLine();
            lLine = line.split(", ");
            if (lLine.length > 0) {
                FactoryListCardPlant factoryListCardPlant = new FactoryListCardPlant(lLine);
                factoryListCardPlant.createListCardPlant();
                gameData.setCardPlantList(factoryListCardPlant.getListCardPlant());
            }
            // Load ZombieSpawner
            line = bufferedReader.readLine();
            int countZombieSpawner = Integer.parseInt(line);
            while (countZombieSpawner > 0 && (line = bufferedReader.readLine()) != null) {
                countZombieSpawner--;
                lLine = line.split(", ");
                if (lLine.length == 3) {
                    gameData.addZombieSpawner(
                            new ZombieSpawner(Integer.parseInt(lLine[0]),
                                    Integer.parseInt(lLine[1]),
                                    lLine[2].toUpperCase())
                    );
                }
            }
            // Sort ZombieSpawner
            Collections.sort(gameData.getZombieSpawner(), new Comparator<ZombieSpawner>() {
                @Override
                public int compare(ZombieSpawner o1, ZombieSpawner o2) {
                    return o1.getTime() - o2.getTime();
                }
            });
            // Load LawnMower
            line = bufferedReader.readLine();
            lLine = line.split(", ");
            for (int i = 0; i < lLine.length; i++) {
                gameData.getLawnMowers().add(FactoryLawnMower.createLawnMower(Integer.parseInt(lLine[i])));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gameData;
    }

    // Random file
    private File randomFile(File file) {
        File [] lFIle = file.listFiles();
        Random random = new Random();
        int index = random.nextInt(lFIle.length);
        return lFIle[index];
    }
    // Getter and Setter

}
