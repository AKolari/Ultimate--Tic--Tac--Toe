package application; 

import java.util.Scanner;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * 
 */
/**
 * TicTacToe (abbreviation as TTT) is AN instance AND composition of space. 
 * It's composed of Spaces to make the logic of a TTT game. 
 * But also an instance so it can be tied to a single char value for use in UltimateTicTacToe (UTTT).
 * @author Savion
 *
 */
public class TicTacToe extends Space{

	/**
	 * Creates a 2D Array of spaces 
	 */
	protected Space[][] board; 
	

	protected int[] last_pos = new int[2]; 

	/**
	 * The first player
	 */
	protected Player playerOne;
	/**
	 * The second player
	 */

	protected Player playerTwo;

	/**
	 * The current Player
	 */
	protected Player currentPlayer; 
	
	/**
	 * The size of the board (hard coded to 3 in runner since that's standard for TTT boards)
	 */
	protected int size; 
	
	/**
	 * Scanner object for user input
	 */
	protected Scanner input;
	
	/**
	 * Win condition
	 */
	protected boolean win; 
	
	//Need for Runner
	public boolean getWin() {
		return win;
	}
	
	protected boolean continue_game = true;
	
	/**
	 * 
	 * @param n : 
	 */
	public TicTacToe(Player PlayerOne, Player PlayerTwo) {
		super();
		size = 3;
		board = new Space[3][3]; //Creates 2D array
		initializeBoard(); //Creates blank board spaces in array
		playerOne=PlayerOne;
		playerTwo=PlayerTwo;
		currentPlayer = playerOne;
		input = new Scanner(System.in); //For user input
	}
	
	/**
	 * Starts the game
	 */
	public void start(Player player) { 
		currentPlayer = player;
		//Game Logic.
//		System.out.println("Welcome to CSC330 Tic Tac Toe!");
		
		//Now an if statement so UTTT can switch boards. A single call of start() plays one turn. 
		//The need to switch boards is also why initializeBoard() is called in the constructor
		if(!win && !isDraw() && continue_game == true) {
			
				printBoard();     //print board
				System.out.println("It is " + currentPlayer.getName() + "'s turn.");
				//Get input.
				int row, col; 
				do { //Throws exceptions for invalid input (by making all invalids -1)
					try {
						row = getRow();
					} catch (TicTacToeException ttte) {
						System.out.println(ttte.getMessage());
						row = -1;
					}
					try {
						col = getCol();
					} catch (TicTacToeException ttte) {
						System.out.println(ttte.getMessage());
						col = -1;
					}
					if (row != -1 && col != -1 && isOccupied(row, col)) {
						System.out.println("That location is occupied. Try again.");
					}
					
				} while(row == -1 || col == -1 || isOccupied(row, col));
				
				System.out.println("\n\n");

				//We have a valid row and column: 
				
				//Record pos chosen
				last_pos[0] = row; 
				last_pos[1] = col;
				
				
				//Value changes
				board[row][col].value = currentPlayer.getSymbol(); //Marks position  
				board[row][col].space_b = new Label(""+board[row][col].value);
				
				
				win = isWinner(); //Win condition 
				
				if (win) {  //Win condition check
					System.out.println( currentPlayer.getName() + " wins this board! \n");  
					
					//Play win sound
					
					System.out.println("This board is now occupied. You cannot go back to it.");
					//Setting TTT char value (VITAL): 
					value = currentPlayer.getSymbol(); 
					continue_game = false;
					
				} else {
					changePlayer();
				}
				if (isDraw()) { //Draw check
					System.out.println("DRAW! No one has won. I guess the only way to win is to not play the game.\n"); 
					System.out.println("This board is now occupied. You cannot go back to it.");
					continue_game = false;
				}
				
			
			
		}
		
		else {
			System.out.println("Game in Progress...?");
		}
		
		//OLD LOOPING DO WHILE
		//initializeBoard();
//		do {
//			printBoard();     //print board
//			System.out.println("It is " + currentPlayer + "'s turn.");
//			//Get input.
//			int row, col; 
//			do { //Throws exceptions for invalid input (by making all invalids -1)
//				try {
//					row = getRow();
//				} catch (TicTacToeException ttte) {
//					System.out.println(ttte.getMessage());
//					row = -1;
//				}
//				try {
//					col = getCol();
//				} catch (TicTacToeException ttte) {
//					System.out.println(ttte.getMessage());
//					col = -1;
//				}
//				if (row != -1 && col != -1 && isOccupied(row, col)) {
//					System.out.println("That location is occupied. Try again.");
//				}
//				
//			} while(row == -1 || col == -1 || isOccupied(row, col));
//			
//			//We have a valid row and column:
//			
//			board[row][col].value = currentPlayer; //Marks position 
//			win = isWinner(); //Win condition 
//			
//			if (win) {  //Win condition check
//				System.out.println("Congratulations! " + currentPlayer + " wins!!!");  
//				
//				//Setting TTT char value (VITAL): 
//				value = currentPlayer;
//				
//			} else {
//				changePlayer();
//			}
//			if (isDraw()) { //Draw check
//				System.out.println("DRAW! No one has won. I guess the only way to win is to not play the game.");
//			}
//			
//		//CAUSES LOOPING
//		} while (!win && !isDraw()); //Game is not Won AND not a draw yet
//		System.out.println("GAME OVER.");
	
	
	} //End of start();
	
