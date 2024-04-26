package src.DataBase.Handle;

import src.Help.CardPlants.FactoryListCardPlant;
import src.Help.LawnMower.FactoryLawnMower;
import src.Model.GameData;
import src.Help.CardPlants.FactoryCardPlant;
import src.Model.ZombieSpawner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class HandleDataFile implements HandleData {
    // Var
    private String pathDataSave = "src/DataBase/";
    private int maxLevel = 2;
    //

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
        return List.of();
    }

    @Override
    public void addDataSave(GameData gameData) {

    }

    @Override
    public void addDataLevel(GameData gameData) {

    }

    @Override
    public void updateDataLevel(GameData gameData) {

    }

    @Override
    public void updateDataSave(GameData gameData) {

    }

    @Override
    public void deleteDataSave(GameData gameData) {

    }

    @Override
    public void deleteDataLevel(GameData gameData) {

    }

    @Override
    public int getIDMaxDataSave() {
        return 0;
    }

    // Main test
    public static void main(String [] arg) {
        HandleDataFile handleDataFile = new HandleDataFile();
        List<GameData> listGameData = handleDataFile.getDatalevel(1);
        for (GameData gameData : listGameData) {
            System.out.println(gameData);
        }
    }
}
