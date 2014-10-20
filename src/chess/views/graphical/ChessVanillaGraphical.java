/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.views.graphical;

import chess.models.ChessBoard;
import chess.models.ChessState;
import chess.views.ChessView;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 *
 * @author justin
 */
public class ChessVanillaGraphical extends ChessView implements MouseListener, MouseMotionListener {
    
    JLayeredPane lPane;
    JPanel chessBoard;
    int xAdjustment;
    int yAdjustment;

    JLabel piece;
    
    public void ChessVanillaGraphical(){
        JPanel panel = new JPanel();
        Dimension boardSize = new Dimension(500, 600);

        lPane = new JLayeredPane();
        panel.add(lPane);
        lPane.setPreferredSize(boardSize);
        lPane.addMouseListener(this);
        lPane.addMouseMotionListener(this);

        chessBoard = new JPanel();
        lPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
        chessBoard.setLayout(new GridLayout(8, 8));
        chessBoard.setSize(500, 500);
        chessBoard.setBounds(0, 0, 500, 500);

        for (int i = 0; i < 64; i++) {
            JPanel tile = new JPanel(new BorderLayout());
            chessBoard.add(tile);

            int row = (i / 8) % 2;
            if (row == 0) {
                tile.setBackground(i % 2 == 0 ? Color.gray : Color.white);
            } else {
                tile.setBackground(i % 2 == 0 ? Color.white : Color.gray);
            }
        }

        initializeGame();
    }
    
