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
public class PriceDijkstra implements WeightDijkstra {
    DirectedEdge[] edgeTo;
    Graph graph;
    double[] priceTo;
    PriorityQueue queue;
    int source;


    public PriceDijkstra(int source, Graph graph)
    {
        edgeTo = new DirectedEdgeConcrete[graph.vertices()];
        this.graph = graph;
        priceTo = new double[graph.vertices()];
        queue = new SpecialPQ();
        this.source = source;

    }
    @Override
    public Void dijkstra() {
        priceTo[source] = 0;
        insertAllVertices(queue);
        while(!queue.isEmpty()){
            int v = queue.deleteMin();
            for(DirectedEdgeCluster d: graph.adj(v)){
                shorterEdge(d.getLowestPriceDE());
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
        if(priceTo[w] > priceTo[v] + edge.getWeight().priceWeight()){
            priceTo[w] = priceTo[v] + edge.getWeight().priceWeight();
            edgeTo[w] = edge;
            if(queue.contains(w)){
                queue.update(w,priceTo[w]);
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
        return priceTo;
    }
}
