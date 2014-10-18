/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.models;

/**
 *
 * @author justin
 */
public class ChessState {
    
    ChessBoard Board;
    
    public enum PieceOwner
    {
        White,
        Black
    }
    
    public ChessState( ChessBoard Board )
    {
        this.Board = Board;
    }
    
    public boolean Move( String Start, String End )
    {
        return Board.Move( Start, End );
    }
}
