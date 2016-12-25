package Model.Graphs;

import Model.Tools.Time;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nathnael on 6/4/2016.
 */
public class DirectedEdgeConcreteTest {
    Weight weightTest;
    DirectedEdgeConcrete edgeTest;
    @Before
    public void setUp() throws Exception {
        edgeTest = new DirectedEdgeConcrete(2, 6, 3366.1, 234,new Time(12,2),new Time(13,3));
    }

    @After
    public void tearDown() throws Exception {
        edgeTest = null;
    }

    @Test
    public void from() throws Exception {
        assertEquals(edgeTest.from(), new Integer(2));
    }

    @Test
    public void to() throws Exception {
        assertEquals(edgeTest.to(),new Integer(6));
    }




}