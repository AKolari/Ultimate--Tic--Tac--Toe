package com.example;
import java.util.Random;

public class AIPlayer extends Player{

    public AIPlayer(char symbol, int wins){
        super("Simon", symbol, wins);
    }
    

    @Override
    public int chooseValue(String item){
    
        
		int value = new Random().nextInt(2);
        System.out.println(this.getName()+" chose " +item+" "+value);
		
		return value;
    }
    
}
