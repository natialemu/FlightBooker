package Model.Graphs;

import java.util.*;

/**
 * Created by Nathnael on 6/2/2016.
 */
public interface Graph {


    Integer vertices();
    Integer edges();
    List<DirectedEdgeCluster> adj(int vertex);
}
