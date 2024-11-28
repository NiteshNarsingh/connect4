import javax.swing.*;

/**
 * The entry point for the Connect Four application.
 *
 * This class initializes the game environment, including the statistics tracker,
 * visualizer, and game loop to simulate 20 matches. The results are displayed
 * visually and printed as cumulative statistics after all games.
 */
public class Main {

    /**
     * Main method to launch the Connect Four application.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Create the statistics object to track game outcomes
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

            // Create a new game instance with statistics and visualizer
            Game game = new Game(statistics, visualizer);

            // Start the game
            game.start();

            // Add a delay of 2 seconds between games for better clarity
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Print the cumulative statistics after all games are completed
        statistics.printStatistics();
    }
}
