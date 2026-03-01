package algodemo;

import java.util.Arrays;

/**
 * SortExamples
 *
 * Demonstrates:
 * - Merge Sort
 * - Quick Sort
 *
 * Both are divide-and-conquer algorithms.
 */
public class SortExamples {

    /**
     * Merge Sort
     *
     * Steps:
     * 1. Divide array into two halves
     * 2. Recursively sort each half
     * 3. Merge the sorted halves
     *
     * Time Complexity:
     * Best case: O(n log n)
     * Worst case: O(n log n)
     * Average case: O(n log n)
     *
     * Space Complexity:
     * O(n) because of temporary arrays
     */
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Sort left half
            mergeSort(arr, left, mid);

            // Sort right half
            mergeSort(arr, mid + 1, right);

            // Merge sorted halves
            merge(arr, left, mid, right);
        }
    }

    /**
     * Helper method for Merge Sort
     */
    private static void merge(int[] arr, int left, int mid, int right) {
        // Sizes of the two temporary subarrays
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Temporary arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data into temporary arrays
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }

        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        // Merge the temp arrays back into arr[left...right]
        int i = 0; // index for leftArray
        int j = 0; // index for rightArray
        int k = left; // index for merged array

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements from leftArray
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements from rightArray
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    /**
     * Quick Sort
     *
     * Steps:
     * 1. Choose a pivot
     * 2. Partition array so smaller values go left of pivot
     *    and larger values go right of pivot
     * 3. Recursively sort left and right parts
     *
     * Time Complexity:
     * Best case: O(n log n)
     * Average case: O(n log n)
     * Worst case: O(n^2)
     *
     * Space Complexity:
     * O(log n) average recursive stack
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition the array and get pivot index
            int pivotIndex = partition(arr, low, high);

            // Sort elements before pivot
            quickSort(arr, low, pivotIndex - 1);

            // Sort elements after pivot
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    /**
     * Partition method for Quick Sort
     *
     * Here we choose the last element as the pivot.
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // pivot
        int i = low - 1; // index of smaller element

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place pivot in correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    /**
     * Helper method to print arrays nicely
     */
    public static void printArray(String message, int[] arr) {
        System.out.println(message + Arrays.toString(arr));
    }
}