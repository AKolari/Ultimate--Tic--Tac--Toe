package application;

import javafx.application.Application; 
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.Screen;


public class UltimateTicTacToe extends TicTacToe {
	
	/**
	 * Creates a 2D Array of TicTacToe boards 
	 */ 
	

	//protected TicTacToe[][] outerBoard; 
	
	
	
	public UltimateTicTacToe(Player PlayerOne, Player PlayerTwo) {
		super(PlayerOne, PlayerTwo); //Calls all original data from TTT 
		size = 3;
		board = new TicTacToe[3][3]; //Hard coded since TTT games are 3x3
		initializeOuterBoard(); 
	}  
	
	/**
	 * Unlike TTT, UTTT  determines board placement based on the previous moves. 
	 * The game is started in the center board, and the placement from that board determines the next boards. 
	 * UTTT_start() SHOULD run before UTTT_loop in the runner 
	 */
	
	private int[] start_pos = new int[2]; 
	
	public void UTTT_start() {
		
		
		System.out.println("Welcome to ULTIMATE Tic Tac Toe! \n"); 
		System.out.println("Unlike regular TicTacToe, you play in one OUTER board, and 9 INNER boards, \n"
				+ "with each board's winner claiming a piece in the outer board \n\n");  
		System.out.println("Your placement in the inner board determines which OUTER board your opponent will start in. \n"); 
		System.out.println("Get TicTacToe in the OUTER (and INNER) boards to WIN! Strategize carefully! \n\n\n"); 
		
		System.out.println("To start, " + currentPlayer.getName() +  " can choose any inner board."); 
		
		//initializeOuterBoard();
		printOuterBoard();     //print board
		System.out.println("It is " + currentPlayer.getName() + "'s turn.");
		//Get input.
		int rowCol[]=new int[2];
		int row, col; 
		do { //Throws exceptions for invalid input (by making all invalids -1)
			try {
				rowCol = getRowCol();
				row=rowCol[0];
				col=rowCol[1];
			} catch (TicTacToeException ttte) {
				System.out.println(ttte.getMessage());
				row = -1;
				col = -1;
			}
			if (row != -1 && col != -1 && isOccupied(row, col)) {
				System.out.println("That location is occupied. Try again.");
			}
			
		} while(row == -1 || col == -1 || isOccupied(row, col)); 
		
		((TicTacToe)board[row][col]).start(currentPlayer); //Starts turn of innerboard
		
		start_pos[0] = ((TicTacToe)board[row][col]).last_pos[0]; 
		start_pos[1] = ((TicTacToe)board[row][col]).last_pos[1];
		
		changePlayer(); 
		System.out.println("\n");  
//		UTTT_loop();
		
	}
	
	public void UTTT_loop() {
//UTTT does board switching internally, so it uses a do while

				int row, col;
				int rowCol[]=new int[2];
				do {
					
						printOuterBoard();     //print board
						System.out.println("It is " + currentPlayer.getName() + "'s turn.");
						//Get input.
						 
						
						row = start_pos[0]; 
						col = start_pos[1]; 

						System.out.println("It is " + currentPlayer.getName() + "'s turn."+((TicTacToe)board[row][col]).isOccupied(row, col));
						System.out.println(((TicTacToe)board[row][col]).value);
						
						System.out.println("\n");
						
						//We have a valid row and column:
						if(!this.isOccupied(row, col)){
						System.out.println("You will play in board (" + (row) + "," + col + ")." );
						}
						else{
							do { //Throws exceptions for invalid input (by making all invalids -1)
								try {
									rowCol = getRowCol();
									row=rowCol[0];
									col=rowCol[1];
								} catch (TicTacToeException ttte) {
									System.out.println(ttte.getMessage());
									row = -1;
									col = -1;
								}
								if (row != -1 && col != -1 && isOccupied(row, col)) {
									System.out.println("That location is occupied. Try again.");
								}
								
							} while(row == -1 || col == -1 || isOccupied(row, col)); 
						}
						
						((TicTacToe)board[row][col]).start(currentPlayer); //Starts turn of innerboard
						
						//Does the program need to "wait" until .start() finishes?
						
						//Changes next start_pos
						start_pos[0] = ((TicTacToe)board[row][col]).last_pos[0]; 
						System.out.println("start_pos[0] = " + start_pos[0] + "\n" );

						start_pos[1] = ((TicTacToe)board[row][col]).last_pos[1]; 
						System.out.println("start_pos[1] = " + start_pos[1] + "\n" );
						
						this.win = isWinner(); //Win condition 
						
						if (this.win) {  //Win condition check
							System.out.println("Congratulations! " + currentPlayer.getName() + " wins the game!!!");  
							
//							//Setting TTT char value (VITAL): 
//							value = currentPlayer;
							
						} else {
							changePlayer();
						}
						if (isDraw()) { //Draw check
							System.out.println("DRAW! No one has won. Better luck next time!");
						}
							
				} while (!this.win && !isDraw());
				System.out.println("Game Over.");
				
		
	} //End of UTTT_start
	

