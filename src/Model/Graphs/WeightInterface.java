package Model.Graphs;

import Model.Tools.Time;

/**
 * Created by Nathnael on 6/10/2016.
 */
public interface WeightInterface {

    Integer priceWeightId();
    Integer distanceWeightId();
    Integer timeWeightId();

    Double priceWeight();
    Double distanceWeight();
    Time DepartureTime();
    Time ArrivalTime();
}
