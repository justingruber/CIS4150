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
 
    public abstract ChessPiece getPieceAtPosition(int row, int col);
    public abstract ChessBoard getBoard();
    
}
