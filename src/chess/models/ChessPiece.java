/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.models;

/**
 *
 * @author justin
 */
public abstract class ChessPiece {
    
    protected String Name;
    protected ChessState.PieceOwner Owner;
    protected ChessMovement Movement;
    protected String ImagePath;
    protected String ImageFile;
    private boolean bHasMoved = false;
    
    final public boolean HasMoved()
    {
        return bHasMoved;
    }
    
    final public String GetName()
    {
        return Name;
    }
    
    final public ChessState.PieceOwner GetOwner()
    {
        return Owner;
    }
    
    final public String GetImagePath()
    {
        String OwnerSubstring;
        if( Owner == ChessState.PieceOwner.Black )
        {
            OwnerSubstring = "blackPieces\\b";
        }
        else
        {
            OwnerSubstring = "whitePieces\\w";
        }
        return ImagePath + OwnerSubstring + ImageFile;
    }
    
    final public boolean Move( ChessTile start, ChessTile end )
    {
        if( Movement.MovePiece( start, end ) )
        {
            bHasMoved = true;
            return true;
        }
        return false;
    }
    
}
