package main;

import java.util.*;

//this class is the map where we do all the logic and where we operate
public class MapGraph {
    //the map its made up of intersections and the integer is for their
    //identification
    private HashMap<Integer, Intersection> graph;

    //the map is empty at first so then we can add everything it has
    public MapGraph(){
        this.graph = new HashMap<>();
    }

    //to add in the map its intersections giving an id
    public Intersection addIntersection(int id){
        //every intersection is identified with an id
        Intersection inter = new Intersection(id);
        //to add in the map an intersection
        this.graph.put(id,inter);
        //intersection created so we return it
        return inter;
    }

    //to connect one intersection with another
    public void connectRoad(Intersection start, Intersection end, int seconds, int distanceInMeters){
        //to add a road from the start point to the destination
        Road wayThere = new Road(seconds,distanceInMeters,start,end);
        start.addRoad(wayThere);

        //to add the road from the end to the start, since we reach the end
        //and we have to go back
        Road wayBack = new Road(seconds, distanceInMeters, end, start);
        end.addRoad(wayBack);
    }

    //the Dijkstra algorithm method to know the fastest way
    public List<Intersection> findFastestRoute(Intersection start, Intersection end){
        //
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
