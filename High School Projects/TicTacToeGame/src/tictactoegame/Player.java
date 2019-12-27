//represents a player within the tic tac toe game

package tictactoegame;

public class Player 
{
    //1 and 0 for the tiles
    private final int tile;
    private boolean winner = false;
    String name;
    
    //constructs all the instance variables
    public Player(int tile, String name)
    {
        this.tile = tile;
        this.name = name;
    }
    
    //plays the move using the method of the ticboard class
    public void play(int row, int col, TicBoard board)
    {
        board.setTile(row, col, this.tile);        
    }
    
    //checks if the move is valid using the TicBoard object passed to it
    public boolean validMove(int row, int col, TicBoard board)
    {
        boolean valid = false;
        if(board.getBoard()[row][col] == -1)
        {
            valid = true;
        }
        else
        {
            valid = false;
            
        }
        return valid;
    }

    //setter method using the ticboard class to check if the player has won
    public void checkWin(TicBoard board)
    {
        if(board.checkWin(this.tile))
        {
            this.winner = true;
        }
    }
    
    //getter method which will check if the player has won
    public boolean getWinner()
    {
        return this.winner;
    }
    
    //getter method which will return the player's name when needed
    public String getName()
    {
        return this.name;
    }  
}
