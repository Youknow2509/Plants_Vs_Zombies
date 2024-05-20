package src.Utils;

import src.Model.GameData;
import src.Model.GameProcess;

import java.util.List;

public class RandomListGameData {

    // Random GameProcess from List
    public static GameProcess randomGameProcess(List<GameProcess> gameDataList) {
        int index = (int) (Math.random() * gameDataList.size());
        return gameDataList.get(index);
    }

    // Random GameData from List
    public static GameData randomGameData(List<GameData> gameDataList) {
        int index = (int) (Math.random() * gameDataList.size());
        return gameDataList.get(index);
    }
}
