/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.controllers;
import chess.models.*;
/**
 *
 * @author justin
 */
abstract public class ChessController{
    
    private int playerID;
    
    public ChessController(int playerID){
        
        this.playerID = playerID;
        
    }
    
    public int getPlayerID(){
        
        return playerID;
        
    }
    
    public void setPlayerID(int playerID){
        
        this.playerID = playerID;
        
    }
    
    public void turnResult(boolean isValidMove){
        
        ChessGame.getGame().changeTurn(playerID, isValidMove);
        
    }
    
}
