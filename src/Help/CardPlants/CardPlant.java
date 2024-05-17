package src.Help.CardPlants;

import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import src.Controller.Game.GameMainController;

import java.io.Serial;
import java.io.Serializable;

public class CardPlant implements Serializable {
    // SerialVersionUID
    @Serial
    private static final long serialVersionUID = 1L;
    // Var
    private final static int width = 105;
    private final static int height = 67;
    private final static int fitWidth = 85;
    private final static int fitHeight = 50;

    private transient ImageView imageView;
    private transient Image image;
    private double x, y;
    private boolean haveBuy = true; // True: have buy, False: haven't buy
    private String path;
    private String name;
    private int timeBuy;
    private double opacity = 0.6;
    private int cost;
    private HandleCardPlant handleCardPlant = new HandleCardPlant(this);

    // Constructor
    public CardPlant() {
        super();
    }
    public CardPlant(String path, String name, int cost) {
        super();
        this.path = path;
        this.name = name;
        this.cost = cost;
    }

    public CardPlant(double x, double y, String path, String name, int cost) {
        super();
        this.x = x;
        this.y = y;
        this.path = path;
        this.name = name;
        this.cost = cost;
    }

    // Method
    public void createImage() {
        handleCardPlant.creatImageView();
    }
    // Set time out to buy Plant
    public void setTimeOutToBuyPlant(int time) {
        handleCardPlant.setTimeOutBuyPlant(time);
        this.timeBuy = time;
    }

    // Lock card
    public void lockCard() {
        if (imageView != null) {
            imageView.setOpacity(0.6);
            imageView.setDisable(true);
        }
    }

    // Unlock card
    public void unlockCard() {
        if (imageView != null) {
            imageView.setOpacity(1);
            imageView.setDisable(false);
        }
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
    public HandleCardPlant getHandleCardPlant() {
        return handleCardPlant;
    }

    public void setHandleCardPlant(HandleCardPlant handleCardPlant) {
        this.handleCardPlant = handleCardPlant;
    }

    public double getOpacity() {
        return opacity;
    }

    public void setOpacity(double opacity) {
        this.opacity = opacity;
        this.imageView.setOpacity(opacity);
    }

    public int getTimeBuy() {
        return timeBuy;
    }

    public void setTimeBuy(int timeBuy) {
        this.timeBuy = timeBuy;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
