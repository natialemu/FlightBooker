package View.Facade;

import Adapter.ToModel;
import Adapter.ToView;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Nathnael on 6/2/2016.
 */
public class FBFacadeConcrete implements FlightBookerFacade {

    private String origin;
    private String destination;
    private String priority;
    private Scanner input;


    public FBFacadeConcrete(){
        origin = "";
        destination = "";
        priority = "";
    }

    public FBFacadeConcrete(String origin, String destination, String priority)
    {
        this.origin = origin;
        this.destination = destination;
        this.priority = priority;
    }
    public String getOrigin(){
        return origin;
    }

    public String getDestination(){
        return destination;
    }
    public String getPriority(){
        return priority;
    }


    @Override
    public Void setDestination(String destination) {
        this.destination = destination;
        return null;
    }

    @Override
    public Void setOrigin(String origin) {
        this.origin = origin;
        return null;
    }

    @Override
    public Void setPriority() {//make sure input is not error prone
         input = new Scanner(System.in);
        System.out.println("Please choose how you want to optimize your flight search: ");
        System.out.println("Price\nDistance\nTime");
        String priority = input.next();
        this.priority = priority;
        return null;
    }

    @Override
    public Void SearchFlight() {

        ToModel passInfo = new ToModel(new FBFacadeConcrete(origin,destination,priority));
        passInfo.runDijkstra();
        DisplayResults();
        return null;
    }


    private Void DisplayResults(){
        ToView getInfo = new ToView(new FBFacadeConcrete(origin,destination,priority));

        List<String> airports = getInfo.getAirports();
        double totalPrice = getInfo.getTotalPrice();
        double totalDistance = getInfo.getTotalDistance();

        if(airports.size() > 0) {
            System.out.println("Here are results for your flight from " + origin + " to " + destination + " :\n");
            System.out.print(airports.get(0));
            for (int i = 1; i < airports.size(); i++) {
                System.out.print(" ---> " + airports.get(i));
            }
        }
        else{
            System.out.println("Your search query returned no results!");
        }


        return null;
    }
}
