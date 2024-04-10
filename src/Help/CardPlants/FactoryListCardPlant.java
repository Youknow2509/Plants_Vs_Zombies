package src.Help.CardPlants;

import java.util.ArrayList;
import java.util.List;

public class FactoryListCardPlant {
    // Var
    private final double  x = 36; // Tọa độ x 36
    private final double [] y = {90, 150, 210, 270, 330, 390, 450}; // Tọa độ y
    private List<CardPlant> listCardPlant;
    private String [] pathCardPlant;

    // Constructor
    public FactoryListCardPlant() {
        super();
        listCardPlant = new ArrayList<CardPlant>();
    }
    public FactoryListCardPlant(String [] pathCardPlant) {
        super();
        this.pathCardPlant = pathCardPlant;
        listCardPlant = new ArrayList<CardPlant>();
    }

    // Method
    // Them the cay vao list
    public void createCardPlant() {
        for (int i = 0; i < pathCardPlant.length; i++) {
            CardPlant cardPlant = FactoryCardPlant.createCardPlant(pathCardPlant[i]);
            cardPlant.setX(x);
            cardPlant.setY(y[i]);
            listCardPlant.add(cardPlant);
        }
    }
    // Tao anh the cay
    public void createImageCardPlant() {
        for (CardPlant cardPlant : listCardPlant) {
            cardPlant.createImage();
        }
    }
    // Getter and Setter
    public double getX() {
        return x;
    }

    public double[] getY() {
        return y;
    }

    public List<CardPlant> getListCardPlant() {
        return listCardPlant;
    }

    public void setListCardPlant(List<CardPlant> listCardPlant) {
        this.listCardPlant = listCardPlant;
    }

    public String[] getPathCardPlant() {
        return pathCardPlant;
    }

    public void setPathCardPlant(String[] pathCardPlant) {
        this.pathCardPlant = pathCardPlant;
    }
}
