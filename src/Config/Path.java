package src.Config;

public class Path {
    // View
    public static final String VIEW_GameMain = "/src/View/Game/GameMain.fxml";
    public static final String VIEW_GameMenu = "/src/View/Game/MenuGame.fxml";
    public static final String VIEW_Home = "/src/View/Home/Home.fxml";
    public static final String VIEW_ListGameSave = "/src/View/LoadData/ListGameSave.fxml";
    public static final String VIEW_EditGameSave = "/src/View/LoadData/EditGameSave.fxml";
    public static final String VIEW_Level = "/src/View/Level/Level.fxml";
    public static final String VIEW_GameWin = "/src/View/Game/GameWin.fxml";
    public static final String VIEW_GameLose = "/src/View/Game/GameLose.fxml";

    // CSS
    public static final String CSS_GameMenu = "/src/Assets/css/MenuGame.css";

    // Controller
    public static final String CONTROLLER_GameMain = "/src/Controller/Game/GameMainController.java";
    public static final String CONTROLLER_GameMenu = "/src/Controller/Game/MenuGameController.java";

    // Assets
    public static final String ASSETS_Images = "/src/Assets/images/";

    // Assets - Images Plants
    public static final String ASSETS_Image_Pea = "/Assets/images/items/Pea.png";
    public static final String ASSETS_Image_PeaShooter = "/Assets/images/Plants/Peashooter.gif";
    public static final String ASSETS_Image_Repeater = "/Assets/images/Plants/Repeater.gif";
    public static final String ASSETS_Image_Sun = "/Assets/images/items/Sun.png";
    public static final String ASSETS_Image_SunFlower = "/Assets/images/Plants/SunFlower.gif";
    public static final String ASSETS_Image_Wallnut = "/Assets/images/Plants/Wallnut.gif";
    public static final String ASSETS_Image_WallNut2 = "/Assets/images/Plants/Wallnut.gif"; // gif wallnut bị ăn khi máu <= 2667
    public static final String ASSETS_Image_WallNut3 = "/Assets/images/Plants/Wallnut.gif"; // gif wallnut bị ăn khi máu <= 1334

    // Assets - Images Zombies
    public static final String ASSETS_Image_NormalZombie_Run = "/Assets/images/Zombies/NormalZombieRun.gif";
    public static final String ASSETS_Image_NormalZombie_Eat = "/Assets/images/Zombies/NormalZombieEat.gif";
    public static final String ASSETS_Image_ConeheadZombie_Run = "/Assets/images/Zombies/NormalZombieRun.gif"; // todo chua co dung tam
    public static final String ASSETS_Image_ConeheadZombie_Eat = "/Assets/images/Zombies/NormalZombieRun.gif"; // todo chua co dung tam
    public static final String ASSETS_Image_FlagZombie_Run = "/Assets/images/Zombies/FlagZombie.gif"; // todo add
    public static final String ASSETS_Image_FlagZombie_Eat = "/Assets/images/Zombies/FlagZombie.gif"; // todo add
    // Assets - Images Cards
    public static final String ASSETS_Image_Card_SunFlower = "/Assets/images/Cards/SunFlower.png";
    public static final String ASSETS_Image_Card_PeaShooter = "/Assets/images/Cards/PeaShooter.png";
    public static final String ASSETS_Image_Card_WallNut = "/Assets/images/Cards/WallNut.png";

    public static final String ASSETS_Image_Card_Repeater = "/Assets/images/Cards/Repeater.png";

    // Assets - Images Items
    public static final String ASSETS_Image_LawnMower = "/Assets/images/items/lawnMower_Idle.gif"; // todo sua net hon
    public static final String ASSETS_Image_LawnMower_Active = "/Assets/images/items/lawnMower_Active.gif"; // todo sua net hon
    public static final String ASSETS_Image_Shovel = "/Assets/images/items/Shovel.png";
}
