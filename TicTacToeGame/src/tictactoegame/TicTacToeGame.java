/*
 * DJ Yeh
 * May 22nd, 2018
 * JDK Version 8.2
 * This project will recreate a game of tic tac toe.
 */

package tictactoegame;
import javax.swing.JOptionPane;
import java.awt.*;
import javax.swing.*;

public class TicTacToeGame 
{
    public static void main(String[] args)
    {
        //the condition that allows the whole loop to run
        String input = "yes";
        input = "yes";
        
        //giant for loop 
        while(input.equals("yes"))
        {
            //sets up the players and the boards at the beginning of each game
            input = JOptionPane.showInputDialog(null, 
                    "What is the first player's name?");
            int[][] boardFormat = new int[3][3];
            Player player1 = new Player(0, input);
            input = JOptionPane.showInputDialog(null, 
                    "What is the second player's name?");
            Player player2 = new Player(1, input);
            TicBoard board = new TicBoard(boardFormat);
            int col = -1;
            int row = -1;
        
            //prints the rules of the game
            JOptionPane.showMessageDialog(null, "Rules:"
                + "\n1.) There are two players, each taking turns."
                + "\n2.) This is a 3x3 board." 
                + "\n3.) In order to win, you must have " 
                + "three consecutive tiles in any row, column, or diagonal.");
            board.setUp();
        
            //the inner loop that allows the players to make their moves
            for(int moves = board.getBoard().length * board.getBoard()[0].length; 
                                                             moves > 0; moves--)
            {
                //player 1's moves
                if(moves%2 == 1)
                {
                    boolean valid = false;
                    while(valid == false)
                    {
                        input = JOptionPane.showInputDialog(null, 
                            player1.getName() + ", which row would you like to" 
                                    + " place your tile in?");
                        row = Integer.parseInt(input) - 1;
                        if(row > 2 || row < 0)
                        {
                            JOptionPane.showMessageDialog(null, "Invalid row "
                                    + "move.");
                            valid = false;
                        }
                        else
                        {
                            valid = true;
                        }
                    }
                    //makes sure the input value for the row is within the array
                
                    valid = false;
                    while(valid == false)
                    {
                        input = JOptionPane.showInputDialog(null, 
                            player1.getName() + " , which column would you like to" 
                                    + " place your tile in?");
                        col = Integer.parseInt(input) - 1;
                        if(col > 2 || col < 0)
                        {   
                            JOptionPane.showMessageDialog(null, "Invalid column "
                                    + "move.");
                            valid = false;
                        }
                        else
                        {
                            valid = true;
                        }
                    }
                    //checks if the move is in a valid column
                
                    if(player1.validMove(row, col, board))//if a valid move, makes the move
                    {
                        player1.play(row, col, board);
                    }
                    else//makes the player make another move
                    {
                        JOptionPane.showMessageDialog(null, 
                            "This is not a valid move. "
                                    + "The space is already taken.");
                        moves++;
                    }
                    player1.checkWin(board);//checks if the player has won
                    board.printBoard();//print version of the game
                    board.repaint();//GUI COMPONENT
                    if(player1.getWinner())
                    {
                        JOptionPane.showMessageDialog(null, player1.getName() 
                            + " WINNNSSS!!!");
                        break;
                    }
                
                }
                
                //player 2's moves
                else
                {
                    boolean valid = false;
                    //loop until a valid row move is played
                    while(valid == false)
                    {
                        input = JOptionPane.showInputDialog(null, 
                            player2.getName() 
                        + " , which row would you like to place your tile in?");
                        row = Integer.parseInt(input) - 1;
                        if(row > 2 || row < 0)
                        {
                            JOptionPane.showMessageDialog(null, "Invalid row "
                                    + "move.");
                            valid = false;
                        }
                        else
                        {
                            valid = true;
                        }
                    }
                
                    //loop until a valid column move is made
                    valid = false;
                    while(valid == false)
                    {
                        input = JOptionPane.showInputDialog(null, 
                            player2.getName() 
                     + " , which column would you like to place your tile in?");
                        col = Integer.parseInt(input) - 1;
                        if(col > 2 || col < 0)
                        {
                            JOptionPane.showMessageDialog(null, "Invalid column "
                                    + "move.");
                            valid = false;
                        }
                        else
                        {
                            valid = true;
                        }
                    }
                    if(player2.validMove(row, col, board))
                    {
                        player2.play(row, col, board);
                    }
                    else//makes the player make another move
                    {
                        JOptionPane.showMessageDialog(null, 
                                "This is not a valid move. "
                                        + "The space is already taken.");
                        moves++;
                    }
                    player2.checkWin(board);
                    board.repaint();//GUI COMPONENT
                    board.printBoard();
                    if(player2.getWinner())
                    {
                        JOptionPane.showMessageDialog(null, player2.getName()
                            + " WINNNSSS!!!");
                        break;
                    }
                }  
            }
            
            //after all the spaces are taken and its a draw
            if(!(player1.getWinner()) && !(player2.getWinner()))
            {
                JOptionPane.showMessageDialog(null, "Lol ur both garb.");
            }
            
            //checks if the player wants to play again
            input = JOptionPane.showInputDialog(null, 
                "Would you like to play again?(yes or no)");
            if(input.equals("yes"))
            {
                int[][] newBoardFormat = new int[3][3];
                board = new TicBoard(newBoardFormat);
                board.repaint();
            }
        }
    }    
}
