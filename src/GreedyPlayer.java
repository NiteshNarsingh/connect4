import java.util.Random;

/**
 * Represents a greedy AI player in the Connect Four game.
 *
 * The AI attempts to block the opponent's winning moves, secure its own wins,
 * and occasionally makes random moves to simulate variability and encourage draws.
 */
public class GreedyPlayer extends Player {
    private Board board;                 // Reference to the game board
    private char opponentSymbol;         // Symbol of the opponent player ('X' or 'O')
    private GameStatistics statistics;   // Tracker for game statistics
    private Random random;               // Random number generator for making unpredictable moves

    /**
     * Constructor for the GreedyPlayer.
     *
     * @param symbol the AI's symbol ('X' or 'O')
     * @param board the game board
     * @param opponentSymbol the opponent's symbol ('X' or 'O')
     * @param statistics the game statistics tracker
     */
    public GreedyPlayer(char symbol, Board board, char opponentSymbol, GameStatistics statistics) {
        super(symbol);
        this.board = board;
        this.opponentSymbol = opponentSymbol;
        this.statistics = statistics;
        this.random = new Random();
    }

    /**
     * Chooses a move for the AI player based on the game state.
     *
     * The AI prioritizes:
     * 1. Blocking the opponent's winning moves.
     * 2. Making a winning move for itself.
     * 3. Occasionally making random moves to increase draw chances.
     *
     * @return the column where the AI decides to drop its disc
     */
    public int chooseMove() {
        // Introduce a small chance of making a random move (10%)
        if (random.nextDouble() < 0.1) {
            return makeRandomMove();
        }

        // Check for a blocking move to prevent the opponent from winning
        for (int col = 0; col < 7; col++) {
            if (board.dropDisc(col, opponentSymbol)) {
                if (board.checkWin(opponentSymbol)) {
                    board.removeTopDisc(col); // Undo move after checking
                    statistics.incrementBlockedMoves(); // Track the blocking move
                    return col; // Play the blocking move
                }
                board.removeTopDisc(col); // Undo move after simulation
            }
        }

        // Check for a winning move for itself
        for (int col = 0; col < 7; col++) {
            if (board.dropDisc(col, getSymbol())) {
                if (board.checkWin(getSymbol())) {
                    board.removeTopDisc(col); // Undo move after checking
                    return col; // Play the winning move
                }
                board.removeTopDisc(col); // Undo move after simulation
            }
        }

        // If no winning or blocking move exists, make a random valid move
        return makeRandomMove();
    }

    /**
     * Makes a random valid move by choosing an available column.
     *
     * Ensures the column is not full before placing the disc.
     *
     * @return the column where the AI places its disc
     */
    private int makeRandomMove() {
        int col;
        do {
            col = random.nextInt(7); // Pick a random column between 0 and 6
        } while (!board.dropDisc(col, getSymbol())); // Ensure the column is valid
        board.removeTopDisc(col); // Undo the temporary move to maintain game state
        return col;
    }
}
