package main;

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

    public Intersection getEnd() {
        return end;
    }
    public Intersection getStart(){
        return start;
    }
    public int getDistanceInMeters(){
        return distanceInMeters;
    }
    public int getSeconds(){
        return seconds;
    }

}
