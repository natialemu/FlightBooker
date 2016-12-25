package Model.Graphs;

import Model.Tools.Time;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nathnael on 6/2/2016.
 */
public class WeightedDiGraph implements Graph {
    private List<DirectedEdgeCluster>[] adjMatrix;
    private final int numVertices;

    //
    public WeightedDiGraph(int numVertices){
        this.numVertices = numVertices;
        adjMatrix = (List<DirectedEdgeCluster>[]) new ArrayList[numVertices];
        for(int i = 0; i < numVertices; i++){
            adjMatrix[i] = new ArrayList<>();
        }
    }

    //
    @Override
    public Integer vertices() {
        return adjMatrix.length;
    }

    //
    @Override
    public Integer edges() {
        int numEdgeClusters = 0;
        for(int i = 0; i < adjMatrix.length;i++){
            numEdgeClusters+=adjMatrix[i].size();
        }
        return numEdgeClusters;
    }
    //
    public List<DirectedEdgeCluster> adj(int vertex)
    {
        return adjMatrix[vertex];
    }

    //
    public Void addEdge(int source, int destination, double price, double distance, Time time1, Time time2){
        //create a directed edge out of these values
        //check of a cluster already exists from source to the destination
        //if so just simply go there and add this directedEdge
        //if not then create a new cluster and add the directed edge there

        //make sure an edge is not being added between vertices that dont exist
        Weight w = new Weight(price,distance,time1,time2);
        DirectedEdge e = new DirectedEdgeConcrete(w,source,destination);
        int clusterIndex = edgeClusterExists(adjMatrix[source],source, destination);
        if( clusterIndex != -1){
            adjMatrix[source].get(clusterIndex).add(e);
        }else{
            DirectedEdgeCluster cluster = new DirectedEdgeCluster();
            cluster.add(e);
            adjMatrix[source].add(cluster);
        }



        return null;
    }

    // will return -1 if it doesnt exist
    private int edgeClusterExists(List<DirectedEdgeCluster> cluster, int source, int destination)
    {
        //go through the cluster and compare the destination
        for(int i = 0; i < cluster.size(); i++){
            if(cluster.get(i).destination == destination){
                return i;
            }
        }
        return -1;

    }

}
