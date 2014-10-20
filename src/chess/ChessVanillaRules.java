/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import chess.controllers.ChessGame;
import chess.models.*;
import chess.views.ChessView;

/**
 *
 * @author King
 */
public class ChessVanillaRules extends ChessRules 
{
    private final static String Path = "views\\graphical\\Images\\";
    
    private class ChessPawnPiece extends ChessPiece
    {
        private ChessPawnPiece( ChessState.PieceOwner Owner ) {
            this.Name = "Pawn";
            this.Owner = Owner;
            this.ImagePath = Path;
            this.ImageFile = "Pawn.png";
            this.Movement = new ChessMovement()
            {
                @Override
                public boolean MovePiece( ChessTile Start, ChessTile End )
                {
                    int ForwardMove;
                    int SideMove;
                    ChessPiece MovingPiece;
                    ChessPiece TargetPiece;
                    
                    // Check invalid paramters
                    if( Start.GetHeldPiece() == null || End == null || Start == End )
                    {
                        return false;
                    }
                    
                    ForwardMove = Start.GetPosition()[1] - End.GetPosition()[1];
                    SideMove = Math.abs( Start.GetPosition()[0] - End.GetPosition()[0] );
                    MovingPiece = Start.GetHeldPiece();
                    TargetPiece = End.GetHeldPiece();
                    
                    // Note: In this set of rules, the black pieces are at the top of the board
                    if( MovingPiece.GetOwner() == ChessState.PieceOwner.White )
                    {
                        ForwardMove = -ForwardMove;
                    }
                    
                    // Initial Double Move
                    if( ForwardMove == 2 && SideMove == 0 )
                    {
                        System.out.printf("Initial move: %d %d", ForwardMove, SideMove );
                        if( Start.GetHeldPiece().HasMoved() || TargetPiece != null )
                        {
                            return false;
                        }
                    }
                    
                    // Attacking Move
                    else if( ForwardMove == 1 && SideMove == 1 )
                    {
                        System.out.printf("Attack move: %d %d", ForwardMove, SideMove );
                        if( TargetPiece == null || TargetPiece.GetOwner() == MovingPiece.GetOwner() )
                        {
                            return false;
                        }
                    }
                    
                    // Standard Move
                    else if( ForwardMove == 1 && SideMove == 0 )
                    {
                        System.out.printf("Standard move: %d %d", ForwardMove, SideMove );
                        if( TargetPiece != null )
                        {
                            return false;
                        }
                    }
                    
                    // All other moves are invalid
                    else
                    {
                        System.out.printf("Invalid move: %d %d", ForwardMove, SideMove );
                        return false;
                    }
                    
                    // Perform successful move
                    if( TargetPiece == null || TargetPiece.GetOwner() != MovingPiece.GetOwner() )
                    {
                        Start.SetHeldPiece( null );
                        End.SetHeldPiece( MovingPiece );
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
            };
        }
    }
    
    private class ChessRookPiece extends ChessPiece
    {
        private ChessRookPiece( ChessState.PieceOwner Owner ) {
            this.Name = "Rook";
            this.Owner = Owner;
            this.ImagePath = Path;
            this.ImageFile = "Rook.png";
            this.Movement = new ChessMovement()
            {
                @Override
                public boolean MovePiece( ChessTile Start, ChessTile End )
                {
                    int ForwardMove;
                    int SideMove;
                    ChessPiece MovingPiece;
                    ChessPiece TargetPiece;
                    
                    // Check invalid paramters
                    if( Start.GetHeldPiece() == null || End == null || Start == End )
                    {
                        return false;
                    }
                    
                    ForwardMove = Start.GetPosition()[1] - End.GetPosition()[1];
                    SideMove = Start.GetPosition()[0] - End.GetPosition()[0];
                    MovingPiece = Start.GetHeldPiece();
                    TargetPiece = End.GetHeldPiece();
                    
                    // King Switch
                    /* To Implement */
                    
                    // Standard Move
                    /* else */ if( ForwardMove == 0 || SideMove == 0 )
                    {
                        // Continue
                    }
                    
                    // All other moves are invalid
                    else
                    {
                        return false;
                    }
                    
                    // Perform successful move
                    if( TargetPiece == null || TargetPiece.GetOwner() != MovingPiece.GetOwner() )
                    {
                        Start.SetHeldPiece( null );
                        End.SetHeldPiece( MovingPiece );
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
            };
        }
    }
    
    private class ChessKnightPiece extends ChessPiece
    {
        private ChessKnightPiece( ChessState.PieceOwner Owner ) {
            this.Name = "Knight";
            this.Owner = Owner;
            this.ImagePath = Path;
            this.ImageFile = "Knight.png";
            this.Movement = new ChessMovement()
            {
                @Override
                public boolean MovePiece( ChessTile Start, ChessTile End )
                {
                    int ForwardMove;
                    int SideMove;
                    ChessPiece MovingPiece;
                    ChessPiece TargetPiece;
                    
                    // Check invalid paramters
                    if( Start.GetHeldPiece() == null || End == null || Start == End )
                    {
                        return false;
                    }
                    
                    ForwardMove = Start.GetPosition()[1] - End.GetPosition()[1];
                    SideMove = Start.GetPosition()[0] - End.GetPosition()[0];
                    MovingPiece = Start.GetHeldPiece();
                    TargetPiece = End.GetHeldPiece();
                    
                    // Standard Move
                    if( Math.abs( ForwardMove ) == 2 && Math.abs( SideMove ) == 1 )
                    {
                        // Continue
                    }
                    else if( Math.abs( ForwardMove ) == 1 && Math.abs( SideMove ) == 2 )
                    {
                        // Continue
                    }
                    
                    // All other moves are invalid
                    else
                    {
                        return false;
                    }
                    
                    // Perform successful move
                    if( TargetPiece == null || TargetPiece.GetOwner() != MovingPiece.GetOwner() )
                    {
                        Start.SetHeldPiece( null );
                        End.SetHeldPiece( MovingPiece );
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
            };
        }
    }
    
    private class ChessBishopPiece extends ChessPiece
    {
        private ChessBishopPiece( ChessState.PieceOwner Owner ) {
            this.Name = "Bishop";
            this.Owner = Owner;
            this.ImagePath = Path;
            this.ImageFile = "Bishop.png";
            this.Movement = new ChessMovement()
            {
                @Override
                public boolean MovePiece( ChessTile Start, ChessTile End )
                {
                    int ForwardMove;
                    int SideMove;
                    ChessPiece MovingPiece;
                    ChessPiece TargetPiece;
                    
                    // Check invalid paramters
                    if( Start.GetHeldPiece() == null || End == null || Start == End )
                    {
                        return false;
                    }
                    
                    ForwardMove = Start.GetPosition()[1] - End.GetPosition()[1];
                    SideMove = Start.GetPosition()[0] - End.GetPosition()[0];
                    MovingPiece = Start.GetHeldPiece();
                    TargetPiece = End.GetHeldPiece();
                    
                    // Standard Move
                    if( ForwardMove == SideMove )
                    {
                        // Continue
                    }
                    
                    // All other moves are invalid
                    else
                    {
                        return false;
                    }
                    
                    // Perform successful move
                    if( TargetPiece == null || TargetPiece.GetOwner() != MovingPiece.GetOwner() )
                    {
                        Start.SetHeldPiece( null );
                        End.SetHeldPiece( MovingPiece );
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
            };
        }
    }
    
    private class ChessQueenPiece extends ChessPiece
    {
        private ChessQueenPiece( ChessState.PieceOwner Owner ) {
            this.Name = "Queen";
            this.Owner = Owner;
            this.ImagePath = Path;
            this.ImageFile = "Queen.png";
            this.Movement = new ChessMovement()
            {
                @Override
                public boolean MovePiece( ChessTile Start, ChessTile End )
                {
                    int ForwardMove;
                    int SideMove;
                    ChessPiece MovingPiece;
                    ChessPiece TargetPiece;
                    
                    // Check invalid paramters
                    if( Start.GetHeldPiece() == null || End == null || Start == End )
                    {
                        return false;
                    }
                    
                    ForwardMove = Start.GetPosition()[1] - End.GetPosition()[1];
                    SideMove = Start.GetPosition()[0] - End.GetPosition()[0];
                    MovingPiece = Start.GetHeldPiece();
                    TargetPiece = End.GetHeldPiece();
                    
                    // Forward and Side Movement
                    if( ForwardMove == 0 || SideMove == 0 )
                    {
                        // Continue
                    }
                    
                    // Diagonal Movement
                    else if( ForwardMove == SideMove )
                    {
                        // Continue
                    }
                    
                    // All other moves are invalid
                    else
                    {
                        return false;
                    }
                    
                    // Perform successful move
                    if( TargetPiece == null || TargetPiece.GetOwner() != MovingPiece.GetOwner() )
                    {
                        Start.SetHeldPiece( null );
                        End.SetHeldPiece( MovingPiece );
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
            };
        }
    }
    
    private class ChessKingPiece extends ChessPiece
    {
        private ChessKingPiece( ChessState.PieceOwner Owner ) {
            this.Name = "King";
            this.Owner = Owner;
            this.ImagePath = Path;
            this.ImageFile = "King.png";
            this.Movement = new ChessMovement()
            {
                @Override
                public boolean MovePiece( ChessTile Start, ChessTile End )
                {
                  int ForwardMove;
                    int SideMove;
                    ChessPiece MovingPiece;
                    ChessPiece TargetPiece;
                    
                    // Check invalid paramters
                    if( Start.GetHeldPiece() == null || End == null || Start == End )
                    {
                        return false;
                    }
                    
                    ForwardMove = Start.GetPosition()[1] - End.GetPosition()[1];
                    SideMove = Start.GetPosition()[0] - End.GetPosition()[0];
                    MovingPiece = Start.GetHeldPiece();
                    TargetPiece = End.GetHeldPiece();
                    
                    // Standard Move
                    if( ForwardMove <= 1 && SideMove <= 1 )
                    {
                        // Continue
                    }
                    
                    // All other moves are invalid
                    else
                    {
                        return false;
                    }
                    
                    // Perform successful move
                    if( TargetPiece == null || TargetPiece.GetOwner() != MovingPiece.GetOwner() )
                    {
                        Start.SetHeldPiece( null );
                        End.SetHeldPiece( MovingPiece );
                        return true;
                    }
                    else
                    {
                        return false;
                    }  
                }
            };
        }
    }
    
    private class ChessVanillaBoard extends ChessBoard
    {
        private ChessVanillaBoard()
        {
            this.BoardSize[0] = 8;
            this.BoardSize[1] = 8;
            
            this.Board = new ChessTile[ BoardSize[0] ][ BoardSize [1] ];
        
            for( int i = 0; i < BoardSize[0]; i++ )
            {
                for( int j = 0; j < BoardSize[1]; j++ )
                {
                    ChessPiece Piece = null;
                    
                    if( j == 0 || j == 7)
                    {
                        ChessState.PieceOwner Owner;
                        if( j == 0 )
                        {
                            Owner = ChessState.PieceOwner.White;
                        }
                        else
                        {
                            Owner = ChessState.PieceOwner.Black;
                        }
                        
                        switch( i )
                        {
                            case( 0 ):
                            case( 7 ):
                                Piece = new ChessRookPiece( Owner );
                                break;
                            case( 1 ):
                            case( 6 ):
                                Piece = new ChessKnightPiece( Owner );
                                break;
                            case( 2 ):
                            case( 5 ):
                                Piece = new ChessBishopPiece( Owner );
                                break;
                            case( 3 ):
                                Piece = new ChessQueenPiece( Owner );
                                break;
                            case( 4 ):
                                Piece = new ChessKingPiece( Owner );
                                break;
                        }
                    }
                    else if( j == 1 || j == 6 )
                    {
                        ChessState.PieceOwner Owner;
                        if( j == 1 )
                        {
                            Owner = ChessState.PieceOwner.White;
                        }
                        else
                        {
                            Owner = ChessState.PieceOwner.Black;
                        }
                        
                        Piece = new ChessPawnPiece( Owner );
                    }
                    
                    this.Board[i][j] = new ChessTile( i, j, Piece );
                }
            }            
        }
        
        private int[] ParsePosition( String ToParse )
        {
            int Position[] = { 0, 0 };
            
            if( ToParse.length() == 2 )
            {
            
                switch( ToParse.toUpperCase().charAt( 0 ) )
                {
                    case('A'):
                        Position[0] = 0;
                        break;
                    case('B'):
                        Position[0] = 1;
                        break;
                    case('C'):
                        Position[0] = 2;
                        break;
                    case('D'):
                        Position[0] = 3;
                        break;
                    case('E'):
                        Position[0] = 4;
                        break;
                    case('F'):
                        Position[0] = 5;
                        break;
                    case('G'):
                        Position[0] = 6;
                        break;
                    case('H'):
                        Position[0] = 7;
                        break;
                }
                Position[1] = Integer.parseInt( ToParse.substring( 1 ) );

                System.out.printf("%s: %d %d\n", ToParse, Position[0], Position[1]);
                return Position;
            
            }
            Position[0] = -1;
            Position[1] = -1;
            return Position;
        }
        
        @Override
        public ChessPiece getPieceAtPosition(int X, int Y) 
        {
            return Board[X][Y].GetHeldPiece();
        }

        @Override
        public boolean Move( int PlayerId, String Start, String End ) 
        {
            int StartPosition[];
            int EndPosition[];
            
            StartPosition = ParsePosition( Start );
            EndPosition = ParsePosition( End );
            
            if( StartPosition[0] >= 0 && EndPosition[0] >= 0 )
            {
                ChessPiece TargetPiece = Board[EndPosition[0]][EndPosition[1]].GetHeldPiece();
                boolean bValidMove = Board[StartPosition[0]][StartPosition[1]].Move( PlayerId, Board[EndPosition[0]][EndPosition[1]] );
                if( bValidMove && TargetPiece != null && TargetPiece.GetName().equals( "King" ) )
                {
                    if( TargetPiece.GetOwner() == ChessState.PieceOwner.White )
                    {
                        ChessGame.EndGame( ChessGame.EndGameResults.Player1 );
                    }
                    else
                    {
                        ChessGame.EndGame( ChessGame.EndGameResults.Player2 );
                    }
                }
                return bValidMove;
            }
            else
            {
                return false;
            }
        }
    }
    
    @Override
    public ChessState InitializeGameState( ChessView Display )
    {
        ChessBoard Board = new ChessVanillaBoard();
        ChessState State = new ChessState( Display, Board );
        Display.update( Board, 1 );
        return State;
    }
    
}
