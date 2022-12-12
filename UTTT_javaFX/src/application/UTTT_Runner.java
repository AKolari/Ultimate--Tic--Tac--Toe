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
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox; 

import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class UTTT_Runner extends Application { 
	
	
	public static Player PlayerOne=new AIPlayer('x', 0);
	public static Player PlayerTwo=new AIPlayer('o', 10);
	public static UltimateTicTacToe ttt;  
	
	private TextField colField; 
	private TextField rowField; 
	
	
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
							
							VBox vbox = new VBox(
									((TicTacToe)ttt.board[R][r]).board[C][c].space_b
									
									);
							pane.add(vbox, (R*3)+C, (r*3)+c); //Programmatically accommodates 0 to 8 
						}
					}
				} 
			}
			
//			VBox selection = new VBox(turn, rowText, colText, select);
			
//			selection.setAlignment(Pos.BOTTOM_CENTER);
			
//			pane.add(selection, 9, 9);
			
			Label turn = new Label("Player " +ttt.currentPlayer.getName() +"'s turn.");
			Label colText = new Label("Enter Column");
			Label rowText = new Label("Enter Row");
//			final TextField colField;
//			final TextField rowField; 
			
			Button select = new Button("Choose Coordinates");
			
		      select.setOnAction(new selectionHandler());
			
		    //Instantiation of textfield
		    colField = new TextField();
		  	rowField = new TextField();
			
			
			pane.add(turn, 9, 0);
			pane.add(rowText, 10, 1);
			pane.add(rowField, 9, 1);
			pane.add(colText, 10, 2);
			pane.add(colField, 9, 2);
			pane.add(select, 9, 3);
		
			pane.setAlignment(Pos.CENTER);
			Scene scene = new Scene(pane,700,700);
			primaryStage.setScene(scene);
			primaryStage.show();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}  
	
	class selectionHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) { 
			int x_input = Integer.parseInt(rowField.getText()); 
			int y_input = Integer.parseInt(colField.getText());  
			
//			((AIPlayer)ttt.currentPlayer).setValue(x_input,y_input);  
			
			
			
			
//			(HumanPlayer)ttt.((HumanPlayer)currentPlayer).setValue(x_input,y_input);  
			
		
	
		}
}

/**
 * When the button is pressed it will read from the two text fields and put either an X/O
 * In the Col/Row's
 * Once that happens, change player.
 * @author Steven
 *
 */
 

} //END OF UTTT_Runner
