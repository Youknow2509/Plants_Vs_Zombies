package src.DataBase.Handle;

import src.Help.CardPlants.FactoryListCardPlant;
import src.Help.LawnMower.FactoryLawnMower;
import src.Model.GameData;
import src.Help.CardPlants.FactoryCardPlant;
import src.Model.ZombieSpawner;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HandleDataFile implements HandleData {
    // Var
    private String pathDataSave = "src/DataBase/";
    private int maxLevel = 0;

    // Constructor
    public HandleDataFile() {
        File folder = new File(pathDataSave + "Levels");
        if (!folder.exists()) {
            folder.mkdirs();
        }

        maxLevel = folder.listFiles().length;

        folder = new File(pathDataSave + "SaveGames");
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }

    // Implementation
    @Override
    public List<GameData> getDatalevel(int level) {
        if (level > maxLevel) return null;
        String pathFolder = pathDataSave + "Levels/Level_" + level;
        List<GameData> listGameData = new ArrayList<GameData>();

        File folder = new File(pathFolder);
        File[] listFile = folder.listFiles();
        for (File file : listFile) {
            BufferedReader br = null;
            FileReader fr = null;
            try {
                GameData gameDataAdd = new GameData();
                fr = new FileReader(file);
                br = new BufferedReader(fr);

                // Read Sun and Tick
                String [] Sun_Tic_GameDucation = br.readLine().split(", ");
                gameDataAdd.setSun(Integer.parseInt(Sun_Tic_GameDucation[0]));
                gameDataAdd.setTick(Integer.parseInt(Sun_Tic_GameDucation[1]));
                gameDataAdd.setDurationDropSun(Integer.parseInt(Sun_Tic_GameDucation[2]));

                // Read ListCard
                String [] ListCard = br.readLine().split(", ");
                FactoryListCardPlant factoryListCardPlant = new FactoryListCardPlant(ListCard);
                gameDataAdd.setCardPlantList(factoryListCardPlant.getListCardPlant());

                // Read ZombieSpawner
                int numberZombie = Integer.parseInt(br.readLine());
                for (int i = 0; i < numberZombie; i++) {
                    String [] ZombieSpawner = br.readLine().split(", ");
                    gameDataAdd.getZombieSpawner().add(
                            new ZombieSpawner(
                                    Integer.parseInt(ZombieSpawner[0]),
                                    Integer.parseInt(ZombieSpawner[1]),
                                    ZombieSpawner[2]
                            )
                    );
                }

                // Read ListLawnMower
                String [] ListLawnMower = br.readLine().split(", ");
                for (String lawnMower : ListLawnMower) {
                    gameDataAdd.getLawnMowers().add(
                            FactoryLawnMower.createLawnMower(Integer.parseInt(lawnMower)
                            ));
                }

                // Load sumZombie
                gameDataAdd.loadSumZombie();

                listGameData.add(gameDataAdd);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (br != null) br.close();
                    if (fr != null) fr.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return listGameData;
    }

    @Override
    public List<GameData> getDataSave() {
        String pathFolder = pathDataSave + "SaveGames";
        List<GameData> listGameData = new ArrayList<GameData>();

        File folder = new File(pathFolder);
        File[] listFile = folder.listFiles();
        for (File file : listFile) {
            FileInputStream fis = null;
            ObjectInputStream ois = null;
            try {
                fis = new FileInputStream(file);
                ois = new ObjectInputStream(fis);
                listGameData.add((GameData) ois.readObject());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (ois != null) ois.close();
                    if (fis != null) fis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return listGameData;
    }

    @Override
    public void addDataSave(GameData gameData, String nameSaveGame) {
        String pathFile = pathDataSave + "SaveGames/" + nameSaveGame + ".ser";

        File folder = new File(pathFile);
        if (folder.exists()) {
            System.out.println("File ton tai !!!");
            return;
        }
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(pathFile);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(gameData);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) oos.close();
                if (fos != null) fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void updateDataSave(GameData gameData, String nameSaveGame) {
        String pathFile = pathDataSave + "SaveGames/" + nameSaveGame + ".ser";

        File folder = new File(pathFile);
        if (!folder.exists()) {
            System.out.println("File khong ton tai !!!");
            return;
        }
        deleteDataSave(nameSaveGame);
        addDataSave(gameData, nameSaveGame);
    }

    @Override
    public void deleteDataSave(String nameSaveGame) {
        String pathFile = pathDataSave + "SaveGames/" + nameSaveGame + ".ser";

        File folder = new File(pathFile);
        if (!folder.exists()) {
            System.out.println("File khong ton tai !!!");
            return;
        }
        folder.delete();
    }

    @Override
    public int getIDMaxDataSave() {
        return 0;
    }


    // Getter - Setter
    public String getPathDataSave() {
        return pathDataSave;
    }

    public void setPathDataSave(String pathDataSave) {
        this.pathDataSave = pathDataSave;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }
}




