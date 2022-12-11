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
							
							char thing = (((TicTacToe)ttt.board[R][r]).board[C][c].value);

							Label space = new Label(Character.toString(thing)); 
//							System.out.println(Character.toString(thing));
							VBox vbox = new VBox(space);
							pane.add(vbox, (R*3)+C, (r*3)+c); //Programmatically accommodates 0 to 8 
						}
					}
				} 
			}
			
			//Cols
//			Label col1 = new Label("Col 1");
//			Label col2 = new Label("Col 2");
//			Label col3 = new Label("Col 3");
//			Label col4 = new Label("Col 4");
//			Label col5 = new Label("Col 5");
//			Label col6 = new Label("Col 6");
//			Label col7 = new Label("Col 7");
//			Label col8 = new Label("Col 8");
//			Label col9 = new Label("Col 9");
//			//Rows
//			Label row1 = new Label("Row 1");
//			Label row2 = new Label("Row 2");
//			Label row3 = new Label("Row 3");
//			Label row4 = new Label("Row 4");
//			Label row5 = new Label("Row 5");
//			Label row6 = new Label("Row 6");
//			Label row7 = new Label("Row 7");
//			Label row8 = new Label("Row 8");
//			Label row9 = new Label("Row 9");
//			Button testButton = new Button("Start game?");
//
//			GridPane pane = new GridPane();
//			pane.setHgap(30);
//			pane.setVgap(30);
//			
//			pane.add(col1, 0, 0);
//			pane.add(col2, 1, 0);
//			pane.add(col3, 2, 0);
//			pane.add(col4, 3, 0);
//			pane.add(col5, 4, 0);
//			pane.add(col6, 5, 0);
//			pane.add(col7, 6, 0);
//			pane.add(col8, 7, 0);
//			pane.add(col9, 8, 0);
//			
//			
//			pane.add(row1, 0, 0);
//			pane.add(row2, 0, 1);
//			pane.add(row3, 0, 2);
//			pane.add(row4, 0, 3);
//			pane.add(row5, 0, 4);
//			pane.add(row6, 0, 5);
//			pane.add(row7, 0, 6);
//			pane.add(row8, 0, 7);
//			pane.add(row9, 0, 8);
//			
//			
//			pane.add(testButton, 9, 5);
			
			pane.setAlignment(Pos.CENTER);
			Scene scene = new Scene(pane,700,700);
			primaryStage.setScene(scene);
			primaryStage.show();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}