package src.Help.CardPlants;

import javafx.scene .Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import src.Controller.GameMainController;
import src.Help.Shovel.Shovel;

public class CardPlant {
    // Var
    private final static int width = 105;
    private final static int height = 67;
    private final static int fitWidth = 85;
    private final static int fitHeight = 50;

    private ImageView imageView;
    private Image image;
    private double x, y;
    private boolean haveBuy = true;
    private String path;
    private String name;
    private HandleCardPlant handleCardPlant = new HandleCardPlant(this);

    // Constructor
    public CardPlant() {
        super();
    }
    public CardPlant(String path, String name) {
        super();
        this.path = path;
        this.name = name;
    }

    public CardPlant(double x, double y, String path, String name) {
        super();
        this.x = x;
        this.y = y;
        this.path = path;
        this.name = name;
    }
    // Method
    public void createImage() {
        handleCardPlant.creatImageView();
    }
    // Set time out to buy Plant
    public void setTimeOutToBuyPlant(int time) {
        handleCardPlant.setTimeOutBuyPlant(time);
    }
    // To string
    @Override
    public String toString() {
        return "CardPlant{" +
                "x=" + x +
                ", y=" + y +
                ", haveBuy=" + haveBuy +
                ", path='" + path + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    // Getter and Setter
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isHaveBuy() {
        return haveBuy;
    }

    public void setHaveBuy(boolean haveBuy) {
        this.haveBuy = haveBuy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
    public static int getWidth() {
        return width;
    }
    public static int getHeight() {
        return height;
    }
    public static int getFitWidth() {
        return fitWidth;
    }
    public static int getFitHeight() {
        return fitHeight;
    }
}
