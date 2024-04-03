package src.Help.CardPlants;

import java.util.ArrayList;
import java.util.List;

public class FactoryCardPlant {
    // Var
    private final double  x = 36; // Tọa độ x 36
    private final double [] y = {90, 150, 210, 270, 330, 390, 450}; // Tọa độ y
    private List<CardPlant> listCardPlant;
    private String [] pathCardPlant;

    // Constructor
    public FactoryCardPlant() {
        super();
        listCardPlant = new ArrayList<CardPlant>();
    }
    public FactoryCardPlant(String [] pathCardPlant) {
        super();
        this.pathCardPlant = pathCardPlant;
        listCardPlant = new ArrayList<CardPlant>();
    }

    // Method
    // Tao cac the cay
    public void createCardPlant() {
        for (int i = 0; i < pathCardPlant.length; i++) {
            CardPlant cardPlant = new CardPlant(x, y[i], pathCardPlant[i]);
            cardPlant.createImage();

            listCardPlant.add(cardPlant);
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
