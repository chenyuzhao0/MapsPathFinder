package main;

public class Road {

    //Every road should know how it takes to go from the start to the
    // end point. We measure it knowing the time and distance
    private int seconds;
    private int distanceInMeters;
    private Intersection start;
    private Intersection end;

    //To build every road, we need all those values.
    public Road(int seconds, int distanceInMeters, Intersection start, Intersection end){
        this.seconds = seconds;
        this.distanceInMeters = distanceInMeters;
        this.start = start;
        this.end = end;
    }

    //to know the end
    public Intersection getEnd() {
        return end;
    }

    //to know the start
    public Intersection getStart(){ return start; }

    //to know the distance
    public int getDistanceInMeters(){
        return distanceInMeters;
    }

    //to know the time
    public int getSeconds(){
        return seconds;
    }

}
