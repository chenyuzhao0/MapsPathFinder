public class Main {
    public static void main(String[] args) {
        MapGraph galicia = new MapGraph();
        Intersection route1 = galicia.addIntersection(1);
        Intersection route2 = galicia.addIntersection(2);
        Intersection route3 = galicia.addIntersection(3);
        galicia.connectRoad(route1,route2,120,400);
        galicia.connectRoad(route2,route3,90,300);
        galicia.connectRoad(route3,route1,200,600);
    }
}
