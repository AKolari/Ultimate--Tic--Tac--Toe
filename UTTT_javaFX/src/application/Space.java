package application;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * 
 * @author Savion
 *	Space is the most basic unit of play in UTTT. 
 *	A player can put their character in a space. 
 *	UTTT logic is handled by other classes using the char value. 
 *	For JavaFX, each space can be matched 
 */
public class Space { 
	/**
	 * Current space value
	 */
	protected char value = '_';  
	
	/**
	 * X value of Space in INNER board.
	 * On a non-cartesian plane. X=0 is not the center.
	 */
	protected int x;   
	
	/**
	 * Y value of Space in INNER board.
	 * On a non-cartesian plane. Y=0 is not the center.
	 */
	protected int y; 
	
	/**
	 * X value of Space in OUTER board.
	 * On a non-cartesian plane. X=0 is not the center. 
	 * Will share this value with 8 other spaces.
	 */
	protected int Out_x;   
	
	/**
	 * Y value of Space in OUTER board.
	 * On a non-cartesian plane. Y=0 is not the center. 
	 * Will share this value with 8 other spaces.
	 */
	protected int Out_y; 
	
	protected Label space_b = new Label(""+value);
}