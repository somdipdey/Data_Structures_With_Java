package algodemo;

/**
 * SearchExamples
 *
 * Demonstrates:
 * - Linear Search
 * - Binary Search (iterative)
 * - Binary Search (recursive)
 */
public class SearchExamples {

    /**
     * Linear Search
     *
     * Checks every element one by one until the target is found.
     *
     * Works on:
     * - sorted arrays
     * - unsorted arrays
     *
     * Time Complexity:
     * Best case: O(1)
     * Worst case: O(n)
     * Average case: O(n)
     */
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // return index if found
            }
        }
        return -1; // not found
    }

    /**
     * Binary Search (Iterative)
     *
     * IMPORTANT:
     * Binary Search only works on a SORTED array.
     *
     * Idea:
     * - Compare target with middle element
     * - If target is smaller, search left half
     * - If target is larger, search right half
     *
     * Time Complexity:
     * O(log n)
     */
    public static int binarySearchIterative(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (target < arr[mid]) {
                high = mid - 1; // search left half
            } else {
                low = mid + 1; // search right half
            }
        }

        return -1; // not found
    }

    /**
     * Binary Search (Recursive)
     *
     * Time Complexity:
     * O(log n)
     */
    public static int binarySearchRecursive(int[] arr, int target, int low, int high) {
        if (low > high) { // base case: target not found
            return -1;
        }

        int mid = (low + high) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (target < arr[mid]) {
            return binarySearchRecursive(arr, target, low, mid - 1);
        } else {
            return binarySearchRecursive(arr, target, mid + 1, high);
        }
    }
}