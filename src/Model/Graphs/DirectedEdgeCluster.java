package Model.Graphs;

import Model.Tools.Time;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nathnael on 6/2/2016.
 */
public class DirectedEdgeCluster {
    private List<DirectedEdge> edges;
    int source;
    int destination;


    public DirectedEdgeCluster(){
        edges = new ArrayList<>();
        source = -1;
        destination = -1;


    }
    //
    public Integer from(){
        return source;
    }
    //
    public Integer to(){
        return destination;
    }

    //
    public Void add(DirectedEdge e){
        //before you add make sure the edge being added has the same source AND destination or that the source
        //and destination are both -1
        if((e.from() == source  && e.to() == destination) || (source == -1 && destination == -1)) {

            edges.add(e);
            source = e.from();
            destination = e.to();

        }
        return null;
    }
    //how do you break ties
    public DirectedEdge getLowestPriceDE(){
        //iterate through the list, compare the prices of all the direced edges, return the one with lowe

        Weight lowestPrice = edges.get(0).getWeight();
        int lowestIndex = 0;
        for(int i =1; i < edges.size();i++){
            if(edges.get(i).getWeight().priceWeight() < lowestPrice.priceWeight()){
                lowestPrice = edges.get(i).getWeight();
                lowestIndex = i;
            }
        }
        return edges.get(lowestIndex);
    }
    //
    public DirectedEdge getShortestDistanceDE(){
        //how do you break ties
        Weight lowestDistance = edges.get(0).getWeight();
        int lowestIndex = 0;
        for(int i =0; i < edges.size();i++){
            if(edges.get(i).getWeight().distanceWeight() < lowestDistance.distanceWeight()){
                lowestDistance = edges.get(i).getWeight();
                lowestIndex = i;
            }
        }

        return edges.get(lowestIndex);
    }

    //how do you break ties
    public DirectedEdge getQuickestDE(){
        Weight quickest = edges.get(0).getWeight();
        int lowestIndex = 0;
        for(int i = 0; i < edges.size();i++){
            Time initalTime = edges.get(i).getWeight().DepartureTime();
            Time finalTime = edges.get(i).getWeight().ArrivalTime();
            if(initalTime.difference(finalTime) < quickest.DepartureTime().difference(quickest.ArrivalTime())){
                quickest = edges.get(i).getWeight();
                lowestIndex = i;
            }
        }
        return edges.get(lowestIndex);
    }

}
