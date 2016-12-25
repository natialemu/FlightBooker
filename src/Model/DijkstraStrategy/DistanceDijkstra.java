package Model.DijkstraStrategy;

import Model.Graphs.DirectedEdge;
import Model.Graphs.DirectedEdgeCluster;
import Model.Graphs.DirectedEdgeConcrete;
import Model.Graphs.Graph;
import Model.Tools.PriorityQueue;
import Model.Tools.SpecialPQ;

/**
 * Created by Nathnael on 6/2/2016.
 */
public class DistanceDijkstra implements WeightDijkstra {
    DirectedEdge[] edgeTo;
    Graph graph;
    double[] distanceTo;
    PriorityQueue queue;
    int source;


    public DistanceDijkstra(int source, Graph graph)
    {
        edgeTo = new DirectedEdgeConcrete[graph.vertices()];
        this.graph = graph;
        distanceTo = new double[graph.vertices()];
        queue = new SpecialPQ();
        this.source = source;

    }
    @Override
    public Void dijkstra() {
        distanceTo[source] = 0;
        insertAllVertices(queue);
        while(!queue.isEmpty()){
            int v = queue.deleteMin();
            for(DirectedEdgeCluster d: graph.adj(v)){
                shorterEdge(d.getShortestDistanceDE());
            }
        }
        return null;
    }

    @Override
    public Void insertAllVertices(PriorityQueue pq) {
        for (int i = 0; i < graph.vertices(); i++) {
            if(i == source){
                continue;
            }
            pq.insert(i);
        }
        return null;
    }

    @Override
    public Void shorterEdge(DirectedEdge edge) {
        int v = edge.from();
        int w = edge.to();
        if(distanceTo[w] > distanceTo[v] + edge.getWeight().priceWeight()){
            distanceTo[w] = distanceTo[v] + edge.getWeight().priceWeight();
            edgeTo[w] = edge;
            if(queue.contains(w)){
                queue.update(w,distanceTo[w]);
                
            }
        }
        return null;
    }

    @Override
    public DirectedEdge[] getEdgeTo() {
        return edgeTo;
    }

    @Override
    public double[] getWeightTo() {
        return distanceTo;
    }
}
