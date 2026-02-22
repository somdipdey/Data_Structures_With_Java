\# HackerRank: Merge Two Sorted Linked Lists (Java 15, Eclipse Project)



This repository contains a \*\*Java 15 solution\*\* for the HackerRank challenge from https://www.hackerrank.com/challenges/one-week-preparation-kit-merge-two-sorted-linked-lists/problem :



\*\*Merge Two Sorted Linked Lists\*\*



It is provided as a simple \*\*Eclipse Java project\*\* so students can:

\- run and test the code locally in Eclipse

\- understand the linked list merge logic

\- copy the solution into HackerRank and submit



---



\## Challenge Summary



Given the heads of two \*\*sorted singly linked lists\*\*, merge them into one sorted linked list.



Example:

\- List A: `1 -> 2 -> 3`

\- List B: `3 -> 4`



Merged:

\- `1 -> 2 -> 3 -> 3 -> 4`



---



\## Learning Goals



This example demonstrates:

\- Singly linked list node structure

\- Building linked lists from input

\- Merging two sorted linked lists using pointers

\- Iterative solution with a dummy node

\- Time complexity and space complexity analysis



---



\## Time Complexity (mergeLists)



For lists of lengths `n` and `m`:



\- \*\*Big-Oh:\*\* `O(n + m)`

\- \*\*Big-Omega:\*\* `Omega(n + m)`

\- \*\*Theta:\*\* `Theta(n + m)`



Reason: every node from both lists is visited at most once.



\*\*Extra space:\*\* `O(1)` (ignoring input/output nodes, since existing nodes are reused)



---



\## Project Structure



```text

src/

&nbsp; Solution.java

sample-input.txt

sample-output.txt

README.md

