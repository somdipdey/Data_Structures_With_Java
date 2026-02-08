package dsdemo;

import java.util.EmptyStackException;

/**
 * ArrayStack - Stack implementation using an array.
 *
 * Stack Operations:
 * - push(x): add to top
 * - pop(): remove from top
 * - peek(): view top
 * - size(), isEmpty()
 *
 * Time complexity (n = number of elements currently in stack):
 * - push: Θ(1) amortised if we resize by doubling when full; worst-case O(n) during resize
 * - pop:  Θ(1)
 * - peek: Θ(1)
 */
public class ArrayStack<E> implements StackADT<E> {

    private E[] data;
    private int top; // index of next free position; also equals size()

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
        top = 0;
    }

    @Override
    public void push(E element) {
        // If array is full, resize (doubling strategy).
        // Resizing cost: O(n) but happens rarely => amortised Θ(1) per push.
        if (top == data.length) {
            resize(2 * data.length);
        }
        data[top] = element;
        top++;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        top--;
        E answer = data[top];
        data[top] = null; // avoid loitering
        return answer;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return data[top - 1];
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public int size() {
        return top;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        // Copy elements: Θ(n)
        for (int i = 0; i < top; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
