//represents a tic tac toe board object
package tictactoegame;
import java.awt.*;
import javax.swing.*;

public class TicBoard extends JComponent
{
    private int [][] board;
    
    //GUI INSTANCE VARIABLES
    private JFrame frame = new JFrame("Tic Tac Toe");
    private Container content = frame.getContentPane(); 
    
    //constructor
    public TicBoard(int[][] board)
    {
        this.board = board;
        
        //sets all the spaces with -1 which signifies it's not filled in
        for(int row = 0; row < board.length; row++)
        {
            for(int col = 0; col < board[0].length; col++)
            {
                board[row][col] = -1;
            }
        }
    }
    
    //sets the tile on the board
    public void setTile(int row, int col, int tile)
    {
        board[row][col] = tile;
    }
    
    //checks if the player has won; uses all the other methods to check if 
    //either player won
    public boolean checkWin(int tile)
    {
        boolean win = false;
        if(checkColumns(tile))
        {
            win = true;
        }
        if(checkRows(tile))
        {
            win = true;
        }
        if(checkFirstDiagonal(tile))
        {
            win = true;
        }
        if(checkSecondDiagonal(tile))
        {
            win = true;
        }
        return win;
    }
    
    //this check checks the diagonal going from left to right
    private boolean checkFirstDiagonal(int tile)
    {
        boolean check = false;
        for(int row = 0; row < board.length; row++)
        {
            for(int col = 0; col < board[0].length; col++)
            {
                if(row == col)
                {
                    if(board[row][col] == tile)
                    {
                        check = true;
                    }    
                    else
                    {
                        return false;
                    }
                }
            }
        }
        return check;
    }
    
    //this check checks the diagonal going from right to left
    private boolean checkSecondDiagonal(int tile)
    {
        boolean check= false;
        int col = board[0].length -1;
        for(int row = 0; row < board.length; row++)
        {
            if(board[row][col] == tile)
            {
                check = true;
            }      
            else
            {
                return false;
            }
            col--;
        }
        return check;
    }
    
    //method that checks if any rows are won by any player
    private boolean checkColumns(int tile)
    {
        boolean check = false;
        
        //checks if player 1 wins in any of the columns
        for(int col = 0; col < board[0].length; col++)
        {
            if(board[0][col] == tile)
            {
                if(board[1][col] == tile)
                {
                    if(board[2][col] == tile)
                    {
                        check = true;
                    }
                }
            }
        }
        return check;
    }
    
    //getter method that needs to be used in the future?????
    public int[][] getBoard()
    {
        return this.board;
    }
    
    //method that is used to check if any of the rows are winning rows
    private boolean checkRows(int tile)
    {
        boolean check = false;
        
        for(int row = 0; row < board.length; row++)
        {
            if(board[row][0] == tile)
            {
                if(board[row][1] == tile)
                {
                    if(board[row][2] == tile)
                    {
                        check = true;
                    }
                }
            }
        }
        return check;
    }
   
//******************************************************************************
    //method not needed at the very end
    public void printBoard()
    {
        for(int row = 0; row < board.length; row++)
        {
            for(int col = 0; col < board[0].length; col ++)
            {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }
//******************************************************************************    
//GUI COMPONENTS
    
    //initial setup of the board
    public void setUp()
    {
        content.add(this);
        content.setBackground(Color.WHITE);
        
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame. EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    //GUI component tha prints the board and updates it
    @Override
    public void paintComponent(Graphics page)
    {
        page.setColor(Color.BLACK);
        page.drawLine(350, 50, 350, 750);
        page.drawLine(650, 50, 650, 750);
        page.drawLine(100, 280, 900, 280);
        page.drawLine(100, 530, 900, 530);
        
        for(int row = 0; row < board.length; row++)
        {
            for(int col = 0; col < board[0].length; col++)
            {
                if(board[row][col] == 0)
                {
                    page.drawLine(130 + 280 * col, 60 + 250 * row, 
                                    330 + 280 * col, 260 + 250 * row);
                    page.drawLine(130 + 280 * col, 260 + 250 * row,
                                    330 + 280 * col, 60 + 250 * row);
                }
                else if(board[row][col] == 1)
                {
                    page.drawArc(130 + 280 * col, 60 + 250 * row,
                                                        200, 200, 0, 360);
                }
                else
                {
                    
                }
            }
        }    
    }   
}
