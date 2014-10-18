/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.views.terminals;
import chess.views.ChessMainMenuView;
/**
 *
 * @author justin
 */
public class ChessMainMenuTerminal extends ChessMainMenuView 
{
    
    public ChessMainMenuTerminal()
    {
        
    }
    @Override
    public void update()
    {
        System.out.println("*---------------------------*");
        System.out.println("|        Yay Chess!         |");
        System.out.println("*---------------------------*");
        System.out.println("Play");
        System.out.println("Quit");
        
    }
    
    public void printBoard()
    {
        
    }
    
    public void printErrorMessage(String errorMessage)
    {
        System.out.println("*---------------------------*");
        System.out.println("Error: " + errorMessage);
        System.out.println("*---------------------------*");

    }
}
