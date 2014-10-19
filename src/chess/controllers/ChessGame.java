/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.controllers;
import chess.models.*;
import chess.ChessRules;
import chess.ChessVanillaRules;
import chess.views.ChessView;
import chess.views.graphical.*;
import chess.views.terminals.*;
import java.util.*;
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
    
    public static enum DisplayState
    {
        Graphical,
        Terminal
    }
    
    /* private static object means only one instance of the object can
    be made, this is the singleton pattern */
    private static ChessGame Game;
    
    private ChessRules Rules;
    private ChessState GameState;
    private ChessController Player1;
    private ChessController Player2;
    private ChessView Display;
    private int turnPlayer;
    EndGameResults Winner = null;
    
    private ChessGame(int ruleNum, DisplayState ViewState ) throws Exception
    {
        switch( ruleNum )
        {
            case(1):
                Rules = new ChessVanillaRules();
                break;
            case(2):
                //Rules = new ChessGuelphGryphonRules();
                break;
            case(3):
                //Rules = new ChessDunsanyRules();
                break;
            default:
                System.out.println( "An invalid rule set has been selected" );
                throw new Exception( "An invalid rule set has been selected" );
        }
        if( ViewState == DisplayState.Graphical )
        {
            Display = new ChessVanillaGraphical();
        }
        else
        {
            Display = new ChessVanillaTerminal();
        }
        GameState = Rules.InitializeGameState( Display );
        Player1 = new ChessPlayerController(1, GameState);
        Player2 = new ChessPlayerController(2, GameState);
        turnPlayer = 1;
    }
    
    public static void StartGame( String[] argv )
    {
        int ruleNum = getRuleNum();
        
// Boolean to make sure initialization succeeds
        boolean bValidInit;
        do
        {
            try
            {
                Game = new ChessGame( ruleNum, DisplayState.Terminal );
                bValidInit = true;
            }
            catch( Exception e )
            {
                System.out.printf( "Exception: " + e.getMessage() + "\n" );
                System.out.printf( "Failed to start game with ruleset %d.\n", ruleNum );
                bValidInit = false;
            }
        } while( !bValidInit ); 
        
        Game.playGame();
    }
    
    public static int getRuleNum(){
        
        int ruleNum = 0;
        Scanner scan = new Scanner(System.in);
        
        //Leave this commented until we implement other rules.
        /*while(ruleNum < 1 || ruleNum > 3){
            
            ruleNum = 0;
            System.out.println("1. Vanilla Chess");
            System.out.println("2. Dunsany's Chess");
            System.out.println("3. Guelph Gryphon Chess");
            System.out.println("Please enter the number correspoding to the version of chess you'd like to play:");
            
            try{
            
                ruleNum = scan.nextInt();
                if(ruleNum < 1 || ruleNum > 3)
                    System.out.println("The number must be between 1 and 3");
            
            }catch(Exception e){
                
                System.out.println("You must enter a whole number");
                scan.next();
                
            }
        
        }*/
        ruleNum = 1;
        
        return ruleNum;
        
    }
    
    public void playGame(){
        
        ChessPlayerController Player;
        boolean gameOver = false;
        
        while(!gameOver){
            
            if(turnPlayer == 1)
                Player = (ChessPlayerController)Player1;
            else
                Player = (ChessPlayerController)Player2;
            
            Player.getMove();
            
            if(Winner != null)
                gameOver = true;
            
        }
        
        ChessGame.EndGame(Winner);
        
    }
    
    public static void EndGame( EndGameResults Winner )
    {
        if( Winner == EndGameResults.Player1 || Winner == EndGameResults.Player2 )
        {
            System.out.println("Congratulations " + Winner + "!");
        }
        else
        {
            System.out.println("Nobody wins this time!");
        }
    }
    
    public static ChessGame getGame(){
        
        return Game;
        
    }
    
    public int getTurnPlayer(){
        
        return turnPlayer;
        
    }
    
    public void setTurnPlayer(int turnPlayer){
        
        this.turnPlayer = turnPlayer;
        
    }
    
    public void endOfTurn(int playerID, boolean isValidMove, int gameResult){
        
        if(gameResult == 0){
            
            if(isValidMove)
                turnPlayer = (playerID % 2) + 1;
            
        }else{
            
            if(gameResult == 1)
                Winner = EndGameResults.Player1;
            else if(gameResult == 2)
                Winner = EndGameResults.Player2;
            else if(gameResult == 3)
                Winner = EndGameResults.Tie;
            else
                Winner = EndGameResults.DNF;
            
        }
        
    }
    
}
