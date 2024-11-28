/**
 * Represents the Connect Four board and manages the game state.
 * This version only supports horizontal and vertical win conditions.
 */
public class Board {
    private char[][] grid;
    private final int rows = 6; // Number of rows
    private final int cols = 7; // Number of columns

    /**
     * Constructor to initialize the board with empty cells ('.').
     */
    public Board() {
        grid = new char[rows][cols];
        for (char[] row : grid) {
            java.util.Arrays.fill(row, '.'); // Empty cell representation
        }
    }

    /**
     * Drops a disc in the specified column for the given player.
     *
     * @param col the column to drop the disc
     * @param playerSymbol the player's symbol ('X' or 'O')
     * @return true if the move is valid and successful, false otherwise
     */
    public boolean dropDisc(int col, char playerSymbol) {
        if (col < 0 || col >= cols || grid[0][col] != '.') {
            return false; // Invalid move
        }
        for (int i = rows - 1; i >= 0; i--) {
            if (grid[i][col] == '.') {
                grid[i][col] = playerSymbol;
                return true;
            }
        }
        return false;
    }

    /**
     * Removes the top-most disc from the specified column.
     *
     * @param col the column to remove the disc from
     */
    public void removeTopDisc(int col) {
        for (int i = 0; i < rows; i++) {
            if (grid[i][col] != '.') {
                grid[i][col] = '.';
                break;
            }
        }
    }

    /**
     * Checks if the board is completely full (no valid moves left).
     *
     * @return true if the board is full, false otherwise
     */
    public boolean isFull() {
        for (int col = 0; col < cols; col++) {
            if (grid[0][col] == '.') {
                return false; // At least one column is not full
            }
        }
        return true; // All columns are full
    }

    /**
     * Checks if the given player has won with a horizontal or vertical line of 4 discs.
     *
     * @param playerSymbol the player's symbol ('X' or 'O')
     * @return true if the player has won, false otherwise
     */
    public boolean checkWin(char playerSymbol) {
        return checkHorizontal(playerSymbol) || checkVertical(playerSymbol);
    }

    /**
     * Checks for a horizontal win for the given player.
     *
     * @param playerSymbol the player's symbol ('X' or 'O')
     * @return true if the player has 4 consecutive discs horizontally, false otherwise
     */
    private boolean checkHorizontal(char playerSymbol) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col <= grid[0].length - 4; col++) {
                if (grid[row][col] == playerSymbol &&
                        grid[row][col + 1] == playerSymbol &&
                        grid[row][col + 2] == playerSymbol &&
                        grid[row][col + 3] == playerSymbol) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks for a vertical win for the given player.
     *
     * @param playerSymbol the player's symbol ('X' or 'O')
     * @return true if the player has 4 consecutive discs vertically, false otherwise
     */
    private boolean checkVertical(char playerSymbol) {
        for (int col = 0; col < grid[0].length; col++) {
            for (int row = 0; row <= grid.length - 4; row++) {
                if (grid[row][col] == playerSymbol &&
                        grid[row + 1][col] == playerSymbol &&
                        grid[row + 2][col] == playerSymbol &&
                        grid[row + 3][col] == playerSymbol) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Retrieves the current state of the game grid.
     *
     * @return the game grid
     */
    public char[][] getGrid() {
        return grid;
    }
}
