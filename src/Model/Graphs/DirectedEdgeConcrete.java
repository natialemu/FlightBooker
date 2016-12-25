package Model.Graphs;

import Model.Tools.Time;

import java.util.Date;

/**
 * Created by Nathnael on 6/2/2016.
 */
public class DirectedEdgeConcrete implements DirectedEdge {
    private int source, destination;
    private Weight edgeWeight;

    public DirectedEdgeConcrete(int source, int destination, double price, double distance, Time initailTime, Time finalTime){

        edgeWeight = new Weight(price,distance,initailTime,finalTime);
        this.source = source;
        this.destination = destination;

    }
    public DirectedEdgeConcrete(Weight edgeWeight, int source, int destination){
        this.edgeWeight = edgeWeight;
        this.source = source;
        this.destination = destination;
    }

    @Override
    public Integer from() {
        return source;
    }

    @Override
    public Integer to() {
        return destination;
    }

    @Override
    public Weight getWeight() {

        return edgeWeight;
    }


}
