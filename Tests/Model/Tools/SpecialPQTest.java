package Model.Tools;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nathnael on 6/4/2016.
 */
public class SpecialPQTest {
    SpecialPQ priorityQueueTest;

    @Before
    public void setUp() throws Exception {
        priorityQueueTest = new SpecialPQ();

    }

    @After
    public void tearDown() throws Exception {
        priorityQueueTest = null;

    }


    @Test
    public void insert() throws Exception {
        priorityQueueTest.insert(2);
        priorityQueueTest.insert(1);
        priorityQueueTest.insert(0);

        assertTrue(priorityQueueTest.vertexToWeight.get(0) == Double.POSITIVE_INFINITY);
        assertTrue(priorityQueueTest.vertexToWeight.get(1) == Double.POSITIVE_INFINITY);
        assertTrue(priorityQueueTest.vertexToWeight.get(2) == Double.POSITIVE_INFINITY);


    }

    @Test
    public void deleteMin() throws Exception {

        priorityQueueTest.insert(2);
        priorityQueueTest.update(2,2);
        priorityQueueTest.insert(1);
        priorityQueueTest.update(1,1);
        priorityQueueTest.insert(3);
        priorityQueueTest.update(3,3);

        priorityQueueTest.insert(4);
        priorityQueueTest.update(4,4);
        priorityQueueTest.insert(6);
        priorityQueueTest.update(6,6);

        assertEquals(priorityQueueTest.deleteMin(),1);
        assertEquals(priorityQueueTest.deleteMin(),2);
        assertEquals(priorityQueueTest.deleteMin(),3);

        priorityQueueTest.insert(8);
        priorityQueueTest.update(8,1);

        assertTrue(priorityQueueTest.deleteMin() == 8);


    }

    @Test
    public void isEmpty() throws Exception {
        assertTrue(priorityQueueTest.isEmpty());
        priorityQueueTest.insert(2);
        assertFalse(priorityQueueTest.isEmpty());

    }

    @Test
    public void contains() throws Exception {
        priorityQueueTest.insert(2);

        assertTrue(priorityQueueTest.contains(2));
        assertFalse(priorityQueueTest.contains(1));


    }



}