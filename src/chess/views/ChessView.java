/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.views;

import chess.models.ChessState;
import chess.models.ChessBoard;
import java.util.Observable;

/**
 *
 * @author justin
 */
public abstract class ChessView extends Observable{
    
    private ChessBoard board;
    
    public abstract void update(ChessState state, int playerID);
   
    public ChessBoard getBoard(){
        return board;
    }
    
    public void setBoard (ChessBoard board) {
        this.board = board;
    }
}
