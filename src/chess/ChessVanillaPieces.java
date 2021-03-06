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
public class ChessVanillaPieces {
    
    private final static String Path = "views\\graphical\\Images\\";
    
    public static class ChessVanillaPawnPiece extends ChessPiece
    {
        public ChessVanillaPawnPiece( ChessState.PieceOwner Owner ) {
            this.Name = "Pawn";
            this.Owner = Owner;
            this.ImagePath = Path;
            this.ImageFile = "Pawn.png";
            this.Movement = new ChessMovement()
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
    
    public static class ChessVanillaRookPiece extends ChessPiece
    {
        public ChessVanillaRookPiece( ChessState.PieceOwner Owner ) {
            this.Name = "Rook";
            this.Owner = Owner;
            this.ImagePath = Path;
            this.ImageFile = "Rook.png";
            this.Movement = new ChessMovement()
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
    
    public static class ChessVanillaKnightPiece extends ChessPiece
    {
        public ChessVanillaKnightPiece( ChessState.PieceOwner Owner ) {
            this.Name = "Knight";
            this.Owner = Owner;
            this.ImagePath = Path;
            this.ImageFile = "Knight.png";
            this.Movement = new ChessMovement()
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
    
    public static class ChessVanillaBishopPiece extends ChessPiece
    {
        public ChessVanillaBishopPiece( ChessState.PieceOwner Owner ) {
            this.Name = "Bishop";
            this.Owner = Owner;
            this.ImagePath = Path;
            this.ImageFile = "Bishop.png";
            this.Movement = new ChessMovement()
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
    
    public static class ChessVanillaQueenPiece extends ChessPiece
    {
        public ChessVanillaQueenPiece( ChessState.PieceOwner Owner ) {
            this.Name = "Queen";
            this.Owner = Owner;
            this.ImagePath = Path;
            this.ImageFile = "Queen.png";
            this.Movement = new ChessMovement()
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
    
    public static class ChessVanillaKingPiece extends ChessPiece
    {
        public ChessVanillaKingPiece( ChessState.PieceOwner Owner ) {
            this.Name = "King";
            this.Owner = Owner;
            this.ImagePath = Path;
            this.ImageFile = "King.png";
            this.Movement = new ChessMovement()
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
