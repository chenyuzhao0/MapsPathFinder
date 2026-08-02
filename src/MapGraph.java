import java.util.HashMap;

public class MapGraph {
    private HashMap<Integer,Intersection> graph;

    public MapGraph(){
        this.graph = new HashMap<>();
    }

    public Intersection addIntersection(int id){
        Intersection inter = new Intersection(id);
        this.graph.put(id,inter);
        return inter;
    }
    public Road connectRoad(Intersection start, Intersection end, int seconds, int distanceInMeters){
        Road road = new Road(seconds,distanceInMeters,start,end);
        start.addRoad(road);
        end.addRoad(road);
        return road;
    }
}
