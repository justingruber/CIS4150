/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.models;

import chess.controllers.ChessGame;
import chess.views.ChessView;

/**
 *
 * @author justin
 */
public class ChessState {
    
    private final ChessBoard Board;
    private final ChessView Display;
    public static int GameOver = -1;
    
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
        boolean bValidMove = Board.Move( PlayerID, Start, End );
        if( bValidMove && GameOver == -1)
        {
            Display.update( this.Board, ((PlayerID % 2) + 1) );
        }
        return bValidMove;
    }
}
