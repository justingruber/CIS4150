/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.models;
import chess.models.ChessBoard;

/**
 *
 * @author King
 */
public abstract class ChessMovement {
    
    public abstract boolean CanMove( ChessTile Start, ChessTile End );
    
    public boolean MovePiece( ChessTile Start, ChessTile End )
    {
        // Check invalid paramters
        if( Start.GetHeldPiece() == null || End == null || Start == End )
        {
            return false;
        }
        
        if( CanMove( Start, End ) )
        {
            ChessPiece MovingPiece = Start.GetHeldPiece();
            ChessPiece TargetPiece = End.GetHeldPiece();
            // Perform successful move
            if( TargetPiece == null || TargetPiece.GetOwner() != MovingPiece.GetOwner() )
            {
                Start.SetHeldPiece( null );
                End.SetHeldPiece( MovingPiece );
                return true;
            }
            else
            {
                return false;
            }
        }
        return false;
    }
    
}
