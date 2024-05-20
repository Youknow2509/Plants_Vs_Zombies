package src.Utils;

import java.io.File;
import java.io.IOException;

public class FindFileinFolder {
    // Var
    private String pathToFolder;
    private String fileName;

    // Xử dụng để tìm kiếm tệp trong thư mục
    public static File findFile(String pathToFolder, String fileName) {
        File folder = new File(pathToFolder);
        File file = null;

        try {
            // Kiểm tra nếu folder không tồn tại hoặc không phải là thư mục
            if (!folder.exists() || !folder.isDirectory()) {
                throw new IOException("Thư mục không hợp lệ: " + pathToFolder);
            }

            File[] listOfFiles = folder.listFiles();

            if (listOfFiles == null) {
                throw new IOException("Không thể liệt kê các tệp trong thư mục: " + pathToFolder);
            }

            for (File f : listOfFiles) {
                if (f.isFile() && f.getName().equals(fileName)) {
                    file = f;
                    break;
                } else if (f.isDirectory()) {
                    file = findFile(f.getAbsolutePath(), fileName);
                    if (file != null) {
                        break;
                    }
                }
            }
        } catch (IOException e) {
            // In ra thông báo lỗi và trả về null
            System.err.println("Đã xảy ra lỗi: " + e.getMessage());
        }

        return file;
    }
}
