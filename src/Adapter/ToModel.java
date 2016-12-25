package Adapter;

import Model.DijkstraStrategy.DijkstraShortestPaths;
import Model.DijkstraStrategy.DistanceDijkstra;
import Model.DijkstraStrategy.PriceDijkstra;
import Model.DijkstraStrategy.TimeDijkstra;
import Model.Graphs.Graph;
import Model.Graphs.WeightedDiGraph;
import View.Facade.FBFacadeConcrete;
import View.Facade.FlightBookerFacade;
import View.InputStrategy.ProcessInput;

import java.util.List;
import java.util.Stack;

/**
 * Created by Nathnael on 6/2/2016.
 *
 *
 */
public class ToModel {

    private ProcessInput processedInput;
    FlightBookerFacade booker;
    Integer source;
    Integer destination;
    String preference;
    Graph graph;
    DijkstraShortestPaths dijkstra;


    public ToModel(FBFacadeConcrete facade){
        processedInput = new ProcessInput();
        booker = facade;
        source = processedInput.getKey(facade.getOrigin());
        destination = processedInput.getKey(facade.getDestination());
        preference = facade.getPriority();
        graph = new WeightedDiGraph(processedInput.numberOfAirports());



    }
    public DijkstraShortestPaths getDijkstra(){
        return dijkstra;
    }


    public Void runDijkstra(){
        dijkstra = new DijkstraShortestPaths(graph,source);
        if(preference.equals("price")){
            dijkstra.setDijkstraWeight(new PriceDijkstra(source,graph));
            dijkstra.performDijkstra();

        } else if(preference.equals("distance")){
            dijkstra.setDijkstraWeight(new DistanceDijkstra(source,graph));
            dijkstra.performDijkstra();
        } else if (preference.equals(equals("time"))){
            dijkstra.setDijkstraWeight(new TimeDijkstra(source,graph));
            dijkstra.performDijkstra();
        }
        return null;
    }

    public int getDestination(){return destination;}
    public Graph getGraph(){return graph;}
    public int getSource(){return source;}





}
