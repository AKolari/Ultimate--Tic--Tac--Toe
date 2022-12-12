package com.example;
import java.util.Random;

public class AIPlayer extends Player{

    public AIPlayer(char symbol, int wins){
        super("Simon", symbol, wins);
    }
   

    @Override
    public int[] chooseValue(String item){
    
        int value[]=new int[2];
		value[0] = new Random().nextInt(3);
        System.out.println(this.getName()+" chose Row "+value[0]);
        value[1] = new Random().nextInt(3);
        System.out.println(this.getName()+" chose Column "+value[1]);
		
		return value;
    }
    
}
