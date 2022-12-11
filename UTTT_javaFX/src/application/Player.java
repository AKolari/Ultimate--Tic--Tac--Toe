package application;
import java.io.Serializable;

public class Player implements Serializable, rowColumnInterface{
    private String name;
    private char symbol;    //Future iterations could potentially allow for the setting of custom icons. Unlikely to happen in this iteration.
    private int wins;

    public Player(String name, char symbol, int wins){
        this.symbol=symbol;
        this.name=name;
        this.wins=wins;

    }
    public char getSymbol() {
        return symbol;
    }
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getWins() {
        return wins;
    }
    public void setWins(int wins) {
        this.wins = wins;
    }

    public int chooseValue(String item) throws TicTacToeException{
        return 0;
    }
    

    






}