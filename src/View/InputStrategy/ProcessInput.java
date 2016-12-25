package View.InputStrategy;

import Model.Tools.Time;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Nathnael on 6/2/2016.
 */
public class ProcessInput {

    /*don't forget to make fields private */
    InputSource inputSource;
    HashMap<String,Integer> mappedAirport;
    List<String> departures;
    List<String> arrivals;
    List<Time> arrivalTimes;
    List<Time> departureTimes;
    List<Double> distances;
    List<Double> prices;


    public ProcessInput(){
        inputSource = new FileInput();
        mappedAirport = new HashMap<>();

        arrivalTimes = new ArrayList<>();
        departureTimes = new ArrayList<>();
        populateTimes();

        departures = inputSource.getOrigins();
        arrivals = inputSource.getDestinations();

        distances = new ArrayList<>();
        prices = new ArrayList<>();
        populatePriceAndDate();
        mapAirports();

    }

    //
    public void setInputSource(InputSource source){
        inputSource = source;
    }

    //
    private void populateTimes(){
        List<String> startTime = inputSource.getStartTime();
        List<String> endTime = inputSource.getEndTime();
        for(int i = 0; i < startTime.size();i++){
            arrivalTimes.add(convertToTime(Integer.parseInt(endTime.get(i))));
            departureTimes.add(convertToTime(Integer.parseInt(startTime.get(i))));
        }
    }


    //
    private void populatePriceAndDate(){
        List<String> price = inputSource.getPrice();
        List<String> distance = inputSource.getDistance();
        for(int i = 0;i<price.size();i++){
            prices.add(Double.parseDouble(price.get(i)));
            distances.add(Double.parseDouble(distance.get(i)));
        }
    }

    //
    public void mapAirports(){

        for(int i = 0; i < departures.size();i++){
            if(!mappedAirport.containsKey(departures.get(i))){
                mappedAirport.put(departures.get(i),i);
            }
            if(!mappedAirport.containsKey(arrivals.get(i))){
                mappedAirport.put(arrivals.get(i),arrivals.size()+i);
            }

        }
    }

    public int getKey(String airport){

        return mappedAirport.get(airport);
    }

    public Time convertToTime(int time)
    {
        int hour;
        int minute;
        //if time is not of length 3 or 4, then there is an error
        String fullTime = Integer.toString(time);
        if(fullTime.length() == 3){
            hour = Integer.parseInt(fullTime.substring(0,1));
            String minuteString = fullTime.substring(1,fullTime.length());
            if(minuteString.charAt(0) == '0'){
                minute = Integer.parseInt(fullTime.substring(2,fullTime.length()));

            }
            else {
                minute = Integer.parseInt(fullTime.substring(1, fullTime.length()));
            }

        }
        else{
            hour = Integer.parseInt(fullTime.substring(0,2));
            String minuteString = fullTime.substring(2,fullTime.length());
            if(minuteString.charAt(0) == '0') {
                minute = Integer.parseInt(fullTime.substring(3,fullTime.length()));
            }
            else {

                minute = Integer.parseInt(fullTime.substring(2, fullTime.length()));
            }
        }
        return new Time(hour,minute);
    }
    public int numberOfAirports(){
        return mappedAirport.size();
    }
    public String getAirport(int airportKey)
    {

            for (String s : mappedAirport.keySet()) {
                for (Integer i : mappedAirport.values()) {
                    if (mappedAirport.get(s) == i) {
                        return s;
                    }
                }


            }
        return "no";


    }

}
