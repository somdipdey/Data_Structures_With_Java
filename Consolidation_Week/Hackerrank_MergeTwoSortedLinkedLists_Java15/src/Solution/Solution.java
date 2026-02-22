package Solution; // Remove this line when uploading solution code to Hackerrank since this is only created to create a package in Eclipse project

import java.io.*;
import java.util.*;

public class Solution {

    // Node definition for singly linked list
    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        SinglyLinkedListNode(int data) {
            this.data = data;
        }
    }

    // Helper linked list class to build lists easily from input
    static class SinglyLinkedList {
        SinglyLinkedListNode head;
        SinglyLinkedListNode tail;

        void insertNode(int data) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(data);

            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
        }
    }

    /*
     * Merge two sorted linked lists into one sorted list.
     *
     * Time Complexity:
     * - Big-Oh: O(n + m)
     * - Big-Omega: Omega(n + m)
     * - Theta: Theta(n + m)
     * because every node from both lists is visited once.
     *
     * Space Complexity:
     * - O(1) extra space (iterative approach, ignoring output list nodes since we reuse nodes)
     */
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode headA, SinglyLinkedListNode headB) {
        // Dummy node helps simplify edge cases
        SinglyLinkedListNode dummy = new SinglyLinkedListNode(0);
        SinglyLinkedListNode tail = dummy;

        SinglyLinkedListNode a = headA;
        SinglyLinkedListNode b = headB;

        while (a != null && b != null) {
            if (a.data <= b.data) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }

        // Attach remaining nodes (only one of these will be non-null)
        tail.next = (a != null) ? a : b;

        return dummy.next;
    }

    // Print linked list in required format: space-separated values
    static void printLinkedList(SinglyLinkedListNode head) {
        StringBuilder sb = new StringBuilder();
        SinglyLinkedListNode current = head;

        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append(" ");
            current = current.next;
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tests = sc.nextInt();

        for (int t = 0; t < tests; t++) {
            // First list
            int n = sc.nextInt();
            SinglyLinkedList listA = new SinglyLinkedList();
            for (int i = 0; i < n; i++) {
                listA.insertNode(sc.nextInt());
            }

            // Second list
            int m = sc.nextInt();
            SinglyLinkedList listB = new SinglyLinkedList();
            for (int i = 0; i < m; i++) {
                listB.insertNode(sc.nextInt());
            }

            // Merge and print
            SinglyLinkedListNode mergedHead = mergeLists(listA.head, listB.head);
            printLinkedList(mergedHead);
        }

        sc.close();
    }
}