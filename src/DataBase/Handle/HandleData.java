package src.DataBase.Handle;

import src.Model.GameData;

import java.util.List;

public interface HandleData {
    List<GameData> getDatalevel(int level);
    List<GameData> getDataSave();
    void addDataSave(GameData gameData);
    void updateDataSave(GameData gameData);
    void deleteDataSave(GameData gameData);
    int getIDMaxDataSave();
}
