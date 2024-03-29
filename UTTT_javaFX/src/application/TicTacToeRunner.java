package application;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Starts a game of TTT continues until finished.
 * @author Savion
 *
 */
public class TicTacToeRunner {
	

	/**
	 * Starts a game of TTT continues until finished.
	 * @param args
	 * @param playerOne : player to instantiate TTT class
	 * @param playerTwo : player to instantiate TTT class
	 */
	public static void main(String[] args, Player playerOne, Player playerTwo) {
		// TODO Auto-generated method stub
		TicTacToe ttt = new TicTacToe(playerOne, playerTwo);
		
		
		///Will run TTT for A SINGLE turn
		//	ttt.start(); 
		
		
		//Loops until finished:
		do {
			ttt.start(playerOne);
		} 
		
		while (ttt.getWin() == false);
	}

};