package src.Utils;

import src.Model.GameData;

import java.util.List;

public class RandomListGameData {
    public static GameData random(List<GameData> gameDataList) {
        int index = (int) (Math.random() * gameDataList.size());
        return gameDataList.get(index);
    }
}
