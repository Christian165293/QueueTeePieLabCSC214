package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class QueueTeesTest {
    // Test Cutie implementations
    @Test
    public void testPuppyImplementation() {
        Cutie puppy = new Puppy();
        assertEquals("A little puppy with big, sad eyes", puppy.description());
        assertEquals(11, puppy.cutenessRating());
    }

    @Test
    public void testKittyImplementation() {
        Cutie kitty = new Kitty();
        assertEquals("A cute kitten", kitty.description());
        assertEquals(10, kitty.cutenessRating());
    }

    @Test
    public void testPygmyMarmosetImplementation() {
        Cutie marmoset = new PygmyMarmoset();
        assertEquals("A tiny Pygmy Marmoset", marmoset.description());
        assertEquals(9, marmoset.cutenessRating());
    }

    // QueueTees tests
    @Test
    public void testEmptyQueue() {
        QueueTees<Cutie> queue = new QueueTees<>();
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
        assertThrows(IllegalStateException.class, queue::peek);
        assertThrows(IllegalStateException.class, queue::dequeue);
    }

    @Test
    public void testEnqueueAndPeek() {
        QueueTees<Cutie> queue = new QueueTees<>();
        Cutie puppy = new Puppy();

        queue.enqueue(puppy);
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.size());
        assertEquals(puppy, queue.peek());
    }

    @Test
    public void testMultipleEnqueues() {
        QueueTees<Cutie> queue = new QueueTees<>();
        Cutie puppy = new Puppy();
        Cutie kitty = new Kitty();

        queue.enqueue(puppy);
        queue.enqueue(kitty);

        assertEquals(2, queue.size());
        assertEquals(puppy, queue.peek());
    }

    @Test
    public void testDequeue() {
        QueueTees<Cutie> queue = new QueueTees<>();
        Cutie puppy = new Puppy();
        Cutie kitty = new Kitty();

        queue.enqueue(puppy);
        queue.enqueue(kitty);

        assertEquals(puppy, queue.dequeue());
        assertEquals(1, queue.size());
        assertEquals(kitty, queue.peek());
    }

    @Test
    public void testFIFOOrder() {
        QueueTees<Cutie> queue = new QueueTees<>();
        Cutie puppy = new Puppy();
        Cutie kitty = new Kitty();
        Cutie marmoset = new PygmyMarmoset();

        queue.enqueue(puppy);
        queue.enqueue(kitty);
        queue.enqueue(marmoset);

        assertEquals(3, queue.size());
        assertEquals(puppy, queue.dequeue());
        assertEquals(kitty, queue.dequeue());
        assertEquals(marmoset, queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testQueueWithMixedCuties() {
        QueueTees<Cutie> queue = new QueueTees<>();
        Cutie puppy = new Puppy();
        Cutie kitty = new Kitty();
        Cutie marmoset = new PygmyMarmoset();

        queue.enqueue(puppy);
        queue.enqueue(kitty);
        queue.enqueue(marmoset);

        Cutie first = queue.dequeue();
        assertEquals("A little puppy with big, sad eyes", first.description());
        assertEquals(11, first.cutenessRating());

        Cutie second = queue.dequeue();
        assertEquals("A cute kitten", second.description());
        assertEquals(10, second.cutenessRating());

        Cutie third = queue.dequeue();
        assertEquals("A tiny Pygmy Marmoset", third.description());
        assertEquals(9, third.cutenessRating());
    }

    @Test
    public void testSizeAfterOperations() {
        QueueTees<Cutie> queue = new QueueTees<>();
        assertEquals(0, queue.size());

        queue.enqueue(new Puppy());
        assertEquals(1, queue.size());

        queue.enqueue(new Kitty());
        assertEquals(2, queue.size());

        queue.dequeue();
        assertEquals(1, queue.size());

        queue.dequeue();
        assertEquals(0, queue.size());
    }

    @Test
    public void testIsEmptyAfterOperations() {
        QueueTees<Cutie> queue = new QueueTees<>();
        assertTrue(queue.isEmpty());

        queue.enqueue(new Puppy());
        assertFalse(queue.isEmpty());

        queue.dequeue();
        assertTrue(queue.isEmpty());
    }
}