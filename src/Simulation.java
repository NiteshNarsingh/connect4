import javax.swing.*;

/**
 * Simulates multiple games of Connect Four and displays the results.
 *
 * This class creates a visualizer for the game, runs 20 simulated games
 * using AI players, and outputs cumulative statistics for all games.
 */
public class Simulation {

    /**
     * The main method serves as the entry point for the simulation.
     *
     * It initializes the game statistics tracker, visualizer, and a loop
     * to simulate 20 games. After all games, it displays the cumulative
     * statistics in the console.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Create the statistics object to track results across all games
        GameStatistics statistics = new GameStatistics();

        // Initialize the game visualizer within a JFrame
        JFrame frame = new JFrame("Connect Four");
        GameVisualizer visualizer = new GameVisualizer();
        frame.add(visualizer);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Simulate 20 games
        for (int i = 0; i < 20; i++) {
            System.out.println("Starting Game " + (i + 1));
            Game game = new Game(statistics, visualizer); // Pass both statistics and visualizer
            game.start(); // Start the game simulation
        }

        // Print the cumulative statistics after all games
        statistics.printStatistics();
    }
}