    //You are going to need to change the path names because of the images I had already put in,
    //If you look at how I did the pieces in the terminal game, you can just adjust that one for this
    public void initializeGame(){
        //black pieces
        JLabel piece = new JLabel(new ImageIcon("Chess Pieces/bRook.gif"));
        JPanel panel = (JPanel) chessBoard.getComponent(0);
        panel.add(piece);

        piece = new JLabel(new ImageIcon("Chess Pieces/bKnight.gif"));
        panel = (JPanel) chessBoard.getComponent(1);
        panel.add(piece);

        piece = new JLabel(new ImageIcon("Chess Pieces/bBishop.gif"));
        panel = (JPanel) chessBoard.getComponent(2);
        panel.add(piece);

        piece = new JLabel(new ImageIcon("Chess Pieces/bQueen.gif"));
        panel = (JPanel) chessBoard.getComponent(3);
        panel.add(piece);

        piece = new JLabel(new ImageIcon("Chess Pieces/bKing.gif"));
        panel = (JPanel) chessBoard.getComponent(4);
        panel.add(piece);

        piece = new JLabel(new ImageIcon("Chess Pieces/bBishop.gif"));
        panel = (JPanel) chessBoard.getComponent(5);
        panel.add(piece);

        piece = new JLabel(new ImageIcon("Chess Pieces/bKnight.gif"));
        panel = (JPanel) chessBoard.getComponent(6);
        panel.add(piece);

        piece = new JLabel(new ImageIcon("Chess Pieces/bRook.gif"));
        panel = (JPanel) chessBoard.getComponent(7);
        panel.add(piece);

        piece = new JLabel(new ImageIcon("Chess Pieces/bPawn.gif"));
        panel = (JPanel) chessBoard.getComponent(8);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("Chess Pieces/bPawn.gif"));
        panel = (JPanel) chessBoard.getComponent(9);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("Chess Pieces/bPawn.gif"));
        panel = (JPanel) chessBoard.getComponent(10);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("Chess Pieces/bPawn.gif"));
        panel = (JPanel) chessBoard.getComponent(11);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("Chess Pieces/bPawn.gif"));
        panel = (JPanel) chessBoard.getComponent(12);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("Chess Pieces/bPawn.gif"));
        panel = (JPanel) chessBoard.getComponent(13);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("Chess Pieces/bPawn.gif"));
        panel = (JPanel) chessBoard.getComponent(14);
        panel.add(piece);
        piece = new JLabel(new ImageIcon("Chess Pieces/bPawn.gif"));
        panel = (JPanel) chessBoard.getComponent(15);
        panel.add(piece);

        //white pieces 
        piece = new JLabel(new ImageIcon("Chess Pieces/wPawn.gif"));
        panel = (JPanel) chessBoard.getComponent(48);
        panel.add(piece);

        piece = new JLabel(new ImageIcon("Chess Pieces/wPawn.gif"));
        panel = (JPanel) chessBoard.getComponent(49);
        panel.add(piece);

        piece = new JLabel(new ImageIcon("Chess Pieces/wPawn.gif"));
        panel = (JPanel) chessBoard.getComponent(50);
        panel.add(piece);

        piece = new JLabel(new ImageIcon("Chess Pieces/wPawn.gif"));
        panel = (JPanel) chessBoard.getComponent(51);
        panel.add(piece);

        piece = new JLabel(new ImageIcon("Chess Pieces/wPawn.gif"));
        panel = (JPanel) chessBoard.getComponent(52);
        panel.add(piece);

        piece = new JLabel(new ImageIcon("Chess Pieces/wPawn.gif"));
        panel = (JPanel) chessBoard.getComponent(53);
        panel.add(piece);

        piece = new JLabel(new ImageIcon("Chess Pieces/wPawn.gif"));
        panel = (JPanel) chessBoard.getComponent(54);
        panel.add(piece);

        piece = new JLabel(new ImageIcon("Chess Pieces/wPawn.gif"));
        panel = (JPanel) chessBoard.getComponent(55);
        panel.add(piece);

        piece = new JLabel(new ImageIcon("Chess Pieces/wRook.gif"));
        panel = (JPanel) chessBoard.getComponent(56);
        panel.add(piece);

        piece = new JLabel(new ImageIcon("Chess Pieces/wKnight.gif"));
        panel = (JPanel) chessBoard.getComponent(57);
        panel.add(piece);

        piece = new JLabel(new ImageIcon("Chess Pieces/wBishop.gif"));
        panel = (JPanel) chessBoard.getComponent(58);
        panel.add(piece);

        piece = new JLabel(new ImageIcon("Chess Pieces/wQueen.gif"));
        panel = (JPanel) chessBoard.getComponent(59);
        panel.add(piece);

        piece = new JLabel(new ImageIcon("Chess Pieces/wKing.gif"));
        panel = (JPanel) chessBoard.getComponent(60);
        panel.add(piece);

        piece = new JLabel(new ImageIcon("Chess Pieces/wBishop.gif"));
        panel = (JPanel) chessBoard.getComponent(61);
        panel.add(piece);

        piece = new JLabel(new ImageIcon("Chess Pieces/wKnight.gif"));
        panel = (JPanel) chessBoard.getComponent(62);
        panel.add(piece);

        piece = new JLabel(new ImageIcon("Chess Pieces/wRook.gif"));
        panel = (JPanel) chessBoard.getComponent(63);
        panel.add(piece);

    }
    
    
    
    @Override
    public void update(ChessBoard board, int playerID)
    {
        
    }
    
    public void mousePressed(MouseEvent e) {
        try {
            piece = null;
            Component c = chessBoard.findComponentAt(e.getX(), e.getY());

            if (c instanceof JPanel) {
                return;
            }

            Point parentLocation = c.getParent().getLocation();
            xAdjustment = parentLocation.x - e.getX();
            yAdjustment = parentLocation.y - e.getY();
            piece = (JLabel) c;
            piece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
            piece.setSize(piece.getWidth(), piece.getHeight());
            lPane.add(piece, JLayeredPane.DRAG_LAYER);
        } catch (Exception x) {

        }
    }

    public void mouseDragged(MouseEvent me) {
        if (piece == null) {
            return;
        }
        piece.setLocation(me.getX() + xAdjustment, me.getY() + yAdjustment);
    }

    public void mouseReleased(MouseEvent e) {
        try {
            if (piece == null) {
                return;
            }

            piece.setVisible(false);
            Component c = chessBoard.findComponentAt(e.getX(), e.getY());

            if (c instanceof JLabel) {
                Container parent = c.getParent();
                parent.remove(0);
                parent.add(piece);
            } else {
                Container parent = (Container) c;
                parent.add(piece);
            }

            piece.setVisible(true);
        } catch (Exception x) {
        }
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
    }
   
     
    
    
    //Ignore this part for now, use ChessPiece's GetImagePath method

    
    // Use this function to get the image path for each piece below
    // Use: getPiecePath(ChessVanillaGraphical.WPAWN);
    // or   getPiecePath(this.WPAWN);
//     private String getPiecePath(String piece){
//         String path = getClass().getResource(piece).toString();
//
//         if (path.startsWith("file:/")) {
//             path = path.substring(path.indexOf('/') + 1, path.length());
//         }
//         return path;
//     }
//    
//    //Need to add the chess pieces' image paths here
//    private final String WPAWN = "./Images/whitePieces/wPawn.png";
//    private final String WKNIGHT = "./Images/whitePieces/wKnight.png";
//    private final String WBISHOP = "./Images/whitePieces/wBishop.png";
//    private final String WROOK = "./Images/whitePieces/wRook.png";
//    private final String WQUEEN = "./Images/whitePieces/wQueen.png";
//    private final String WKING = "./Images/whitePieces/wKing.png";
//    
//    private final String BPAWN = "./Images/blackPieces/bPawn.png";
//    private final String BKNIGHT = "./Images/blackPieces/bKnight.png";
//    private final String BBISHOP = "./Images/blackPieces/bBishop.png";
//    private final String BROOK = "./Images/blackPieces/bRook.png";
//    private final String BQUEEN = "./Images/blackPieces/bQueen.png";
//    private final String BKING = "./Images/blackPieces/bKing.png";
}
