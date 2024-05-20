package src.Help.FlagGameMain;

import src.Config.Path;
import src.Model.GameElements;

public class FlagGameMain extends GameElements {

    // Var final
    public final static int WIDTH = 30;
    public final static int HEIGHT = 25;
    public final static double Y = 4;

    // Var


    // Constructor
    public FlagGameMain() {
        super();
    }

    public FlagGameMain(double x) {
        super(x, Y, Path.ASSETS_Image_Flag, WIDTH, HEIGHT, -1);
    }

    // Getter - Setter

}
