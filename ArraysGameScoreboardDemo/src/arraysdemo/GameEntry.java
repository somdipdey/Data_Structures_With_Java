package arraysdemo;

/**
 * GameEntry
 * Stores a player's name and their best score so far.
 *
 * This class is intentionally simple so we can focus on arrays in Scoreboard.
 *
 * Time complexity notes:
 * - Creating a GameEntry object: Θ(1)
 * - Accessors (getName/getScore): Θ(1)
 */
public class GameEntry {
    private final String name;
    private final int score;

    public GameEntry(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {  // Θ(1)
        return name;
    }

    public int getScore() {    // Θ(1)
        return score;
    }

    @Override
    public String toString() { // Θ(1) relative to fixed-size formatting (ignoring string length)
        return name + " : " + score;
    }
}
