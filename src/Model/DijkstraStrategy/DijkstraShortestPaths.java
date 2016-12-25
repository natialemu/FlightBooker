package Model.DijkstraStrategy;

import Model.Graphs.DirectedEdge;
import Model.Graphs.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Nathnael on 6/2/2016.
 */
public class DijkstraShortestPaths {
    int source;
    double[] weightTo;
    Graph graph;
    DirectedEdge[] edgeTo;
    WeightDijkstra dijkstra;
    Stack<Integer> shortestPaths;


    public DijkstraShortestPaths(Graph graph, int source)
    {
        this.source = source;
        dijkstra = new PriceDijkstra(source,graph);
        weightTo = dijkstra.getWeightTo();
        this.graph = graph;
        edgeTo = dijkstra.getEdgeTo();
        shortestPaths = new Stack<>();
    }

    public void setDijkstraWeight(WeightDijkstra dijkstra)
    {
        this.dijkstra = dijkstra;
    }
    public void performDijkstra(){dijkstra.dijkstra();}

    public double getWeightTo(int destination){
        return weightTo[destination];
    }


    public Stack<Integer> getShortestPathsTo(int destination){
        int s = source;
        int edgeToDestination = destination;
        shortestPaths.push(destination);
        while(edgeToDestination != source){
            edgeToDestination = edgeTo[destination].from();
            shortestPaths.push(edgeToDestination);
        }

        return shortestPaths;
    }


}

