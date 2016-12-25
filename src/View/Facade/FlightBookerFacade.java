package View.Facade;

/**
 * Created by Nathnael on 6/2/2016.
 */
public interface FlightBookerFacade {

    Void setDestination(String destination);
    Void setOrigin(String origin);
    Void setPriority();


    Void SearchFlight();
}
