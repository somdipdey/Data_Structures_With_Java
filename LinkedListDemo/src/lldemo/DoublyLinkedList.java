package lldemo;

/**
 * DoublyLinkedList<T>
 *
 * Doubly linked list nodes have:
 *   data + next pointer + prev pointer
 *
 * This allows traversal in BOTH directions.
 *
 * Key idea:
 * - We keep references to BOTH ends: head and tail.
 *
 * Complexity (n = number of nodes):
 * - addFirst: Θ(1)
 * - addLast:  Θ(1) because we have a tail pointer
 * - removeFirst: Θ(1)
 * - removeLast:  Θ(1) because we have a tail pointer
 * - contains/search: Θ(n)
 */
public class DoublyLinkedList<T> {

    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<T> head; // first node
    private Node<T> tail; // last node
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Add at the front.
     *
     * Before: head <-> A <-> B <-> tail
     * After addFirst(X):
     *         head <-> X <-> A <-> B <-> tail
     *
     * Θ(1)
     */
    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value, null, head);

        if (head == null) {
            // Empty list: head and tail become the same node
            head = tail = newNode;
        } else {
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    /**
     * Add at the end (rear).
     *
     * Because we store tail, this is Θ(1).
     */
    public void addLast(T value) {
        Node<T> newNode = new Node<>(value, tail, null);

        if (tail == null) {
            // Empty list
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /**
     * Remove first element.
     * Θ(1)
     */
    public T removeFirst() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }

        T removed = head.data;

        if (head == tail) {
            // Single-element list
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null; // detach old head
        }
        size--;
        return removed;
    }

    /**
     * Remove last element.
     * Θ(1)
     */
    public T removeLast() {
        if (tail == null) {
            throw new IllegalStateException("List is empty");
        }

        T removed = tail.data;

        if (head == tail) {
            // Single-element list
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null; // detach old tail
        }
        size--;
        return removed;
    }

    /**
     * Check if value exists.
     * Θ(n)
     */
    public boolean contains(T value) {
        Node<T> current = head;
        while (current != null) {
            if (value == null ? current.data == null : value.equals(current.data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int size() {
        return size;
    }

    /**
     * Print forward traversal (head -> tail).
     * Θ(n)
     */
    public void printForward() {
        System.out.print("DLL forward: head <-> ");
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    /**
     * Print backward traversal (tail -> head).
     * Θ(n)
     */
    public void printBackward() {
        System.out.print("DLL backward: tail <-> ");
        Node<T> current = tail;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        }
        System.out.println("null");
    }
}
