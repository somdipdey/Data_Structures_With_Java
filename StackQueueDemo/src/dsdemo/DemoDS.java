package dsdemo;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * DemoDS
 * Run this class in Eclipse: Right-click -> Run As -> Java Application
 *
 * Shows:
 * 1) Custom Stack ADT + ArrayStack implementation
 * 2) Stack Interface usage in Java (best practice: Deque)
 * 3) Custom Queue ADT + ArrayQueue implementation (circular array)
 * 4) Queue Interface usage in Java (java.util.Queue)
 */
public class DemoDS {

    public static void main(String[] args) {

        // ============================================================
        // 1) STACK - using our ADT + array implementation
        // ============================================================
        System.out.println("=== CUSTOM STACK (ArrayStack) ===");
        StackADT<Integer> s = new ArrayStack<>(3);

        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println("Top (peek): " + s.peek()); // 30

        System.out.println("Pop: " + s.pop());         // 30
        System.out.println("Pop: " + s.pop());         // 20
        System.out.println("Size now: " + s.size());   // 1
        System.out.println("Is empty? " + s.isEmpty());

        // push triggers resize when capacity exceeded (amortised Θ(1))
        s.push(99);
        s.push(100);
        s.push(101);
        System.out.println("Top after pushes: " + s.peek());

        // ============================================================
        // 2) STACK interface in Java
        // ============================================================
        System.out.println("\n=== JAVA STACK (Deque as Stack) ===");

        // In modern Java, Deque is recommended for stack behaviour.
        // Operations: push, pop, peek
        Deque<String> stack = new ArrayDeque<>();
        stack.push("A"); // push to top
        stack.push("B");
        stack.push("C");

        System.out.println("Deque peek: " + stack.peek()); // C
        System.out.println("Deque pop: " + stack.pop());   // C
        System.out.println("Deque pop: " + stack.pop());   // B

        // ============================================================
        // 3) QUEUE - using our ADT + circular array implementation
        // ============================================================
        System.out.println("\n=== CUSTOM QUEUE (ArrayQueue) ===");
        QueueADT<String> q = new ArrayQueue<>(3);

        q.enqueue("Alice");
        q.enqueue("Bob");
        q.enqueue("Cara");

        System.out.println("Front: " + q.front());     // Alice
        System.out.println("Dequeue: " + q.dequeue()); // Alice
        System.out.println("Front now: " + q.front()); // Bob
        System.out.println("Size now: " + q.size());   // 2

        // Enqueue more (wrap-around in circular array)
        q.enqueue("Dan");
        q.enqueue("Eve"); // may trigger resize if capacity exceeded
        System.out.println("Dequeue: " + q.dequeue()); // Bob

        // ============================================================
        // 4) QUEUE interface in Java
        // ============================================================
        System.out.println("\n=== JAVA QUEUE (Queue interface) ===");

        // java.util.Queue is an interface. Common implementations:
        // - LinkedList
        // - ArrayDeque (often faster than LinkedList for queue operations)
        Queue<Integer> javaQueue = new LinkedList<>();

        // Queue operations (preferred names):
        // offer(x): enqueue (returns false if can't add)
        // poll(): dequeue (returns null if empty)
        // peek(): front (returns null if empty)
        javaQueue.offer(1);
        javaQueue.offer(2);
        javaQueue.offer(3);

        System.out.println("Peek: " + javaQueue.peek()); // 1
        System.out.println("Poll: " + javaQueue.poll()); // 1
        System.out.println("Poll: " + javaQueue.poll()); // 2
        System.out.println("Size: " + javaQueue.size()); // 1

        // Show ArrayDeque as a queue too
        Queue<Integer> fastQueue = new ArrayDeque<>();
        fastQueue.offer(10);
        fastQueue.offer(20);
        System.out.println("ArrayDeque queue poll: " + fastQueue.poll()); // 10

        System.out.println("\nDemo complete.");
    }
}
