package algodemo;

/**
 * DemoAlgorithms
 *
 * Run this file in Eclipse to demonstrate:
 * - Recursion
 * - Linear Search
 * - Binary Search
 * - Merge Sort
 * - Quick Sort
 */
public class DemoAlgorithms {

    public static void main(String[] args) {

        // =====================================================
        // 1. RECURSION
        // =====================================================
        System.out.println("=== RECURSION EXAMPLES ===");
        System.out.println("Factorial of 5: " + RecursionExamples.factorial(5));
        System.out.println("Fibonacci of 6: " + RecursionExamples.fibonacci(6));

        int[] recursiveArray = {10, 20, 30, 40, 50};
        System.out.print("Print array recursively: ");
        RecursionExamples.printArrayRecursive(recursiveArray, 0);
        System.out.println();

        // =====================================================
        // 2. LINEAR SEARCH
        // =====================================================
        System.out.println("\n=== LINEAR SEARCH ===");
        int[] unsortedArray = {7, 2, 9, 4, 1, 6};
        int target1 = 4;
        int linearResult = SearchExamples.linearSearch(unsortedArray, target1);

        if (linearResult != -1) {
            System.out.println("Target " + target1 + " found at index " + linearResult);
        } else {
            System.out.println("Target " + target1 + " not found");
        }

        // =====================================================
        // 3. MERGE SORT
        // =====================================================
        System.out.println("\n=== MERGE SORT ===");
        int[] mergeSortArray = {38, 27, 43, 3, 9, 82, 10};

        SortExamples.printArray("Before Merge Sort: ", mergeSortArray);
        SortExamples.mergeSort(mergeSortArray, 0, mergeSortArray.length - 1);
        SortExamples.printArray("After Merge Sort:  ", mergeSortArray);

        // =====================================================
        // 4. QUICK SORT
        // =====================================================
        System.out.println("\n=== QUICK SORT ===");
        int[] quickSortArray = {29, 10, 14, 37, 13, 5, 8};

        SortExamples.printArray("Before Quick Sort: ", quickSortArray);
        SortExamples.quickSort(quickSortArray, 0, quickSortArray.length - 1);
        SortExamples.printArray("After Quick Sort:  ", quickSortArray);

        // =====================================================
        // 5. BINARY SEARCH
        // =====================================================
        System.out.println("\n=== BINARY SEARCH ===");
        // Binary search requires sorted array
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15};
        int target2 = 11;

        int binaryIterResult = SearchExamples.binarySearchIterative(sortedArray, target2);
        if (binaryIterResult != -1) {
            System.out.println("Iterative Binary Search: target " + target2 +
                    " found at index " + binaryIterResult);
        } else {
            System.out.println("Iterative Binary Search: target not found");
        }

        int binaryRecResult = SearchExamples.binarySearchRecursive(
                sortedArray, target2, 0, sortedArray.length - 1);

        if (binaryRecResult != -1) {
            System.out.println("Recursive Binary Search: target " + target2 +
                    " found at index " + binaryRecResult);
        } else {
            System.out.println("Recursive Binary Search: target not found");
        }

        // =====================================================
        // 6. RECAP
        // =====================================================
        System.out.println("\n=== TEACHING RECAP ===");
        System.out.println("Linear Search works on unsorted arrays but is slower: O(n)");
        System.out.println("Binary Search is faster: O(log n), but needs a sorted array");
        System.out.println("Merge Sort is always O(n log n), but uses extra memory");
        System.out.println("Quick Sort is often very fast, average O(n log n), but worst-case O(n^2)");
        System.out.println("Recursion is used in Merge Sort, Quick Sort, and Recursive Binary Search");
    }
}