	public void initializeOuterBoard() {
		for(int r = 0; r < size; r++) {
			for(int c = 0; c < size; c++) {
				board[r][c] = new TicTacToe(playerOne, playerTwo);
			}
		}
	} 
	
	
	/**
	 * Prints boards to console
	 */
	
		
	public void printOuterBoard() {
		for (int R = 0; R < 3; R++) { 
			
			//OuterBoard Column
			for(int C = 0; C < 3; C++) { 
				
				//InnerBoard Row
				for(int r = 0; r < this.size; r++) {
					
					//Params fixed from Andi's code
					TicTacToe O_Hold = (TicTacToe) board[R][r]; //Is making new TTTs a memory leak...?
					System.out.print("|"); //Initial line
					
					//InnerBoard Column
					for(int c = 0; c < 3; c++) {
						
						//Params fixed from Andi's code
						System.out.print(O_Hold.board[C][c].value); 
						
						//Assign INNER Space pos
						O_Hold.board[C][c].x = C; 
						O_Hold.board[C][c].y = c; 
						
						//Assign OUTER Space pos
						O_Hold.board[C][c].Out_x = R; 
						O_Hold.board[C][c].Out_y = r;
						 
						//These might be useful for JavaFX. DO NOT DELETE (yet..) 
						//Ex: Once all each spaces are rendered, we can highlight entire OUTER Board using Out_x and Out_y w/ mouse hovers. 
						// From there, we can ONLY highlight spaces from an inner board with x and y.
						
						if (C < size) {
							System.out.print("|"); //Prints rest of row 
							
							//Print/Make Java fx Spaces...?
						} 
								
					} //End of InnerBoard Column loop  
					
					System.out.print("  "); //Spaces between inner boards 
							
					
				} //End of InnerBoard Row Loop
				
				
				System.out.println(); //Skip line	
			
			} //End of OuterBoard Column Loop 
			
			System.out.println(); //Skip line 
			
		} //End of OuterBoard loop
			
	} //End of printBoard() 
	
		
		
		
	
	
	
	
	
	
	
	
	/**
	 * 
	 * @return valid row
	 * @throws UTTT_Exception : When row is out of bounds
	 */
	/* 
	public int getRow() throws TicTacToeException {
		System.out.print("Please enter a valid Outer Board row: ");
		int row = input.nextInt();
		if (row >= this.size || row < 0) {
			throw new TicTacToeException("Invalid Board Row: " + row);
		}
		return row;
	}
	*/
	/**
	 * 
	 * @return valid column
	 * @throws UTTT_Exception : When column is out of bounds
	 */
	/* 
	public int getCol() throws TicTacToeException {
		System.out.print("Please enter a valid Outer Board column: ");
		
		int col = input.nextInt();
		
		if (col >= this.size || col < 0) {
			throw new TicTacToeException("Invalid Board Column: " + col);
		}
		return col;
	} 
	*/
	
	/**
	 * 
	 * @param row
	 * @param col
	 * @return : if board is occupied (won) (T or F)
	 */
	//public boolean isOuterOccupied(int row, int col) {
	//	return outerBoard[row][col].value == 'x' || outerBoard[row][col].value == 'o';
	//} 
	
	
	/**
	 * Checks for vertical, horizontal, and diagonal lines based on outerBoard winners
	 * @return : T if any line is found. F otherwise.
	 */ 
	
	//will currentPlayer's need to be this.currentPlayer ...? 
	/* 
	public boolean isOuterWinner() {
		//sum checks
		int sum;
		//check horizontals
		for(int row = 0; row < size; row++) {
			sum = 0;
			for(int col = 0; col < size; col++) {
				if (((TicTacToe)board[row][col]).value == currentPlayer.getSymbol()) {
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
				if (((TicTacToe)board[row][col]).value == currentPlayer.getSymbol()) {
					sum++;
				}
			}
			//Done with the row
			if (sum == size) return true;
		}
		//check minor diagonal
		sum = 0;
		for(int i = 0; i < size; i++) {
			if (((TicTacToe)board[i][i]).value == currentPlayer.getSymbol()) sum++;
		}
		if (sum == size) return true;
		sum = 0;
		for(int i = 0; i < size; i++) {
			if (((TicTacToe)board[i][i]).value == currentPlayer.getSymbol()) sum++; //size-i-1 decreases row position with i++
		}		
		return sum == size;		
	} 
	*/
	
	
	
	/**
	 * Checks if all boards are occupied. Must run directly after isOuterWinner()
	 * @return : T if ALL spaces are occupied. F otherwise.
	 */
	/* 
	public boolean isOuterDraw() {
		for(int row = 0; row < size; row++) {			
			for(int col = 0; col < size; col++) {
				if (((TicTacToe)board[row][col]).value == '_') return false;
			}
		}
		//if we are here, all spaces are occupied
		return true;
	} 
	*/
	
	/**
	 * Switches player char (x or o)
	 */
	//public void changeOuterPlayer() {
	//	if (currentPlayer == 'x') currentPlayer = 'o';
	//	else currentPlayer = 'x';
	//}
	
	
	
} //End of Entire Class