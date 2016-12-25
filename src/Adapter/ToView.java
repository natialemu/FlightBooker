package Adapter;

import Model.Graphs.Graph;
import Model.Tools.Time;
import View.Facade.FBFacadeConcrete;
import View.InputStrategy.ProcessInput;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Nathnael on 6/2/2016.
 *
 *
 */
public class ToView {
    //this class should also contain information for returning information from the model to the view
    //when the view requests it. information returned should be something in the form of the route to take
    //the has the shortest weight but should also list the time it the other weights not considered in
    //Dijkstra's Algorithm
    private ToModel model;
    private Graph graph;
    private Stack<Integer> paths;
    private double totalPrice;
    private double totalTime;
    private double totalDistance;
    private Time destinationTime;
    private Time arrivalTime;
    private Integer source;
    private Integer destination;
    private List<String> airports;
    private ProcessInput processedInput;

    public ToView(FBFacadeConcrete booker){
        processedInput = new ProcessInput();
        model = new ToModel(booker);
        paths = null;
        graph = model.getGraph();
        source = model.getSource();
        destination = model.getDestination();
        airports = new ArrayList<>();



    }
    public Void getBackResult(){
        paths = model.getDijkstra().getShortestPathsTo(destination);
        return null;
    }

    public Void mapToAirports(){
        for (int i = 0; i < paths.size();i++){
            airports.add(processedInput.getAirport(paths.pop()));
        }
        return null;
    }

    public void findTotalPrice(){
        int initial = source;
        int finalAirport = processedInput.getKey(airports.get(1));
        int i = 2;
        while(finalAirport != destination){
            //use the graph to add up all the prices!
            for (int j = 0; j < graph.adj(initial).size(); j ++){
                if(graph.adj(initial).get(j).to() == finalAirport){
                    totalPrice+= graph.adj(initial).get(j).getLowestPriceDE().getWeight().priceWeight();

                }
            }
            initial = finalAirport;
            finalAirport = processedInput.getKey(airports.get(i));
            i++;





        }


    }

    public void findTotalDistance(){
        int initial = source;
        int finalAirport = processedInput.getKey(airports.get(1));
        int i = 2;
        while(finalAirport != destination){
            //use the graph to add up all the prices!
            for (int j = 0; j < graph.adj(initial).size(); j ++){
                if(graph.adj(initial).get(j).to() == finalAirport){
                    totalDistance+= graph.adj(initial).get(j).getShortestDistanceDE().getWeight().distanceWeight();

                }
            }
            initial = finalAirport;
            finalAirport = processedInput.getKey(airports.get(i));
            i++;





        }


    }

    public void findDestinationTime(){

    }

    public void findArrivalTime(){

    }

    public List<String> getAirports(){
        return airports;
    }

    public double getTotalPrice(){
        return totalPrice;
    }
    public double getTotalDistance(){
        return totalDistance;
    }
}
