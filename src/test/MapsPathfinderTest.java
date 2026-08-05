package test;

import main.Intersection;
import main.Road;
import main.MapGraph;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class MapsPathfinderTest {

    @Test
    public void testWeightTrap(){
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
    }
    @Test
    public void testHappyPathCommute() {
        // 1. ARRANGE: Build a mini-map (1 -> 2 -> 3) using your exact constructors
        Intersection a = new Intersection(1);
        Intersection b = new Intersection(2);
        Intersection c = new Intersection(3);

        // Road constructor: (seconds, distanceInMeters, start, end)
        Road roadAB = new Road(10, 100, a, b);
        Road roadBC = new Road(15, 150, b, c);

        // Use your custom addRoad method
        a.addRoad(roadAB);
        b.addRoad(roadBC);

        // 2. ACT: Run the pathfinder engine from A to C
        MapGraph pathfinder = new MapGraph();
        List<Intersection> result = pathfinder.findFastestRoute(a, c);

        // 3. ASSERT: Prove the engine calculated the exact correct route
        assertNotNull(result, "The route list should not be null.");
        assertEquals(3, result.size(), "The route should contain exactly 3 intersections.");
        assertEquals(a, result.get(0), "The first intersection should be ID 1.");
        assertEquals(b, result.get(1), "The middle intersection should be ID 2.");
        assertEquals(c, result.get(2), "The final intersection should be ID 3.");
    }
}