package application;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javafx.scene.layout.VBox; 

public class UTTT_Runner extends Application { 
	
	
	public static Player PlayerOne=new HumanPlayer("Andi", 'x', 0);
	public static Player PlayerTwo=new AIPlayer('o', 10);
	public static UltimateTicTacToe ttt; 
	
	
	public static void main(String[] args) {
		
		ttt = new UltimateTicTacToe(PlayerOne, PlayerTwo);
		launch(args);
		Scanner input= new Scanner(System.in); 
		
		
//		Player PlayerOne=new HumanPlayer("Andi", 'x', 0);
//		Player PlayerTwo=new AIPlayer('o', 10);
		
		
		//try {
		//	simonReadFile(PlayerTwo);
		//} catch (Exception e) {
		//	System.out.println("Gaming");
		//}

		
		
		
		//System.out.println("Enter 1 for AI, enter 2 for human Player");
		
		//if(input.nextInt()==1){
			

		//}
		
		// TODO Auto-generated method stub
//		UltimateTicTacToe ttt = new UltimateTicTacToe(PlayerOne, PlayerTwo);
			ttt.UTTT_start(); 
//			ttt.UTTT_loop(); 
		
		do {
			ttt.UTTT_loop();
		} 
		
		while (ttt.getWin() == false);
		

	}
	




	public static void simonWriteToFile(Player player) throws FileNotFoundException, IOException{
		ObjectOutputStream OOS= new ObjectOutputStream(new FileOutputStream("Simon.bin"));
		OOS.writeObject(player);
	}
	public static void playerOneWriteToFile(Player player) throws FileNotFoundException, IOException{
		ObjectOutputStream OOS= new ObjectOutputStream(new FileOutputStream("PlayerOne.bin"));
		OOS.writeObject(player);
	}
	public static void playerTwoWriteToFile(Player player) throws FileNotFoundException, IOException{
		ObjectOutputStream OOS= new ObjectOutputStream(new FileOutputStream("PlayerTwo.bin"));
		OOS.writeObject(player);
	}

	public static void simonReadFile(Player player) throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream OIS= new ObjectInputStream(new FileInputStream("Simon.bin"));
		Player gaming=(Player) OIS.readObject();
		System.out.println(gaming.getName());
		System.out.println(gaming.getSymbol());
		System.out.println(gaming.getWins());

		
	}
	public static void OneReadFile(Player player) throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream OIS= new ObjectInputStream(new FileInputStream("PlayerOne.bin"));
		Player gaming=(Player) OIS.readObject();
		
	}
	public static void TwoReadFile(Player player) throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream OIS= new ObjectInputStream(new FileInputStream("PlayerTwo.bin"));
		Player gaming=(Player) OIS.readObject();
		
	}



	@Override
	public void start(Stage primaryStage) {
		try {
			/* 
			 * 
			 * @author Steven
			 */
			BorderPane root = new BorderPane();
			Scene stage = new Scene(root,500,500);
			stage.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(stage);
			primaryStage.setTitle("Ultimate Tic-Tac-Toe!"); 
			
			
			GridPane pane = new GridPane();
			pane.setHgap(30);  
			pane.setVgap(30);
			
//			Prints all 81 spaces
			for (int R=0; R < 3; R++ ) {

				for (int C=0; C < 3; C++ ) {

					for (int r=0; r < 3; r++ ) {

						for (int c=0; c < 3; c++ ) {  
							
							VBox vbox = new VBox(((TicTacToe)ttt.board[R][r]).board[C][c].space_b);
							pane.add(vbox, (R*3)+C, (r*3)+c); //Programmatically accommodates 0 to 8 
						}
					}
				} 
			}
			
			
			
			
			pane.setAlignment(Pos.CENTER);
			Scene scene = new Scene(pane,700,700);
			primaryStage.setScene(scene);
			primaryStage.show();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}