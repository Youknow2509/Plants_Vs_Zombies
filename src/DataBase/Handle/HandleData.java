package src.DataBase.Handle;

import src.Model.GameData;

import java.util.List;

public interface HandleData {
    // Lấy dữ liệu từ level
    List<GameData> getDatalevel(int level);

    // Lấy dữ liệu từ save Game
    List<GameData> getDataSave();

    // Thêm dữ liệu vào save Game
    void addDataSave(GameData gameData);

    // Thêm dữ liệu vào level
    void addDataLevel(GameData gameData);

    // Cập nhật dữ liệu level
    void updateDataLevel(GameData gameData);

    // Cập nhật dữ liệu save Game
    void updateDataSave(GameData gameData);

    // Xóa dữ liệu save Game
    void deleteDataSave(GameData gameData);

    // Xóa dữ liệu level
    void deleteDataLevel(GameData gameData);

    // Lấy ID lớn nhất của save Game - dùng để tạo ID mới
    int getIDMaxDataSave();
}
