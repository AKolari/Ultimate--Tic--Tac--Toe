package application;


/**
 * Helps TTT allow players to choose values and throw exceptions when needed. 
 * AI and Players choose values slightly differently, so an interface was used. 
 * The means of choosing also don't need to be instantiated as classes.
 * @author Andi
 *
 */
public interface rowColumnInterface {
    public int[] chooseValue(String item) throws TicTacToeException;
    
    
}