	/**
	 * Puts blank spaces in each row position
	 */
	public void initializeBoard() {
		for(int r = 0; r < size; r++) {
			for(int c = 0; c < size; c++) {
				board[r][c] = new Space();
			}
		}
	}
	
	/**
	 * Prints board to console
	 */
	public void printBoard(){	
//		System.out.println("Here is the current board:\n");
		
		
		for(int r = 0; r < size; r++) {
			
			System.out.print("|");
			
			//Prints n squares for each row
			for(int c = 0; c < size; c++) {
				System.out.print(board[r][c].value);
				if (c < size) {
					System.out.print("|");
				}				
			}
			
			
			System.out.println();
		}
	}
	
	/**
	 * 
	 * @return valid row
	 * @throws TicTacToeException : When row is out of bounds
	 */
	public int getRow() throws TicTacToeException {
		return currentPlayer.chooseValue("Row");
	}
	
	/**
	 * 
	 * @return valid column
	 * @throws TicTacToeException When column is out of bounds
	 */
	public int getCol() throws TicTacToeException {
		
		return currentPlayer.chooseValue("Column");
	}
	
	/**
	 * 
	 * @param row
	 * @param col
	 * @return : if space is occupied (T or F)
	 */
	public boolean isOccupied(int row, int col) {
		return board[row][col].value == 'x' || board[row][col].value == 'o';
	}
	
	/**
	 * Checks for vertical, horizontal, and diagonal lines
	 * @return : T if any line is found. F otherwise.
	 */
	public boolean isWinner() {
		//sum checks
		int sum;
		//check horizontals
		for(int row = 0; row < size; row++) {
			sum = 0;
			for(int col = 0; col < size; col++) {
				if (board[row][col].value == currentPlayer.getSymbol()) {
					sum++;
				}
			}
			
			
			//Done with the row 
			if (sum == size) return true;
		}
		//check verticals
		for(int col = 0; col < size; col++) {
			sum = 0;
			for(int row = 0; row < size; row++) {
				if (board[row][col].value == currentPlayer.getSymbol()) {
					sum++;
				}
			}
			//Done with the row
			if (sum == size) return true;
		}
		//check minor diagonal
		sum = 0;
		for(int i = 0; i < size; i++) {
			if (board[i][i].value == currentPlayer.getSymbol()) sum++;
		}
		if (sum == size) return true;
		sum = 0;
		for(int i = 0; i < size; i++) {
			if (board[size-i-1][i].value == currentPlayer.getSymbol()) sum++; //size-i-1 decreases row position with i++
		}		
		return sum == size;		
	}
	
	/**
	 * Checks if all spaces are occupied. Must run directly after isWinner()
	 * @return : T if ALL spaces are occupied. F otherwise.
	 */
	public boolean isDraw() {
		for(int row = 0; row < size; row++) {			
			for(int col = 0; col < size; col++) {
				if (board[row][col].value == '_') return false;
			}
		}
		//if we are here, all spaces are occupied
		return true;
	}
	
	/**
	 * Switches player char (x or o)
	 */
	public void changePlayer() {
		if (currentPlayer == playerOne) currentPlayer = playerTwo;
		else currentPlayer = playerOne;
	}
	
}