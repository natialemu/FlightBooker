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
public class TimeDijkstra implements WeightDijkstra {
    DirectedEdge[] edgeTo;
    Graph graph;
    double[] timeTo;
    PriorityQueue queue;
    int source;


    public TimeDijkstra(int source, Graph graph)
    {
        edgeTo = new DirectedEdgeConcrete[graph.vertices()];
        this.graph = graph;
        timeTo = new double[graph.vertices()];
        queue = new SpecialPQ();
        this.source = source;

    }
    @Override
    public Void dijkstra() {
        timeTo[source] = 0;
        insertAllVertices(queue);
        while(!queue.isEmpty()){
            int v = queue.deleteMin();
            for(DirectedEdgeCluster d: graph.adj(v)){
                shorterEdge(d.getQuickestDE());
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
        if(timeTo[w] > timeTo[v] + edge.getWeight().priceWeight()){
            timeTo[w] = timeTo[v] + edge.getWeight().priceWeight();
            edgeTo[w] = edge;
            if(queue.contains(w)){
                queue.update(w,timeTo[w]);
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
        return timeTo;
    }
}
