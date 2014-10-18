/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.views.graphical;

import chess.models.ChessState;
import chess.views.ChessView;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.LayoutManager;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author justin
 */
public class ChessVanillaGraphical extends ChessView{
    
    
    public static void main (String [] args){
        ChessVanillaGraphical c = new ChessVanillaGraphical();
        c.setupBoard();
    }
    
    @Override
    public void update(ChessState state, int playerID)
    {
        
    }
    
    public void printBoard()
    {
        
    }
    
     private void initializeBoard(JFrame f)
    {
        
    }
     
    public void setupBoard()
    {
        JFrame mainView = new JFrame("Chess Game");
        this.setupFrame(mainView, 900,600, null);   
         mainView.repaint();
    }
    
     private void setupFrame(JFrame frame, int height, int width, LayoutManager layout)
    {
        frame.pack();
        frame.setVisible(true);
        frame.setSize(height, width);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(layout);   
    }
   
     
     //Use this function to get the image path for each piece below
     //Use: getPiecePath(ChessVanillaGraphical.WPAWN);
     //or   getPiecePath(this.WPAWN);
     private String getPiecePath(String piece){
         String path = getClass().getResource(piece).toString();

         if (path.startsWith("file:/")) {
             path = path.substring(path.indexOf('/') + 1, path.length());
         }
         return path;
     }
    
    //Need to add the chess pieces' image paths here
    private final String WPAWN = "./Images/whitePieces/wPawn.png";
    private final String WKNIGHT = "./Images/whitePieces/wKnight.png";
    private final String WBISHOP = "./Images/whitePieces/wBishop.png";
    private final String WROOK = "./Images/whitePieces/wRook.png";
    private final String WQUEEN = "./Images/whitePieces/wQueen.png";
    private final String WKING = "./Images/whitePieces/wKing.png";
    
    private final String BPAWN = "./Images/blackPieces/bPawn.png";
    private final String BKNIGHT = "./Images/blackPieces/bKnight.png";
    private final String BBISHOP = "./Images/blackPieces/bBishop.png";
    private final String BROOK = "./Images/blackPieces/bRook.png";
    private final String BQUEEN = "./Images/blackPieces/bQueen.png";
    private final String BKING = "./Images/blackPieces/bKing.png";
}
