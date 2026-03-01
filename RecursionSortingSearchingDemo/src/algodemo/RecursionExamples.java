package algodemo;

/**
 * RecursionExamples
 *
 * This class demonstrates recursion using simple examples.
 *
 * Recursion means a method calls itself.
 * A recursive solution usually has:
 * 1. Base case -> stops the recursion
 * 2. Recursive case -> method calls itself with a smaller/simpler problem
 */
public class RecursionExamples {

    /**
     * Factorial using recursion
     *
     * factorial(5) = 5 * 4 * 3 * 2 * 1 = 120
     *
     * Base case:
     * factorial(0) = 1
     *
     * Time Complexity:
     * O(n)
     */
    public static int factorial(int n) {
        if (n == 0) { // base case
            return 1;
        }
        return n * factorial(n - 1); // recursive case
    }

    /**
     * Fibonacci using recursion
     *
     * fibonacci(0) = 0
     * fibonacci(1) = 1
     * fibonacci(2) = 1
     * fibonacci(3) = 2
     * fibonacci(4) = 3
     * fibonacci(5) = 5
     *
     * Time Complexity:
     * O(2^n) in this simple recursive version
     *
     * Good for teaching recursion, but not efficient.
     */
    public static int fibonacci(int n) {
        if (n == 0) { // base case 1
            return 0;
        }
        if (n == 1) { // base case 2
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2); // recursive case
    }

    /**
     * Recursive method to print array elements
     *
     * Time Complexity:
     * O(n)
     */
    public static void printArrayRecursive(int[] arr, int index) {
        if (index == arr.length) { // base case
            return;
        }

        System.out.print(arr[index] + " ");
        printArrayRecursive(arr, index + 1); // recursive call
    }
}