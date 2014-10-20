/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import chess.controllers.ChessGame;
import chess.models.*;
import chess.views.ChessView;
import java.util.ArrayList;

/**
 *
 * @author King
 */
public class ChessVanillaRules extends ChessRules 
{
    
    private class ChessVanillaBoard extends ChessBoard
    {
        private ChessVanillaBoard()
        {
            this.BoardSize[0] = 8;
            this.BoardSize[1] = 8;
            
            WhitePieces = new ArrayList<>();
            BlackPieces = new ArrayList<>();
            
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
                                Piece = new ChessVanillaPieces.ChessVanillaRookPiece( Owner );
                                break;
                            case( 1 ):
                            case( 6 ):
                                Piece = new ChessVanillaPieces.ChessVanillaKnightPiece( Owner );
                                break;
                            case( 2 ):
                            case( 5 ):
                                Piece = new ChessVanillaPieces.ChessVanillaBishopPiece( Owner );
                                break;
                            case( 3 ):
                                Piece = new ChessVanillaPieces.ChessVanillaQueenPiece( Owner );
                                break;
                            case( 4 ):
                                Piece = new ChessVanillaPieces.ChessVanillaKingPiece( Owner );
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
                        
                        Piece = new ChessVanillaPieces.ChessVanillaPawnPiece( Owner );
                    }
                    
                    this.Board[i][j] = new ChessTile( i, j, this, Piece );
                }
            }            
        }
        
        @Override
        protected int[] ParsePosition( String ToParse )
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
                
                return Position;
            }
            Position[0] = -1;
            Position[1] = -1;
            return Position;
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
                ChessTile StartTile = Board[StartPosition[0]][StartPosition[1]];         
                ChessTile EndTile = Board[EndPosition[0]][EndPosition[1]];
                
                ChessPiece TargetPiece = EndTile.GetHeldPiece();
                
                boolean bValidMove = StartTile.Move( PlayerId, EndTile );
                
                // Check for promotion
                // Check for check or checkmate
                
                // Check end game conditions
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
