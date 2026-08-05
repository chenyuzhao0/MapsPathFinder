package main;
import java.util.ArrayList;
import java.util.List;

public class Intersection {
    private int id;

    private List<Road> roads;

    public Intersection(int id){
        this.id = id;
        this.roads =  new ArrayList<>();
    }

    public void addRoad(Road road){
        this.roads.add(road);
    }

    public List<Road> getRoads() {
        return roads;
    }
    public int getId(){
        return id;
    }
}
