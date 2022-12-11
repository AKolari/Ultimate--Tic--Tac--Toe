package application;

import java.util.Scanner;

public class HumanPlayer extends Player{

    public HumanPlayer(String name, char symbol, int wins){
        super(name, symbol, wins);
    }


    @Override
    public int chooseValue(String item) throws TicTacToeException{
        Scanner input=new Scanner(System.in);
        System.out.print("Please enter a valid " +item+": ");
		int value = input.nextInt();
		if (value >= 3 || value < 0) {
			throw new TicTacToeException("Invalid " +item+": " + value);
		}
		return value;
    }




    
}