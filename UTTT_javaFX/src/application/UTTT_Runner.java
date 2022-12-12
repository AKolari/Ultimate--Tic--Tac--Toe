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


/**
 * Creates TTT game and shows leaderboard from player serialization 
 * We were not able to get a functioning display of the game in JavaFX. :( 
 * We were constantly running into rendering issues and didn't have time to finish due to work in other courses. 
 * @author Savion, Andi and Steven
 *
 */
public class UTTT_Runner extends Application { 
	
	
	public static UltimateTicTacToe ttt;   
	
	

	
	
	public static void main(String[] args) {
		
		
//		try {
//			playerTwoWriteToFile(new HumanPlayer("Savion",'o', 7));
//        } catch (Exception e) {
//            System.out.println("Gaming");
//        }
		

		
		// TODO Auto-generated method stub
//		UltimateTicTacToe ttt = new UltimateTicTacToe(PlayerOne, PlayerTwo);  
		
		launch(args); 
		
//		PlayerOne = new HumanPlayer("Andi", 'x', 0); 
//		PlayerTwo = new HumanPlayer("Savion", 'o', 0); 
		
		Scanner input1= new Scanner(System.in); 
		System.out.println("Do you want to play with computer? (Y or N)");
	    if(input1.nextLine().equals("Y")){ 
	    	
	    	System.out.println("Enter your name"); 
	    	String namey; 
	    	namey = input1.nextLine(); 
	    	Player PlayerOne = new HumanPlayer(namey, 'x', 0); 
	    	Player PlayerCpu2 = new AIPlayer('o', 0);
	    	ttt = new UltimateTicTacToe(PlayerOne, PlayerCpu2);
	    } 
	    
	    else {
	    	System.out.println("Enter your name"); 
	    	String namey; 
	    	namey = input1.nextLine(); 
	    	Player PlayerOne = new HumanPlayer(namey, 'x', 0); 
	    	
	    	System.out.println(" ");
	    	System.out.println("Enter the second name");  
	    	namey = input1.nextLine(); 
	    	Player PlayerTwo = new HumanPlayer(namey, 'o', 0);
	    	ttt = new UltimateTicTacToe(PlayerOne, PlayerTwo);
	    }
	    
	    
	        System.out.println("Thanks for playing!");
		
//		ttt = new UltimateTicTacToe(PlayerOne, PlayerTwo); 
		
		
		
		ttt.UTTT_start(); 


	do {
		ttt.UTTT_loop();
	} 
	
	while (ttt.getWin() == false);  
	
	Scanner input= new Scanner(System.in);
	
	System.out.println("Do you want to save your results?(Yes or No");
    if(input.nextLine().equals("Yes")){
        try {
        playerOneWriteToFile(ttt.currentPlayer);
    } catch (Exception e) {
        System.out.println("Error");
    }
    }

        System.out.println("Thanks for playing!"); 
        
    
//     launch(args); 	
		
		
		

	}
	



	
//Object Serialization 
	
	/**
	 * Saves cpu data (default name is simon)
	 * @param player
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void simonWriteToFile(Player player) throws FileNotFoundException, IOException{
		ObjectOutputStream OOS= new ObjectOutputStream(new FileOutputStream("Simon.bin"));
		OOS.writeObject(player);
	}
	
	/**
	 * Saves Player1 data
	 * @param player
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void playerOneWriteToFile(Player player) throws FileNotFoundException, IOException{
		ObjectOutputStream OOS= new ObjectOutputStream(new FileOutputStream("PlayerOne.bin"));
		OOS.writeObject(player);
	} 
	
	
	/**
	 * Saves Player1 data
	 * @param player
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void playerTwoWriteToFile(Player player) throws FileNotFoundException, IOException{
		ObjectOutputStream OOS= new ObjectOutputStream(new FileOutputStream("PlayerTwo.bin"));
		OOS.writeObject(player);
	}

	/**
	 * Saves reads CPU data (default name is simon)
	 * @param player
	 * @throws FileNotFoundException
	 * @throws IOException 
	 * @return Player data
	 */
	public static Player simonReadFile() throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream OIS= new ObjectInputStream(new FileInputStream("Simon.bin"));
		Player gaming=(Player) OIS.readObject();
//		System.out.println(gaming.getName());
//		System.out.println(gaming.getSymbol());
//		System.out.println(gaming.getWins()); 
		return gaming;
	
	} 
	
	/**
	 * Saves reads Player1 data
	 * @param player
	 * @throws FileNotFoundException
	 * @throws IOException 
	 * @return Player data
	 */
	public static Player OneReadFile() throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream OIS= new ObjectInputStream(new FileInputStream("PlayerOne.bin"));
		Player gaming=(Player) OIS.readObject();
		return gaming;
	} 
	
	/**
	 * Saves reads Player2 data
	 * @param player
	 * @throws FileNotFoundException
	 * @throws IOException 
	 * @return Player data
	 */
	public static Player TwoReadFile() throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream OIS= new ObjectInputStream(new FileInputStream("PlayerTwo.bin"));
		Player gaming=(Player) OIS.readObject(); 
		return gaming;
		
	}


	/**
	 * Creates JavaFX window
	 */
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
			 
			
			
			Label Title = new Label("Welcome to Ultimate Tic Tac Toe!"); 
			pane.add(Title, 1, 0); 
			
			
			Label title2 = new Label("Leaderboard"); 
			pane.add(title2, 1, 1); 
			
			Label nameLabel = new Label("Name"); 
			pane.add(nameLabel, 1, 2); 
			
			Label Scores = new Label("Score"); 
			pane.add(Scores, 2, 2); 
			
			
			Player simon = simonReadFile(); 
			
			Label name1 = new Label(simon.getName()); 
			pane.add(name1, 1, 3); 
			
			Label Score1 = new Label(""+simon.getWins()); 
			pane.add(Score1, 2, 3);  
			
			
			Player Andi = OneReadFile(); 
			
			Label name2 = new Label(Andi.getName()); 
			pane.add(name2, 1, 4); 
			
			Label Score2 = new Label(""+Andi.getWins()); 
			pane.add(Score2, 2, 4); 
			
			
			Player Savion = TwoReadFile(); 
			
			Label name3 = new Label(Savion.getName()); 
			pane.add(name3, 1, 5); 
			
			Label Score3 = new Label(""+Savion.getWins()); 
			pane.add(Score3, 2, 5); 
			

			
			
