package application;

import java.util.Scanner;

/**
 * The Human Player in TTT
 * @author Andi
 *
 */
public class HumanPlayer extends Player{

	/**
	 * Instantiates the Human Player in TTT
	 * @param name
	 * @param symbol
	 * @param wins
	 */
    public HumanPlayer(String name, char symbol, int wins){
        super(name, symbol, wins);
    }

    /**
     * 2D array representing piece placement
     */
    private int value[]=new int[2];
    
    /**
     * Passes back an array of their chosen board position
     * @param item: the Row or Column being chosen 
     * @return array of position
     */
    @Override
    public int[] chooseValue(String item) throws TicTacToeException{
        Scanner input=new Scanner(System.in);
        System.out.print("Please enter a valid Row: ");
        
        
		
        value[0] = input.nextInt();
		
		if (value[0] >= 3 || value[0] < 0) {
			throw new TicTacToeException("Invalid Row: " + value);
		}
		
        System.out.print("Please enter a valid Column: ");
		
        value[1] = input.nextInt();
		
        if (value[1] >= 3 || value[1] < 0) {
			throw new TicTacToeException("Invalid Column: " + value);
		}
		return value;
    } 
    
    /**
     * Sets the x and y value of placed pieces 
     * Aids in game logic outside of TTT scope
     * @param x : piece row
     * @param y : piece column
     */
    public void setValue(int x, int y) {
    	value[0] = x;
    	value[1] = y;
    }




    
}