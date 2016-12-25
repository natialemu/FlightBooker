package View.InputStrategy;



import Model.Tools.Time;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Nathnael on 6/2/2016.
 */
public class FileInput implements InputSource {
    private ArrayList<String> departures;
    private ArrayList<String> arrivals;
    private ArrayList<String> departureTimes;
    private ArrayList<String> arrivalTimes;
    private ArrayList<String> distances;
    private ArrayList<String> prices;

    private String fileName;;
    //tests very neccessary for this part
    public FileInput(){
        fileName = "project1.csv";
        departures = new ArrayList<>();
        arrivals = new ArrayList<>();
        departureTimes = new ArrayList<>();
        arrivalTimes = new ArrayList<>();
        distances = new ArrayList<>();
        prices = new ArrayList<>();
        readFromFile();



    }
    private void readFromFile(){
        try {
            Scanner scan = new Scanner(new File(fileName));
            scan.nextLine();
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                String[] lineContent = line.split(",");
                //make sure the size of the array is six
                departures.add(lineContent[0]);
                arrivals.add(lineContent[1]);
                departureTimes.add(lineContent[2]);
                arrivalTimes.add(lineContent[3]);
                distances.add(lineContent[4]);
                prices.add(lineContent[5]);
            }
        } catch(IOException e){
            System.out.println("File Couldn't be opened or found!");

        }

    }


    @Override
    public List<String> getOrigins() {return departures;
    }

    @Override
    public List<String> getDestinations() {
        return arrivals;
    }

    @Override
    public List<String> getPrice() {
        return prices;
    }

    @Override
    public List<String> getDistance() {
        return distances;
    }

    @Override
    public List<String> getStartTime() {
        return departureTimes;
    }

    @Override
    public List<String> getEndTime() {
        return arrivalTimes;
    }

}