//			Player P1 = OneReadFile(); 
//			
//			Label name1 = new Label(simon.getName()); 
//			pane.add(name1, 1, 3); 
//			
//			Label Score1 = new Label(""+simon.getWins()); 
//			pane.add(Score1, 2, 3);
			
			
//			Button select = new Button("Confirm");
//			pane.add(select, 4, 3); 
			
			
			
			
			//Javafx rendering 
			pane.setAlignment(Pos.CENTER);
			Scene scene = new Scene(pane,700,700);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
//			Prints all 81 spaces
//			for (int R=0; R < 3; R++ ) {
//
//				for (int C=0; C < 3; C++ ) {
//
//					for (int r=0; r < 3; r++ ) {
//
//						for (int c=0; c < 3; c++ ) {  
//							
//							VBox vbox = new VBox(
//									((TicTacToe)ttt.board[R][r]).board[C][c].space_b
//									
//									);
//							pane.add(vbox, (R*3)+C, (r*3)+c); //Programmatically accommodates 0 to 8 
//						}
//					}
//				} 
//			}
			
//			VBox selection = new VBox(turn, rowText, colText, select);
			
//			selection.setAlignment(Pos.BOTTOM_CENTER);
			
//			pane.add(selection, 9, 9);
			
//			Label turn = new Label("Player " +ttt.currentPlayer.getName() +"'s turn.");
//			Label colText = new Label("Enter Column");
//			Label rowText = new Label("Enter Row");
//			final TextField colField;
//			final TextField rowField; 
			
//			Button select = new Button("Choose Coordinates");
//			
//		      select.setOnAction(new selectionHandler());
//			
//		    //Instantiation of textfield
//		    colField = new TextField();
//		  	rowField = new TextField();
//			
//			
//			pane.add(turn, 9, 0);
//			pane.add(rowText, 10, 1);
//			pane.add(rowField, 9, 1);
//			pane.add(colText, 10, 2);
//			pane.add(colField, 9, 2);
//			pane.add(select, 9, 3);
//		
//			pane.setAlignment(Pos.CENTER);
//			Scene scene = new Scene(pane,700,700);
//			primaryStage.setScene(scene);
//			primaryStage.show();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}  //start
	
	class selectionHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			
			//Pass choices to console version

			
//			nameX = nameField1.getText(); 
//			nameO = nameField2.getText(); 
//			cpu_option = cpuField.getText();  
			
////			PlayerOne=new HumanPlayer(nameX,'x', 0);  
//			PlayerOne.setName(nameX);
//			
//			if (cpu_option == "Y" || cpu_option == "y") {
////			
//			} 
//			
//			else {
//				PlayerTwo=new AIPlayer('o', 0);
//			} 
//			
			
			
			
			
			
//			ttt.playerOne.setName(nameX); 
//			ttt.playerTwo.setName(nameO);
		
	
		}
}

///**
// * When the button is pressed it will read from the two text fields and put either an X/O
// * In the Col/Row's
// * Once that happens, change player.
// * @author Steven
// *
// */
// 

} //END OF UTTT_Runner
