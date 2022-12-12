package application;
import java.io.Serializable;

import java.io.Serializable;

/**
 * Player class is used to instantiate players in the game and save player data. 
 * By making players classes, the code becomes more flexible, since Human or AIs are made from Player 
 * 
 */
public abstract class Player implements Serializable, rowColumnInterface{
    /**
     * name of the player
     */
	private String name;
    
	/**
	 * Piece char the player uses (x or o)
	 */
	private char symbol;    //Future iterations could potentially allow for the setting of custom icons. Unlikely to happen in this iteration.
    
	/**
	 * The number of wins the player has. 
	 * Can be seen in leaderboards
	 */
	private int wins;

	
	/**
	 * Parameterized player constructor
	 * @param name : name of the player
	 * @param symbol : Piece char the player uses (x or o)
	 * @param wins : The number of wins the player has.
	 */
    public Player(String name, char symbol, int wins){
        this.symbol=symbol;
        this.name=name;
        this.wins=wins;

    }
    /**
     * retrieves symbol
     * @return symbol
     */
    public char getSymbol() {
        return symbol;
    }
    
    /**
     * changes symbol
     * @param symbol
     */
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
    
    /**
     * retrieves name
     * @return name
     */
    public String getName() {
        return name;
    }
    
    /**
     * changes name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * retrieves wins
     * @return wins
     */
    public int getWins() {
        return wins;
    }
    
    /**
     * changes wins
     * @param wins
     */
    public void setWins(int wins) {
        this.wins = wins;
    }

    /**
     * Passes back an array of their chosen board position
     * @param item: the Row or Column being chosen
     */
    public int[] chooseValue(String item) throws TicTacToeException{
        int[] blank=new int[2];
        return blank ;
    }
    






}