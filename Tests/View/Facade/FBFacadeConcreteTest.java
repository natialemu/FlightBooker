package View.Facade;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nathnael on 6/4/2016.
 */
public class FBFacadeConcreteTest {

    FBFacadeConcrete facadeTest;
    @Before
    public void setUp() throws Exception {
       facadeTest = new FBFacadeConcrete("JFK","ORD","price");



    }

    @After
    public void tearDown() throws Exception {
        facadeTest = null;

    }

    @Test
    public void setDestination() throws Exception {
        facadeTest.setDestination("IAD");
        assertEquals("IAD",facadeTest.getDestination());

    }

    @Test
    public void setOrigin() throws Exception {
        facadeTest.setOrigin("IAD");
        assertEquals("IAD",facadeTest.getOrigin());

    }


    @Test
    public void searchFlight() throws Exception {

        //fail("Not implemented!");
    }

}