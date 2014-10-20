/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import chess.models.ChessMovement;
import chess.models.ChessPiece;
import chess.models.ChessState;
import chess.models.ChessTile;

/**
 *
 * @author King
 */
public class ChessGuelphGryphonPieces {
    
    private final static String Path = "views\\graphical\\Images\\";
    
    private static abstract class ChessGuelphGryphonMovement extends ChessMovement
    {
        @Override
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
                
                ChessPiece NewPiece;
                switch( MovingPiece.GetName() )
                {
                    case( "Pawn" ):
                        NewPiece = new ChessGuelphGryphonKnightPiece( MovingPiece.GetOwner() );
                        break;
                    case( "Knight" ):
                        NewPiece = new ChessGuelphGryphonBishopPiece( MovingPiece.GetOwner() );
                        break;
                    case( "Bishop" ):
                        NewPiece = new ChessGuelphGryphonRookPiece( MovingPiece.GetOwner() );
                        break;
                    case( "Rook" ):
                        NewPiece = new ChessGuelphGryphonQueenPiece( MovingPiece.GetOwner() );
                        break;
                    case( "Queen" ):
                        NewPiece = new ChessGuelphGryphonKingPiece( MovingPiece.GetOwner() );
                        break;
                    case( "King" ):
                        NewPiece = new ChessGuelphGryphonPawnPiece( MovingPiece.GetOwner() );
                        break;
                    default:
                        NewPiece = new ChessGuelphGryphonPawnPiece( MovingPiece.GetOwner() );
                        break;
                }
                
                End.SetHeldPiece( NewPiece );
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
    
    public static class ChessGuelphGryphonPawnPiece extends ChessPiece
    {
        public ChessGuelphGryphonPawnPiece( ChessState.PieceOwner Owner ) {
            this.Name = "Pawn";
            this.Owner = Owner;
            this.ImagePath = Path;
            this.ImageFile = "Pawn.png";
            this.Movement = new ChessGuelphGryphonMovement()
            {
                @Override
                public boolean CanMove( ChessTile Start, ChessTile End )
                {
                    int ForwardMove = Start.GetPosition()[1] - End.GetPosition()[1];
                    int SideMove = Math.abs( Start.GetPosition()[0] - End.GetPosition()[0] );
                    ChessPiece MovingPiece = Start.GetHeldPiece();
                    ChessPiece TargetPiece = End.GetHeldPiece();
                    
                    if( !Start.HasClearPath( End ) )
                    {
                        return false;
                    }
                    
                    // Note: In this set of rules, the black pieces are at the top of the board
                    if( MovingPiece.GetOwner() == ChessState.PieceOwner.White )
                    {
                        ForwardMove = -ForwardMove;
                    }
                    
                    // Initial Double Move
                    if( ForwardMove == 2 && SideMove == 0 )
                    {
                        return !Start.GetHeldPiece().HasMoved() && TargetPiece == null;
                    }
                    
                    // Attacking Move
                    else if( ForwardMove == 1 && SideMove == 1 )
                    {
                        return TargetPiece != null && TargetPiece.GetOwner() != MovingPiece.GetOwner();
                    }
                    
                    // Standard Move
                    else if( ForwardMove == 1 && SideMove == 0 )
                    {
                        return TargetPiece == null;
                    }
                    
                    // All other moves are invalid
                    else
                    {
                        return false;
                    }
                }
            };
        }
    }
    
    public static class ChessGuelphGryphonRookPiece extends ChessPiece
    {
        public ChessGuelphGryphonRookPiece( ChessState.PieceOwner Owner ) {
            this.Name = "Rook";
            this.Owner = Owner;
            this.ImagePath = Path;
            this.ImageFile = "Rook.png";
            this.Movement = new ChessGuelphGryphonMovement()
            {
                @Override
                public boolean CanMove( ChessTile Start, ChessTile End )
                {
                    int ForwardMove = Start.GetPosition()[1] - End.GetPosition()[1];
                    int SideMove = Start.GetPosition()[0] - End.GetPosition()[0];
                    
                    if( !Start.HasClearPath( End ) )
                    {
                        return false;
                    }
                    
                    // King Switch
                    /* To Implement */
                    
                    // Standard Move
                    /* else */ return ForwardMove == 0 || SideMove == 0; // All other moves are invalid
                }
            };
        }
    }
    
