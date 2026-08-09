# MapsPathFinder

A Java routing engine that implements the Dijkstra's Algorithm to find the best/fastest route from two points on a directed weighted graph.

## The Architecture
This engine doesn't try to guess randomly the route:
### Distance Map:
This keeps a record of the time accumulated from the start to the current node. If the time the new time is shorter, it overwrites the old one.
### Queue:
The priorityQueue class uses the 'Comparator' to calculate the shortest time possible accumulated.
### Register Map:
To know where did we come from, we use the previousNodes method like a reversed linked list to have a register of the path we took.

## Testing
This engine was verified using the JUnit Test
