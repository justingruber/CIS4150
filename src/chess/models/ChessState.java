/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.models;

import chess.views.ChessView;

/**
 *
 * @author justin
 */
public class ChessState {
    
    private final ChessBoard Board;
    private final ChessView Display;
    
    public enum PieceOwner
    {
        White,
        Black
    }
    
    public ChessState( ChessView Display, ChessBoard Board )
    {
        this.Display = Display;
        this.Board = Board;
    }
    
    public boolean Move( int PlayerID, String Start, String End )
    {
        boolean bValidMove = Board.Move( Start, End );
        if( bValidMove )
        {
            Display.update( Board, PlayerID );
        }
        return bValidMove;
    }
}
