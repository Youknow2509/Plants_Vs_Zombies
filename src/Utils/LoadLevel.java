package src.Utils;

import src.Model.GameData;
import src.Model.Zombie.NormalZombie;
import src.Model.Zombie.ZombieSpawner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class LoadLevel {
    // Variables
    private String path = "";//"/src/DataBase/Levels/";
    private GameData gameData = null;
    private BufferedReader bufferedReader = null;
    private FileReader fileReader = null;
    private String line = null;
    // Constructor
    public LoadLevel(String path) {
        this.path = path;
        gameData = new GameData();
    }
    // Read file level
    public void read() {
        try {
            fileReader = new FileReader(path);
            bufferedReader = new BufferedReader(fileReader);

            line = bufferedReader.readLine();
            List<String> listCard = Arrays.asList(line.split(", "));
            gameData.setListCardPlant(listCard);

            line = bufferedReader.readLine();
            gameData.setSun(Integer.parseInt(line));

            while ((line = bufferedReader.readLine()) != null) {
                String [] list = line.split(", ");
                gameData.getZombieSpawner().add(new ZombieSpawner(Integer.parseInt(list[0]), Integer.parseInt(list[1]), list[2]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        sortListZombieSpawner();
        gameData.setTick(0);
    }
    // Sort list zombie spawner
    public void sortListZombieSpawner() {
        // Sắp xếp lại thứ tự của zombieSpawners theo thời gian
        Collections.sort(gameData.getZombieSpawner(), new Comparator<ZombieSpawner>() {
            @Override
            public int compare(ZombieSpawner o1, ZombieSpawner o2) {
                return (o1.getTime() - o2.getTime());
            }
        });
    }

    // gettter and setter

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public GameData getGameData() {
        return gameData;
    }

    public void setGameData(GameData gameData) {
        this.gameData = gameData;
    }
}

