package dsdemo;

/**
 * STACK (ADT) - Abstract Data Type
 *
 * Definition (LIFO):
 * Last-In, First-Out. The last item pushed is the first one popped.
 *
 * ADT idea:
 * - Defines WHAT operations exist (behaviour), not HOW they are implemented.
 */
public interface StackADT<E> {

    /** Push element onto top of stack. */
    void push(E element);

    /** Remove and return the top element. */
    E pop();

    /** Return the top element without removing it. */
    E peek();

    /** True if stack has no elements. */
    boolean isEmpty();

    /** Number of elements currently in the stack. */
    int size();
}
