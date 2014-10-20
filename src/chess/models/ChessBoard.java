/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.models;

import java.util.ArrayList;

/**
 *
 * @author justin
 */
public abstract class ChessBoard {
 
// The 2D array implies that the board is a rectangle/square variant
    protected int BoardSize[] = { 0, 0 };
    protected ChessTile Board[][];
    
    protected ArrayList<ChessPiece> WhitePieces;
    protected ArrayList<ChessPiece> BlackPieces;
    
    protected abstract int[] ParsePosition( String ToParse );
    public abstract boolean Move( int PlayerId, String Start, String End );
    
    public ChessPiece getPieceAtPosition(int X, int Y) 
    {
        return Board[X][Y].GetHeldPiece();
    }
    
    public boolean HasClearPath( ChessTile Start, ChessTile End )
    {
        int ForwardDistance;
        int SideDistance;
        
        if( Start == null || End == null )
        {
            return false;
        }
        
        ForwardDistance = Math.abs( End.GetPosition()[1] - Start.GetPosition()[1] );
        SideDistance = Math.abs( End.GetPosition()[0] - Start.GetPosition()[0] );
                
        for( int i = 1; i < Math.max( ForwardDistance, SideDistance ) - 1; i++ )
        {
            int ForwardMin = Math.min( ForwardDistance, i );
            int SideMin = Math.min( SideDistance, i );
            
            if( Start.GetPosition()[0] > End.GetPosition()[0] )
            {
                SideMin = -SideMin;
            }
            if( Start.GetPosition()[1] > End.GetPosition()[1] )
            {
                ForwardMin = -ForwardMin;
            }
                        
            if( Board[Start.GetPosition()[0] + SideMin][Start.GetPosition()[1] + ForwardMin].GetHeldPiece() != null )
            {
                return false;
            }
        }
        return true;
    }
    
    public boolean HasClearPath( int StartX, int StartY, int EndX, int EndY )
    {
        return HasClearPath( Board[StartX][StartY], Board[EndX][EndY] );
    }
    
    public int[] GetBoardSize()
    {
        return BoardSize;
    }
}
