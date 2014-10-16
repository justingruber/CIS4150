/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.controllers;

/**
 *
 * @author justin
 */
public class ChessGame 
{    
    public static enum EndGameResults
    {
        Player1,
        Player2,
        Tie,
        DNF //Did Not Finish OR No Contest
    }
    
    /* private static object means only one instance of the object can
    be made, this is the singleton pattern */
    private static ChessGame Game;
    private ChessController Player1;
    private ChessController Player2;
    
    private ChessGame()
    {
        Player1 = new ChessPlayerController(1);
        Player2 = new ChessPlayerController(2);
    }
    
    public static void StartGame( String[] argv )
    {
        Game = new ChessGame();
    }
    
    public static void EndGame( EndGameResults Winner )
    {
        if( Winner == EndGameResults.Player1 || Winner == EndGameResults.Player2 )
        {
            
        }
        else
        {
            
        }
    }
}
