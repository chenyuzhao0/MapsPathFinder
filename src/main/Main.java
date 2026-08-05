package main;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {
    public static void main(String[] args) {
        Intersection id1 = new Intersection(1);
        Intersection id2 = new Intersection(2);
        Intersection id3 = new Intersection(3);

        Road road13 = new Road(100,500,id1,id3);
        Road road12 = new Road(10, 500,id1, id2);
        Road road23 = new Road(10, 500,id2, id3);

        id1.addRoad(road13);
        id1.addRoad(road12);
        id2.addRoad(road23);

        MapGraph path = new MapGraph();
        List<Intersection> result = path.findFastestRoute(id1,id3);

        assertEquals(3, result.size());
        assertEquals(result.get(0),id1);
        assertEquals(result.get(1),id2);
        assertEquals(result.get(2),id3);

        System.out.println("Calculating fastest route...");
        System.out.println("----------------------------");

        for(int i = 0; i<result.size();i++){
            Intersection currentStop = result.get(i);
            System.out.println("Step " +(i+1) + ": Drive to Intersection ID "+currentStop.getId());
        }
        System.out.println("-----------------------------");
        System.out.println("You have reached your destination");
    }
}
