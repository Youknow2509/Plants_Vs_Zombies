package src.DataBase.Handle;

import src.Model.GameData;
import src.Model.GameProcess;

import java.util.List;

public interface HandleData {
    // Lấy dữ liệu từ level
    List<GameData> getDatalevel(int level);

    // Lấy dữ liệu từ save Game
    List<GameProcess> getDataSave();

    // Thêm dữ liệu vào save Game
    void addDataSave(GameProcess gameProcess);

    // Cập nhật dữ liệu save Game
    void updateDataSave(GameProcess gameProcess);

    // Xóa dữ liệu save Game
    void deleteDataSave(String nameSaveGame);

    // Lấy ID lớn nhất của save Game - dùng để tạo ID mới
    int getIDMaxDataSave();
}
