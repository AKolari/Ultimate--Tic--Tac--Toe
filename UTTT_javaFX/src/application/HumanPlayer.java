package application;

import java.util.Scanner;


public class HumanPlayer extends Player{

    public HumanPlayer(String name, char symbol, int wins){
        super(name, symbol, wins);
    }


    @Override
    public int[] chooseValue(String item) throws TicTacToeException{
        Scanner input=new Scanner(System.in);
        System.out.print("Please enter a valid Row: ");
        int value[]=new int[2];
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




    
}