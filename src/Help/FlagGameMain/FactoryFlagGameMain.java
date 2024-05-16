package src.Help.FlagGameMain;

import src.Model.GameData;

import java.util.List;

public class FactoryFlagGameMain {

    // Variables

    //
    public static void creat(List<Double> listPercent) {
        for (double p : listPercent) {
            FlagGameMain flagGameMain = new FlagGameMain(
                    percentToLocation(p)
            );
            flagGameMain.createImageView();
        }
    }

    // Percent to location in screen
    private static double percentToLocation(double percent) {
        // LayOutXStart : 199 to LayOutXEnd : 398
        return 199 + percent * (398 - 199);
    }
}
