import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    Queue BestQueue;
    @BeforeEach
    void setUp() {
        BestQueue = new Queue();
    }

    @Test
    void enqueue() {
        BestQueue.enqueue(1);
        BestQueue.enqueue(3);
        BestQueue.enqueue(5);
        assertEquals(1, BestQueue.getHead().getData());
        assertEquals(3, BestQueue.size());
    }

    @Test
    void size() {
        assertEquals(0,BestQueue.size());
        BestQueue.enqueue(6);
        BestQueue.enqueue(3);
        assertEquals(2, BestQueue.size());
        BestQueue.enqueue(9);
        BestQueue.enqueue(15);
        assertEquals(4, BestQueue.size());
    }

    @Test
    void dequeue() {
        assertThrows(RuntimeException.class,()-> BestQueue.dequeue());
        BestQueue.enqueue(6);
        BestQueue.enqueue(3);
        assertEquals(6,BestQueue.dequeue());
    }

    @Test
    void testDequeue() {
        assertThrows(RuntimeException.class,()-> BestQueue.dequeue());
        BestQueue.enqueue(6);
        BestQueue.enqueue(3);
        BestQueue.enqueue(9);
        BestQueue.enqueue(15);
        int[] result = BestQueue.dequeue(3);

        assertArrayEquals(new int[] {6,3,9}, result);
        assertEquals(15, BestQueue.getHead().getData());
        assertEquals(1, BestQueue.size());
    }
}