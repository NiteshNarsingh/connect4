/**
 * Tracks and manages game statistics for multiple rounds of Connect Four.
 *
 * This class keeps a record of the number of wins for each player, the number of draws,
 * and specific gameplay events like blocked moves and central moves.
 */
public class GameStatistics {
    private int player1Wins;    // Count of wins for Player 1
    private int player2Wins;    // Count of wins for Player 2
    private int draws;          // Count of games that ended in a draw
    private int blockedMoves;   // Count of moves that blocked an opponent's potential win
    private int centralMoves;   // Count of moves made in the central column (column 3)

    /**
     * Increments the win count for Player 1.
     */
    public void incrementPlayer1Wins() {
        player1Wins++;
    }

    /**
     * Increments the win count for Player 2.
     */
    public void incrementPlayer2Wins() {
        player2Wins++;
    }

    /**
     * Increments the draw count.
     */
    public void incrementDraws() {
        draws++;
    }

    /**
     * Increments the count of moves that blocked the opponent from winning.
     */
    public void incrementBlockedMoves() {
        blockedMoves++;
    }

    /**
     * Increments the count of moves made in the central column (column 3).
     */
    public void incrementCentralMoves() {
        centralMoves++;
    }

    /**
     * Prints the collected statistics to the console in a readable format.
     */
    public void printStatistics() {
        System.out.println("Game Statistics:");
        System.out.println("Player 1 Wins: " + player1Wins);
        System.out.println("Player 2 Wins: " + player2Wins);
        System.out.println("Draws: " + draws);
        System.out.println("Blocked Moves: " + blockedMoves);
        System.out.println("Central Moves: " + centralMoves);
    }
}
