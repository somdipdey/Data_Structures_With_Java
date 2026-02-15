package lldemo;

/**
 * SinglyLinkedList<T>
 *
 * Singly linked list nodes have:
 *   data + next pointer
 *
 * Only forward traversal is possible (head -> ... -> null).
 *
 * Key idea:
 * - The list stores a reference to the FIRST node (head).
 * - Each node points to the next node.
 *
 * Complexity (n = number of nodes):
 * - addFirst: Θ(1)
 * - removeFirst: Θ(1)
 * - addLast: Θ(n) (must traverse to tail)
 * - removeLast: Θ(n) (must traverse to node before tail)
 * - contains/search: Θ(n)
 */
public class SinglyLinkedList<T> {

    /**
     * Node is a nested class: each node stores data + link to next node.
     */
    private static class Node<T> {
        T data;
        Node<T> next; // reference to the next node

        Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<T> head; // first node
    private int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Adds a new element at the front of the list.
     *
     * Example:
     *   Before: head -> A -> B -> null
     *   addFirst(X)
     *   After:  head -> X -> A -> B -> null
     *
     * Θ(1)
     */
    public void addFirst(T value) {
        head = new Node<>(value, head);
        size++;
    }

    /**
     * Adds a new element at the end of the list.
     *
     * Requires traversal because we do not store a tail pointer.
     *
     * Θ(n)
     */
    public void addLast(T value) {
        Node<T> newNode = new Node<>(value, null);

        if (head == null) {
            head = newNode; // empty list
        } else {
            Node<T> current = head;
            while (current.next != null) { // walk until last node
                current = current.next;
            }
            current.next = newNode; // link last node to new node
        }
        size++;
    }

    /**
     * Removes and returns the first element.
     *
     * Example:
     *   Before: head -> A -> B -> null
     *   removeFirst()
     *   After:  head -> B -> null
     *
     * Θ(1)
     */
    public T removeFirst() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }

        T removed = head.data;
        head = head.next; // move head forward
        size--;
        return removed;
    }

    /**
     * Checks if the list contains a value.
     *
     * Θ(n)
     */
    public boolean contains(T value) {
        Node<T> current = head;
        while (current != null) {
            // Use equals for object comparison (null-safe check)
            if (value == null ? current.data == null : value.equals(current.data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Removes the first occurrence of a value.
     *
     * Cases:
     * - Removing head
     * - Removing middle node
     * - Value not found
     *
     * Θ(n)
     */
    public boolean remove(T value) {
        if (head == null) return false;

        // Case 1: head needs removal
        if (value == null ? head.data == null : value.equals(head.data)) {
            head = head.next;
            size--;
            return true;
        }

        // Case 2: find node BEFORE the one we want to remove
        Node<T> current = head;
        while (current.next != null) {
            if (value == null ? current.next.data == null : value.equals(current.next.data)) {
                // "Skip" the node by relinking
                current.next = current.next.next;
                size--;
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
     * Prints list contents.
     * Θ(n)
     */
    public void print() {
        System.out.print("SLL: head -> ");
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
