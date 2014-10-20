/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.models;

/**
 *
 * @author Jake
 */
public class ChessTile 
{
    final private int Position[] = { 0, 0 };
    private ChessPiece HeldPiece = null;
    
    public ChessTile( int X, int Y ) //throws Exception
    {
        if( X < 0 || Y < 0 )
        {
            System.out.printf( "An error occured while constructing the game board\n" );
            //throw new Exception( "Position values must be greater than zero" );
        }
        Position[0] = X;
        Position[1] = Y;
        this.HeldPiece = null;
    }
    
    public ChessTile( int X, int Y, ChessPiece Piece ) //throws Exception
    {
        this( X, Y );
        this.HeldPiece = Piece;
    }
    
    public int[] GetPosition()
    {
        return Position;
    }
    
    public ChessPiece GetHeldPiece()
    {
        return HeldPiece;
    }
    
    public boolean SetHeldPiece( ChessPiece Piece )
    {
        HeldPiece = Piece;
        return true;
    }
    
    public boolean Move( int PlayerId, ChessTile End )
    {
        if( HeldPiece != null && End != null )
        {
            if( ( PlayerId == 1 && HeldPiece.GetOwner() == ChessState.PieceOwner.White )
                || ( PlayerId == 2 && HeldPiece.GetOwner() == ChessState.PieceOwner.Black ) )
            {
                return HeldPiece.Move( this, End );
            }
        }
        return false;
    }
}
