package Adapter;

import View.Facade.FBFacadeConcrete;
import View.Facade.FlightBookerFacade;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nathnael on 6/4/2016.
 */
public class ToModelTest {
    FBFacadeConcrete facadeTest;
    ToModel toModelTest;
    @Before
    public void setUp() throws Exception {
        facadeTest = new FBFacadeConcrete("JFK","ORD","price");
        toModelTest = new ToModel(facadeTest);


    }

    @After
    public void tearDown() throws Exception {

        facadeTest = null;
        toModelTest = null;
    }




}