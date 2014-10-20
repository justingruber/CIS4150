/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.controllers;
import chess.models.*;
import chess.ChessRules;
import chess.ChessVanillaRules;
import chess.ChessDunsanyRules;
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
                Rules = new ChessDunsanyRules();
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
        
        ChessMainMenuTerminal Menu = new ChessMainMenuTerminal();
        int option = 0;
        int ruleNum = 0;
        
        option = getNumber(Menu, 2);
        if(option == 1){
            
            Menu.setState(ChessMainMenuTerminal.State.PLAY);
            ruleNum = getNumber(Menu, 3);
        
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
        
        }else
            System.out.println("Goodbye.");
        
    }
    
    public static int getNumber(ChessMainMenuTerminal Menu, int maxNum){
        
        int num = 0;
        Scanner scan = new Scanner(System.in);
        
        //Leave this commented until we implement other rules.
        while(num < 1 || num > maxNum){
            
            num = 0;
            try{
            
                Menu.update();
                num = scan.nextInt();
                if(num < 1 || num > maxNum)
                    Menu.displayMessage("The number must be between 1 and 3");
            
            }catch(Exception e){
                
                Menu.displayMessage("You must enter a whole number");
                scan.next();
                
            }
        
        }
        
        return num;
        
    }
    
    public void playGame(){
        
        ChessPlayerController Player;
        boolean gameOver = false;
        String input = "";
        
        while(!gameOver){
            
            if(turnPlayer == 1)
                Player = (ChessPlayerController)Player1;
            else
                Player = (ChessPlayerController)Player2;
            
            input = Player.getMove(Display, turnPlayer);
            
            if(Winner != null || input.equalsIgnoreCase("q"))
                gameOver = true;
            
        }
        
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
        ChessState.GameOver = 1;
        getGame().Winner = Winner;
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
    
    public void endOfTurn(int playerID){
        
        turnPlayer = (playerID % 2) + 1;
        
    }
    
    public EndGameResults getWinner(){
        
        return Winner;
        
    }
    
}
