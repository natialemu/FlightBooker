package Model.Graphs;

import Model.Tools.Time;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nathnael on 6/4/2016.
 */
public class WeightedDiGraphTest {

    WeightedDiGraph graphTest;
    @Before
    public void setUp() throws Exception {
        graphTest = new WeightedDiGraph(5);

    }

    @After
    public void tearDown() throws Exception {
        graphTest = null;
    }


    @Test
    public void vertices() throws Exception {
        assertTrue(graphTest.vertices() == 5);
    }

    @Test
    public void edges() throws Exception {
        assertTrue(graphTest.edges() == 0);



    }

    @Test
    public void adj() throws Exception {
        graphTest.addEdge(2,4,120,340,new Time(12,3),new Time(13,4));
        graphTest.addEdge(3,2,120,340,new Time(12,3),new Time(13,4));
        graphTest.addEdge(1,4,120,340,new Time(12,3),new Time(13,4));
        graphTest.addEdge(2,3,120,340,new Time(12,3),new Time(13,4));
        graphTest.addEdge(2,1,120,340,new Time(12,3),new Time(13,4));
        graphTest.addEdge(3,4,120,340,new Time(12,3),new Time(13,4));

        assertTrue(graphTest.adj(2).size() == 3);
        assertTrue(graphTest.adj(3).size() == 2);



    }

    @Test
    public void addEdge() throws Exception {

        assertTrue(graphTest.edges() == 0);

        graphTest.addEdge(2,4,120,340,new Time(12,3),new Time(13,4));
        graphTest.addEdge(3,2,120,340,new Time(12,3),new Time(13,4));
        graphTest.addEdge(1,4,120,340,new Time(12,3),new Time(13,4));

        assertTrue(graphTest.edges() == 3);

    }

}