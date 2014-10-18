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
    //Test entrence to program for gui testing only
//    public static void main (String [] args){
//        ChessMainMenuGraphical g = new ChessMainMenuGraphical();
//        g.setupBoard();
//    }
    
    public void setupBoard()
    {
        JFrame mainView = new JFrame("Chess Program");
        this.setupFrame(mainView, 900,600, new BorderLayout());
        this.initializeComponents(mainView);
    }
    
    @Override
    public void update()
    {
        
    }
    
    @Override
    public void displayMessage(String Message)
    {
        
    }
    
    private void initializeComponents(JFrame frame)
    {
        
    }
    
     private void setupFrame(JFrame frame, int height, int width, LayoutManager layout)
    {
        frame.pack();
        frame.setVisible(true);
        frame.setSize(height, width);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(layout);   
    }
}
