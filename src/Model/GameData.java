package src.Model;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import src.Utils.Game.Level.ZombieSpawner;
import src.Model.Plants.Plant;
import src.Model.Zombies.Zombie;

public class GameData {
    // Var
    private List<String> cardPlantList = null;
    private List<Plant> listPlant = null;
    private List<Zombie> zombieAlive = null;
    private List<ZombieSpawner> zombieSpawner = null;
    private int sun = 0;
    private int tick = 0;
    private int durationDropSun = 0;
    // Construct
    public GameData() {
        super();
        this.cardPlantList = new ArrayList<String>();
        this.listPlant = Collections.synchronizedList(new ArrayList<Plant>()); // Xử dụng Collections.synchronizedList để đồng bộ dữ liệu 
        this.zombieAlive = Collections.synchronizedList(new ArrayList<Zombie>());;
        this.zombieSpawner = Collections.synchronizedList(new ArrayList<ZombieSpawner>());;
    }
    public GameData(List<String> cardPlantList, List<Plant> listPlant, List<Zombie> zombieAlive
            , List<ZombieSpawner> zombieSpawner, int sun, int tick, int durationDropSun) {
        super();
        this.cardPlantList = cardPlantList;
        this.listPlant = listPlant;
        this.zombieAlive = zombieAlive;
        this.zombieSpawner = zombieSpawner;
        this.sun = sun;
        this.tick = tick;
        this.durationDropSun = durationDropSun;
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
    public List<String> getcardPlantList() {
        return cardPlantList;
    }
    public void setcardPlantList(List<String> cardPlantList) {
        this.cardPlantList = cardPlantList;
    }
    public int getDurationDropSun() {
        return durationDropSun;
    }
    public void setDurationDropSun(int durationDropSun) {
        this.durationDropSun = durationDropSun;
    }

}
