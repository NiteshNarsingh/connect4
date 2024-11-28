/**
 * Represents a player in the Connect Four game.
 *
 * This class serves as a base class for different types of players,
 * such as human players or AI players. Each player has a unique symbol
 * that identifies their discs on the board.
 */
public class Player {
    private char symbol; // The player's symbol ('X' or 'O')

    /**
     * Constructor for the Player class.
     *
     * @param symbol the symbol used by the player ('X' or 'O')
     */
    public Player(char symbol) {
        this.symbol = symbol;
    }

    /**
     * Retrieves the player's symbol.
     *
     * @return the symbol representing the player ('X' or 'O')
     */
    public char getSymbol() {
        return symbol;
    }
}
