/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.views.terminals;
import chess.views.ChessView;
import chess.models.ChessState;
import chess.models.ChessPiece;
import chess.ChessVanillaRules;
import chess.models.ChessBoard;

/**
 *
 * @author justin
 */
public class ChessVanillaTerminal extends ChessView
{  
    public ChessBoard currBoard;
    
    @Override
    public void update(ChessBoard board, int playerID)
    {
        currBoard = board;
        //Once I see the possible states, I will wrap this statement
        printBoard();
        System.out.println("Is is currently player " + playerID + "'s turn.");
        System.out.println("What would you like to do?");
    }
    
    public void displayBoard() 
    {
        System.out.println();
        printBoard();
        System.out.println();
    }
    
    public void printBoard()
    {
        String abc = "ABCDEFGH";
        System.out.print(" " + String.valueOf(ChessVanillaTerminal.VERTICAL));
        
        for (int i = 0; i < abc.length (); i++) {
            System.out.print(abc.charAt(i) + " " + String.valueOf(ChessVanillaTerminal.VERTICAL));
        }
        
        System.out.println();
        System.out.println(" " + String.valueOf(ChessVanillaTerminal.TOP_LEFT) + repeatChar (ChessVanillaTerminal.HORIZONTAL, 23) + String.valueOf (ChessVanillaTerminal.TOP_RIGHT));
        
        ChessBoard board = currBoard;
        
        for (int i = 0; i < 8; i++) {
            System.out.print (i + String.valueOf (ChessVanillaTerminal.VERTICAL));
            
            for (int j = 0; j < 8; j++) {
                //System.out.print(i + "," + j);
                
                ChessPiece piece = board.getPieceAtPosition (i, j);
                String color = " ";
                String pieceChar = " ";
                
                
                //Will change this section based off of how the ChessPiece class is done
                if (piece != null) {
                    color = (piece.GetOwner() == ChessState.PieceOwner.Black) ? "B" : "W";
                    pieceChar = " ";
                    
                    String name = piece.GetName();
                    
                    if (name == "King") {
                        pieceChar = String.valueOf (ChessVanillaTerminal.KING);
                    } else if (name == "Queen") {
                        pieceChar = String.valueOf (ChessVanillaTerminal.QUEEN);
                    } else if (name == "Rook") {
                        pieceChar = String.valueOf (ChessVanillaTerminal.ROOK);
                    } else if (name == "Bishop") {
                        pieceChar = String.valueOf (ChessVanillaTerminal.BISHOP);
                    } else if (name == "Knight") {
                        pieceChar = String.valueOf (ChessVanillaTerminal.KNIGHT);
                    } else if (name == "Pawn") {
                        pieceChar = String.valueOf (ChessVanillaTerminal.PAWN);
                    }
                }
                
                System.out.print(color + pieceChar + String.valueOf(ChessVanillaTerminal.VERTICAL));
            }
            
            System.out.print(i);
            System.out.println();
        }
        
        System.out.println(" " + String.valueOf (ChessVanillaTerminal.BOTTOM_LEFT) + repeatChar (ChessVanillaTerminal.HORIZONTAL, 23) + String.valueOf (ChessVanillaTerminal.BOTTOM_RIGHT));
        System.out.print(" " + String.valueOf (ChessVanillaTerminal.VERTICAL));
        
        for (int i = 0; i < abc.length(); i++) {
            System.out.print(abc.charAt(i) + " " + ChessVanillaTerminal.VERTICAL);
        }
        
        System.out.println();
    }
    
     public void displayLegend() 
     {
        System.out.println ("===============LEGEND===============");
        System.out.println ("The first letter of each pair represents the color. W is white. B is black.");
        System.out.println ("The second letter of each pair represents the type of piece.");
        System.out.println ("K - King");
        System.out.println ("Q - Queen");
        System.out.println ("B - Bishop");
        System.out.println ("N - Knight");
        System.out.println ("R - Rook");
        System.out.println ("P - Pawn");
        System.out.println ("====================================");
    }
     
      private String repeatChar(char c, int n) 
      {
        String s = "";
        
        for (int i = 0; i < n; i++) 
        {
            s += c;
        }
        
        return s;
    }
      
      
    private static final char KING = 'K';
    private static final char QUEEN = 'Q';
    private static final char ROOK = 'R';
    private static final char BISHOP = 'B';
    private static final char KNIGHT = 'N';
    private static final char PAWN = 'P';

    private static final char HORIZONTAL = '-';
    private static final char VERTICAL = '|';
    private static final char TOP_LEFT = '-';
    private static final char TOP_RIGHT = '-';
    private static final char BOTTOM_LEFT = '-';
    private static final char BOTTOM_RIGHT = '-';
    
}
