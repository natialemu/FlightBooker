package Model.Graphs;

import Model.Tools.Time;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nathnael on 6/4/2016.
 */
public class DirectedEdgeClusterTest {
    DirectedEdgeCluster edgeClusterTest;
    @Before
    public void setUp() throws Exception {
        edgeClusterTest = new DirectedEdgeCluster();

    }

    @After
    public void tearDown() throws Exception {
        edgeClusterTest = null;

    }


    @Test
    public void add() throws Exception {
        assertTrue(edgeClusterTest.from() == -1);
        assertTrue(edgeClusterTest.to() == -1);


        edgeClusterTest.add(new DirectedEdgeConcrete(2, 6, 3366.1, 234,new Time(12,2),new Time(13,3)));

        assertTrue(edgeClusterTest.to() == 6);
        assertTrue(edgeClusterTest.from() == 2);

    }

    @Test
    public void getLowestPriceDE() throws Exception {

        edgeClusterTest.add(new DirectedEdgeConcrete(2, 6, 3366.1, 234,new Time(12,2),new Time(13,3)));
        edgeClusterTest.add(new DirectedEdgeConcrete(2, 6, 2000, 234,new Time(12,2),new Time(13,3)));
        edgeClusterTest.add(new DirectedEdgeConcrete(2, 6, 1000, 234,new Time(12,2),new Time(13,3)));
        edgeClusterTest.add(new DirectedEdgeConcrete(2, 6, 150, 234,new Time(12,2),new Time(13,3)));


        assertTrue(edgeClusterTest.getLowestPriceDE().getWeight().priceWeight().equals(new Double(150)));

    }

    @Test
    public void getShortestDistanceDE() throws Exception {

        edgeClusterTest.add(new DirectedEdgeConcrete(2, 6, 3366.1, 534,new Time(12,2),new Time(13,3)));
        edgeClusterTest.add(new DirectedEdgeConcrete(2, 6, 2000, 120,new Time(12,2),new Time(13,3)));
        edgeClusterTest.add(new DirectedEdgeConcrete(2, 6, 1000, 234,new Time(12,2),new Time(13,3)));
        edgeClusterTest.add(new DirectedEdgeConcrete(2, 6, 150, 234,new Time(12,2),new Time(13,3)));

        assertTrue(edgeClusterTest.getShortestDistanceDE().getWeight().distanceWeight().equals(new Double(120)));
    }

    @Test
    public void getQuickestDE() throws Exception {

        edgeClusterTest.add(new DirectedEdgeConcrete(2, 6, 3366.1, 534,new Time(12,2),new Time(13,3)));
        edgeClusterTest.add(new DirectedEdgeConcrete(2, 6, 2000, 120,new Time(12,2),new Time(14,3)));
        edgeClusterTest.add(new DirectedEdgeConcrete(2, 6, 1000, 234,new Time(12,2),new Time(15,3)));
        edgeClusterTest.add(new DirectedEdgeConcrete(2, 6, 150, 234,new Time(12,2),new Time(16,3)));

        assertTrue(edgeClusterTest.getQuickestDE().getWeight().ArrivalTime().equals(new Time(13,3)));



    }

}