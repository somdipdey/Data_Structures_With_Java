package arraysdemo;

/**
 * DemoScoreboard
 * Run this to show how the array-based scoreboard behaves as you insert entries.
 */
public class DemoScoreboard {
    public static void main(String[] args) {

        // Create a scoreboard that can store only TOP 5 entries (fixed-size array)
        Scoreboard sb = new Scoreboard(5);

        // Add entries (watch how insertion shifts elements in the array)
        sb.add(new GameEntry("Alice", 40));
        sb.add(new GameEntry("Bob", 90));
        sb.add(new GameEntry("Cara", 75));
        sb.add(new GameEntry("Dan", 60));
        sb.add(new GameEntry("Eve", 30));

        sb.printScoreboard();

        // Add an entry that should NOT be included (too low, board full)
        // This demonstrates best-case Ω(1) for add: quick rejection.
        sb.add(new GameEntry("Frank", 10));
        sb.printScoreboard();

        // Add a high score, forcing many shifts (worst-case O(n))
        sb.add(new GameEntry("Grace", 95));
        sb.printScoreboard();

        // Remove an entry from the middle (shifts left => O(n))
        System.out.println("Removing rank 3: " + sb.remove(2));
        sb.printScoreboard();

        // Demonstrate array indexing: Θ(1)
        System.out.println("Top entry (rank 1): " + sb.get(0));
    }
}
