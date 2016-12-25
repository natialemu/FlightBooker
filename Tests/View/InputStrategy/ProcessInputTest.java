package View.InputStrategy;

import Model.Tools.Time;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nathnael on 6/4/2016.
 */
public class ProcessInputTest {

    ProcessInput inputTest;

    @Before
    public void setUp() throws Exception {
        inputTest = new ProcessInput();

    }

    @Test
    public void mapAirports() throws Exception {

    }


    @Test
    public void getAirport() throws Exception {

        int airportKey = inputTest.mappedAirport.get("JFK");
        assertTrue(inputTest.getAirport(airportKey) == "JFK");
    }



    @After
    public void tearDown() throws Exception {

        inputTest = null;
    }

    @Test
    public void ProcessInput() throws Exception {

        //check the sizes of the Lists
        assertTrue(inputTest.arrivals.size()==470);
        assertTrue(inputTest.departures.size()==470);
        assertTrue(inputTest.departureTimes.size()==470);
        assertTrue(inputTest.arrivalTimes.size()==470);
        assertTrue(inputTest.distances.size() ==470);
        assertTrue(inputTest.prices.size()==470);

        //check that the departure values are correct
        assertEquals("JFK",inputTest.departures.get(0));
        assertEquals("SFO",inputTest.departures.get(1));
        assertEquals("ATL",inputTest.departures.get(inputTest.departures.size()-1));

        //check that the arrivals values are correct
        assertEquals("SFO",inputTest.arrivals.get(0));
        assertEquals("JFK",inputTest.arrivals.get(1));
        assertEquals("JAN",inputTest.arrivals.get(inputTest.arrivals.size()-1));

        //check that the arrivalTimes are correct
        assertEquals(new Time(13,58),inputTest.arrivalTimes.get(0));
        assertEquals(new Time(15,39),inputTest.arrivals.get(1));
        assertEquals(new Time(8,55),inputTest.arrivals.get(inputTest.arrivalTimes.size()-1));

        //check that the departureTimes are correct
        assertEquals(new Time(7,10),inputTest.departureTimes.get(0));
        assertEquals(new Time(10,9),inputTest.departureTimes.get(1));
        assertEquals(new Time(7,33),inputTest.departureTimes.get(inputTest.departureTimes.size()-1));

        //check that the distances are correct
        assertEquals(new Double(2586),new Double(inputTest.distances.get(0)));
        assertEquals(new Double(2586),new Double(inputTest.distances.get(1)));
        assertEquals(new Double(341) ,new Double(inputTest.distances.get(inputTest.distances.size()-1)));

        //check that the prices are correct
        assertEquals(new Double(3361.8),new Double(inputTest.prices.get(0)));
        assertEquals(new Double(3361.8),new Double(inputTest.prices.get(1)));
        assertEquals(new Double(251) ,new Double(inputTest.distances.get(inputTest.prices.size()-1)));

        //check that the mappedAirports is correct
        assertTrue(inputTest.mappedAirport.containsKey("JFK"));
        inputTest.mappedAirport.remove("JFK");
        assertFalse(inputTest.mappedAirport.containsKey("JFK"));

        assertTrue(inputTest.mappedAirport.containsKey("ORD"));
        inputTest.mappedAirport.remove("ORD");
        assertFalse(inputTest.mappedAirport.containsKey("ORD"));

        assertTrue(inputTest.mappedAirport.containsKey("SFO"));
        inputTest.mappedAirport.remove("SFO");
        assertFalse(inputTest.mappedAirport.containsKey("SFO"));

        assertTrue(inputTest.mappedAirport.containsKey("ATL"));
        inputTest.mappedAirport.remove("ATL");
        assertFalse(inputTest.mappedAirport.containsKey("ATL"));

        
    }

    @Test
    public void convertTime() throws Exception {
        assertTrue(inputTest.convertToTime(1234).getMinute() == 34);
        assertTrue(inputTest.convertToTime(1234).getHour() == 12);

        assertTrue(inputTest.convertToTime(702).getMinute() == 2);
        assertTrue(inputTest.convertToTime(702).getHour() == 7);
    }



}