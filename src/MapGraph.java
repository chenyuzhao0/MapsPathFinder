import java.sql.Array;
import java.util.*;

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

    public List<Intersection> findFastestRoute(Intersection start, Intersection end){
        HashMap<Intersection,Integer> distances = new HashMap<>();

        HashMap<Intersection,Intersection> previousNodes = new HashMap<>();

        PriorityQueue<Intersection> queue = new PriorityQueue<>(
                Comparator.comparingInt(node->distances.get(node)));

        distances.put(start, 0);
        queue.add(start);

        while(!queue.isEmpty()){
            Intersection current = queue.poll();
            for(int i = 0; i<current.getRoads().size();i++) {
                Road road = current.getRoads().get(i);
                Intersection neighbor = road.getEnd();
                int proposedTime = distances.get(current) + road.getSeconds();
                if (!distances.containsKey((neighbor)) || proposedTime < distances.get(neighbor)) {
                    distances.put(neighbor, proposedTime);
                    previousNodes.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        List<Intersection> path = new ArrayList<>();
        Intersection tracker = end;
        while(tracker != null){
            path.add(tracker);
            tracker = previousNodes.get(tracker);
        }
        Collections.reverse(path);
        return path;
    }
}
