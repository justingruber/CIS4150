/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.views.graphical;

import chess.views.ChessMainMenuView;
import chess.models.ChessPiece;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.util.ArrayList;
/**
 *
 * @author justin
 */
public class ChessMainMenuGraphical extends ChessMainMenuView 
{
    public static void main (String [] args){
        ChessMainMenuGraphical g = new ChessMainMenuGraphical();
        g.setupBoard();
    }
    
    public void setupBoard()
    {
        JFrame mainView = new JFrame("Chess Program");
        this.setupFrame(mainView, 900,600);
        this.initializeBoard(mainView);
    }
    
    @Override
    public void update()
    {
        
    }
    
    private void initializeBoard(JFrame f)
    {
//        ArrayList <JPanel> tiles = new ArrayList ();
//        for (int i = 1; i < 9; i++)
//        {
//            for (int j = 1; j < 9; j++)
//            {
//                
//            }
//        }
        
    }
    
    private void setupFrame(JFrame frame, int height, int width)
    {
        frame.pack();
        frame.setVisible(true);
        frame.setSize(height, width);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
    }
    
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