    public static class ChessGuelphGryphonKnightPiece extends ChessPiece
    {
        public ChessGuelphGryphonKnightPiece( ChessState.PieceOwner Owner ) {
            this.Name = "Knight";
            this.Owner = Owner;
            this.ImagePath = Path;
            this.ImageFile = "Knight.png";
            this.Movement = new ChessGuelphGryphonMovement()
            {
                @Override
                public boolean CanMove( ChessTile Start, ChessTile End )
                {
                    int ForwardMove = Math.abs( Start.GetPosition()[1] - End.GetPosition()[1] );
                    int SideMove = Math.abs( Start.GetPosition()[0] - End.GetPosition()[0] );
                    
                    // Standard Move
                    if( Math.abs( ForwardMove ) == 2 && Math.abs( SideMove ) == 1 )
                    {
                        return true;
                    }
                    else return Math.abs( ForwardMove ) == 1 && Math.abs( SideMove ) == 2; // All other moves are invalid
                }
            };
        }
    }
    
    public static class ChessGuelphGryphonBishopPiece extends ChessPiece
    {
        public ChessGuelphGryphonBishopPiece( ChessState.PieceOwner Owner ) {
            this.Name = "Bishop";
            this.Owner = Owner;
            this.ImagePath = Path;
            this.ImageFile = "Bishop.png";
            this.Movement = new ChessGuelphGryphonMovement()
            {
                @Override
                public boolean CanMove( ChessTile Start, ChessTile End )
                {
                    int ForwardMove = Math.abs( Start.GetPosition()[1] - End.GetPosition()[1] );
                    int SideMove = Math.abs( Start.GetPosition()[0] - End.GetPosition()[0] );
                    
                    if( !Start.HasClearPath( End ) )
                    {
                        return false;
                    }
                    
                    // Standard Move
                    return ForwardMove == SideMove; // All other moves are invalid
                }
            };
        }
    }
    
    public static class ChessGuelphGryphonQueenPiece extends ChessPiece
    {
        public ChessGuelphGryphonQueenPiece( ChessState.PieceOwner Owner ) {
            this.Name = "Queen";
            this.Owner = Owner;
            this.ImagePath = Path;
            this.ImageFile = "Queen.png";
            this.Movement = new ChessGuelphGryphonMovement()
            {
                @Override
                public boolean CanMove( ChessTile Start, ChessTile End )
                {
                    int ForwardMove = Math.abs( Start.GetPosition()[1] - End.GetPosition()[1] );
                    int SideMove = Math.abs( Start.GetPosition()[0] - End.GetPosition()[0] );
                    
                    if( !Start.HasClearPath( End ) )
                    {
                        return false;
                    }
                    
                    // Forward and Side Movement
                    if( ForwardMove == 0 || SideMove == 0 )
                    {
                        return true;
                    }
                    
                    // Diagonal Movement
                    else return ForwardMove == SideMove; // All other moves are invalid
                }
            };
        }
    }
    
    public static class ChessGuelphGryphonKingPiece extends ChessPiece
    {
        public ChessGuelphGryphonKingPiece( ChessState.PieceOwner Owner ) {
            this.Name = "King";
            this.Owner = Owner;
            this.ImagePath = Path;
            this.ImageFile = "King.png";
            this.Movement = new ChessGuelphGryphonMovement()
            {
                @Override
                public boolean CanMove( ChessTile Start, ChessTile End )
                {
                    int ForwardMove = Math.abs( Start.GetPosition()[1] - End.GetPosition()[1] );
                    int SideMove = Math.abs( Start.GetPosition()[0] - End.GetPosition()[0] );
                    
                    // Standard Move
                    return ForwardMove <= 1 && SideMove <= 1; // All other moves are invalid 
                }
            };
        }
    }
    
}
