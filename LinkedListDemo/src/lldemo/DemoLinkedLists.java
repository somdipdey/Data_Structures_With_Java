package lldemo;

/**
 * DemoLinkedLists
 * Run this class to show operations and how pointers change.
 */
public class DemoLinkedLists {
    public static void main(String[] args) {

        // ==========================
        // Singly Linked List demo
        // ==========================
        System.out.println("=== Singly Linked List Demo ===");
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();

        sll.addFirst(10); // head -> 10 -> null
        sll.addFirst(20); // head -> 20 -> 10 -> null
        sll.addLast(5);   // head -> 20 -> 10 -> 5 -> null (traversal required)
        sll.print();

        System.out.println("Contains 10? " + sll.contains(10));
        System.out.println("RemoveFirst: " + sll.removeFirst());
        sll.print();

        System.out.println("Remove value 10: " + sll.remove(10));
        sll.print();
        System.out.println("Size: " + sll.size());

        // ==========================
        // Doubly Linked List demo
        // ==========================
        System.out.println("\n=== Doubly Linked List Demo ===");
        DoublyLinkedList<String> dll = new DoublyLinkedList<>();

        dll.addFirst("B"); // head=tail="B"
        dll.addFirst("A"); // head="A" <-> "B"
        dll.addLast("C");  // "A" <-> "B" <-> "C" (Θ(1) due to tail)
        dll.addLast("D");  // "A" <-> "B" <-> "C" <-> "D"
        dll.printForward();

        // Show backward traversal (possible only with doubly linked list)
        dll.printBackward();

        System.out.println("RemoveFirst: " + dll.removeFirst());
        dll.printForward();

        System.out.println("RemoveLast: " + dll.removeLast());
        dll.printForward();

        System.out.println("Size: " + dll.size());
        System.out.println("Contains 'C'? " + dll.contains("C"));
    }
}
