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
    
    private JMenuItem quit;
    
    public ChessMainMenuGraphical()
    {
        
        JFrame frame = new JFrame("Chess");
        frame.setLayout(null);
        
        JMenuBar menuBar = new JMenuBar ();
        frame.setJMenuBar(menuBar);
        
        JMenu fileMenu = new JMenu ("File");
        fileMenu.setMnemonic ('F');
        menuBar.add (fileMenu);
        
        fileMenu.add (quit = new JMenuItem ("Quit"));
        quit.setAccelerator(KeyStroke.getKeyStroke("control Q"));
        
        
        final Board b = new Board();
        b.setLocation (0,50);
        b.setSize (550, 550);
        frame.add (b);
        
        
        quit.addActionListener (new ActionListener ()
        {
            public void actionPerformed (ActionEvent e)
            {
                 System.exit (0);
            }
        }
        );
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable (false);
        frame.setSize (550,750);
        frame.setVisible (true);
    }
    
    @Override
    public void update()
    {
        
    }
    
    @Override
    public void displayMessage(String Message)
    {
        
    }
}
