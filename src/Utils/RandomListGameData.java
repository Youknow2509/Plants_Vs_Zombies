package src.Utils;

import src.Model.GameData;
import src.Model.GameProcess;

import java.util.List;

public class RandomListGameData {

    public static GameProcess randomGameProcess(List<GameProcess> gameDataList) {
        int index = (int) (Math.random() * gameDataList.size());
        return gameDataList.get(index);
    }
    public static GameData randomGameData(List<GameData> gameDataList) {
        int index = (int) (Math.random() * gameDataList.size());
        return gameDataList.get(index);
    }
}
