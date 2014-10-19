/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.models;

/**
 *
 * @author justin
 */
public abstract class ChessBoard {
 
// The 2D array implies that the board is a rectangle/square variant
    protected int BoardSize[] = { 0, 0 };
    protected ChessTile Board[][];
    
    public abstract ChessPiece getPieceAtPosition( int X, int Y );
    
    public abstract boolean Move( String Start, String End );
    
    public int[] GetBoardSize()
    {
        return BoardSize;
    }
}
