package application;
import java.util.Random;

/**
 * The Computer Player in TTT
 * @author Andi
 *
 */
public class AIPlayer extends Player{

	/**
	 * Instantiates the Computer Player in TTT
	 * @param symbol : Their playing piece (x or o)
	 * @param wins : number of wins they have
	 */
    public AIPlayer(char symbol, int wins){
        super("Simon", symbol, wins);
    }
   
    
    /**
     * Passes back an array of their chosen board position
     * @param item: the Row or Column being chosen
     */
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