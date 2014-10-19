/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.views.terminals;
import chess.views.ChessMainMenuView;
import java.util.Scanner;
import chess.models.GameType;
/**
 *
 * @author justin
 */
public class ChessMainMenuTerminal extends ChessMainMenuView 
{
    private State state = State.MAIN;
    
    //Will need the controller to change the state after it gets input
    @Override
    public void update()
    {
        if (state == State.MAIN) {
            System.out.println("*---------------------------*");
            System.out.println("|        Yay Chess!         |");
            System.out.println("*---------------------------*");
            System.out.println("(1)Play");
            System.out.println("(2)Quit");
            System.out.println("Enter the number of your choice from the list above:");
        } else if (state == State.PLAY) {
            int i = 1;
            System.out.println("Which variant do you want to play?");

            for (GameType type : GameType.values()) {
                System.out.println("[" + i + "] " + type + " - " + type.getDescription());
                i++;
            }

            System.out.println("Back");
        }
        
    }
    
    @Override
    public void displayMessage(String errorMessage)
    {
        System.out.println("*---------------------------*");
        System.out.println("Error: " + errorMessage);
        System.out.println("*---------------------------*");
    }
    
    
    public void setState (State state) {
        this.state = state;
    }
    
    public State getState () {
        return state;
    }
    
    public enum State { MAIN, PLAY }
}
