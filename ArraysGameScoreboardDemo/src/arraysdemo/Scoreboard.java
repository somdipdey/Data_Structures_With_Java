package arraysdemo;

import java.util.Arrays;

/**
 * Scoreboard
 * Demonstrates the use of a FIXED-SIZE ARRAY to store GameEntry objects.
 *
 * Key array concept:
 * - Arrays have a fixed capacity.
 * - We track how many slots are actually used using 'numEntries'.
 *
 * This scoreboard keeps the TOP scores in descending order.
 */
public class Scoreboard {

    private final GameEntry[] board; // the array
    private int numEntries = 0;      // how many entries are currently stored

    /**
     * Create a scoreboard with a fixed capacity.
     *
     * Time complexity: Θ(1)
     * - Allocating an array of size n is Θ(n) in a strict sense (initialisation),
     *   but for teaching: treat creation as Θ(1) for the algorithmic interface.
     */
    public Scoreboard(int capacity) {
        board = new GameEntry[capacity];
    }

    /**
     * Adds a new GameEntry to the scoreboard if it belongs in the top list.
     * Maintains the array in DESCENDING order by score.
     *
     * Core array operation demonstrated:
     * - Insertion into a sorted array requires shifting elements to make space.
     *
     * Time Complexity Analysis:
     * Let n = capacity of the scoreboard (board.length).
     *
     * Worst-case: O(n)
     *  - Example: new score is the highest → shift many elements right.
     * Best-case: Ω(1)
     *  - Example: scoreboard is full and score is too small → constant-time reject.
     * Typical-case: Θ(n) (often)
     *  - Because insertion usually requires shifting some portion of the array.
     */
    public void add(GameEntry e) {
        int newScore = e.getScore();

        // If scoreboard isn't full, we will definitely insert it somewhere.
        // If it is full, we only insert if newScore is greater than the last entry.
        if (numEntries < board.length) {
            numEntries++; // we have space
        } else {
            // board is full
            if (newScore <= board[numEntries - 1].getScore()) {
                // reject quickly
                // Best-case: Ω(1)
                return;
            }
        }

        // Find the correct position for this entry (descending order).
        // Shift elements to the right until we find the correct spot.
        int i = numEntries - 1;

        // While there is a previous entry and it has a smaller score, shift it right.
        while (i > 0 && board[i - 1].getScore() < newScore) {
            board[i] = board[i - 1]; // shift right
            i--;
        }

        // Insert new entry at position i
        board[i] = e;

        // Worst-case shifting loop runs ~n times => O(n)
        // Best-case shifting runs 0 times => Ω(1) (if it goes at the end)
    }

    /**
     * Removes and returns the entry at index i, shifting remaining elements left.
     *
     * Core array operation demonstrated:
     * - Deletion from an array requires shifting elements to fill the gap.
     *
     * Time Complexity:
     * Worst-case: O(n)
     *  - removing near the start → many elements shift left
     * Best-case: Ω(1)
     *  - removing the last element → no shifting
     * Theta: Θ(n) in general when removal position is arbitrary
     */
    public GameEntry remove(int i) {
        if (i < 0 || i >= numEntries) {
            throw new IndexOutOfBoundsException("Invalid index: " + i);
        }

        GameEntry removed = board[i];

        // Shift entries left to fill the hole
        for (int j = i; j < numEntries - 1; j++) {
            board[j] = board[j + 1];
        }

        // Avoid "loitering": remove reference at the end
        board[numEntries - 1] = null;
        numEntries--;

        return removed;
    }

    /**
     * Returns the number of entries currently stored.
     *
     * Time complexity: Θ(1)
     */
    public int size() {
        return numEntries;
    }

    /**
     * Returns the entry at a given rank/index.
     *
     * Array indexing is constant time:
     * Time complexity: Θ(1)
     */
    public GameEntry get(int index) {
        if (index < 0 || index >= numEntries) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        return board[index];
    }

    /**
     * Returns a snapshot array containing only the used entries (0..numEntries-1).
     *
     * Time complexity: Θ(n) where n = numEntries (copying elements)
     */
    public GameEntry[] entries() {
        return Arrays.copyOf(board, numEntries);
    }

    /**
     * Prints the scoreboard.
     *
     * Time complexity: Θ(n) for printing n entries.
     */
    public void printScoreboard() {
        System.out.println("---- SCOREBOARD (Top " + board.length + ") ----");
        for (int i = 0; i < numEntries; i++) {
            System.out.println((i + 1) + ". " + board[i]);
        }
        System.out.println("------------------------------");
    }
}
