/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.controllers;
import chess.models.*;
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
    
    public void getMove(){
        
        Scanner scan = new Scanner(System.in);
        Scanner parse;
        String input = "";
        String start = "";
        String end = "";
        boolean valid = false;
        
        System.out.println("Input must be of the form 'a b' where 'a' is the starting space and 'b' is the ending space.");
        System.out.println("Ex. a1 c2");
        //This will take the input and parse it so the model will be able to use it as is.
        while(!valid){
            
            try{
            
                System.out.println("Please enter your move:");
                input = scan.nextLine();
                parse = new Scanner(input).useDelimiter("\\s");
                start = parse.next();
                end = parse.next();
                valid = true;
        
            }catch(Exception e){
                System.out.println("Invalid input. Please try again.");
            }
            
        }
        
        //This method will be in the state.
        GameState.Move( start, end );
    }
    
}