package src.Utils;

public class LaneToLayoutY {
    // Lấy ra vị trí điểm rơi y với mỗi lane tương ứng truyền vào
    public static int sunGetLayoutY(int lane) {
        switch (lane) {
            case 0:
                return 140; // x0 : 315  320 - 85
            case 1:
                return 240;
            case 2:
                return 340;
            case 3:
                return 440;
            case 4:
                return 540;
            default:
                return 0;
        }
    }
    public static int zombieGetLayoutY(int lane) {
        switch (lane) {
            case 0:
                return 35;
            case 1:
                return 135;
            case 2:
                return 235;
            case 3:
                return 335;
            case 4:
                return 435;
            default:
                return 0;
        }
    }
    public static int lawnMowerGetLayoutY(int lane) {
        switch (lane) {
            case 0:
                return 80;
            case 1:
                return 180;
            case 2:
                return 280;
            case 3:
                return 380;
            case 4:
                return 480;
            default:
                return 0;
        }
    }
}
