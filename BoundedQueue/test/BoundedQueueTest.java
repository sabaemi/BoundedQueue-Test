import static org.junit.Assert.*;
import org.junit.*;

public class BoundedQueueTest {

    private BoundedQueue bq; // Test fixture

    @Before      // Set up
    public void setUp() throws Exception {
        bq = new BoundedQueue(4);
    }

    @After      // Tear down
    public void tearDown(){
        bq = null;
    }

    // Test for negative capacity in constructor
    @Test(expected = IllegalArgumentException.class)
    public void testCapacity(){
        System.out.println("Testing negative capacity in constructor");
        BoundedQueue bq = new BoundedQueue(-1);
    }

    // Test for enQueue method, pushing o1
    @Test
    public void testEnQueue() {
        System.out.println("Testing enQueue method");
        Object o1 = "o1";
        bq.enQueue(o1);
        assertTrue ("incorrect enQueue method", "[o1]".equals(bq.toString()));
    }

    // Test for enQueue method, pushing null element
    @Test(expected = NullPointerException.class)
    public void testNullElement() {
        System.out.println("Testing enQueue method...pushing null element");
        BoundedQueue bq = new BoundedQueue(1);
        Object o1 = "o1";
        bq.enQueue(o1);
        bq.enQueue(null);
    }

    // Test for enQueue method, pushing o1, o2 into a queue with capacity of one
    @Test(expected = IllegalStateException.class)
    public void testOutOfRange() {
        System.out.println("Testing enQueue method...pushing element in a full queue");
        bq = new BoundedQueue(1);
        Object o1 = "o1";
        Object o2 = "o2";
        bq.enQueue(o1);
        bq.enQueue(o2);
    }

    // Test for deQueue method, pushing o1, o2 then pop o1
    @Test
    public void testDeQueue() {
        System.out.println("Testing deQueue method");
        Object o1 = "o1";
        Object o2 = "o2";
        bq.enQueue(o1);
        bq.enQueue(o2);
        bq.deQueue();
        assertTrue ("incorrect dnQueue method", "[o2]".equals(bq.toString()));
    }

    // Test for deQueue method, popping element from an empty queue
    @Test(expected = IllegalStateException.class)
    public void testPopEmpty() {
        System.out.println("Testing deQueue method...popping element from an empty queue");
        bq.deQueue();
    }

    // Test for isEmpty method
    @Test
    public void testIsEmpty() {
        System.out.println("Testing isEmpty method");
        assertTrue ("incorrect isEmpty method", bq.isEmpty());
    }

    // Test for isFull method, pushing o1, o2, o3, o4 into a queue with capacity of 4
    @Test
    public void testIsFull() {
        System.out.println("Testing isFull method");
        for (int i = 1; i < 5; i++)
        {
            String obj = "o" + i;
            Object o = obj;
            bq.enQueue(o);
        }
        assertTrue ("incorrect isFull method", bq.isFull());
    }

    // Test for toString method, pushing o1, o2, o3
    @Test
    public void testToString() {
        System.out.println("Testing toString method");
        for (int i = 1; i < 4; i++)
        {
            String obj = "o" + i;
            Object o = obj;
            bq.enQueue(o);
        }
        assertTrue ("incorrect toString method", "[o1, o2, o3]".equals(bq.toString()));
    }
}
