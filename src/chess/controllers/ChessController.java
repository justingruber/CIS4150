/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.controllers;
import chess.models.ChessState;
/**
 *
 * @author justin
 */
abstract public class ChessController{
    
    private ChessState state; //Will the controller receive this from ChessGame?
    private int playerID;
    private boolean myTurn;
    
    public ChessController(int playerID, ChessState state){
        
        this.playerID = playerID;
        if(this.playerID == 1)
            myTurn = true;
        else
            myTurn = false;
        this.state = state;
        
    }
    
    public ChessState getState(){
        
        return state;
        
    }
    
    public int getPlayerID(){
        
        return playerID;
        
    }
    
    public boolean getIfTurn(){
        
        return myTurn;
        
    }
    
    public void setState(ChessState state){
        
        this.state = state;
        
    }
    
    public void setPlayerID(int playerID){
        
        this.playerID = playerID;
        
    }
    
    public void setIfTurn(boolean myTurn){
        
        this.myTurn = myTurn;
        
    }
    
    public void turnResult(boolean isValidMove){
        
        /*I didn't add this method to ChessGame yet, but it is the one
          that tells ChessGame if the current player needs to try to move
          again or if it is the other player's turn.
        */
        ChessGame.Game.changeTurn(playerID, isValidMove);
        
    }
    
}
