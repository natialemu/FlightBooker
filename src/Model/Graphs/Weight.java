package Model.Graphs;

import Model.Tools.Time;

/**
 * Created by Nathnael on 6/10/2016.
 */
public class Weight implements WeightInterface {
    private final int id1 = 001;
    private final int id2 = 002;
    private final int id3 = 003;


    private int priceId,distanceId,timeId;
    private double price,distance;
    private Time initialTime, finalTime;

    public Weight(double price, double distance, Time initialTime, Time finalTime)
    {
        this.price = price;
        this.priceId = id1;
        this.distance = distance;
        distanceId = id2;
        this.timeId = id3;
        this.initialTime = initialTime;
        this.finalTime = finalTime;
    }

    @Override
    public Integer priceWeightId() {
        return priceId;
    }

    @Override
    public Integer distanceWeightId() {
        return distanceId;
    }

    @Override
    public Integer timeWeightId() {
        return timeId;
    }

    @Override
    public Double priceWeight() {
        return price;
    }

    @Override
    public Double distanceWeight() {
        return distance;
    }

    @Override
    public Time DepartureTime() {
        return initialTime;
    }

    @Override
    public Time ArrivalTime() {
        return finalTime;
    }
}
