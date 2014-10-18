/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.views;

import java.util.Observable;

/**
 *
 * @author justin
 */
public abstract class ChessMainMenuView extends Observable{
    
    public abstract void update();
    public abstract void displayMessage (String message);
}
