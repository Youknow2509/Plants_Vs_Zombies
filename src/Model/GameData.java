package src.Model;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import src.Help.CardPlants.CardPlant;
import src.Help.LawnMower.LawnMower;
import src.Model.Plants.Plant;
import src.Model.Plants.Sun.DropSun;
import src.Model.Zombies.Zombie;

public class GameData {
// Var
    private static final long serialVersionUID = 1L;
    private int ID;
    private List<CardPlant> cardPlantList = null;
    private List<Plant> listPlant = null;
    private List<Zombie> zombieAlive = null;
    private List<ZombieSpawner> zombieSpawner = null;
    private List<LawnMower> lawnMowers = null;
    private DropSun dropSun = null;
    private int sun = 0;
    private int tick = 0;
    private int durationDropSun = 0;
    private int sumZombie = 0;
// Construct
    public GameData() {
        super();
        this.cardPlantList = new ArrayList<CardPlant>();
        this.listPlant = Collections.synchronizedList(new ArrayList<Plant>()); // Xử dụng Collections.synchronizedList để đồng bộ dữ liệu 
        this.zombieAlive = Collections.synchronizedList(new ArrayList<Zombie>());;
        this.zombieSpawner = Collections.synchronizedList(new ArrayList<ZombieSpawner>());
        this.lawnMowers = new ArrayList<LawnMower>();
        this.dropSun = new DropSun();
    }
    public GameData(List<CardPlant> cardPlantList, List<Plant> listPlant, List<Zombie> zombieAlive
            , List<ZombieSpawner> zombieSpawner, List<LawnMower> lawnMowers, int sun, int tick, int durationDropSun) {
        super();
        this.cardPlantList = cardPlantList;
        this.listPlant = listPlant;
        this.zombieAlive = zombieAlive;
        this.zombieSpawner = zombieSpawner;
        this.sun = sun;
        this.tick = tick;
        this.durationDropSun = durationDropSun;
        this.lawnMowers = lawnMowers;
        this.dropSun = new DropSun();
        loadSumZombie();
    }

    // Thêm cây
    public void addPlant(Plant p) {
        listPlant.add(p);
    }

    // Xoá cây
    public void remotePlant(Plant p) {
        listPlant.remove(p);
    }

    // Thêm Zombie vào game
    public void addZombieAlive(Zombie z) {
        zombieAlive.add(z);
    }

    // Xoá Zombie tồn tại - Zombie chết
    public void remoteZombieAlive(Zombie z) {
        zombieAlive.remove(z);
    }

    // Thêm Zombie vào hàng đợi
    public void addZombieSpawner(ZombieSpawner z) {
        zombieSpawner.add(z);
    }

    // Xoá Zombie hàng đợi
    public void remoteZombieSpawner(ZombieSpawner z) {
        zombieSpawner.remove(z);
    }

    // Lấy ra tổng số Zombie
    public void loadSumZombie() {
        this.sumZombie = zombieAlive.size() + zombieSpawner.size();
    }

    // To String


    @Override
    public String toString() {
        return "GameData{" +
                "ID=" + ID +
                "\n, cardPlantList=" + cardPlantList +
                "\n, listPlant=" + listPlant +
                "\n, zombieAlive=" + zombieAlive +
                "\n, zombieSpawner=" + zombieSpawner +
                "\n, lawnMowers=" + lawnMowers +
                "\n, dropSun=" + dropSun +
                "\n, sun=" + sun +
                "\n, tick=" + tick +
                "\n, durationDropSun=" + durationDropSun +
                "\n, sumZombie=" + sumZombie +
                '}';
    }

    // Getter and setter
    public List<Plant> getListPlant() {
        return listPlant;
    }
    public void setListPlant(List<Plant> listPlant) {
        this.listPlant = listPlant;
    }
    public List<Zombie> getZombieAlive() {
        return zombieAlive;
    }
    public void setZombieAlive(List<Zombie> zombieAlive) {
        this.zombieAlive = zombieAlive;
    }
    public List<ZombieSpawner> getZombieSpawner() {
        return zombieSpawner;
    }
    public void setZombieSpawner(List<ZombieSpawner> zombieSpawner) {
        this.zombieSpawner = zombieSpawner;
    }
    public int getSun() {
        return sun;
    }
    public void setSun(int sun) {
        this.sun = sun;
    }
    public int getTick() {
        return tick;
    }
    public void setTick(int tick) {
        this.tick = tick;
    }
    public int getDurationDropSun() {
        return durationDropSun;
    }
    public void setDurationDropSun(int durationDropSun) {
        this.durationDropSun = durationDropSun;
    }

    public List<CardPlant> getCardPlantList() {
        return cardPlantList;
    }

    public void setCardPlantList(List<CardPlant> cardPlantList) {
        this.cardPlantList = cardPlantList;
    }

    public DropSun getDropSun() {
        return dropSun;
    }
    public void setDropSun(DropSun dropSun) {
        this.dropSun = dropSun;
    }

    public int getSumZombie() {
        return sumZombie;
    }

    public void setSumZombie(int sumZombie) {
        this.sumZombie = sumZombie;
    }

    public List<LawnMower> getLawnMowers() {
        return lawnMowers;
    }

    public void setLawnMowers(List<LawnMower> lawnMowers) {
        this.lawnMowers = lawnMowers;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

}
