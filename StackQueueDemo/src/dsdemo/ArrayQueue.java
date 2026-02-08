package dsdemo;

import java.util.NoSuchElementException;

/**
 * ArrayQueue - Queue implementation using a circular array (ring buffer).
 *
 * Queue Operations:
 * - enqueue(x): add to rear
 * - dequeue(): remove from front
 * - front(): view front
 *
 * Why circular?
 * - Avoid shifting elements on dequeue (which would be Θ(n)).
 *
 * Time complexity (n = number of elements in queue):
 * - enqueue: Θ(1) amortised with resizing; worst-case O(n) on resize
 * - dequeue: Θ(1)
 * - front:  Θ(1)
 */
public class ArrayQueue<E> implements QueueADT<E> {

    private E[] data;
    private int front; // index of front element
    private int size;  // number of elements

    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        data = (E[]) new Object[capacity];
        front = 0;
        size = 0;
    }

    @Override
    public void enqueue(E element) {
        // Resize if full: O(n) copy but amortised Θ(1) per operation
        if (size == data.length) {
            resize(2 * data.length);
        }
        int avail = (front + size) % data.length; // next free slot at rear
        data[avail] = element;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        E answer = data[front];
        data[front] = null; // avoid loitering
        front = (front + 1) % data.length;
        size--;
        return answer;
    }

    @Override
    public E front() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return data[front];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];

        // Copy elements in correct order: Θ(n)
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
    }
}
