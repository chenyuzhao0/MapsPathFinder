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
        //to know the total distance we have already taken
        HashMap<Intersection,Integer> distances = new HashMap<>();
        //to remember the intersections we went, so register the current and the last
        HashMap<Intersection,Intersection> previousNodes = new HashMap<>();
        //we make a queue so the lowest node given to the comparator is at the first position
        PriorityQueue<Intersection> queue = new PriorityQueue<>(
                Comparator.comparingInt(node->distances.get(node)));
        //initialize the start point distance to 0
        distances.put(start, 0);
        //adding in the queue the first intersection where all begins
        queue.add(start);
        //move through the queue until the queue becomes empty starting with the lowest distance
        while(!queue.isEmpty()){
            //the fastest intersection of the queue and then we remove it
            Intersection current = queue.poll();
            //loop to go throw the roads that the intersection has inside it
            for(int i = 0; i<current.getRoads().size();i++) {
                //to know in which road we are
                Road road = current.getRoads().get(i);
                //to know to which intersection we can reach at the end of the current road we are
                Intersection neighbor = road.getEnd();
                //calculating the time adding the current time we have till now
                int proposedTime = distances.get(current) + road.getSeconds();
                //we have to check if this the time is registered or if the time we have
                //is bigger than the time we calculated now
                if (!distances.containsKey((neighbor)) || proposedTime < distances.get(neighbor)) {
                    //to the time we have accumulated, we register the
                    //intersection we are and the time it takes us
                    distances.put(neighbor, proposedTime);
                    //register the new node we are currently and the previous one
                    previousNodes.put(neighbor, current);
                    //since it is shorter time, we add the node to the queue
                    queue.add(neighbor);
                }
            }
        }
        //we have the path made, but now we have to know where did we go
        //so we have to go backwards to the path we just made
        List<Intersection> path = new ArrayList<>();
        //we start the cursor at the end
        Intersection tracker = end;
        while(tracker != null){
            //we are adding all the nodes we went
            path.add(tracker);
            //we move the cursor backwards through all the
            //nodes we went registered in the previousNodes
            tracker = previousNodes.get(tracker);
        }
        //now the path we have starts from the end, but we need to
        //know how to go in the start so we reverse it
        Collections.reverse(path);
        //the leet the user see the entire fastest route to the destination
        return path;
    }
}
