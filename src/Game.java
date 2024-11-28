/**
 * Manages a single game of Connect Four.
 *
 * This class handles the game logic, including switching between players,
 * checking for wins or draws, and updating the game board's visual representation.
 */
public class Game {
    private Board board;                 // The game board
    private GreedyPlayer player1;        // AI Player 1
    private GreedyPlayer player2;        // AI Player 2
    private GameVisualizer visualizer;   // Visual representation of the game board
    private GameStatistics statistics;   // Tracks statistics for the game

    /**
     * Constructor for the Game class.
     *
     * @param statistics the object that tracks game statistics
     * @param visualizer the object that visually represents the game board
     */
    public Game(GameStatistics statistics, GameVisualizer visualizer) {
        this.statistics = statistics;
        this.visualizer = visualizer;
        board = new Board();
        player1 = new GreedyPlayer('X', board, 'O', statistics); // Player 1 uses 'X'
        player2 = new GreedyPlayer('O', board, 'X', statistics); // Player 2 uses 'O'
    }

    /**
     * Starts and manages the game loop.
     *
     * The game alternates turns between Player 1 and Player 2 until there is a winner
     * or the board is full (resulting in a draw). The board state is updated visually
     * after each move.
     */
    public void start() {
        GreedyPlayer currentPlayer = player1; // Player 1 starts the game

        while (true) {
            // Get the column for the current player's move
            int col = currentPlayer.chooseMove();

            // Execute the chosen move by placing the player's disc on the board
            board.dropDisc(col, currentPlayer.getSymbol());
            visualizer.updateGrid(board.getGrid()); // Update the visual board

            // Check if the current player has won
            if (board.checkWin(currentPlayer.getSymbol())) {
                if (currentPlayer == player1) {
                    statistics.incrementPlayer1Wins(); // Update Player 1's win count
                } else {
                    statistics.incrementPlayer2Wins(); // Update Player 2's win count
                }
                break; // End the game if there is a winner
            }

            // Check if the board is full, resulting in a draw
            if (board.isFull()) {
                statistics.incrementDraws(); // Update the draw count
                break; // End the game if it's a draw
            }

            // Switch to the other player
            currentPlayer = (currentPlayer == player1) ? player2 : player1;

            // Add a short delay for animation purposes
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
