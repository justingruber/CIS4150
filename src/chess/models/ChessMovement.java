/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.models;

/**
 *
 * @author King
 */
public interface ChessMovement {
    
    /**
     * Move the owning piece.
     * NOTE: Consider changing Start parameter to take the ChessPiece instead.
     * 
     * @param Start the initial position of the piece
     * @param End the final position of the piece
     * @return true if the move was successful, else false
     */
    public abstract boolean MovePiece( ChessTile Start, ChessTile End );
    
}
