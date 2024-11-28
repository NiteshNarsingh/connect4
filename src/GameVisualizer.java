import javax.swing.*;
import java.awt.*;

/**
 * A visual representation of the Connect Four board.
 *
 * This class extends JPanel to provide a 2D graphical visualization of the game board,
 * updating dynamically as the game progresses.
 */
public class GameVisualizer extends JPanel {
    private final int rows = 6;        // Number of rows in the board
    private final int cols = 7;        // Number of columns in the board
    private final int cellSize = 100; // Size of each cell in pixels
    private final char[][] grid;      // Grid representation of the board

    /**
     * Constructor for GameVisualizer.
     * Initializes the grid with empty cells represented by '.'.
     */
    public GameVisualizer() {
        this.grid = new char[rows][cols];
        for (char[] row : grid) {
            java.util.Arrays.fill(row, '.'); // Empty cell representation
        }
    }

    /**
     * Updates the grid with the latest game state.
     * This method is called whenever the board changes.
     *
     * @param newGrid the updated game grid
     */
    public void updateGrid(char[][] newGrid) {
        for (int i = 0; i < rows; i++) {
            System.arraycopy(newGrid[i], 0, grid[i], 0, cols);
        }
        repaint(); // Redraw the panel with the updated grid
    }

    /**
     * Paints the Connect Four board and discs on the JPanel.
     * Called automatically whenever the component needs to be redrawn.
     *
     * @param g the Graphics object for drawing
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the board background
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, cols * cellSize, rows * cellSize);

        // Draw each cell and its contents
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // Draw the cell as a white circle
                g.setColor(Color.WHITE);
                g.fillOval(c * cellSize + 10, r * cellSize + 10, cellSize - 20, cellSize - 20);

                // Draw the disc if present
                if (grid[r][c] == 'X') {
                    g.setColor(Color.RED); // Player 1's disc
                } else if (grid[r][c] == 'O') {
                    g.setColor(Color.YELLOW); // Player 2's disc
                } else {
                    continue; // Skip empty cells
                }
                g.fillOval(c * cellSize + 10, r * cellSize + 10, cellSize - 20, cellSize - 20);
            }
        }
    }

    /**
     * Returns the preferred size of the JPanel.
     * Ensures the JPanel is large enough to display the entire board.
     *
     * @return the preferred size of the JPanel
     */
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(cols * cellSize, rows * cellSize);
    }
}
