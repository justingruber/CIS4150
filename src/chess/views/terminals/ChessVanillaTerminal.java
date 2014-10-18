/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.views.terminals;
import chess.views.ChessView;
import chess.models.ChessState;

/**
 *
 * @author justin
 */
public class ChessVanillaTerminal extends ChessView
{
    
    @Override
    public void update(ChessState state, int playerID)
    {
        //Once I see the possible states, I will wrap this statement
        System.out.println("Is is currently player " + playerID + "'s turn.");
        System.out.println("What would you like to do?");
        
    }
    
    public void printBoard()
    {
        
    }
}
