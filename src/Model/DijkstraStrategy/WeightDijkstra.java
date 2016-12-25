package Model.DijkstraStrategy;

import Model.Graphs.DirectedEdge;
import Model.Tools.PriorityQueue;

/**
 * Created by Nathnael on 6/2/2016.
 */
public interface WeightDijkstra {

    Void dijkstra();
    Void insertAllVertices(PriorityQueue pq);
    Void shorterEdge(DirectedEdge edge);
    DirectedEdge[] getEdgeTo();
    double[] getWeightTo();



}
