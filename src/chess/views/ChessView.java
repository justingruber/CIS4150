/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.views;

import chess.models.ChessState;

/**
 *
 * @author justin
 */
public abstract class ChessView {
    
    public abstract void update(ChessState state, int playerID);

}
