/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import chess.models.ChessState;
import chess.views.ChessView;

/**
 *
 * @author justin
 */
public abstract class ChessRules
{    
    public abstract ChessState InitializeGameState( ChessView Display );
}
