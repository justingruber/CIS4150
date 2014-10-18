/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.views.graphical;

import chess.models.ChessState;
import chess.views.ChessView;
import javax.swing.JFrame;

/**
 *
 * @author justin
 */
public class ChessVanillaGraphical extends ChessView{
    
    
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
    
   
    
    //Need to add the chess pieces' image paths here
    private final String WPAWN = "";
    private final String WKNIGHT = "";
    private final String WBISHOP = "";
    private final String WROOK = "";
    private final String WQUEEN = "";
    private final String WKING = "";
    
    private final String BPAWN = "";
    private final String BKNIGHT = "";
    private final String BBISHOP = "";
    private final String BROOK = "";
    private final String BQUEEN = "";
    private final String BKING = "";
}
