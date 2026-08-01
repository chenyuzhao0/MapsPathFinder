public class Road {
    private int seconds;

    private int distanceInMeters;
    private Intersection start;
    private Intersection end;

    public Road(int seconds, int distanceInMeters, Intersection start, Intersection end){
        this.seconds = seconds;
        this.distanceInMeters = distanceInMeters;
        this.start = start;
        this.end = end;
    }
}
