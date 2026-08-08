package main;
import java.util.ArrayList;
import java.util.List;

public class Intersection {
    //every intersection needs to be distinguished and unique
    private int id;

    //all the roads/directions an intersection has
    private List<Road> roads;

    //to build the actual intersection
    public Intersection(int id){
        //use the id they gave you
        this.id = id;
        //empty roads of an id so then I can add the roads of the intersection
        this.roads =  new ArrayList<>();
    }

    //the roads of an Intersection are empty. Now add whatever roads can an id reach.
    public void addRoad(Road road){
        this.roads.add(road);
    }

    //to know all the roads an id has
    public List<Road> getRoads() {
        return roads;
    }

    //know the id
    public int getId(){
        return id;
    }
}
