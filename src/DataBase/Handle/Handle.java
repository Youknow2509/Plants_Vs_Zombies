package src.DataBase.Handle;

import src.Model.GameData;

public interface Handle {
    GameData load();
    void save();
    void update();
    void delete();
}
