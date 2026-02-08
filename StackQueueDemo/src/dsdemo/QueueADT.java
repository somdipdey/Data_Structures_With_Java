package dsdemo;

/**
 * QUEUE (ADT) - Abstract Data Type
 *
 * Definition (FIFO):
 * First-In, First-Out. The first item enqueued is the first one dequeued.
 *
 * ADT idea:
 * - Defines WHAT operations exist, not HOW implemented.
 */
public interface QueueADT<E> {

    /** Add element to the back (rear) of the queue. */
    void enqueue(E element);

    /** Remove and return element from the front of the queue. */
    E dequeue();

    /** Return (but do not remove) the front element. */
    E front();

    /** True if queue is empty. */
    boolean isEmpty();

    /** Number of elements in queue. */
    int size();
}
