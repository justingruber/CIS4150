/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.controllers;
import chess.models.*;
import chess.views.ChessView;
import chess.views.terminals.*;
import java.util.*;
/**
 *
 * @author justin
 */
public class ChessPlayerController extends ChessController{
    
    private final ChessState GameState;
    
    public ChessPlayerController(int playerID, ChessState GameState){
        
        super(playerID);
        this.GameState = GameState;
    }
    
    public String getMove(ChessView Display, int playerID){
        
        Scanner scan = new Scanner(System.in);
        Scanner parse;
        String input = "";
        String start = "";
        String end = "";
        boolean valid = false;
        
        Display.update(GameState.Board, playerID);
        //This will take the input and parse it so the model will be able to use it as is.
        while(!valid){
            
            try{
            
                System.out.println("Please enter your move:");
                input = scan.nextLine();
                if(!input.equalsIgnoreCase("q")){
                    
                    parse = new Scanner(input).useDelimiter("\\s");
                    start = parse.next();
                    end = parse.next();
                
                }
                valid = true;
        
            }catch(Exception e){
                System.out.println("Invalid input. Please try again.");
            }
            
        }
        
        if(!input.equalsIgnoreCase("q"))
            GameState.Move( getPlayerID(), start, end );
        else
            System.out.println("Goodbye.");
        
        return input;
        
    }
    
}