/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess.models;

/**
 *
 * @author Justin
 */
public enum GameType {
    VANILLA ("Vanilla", "Regular ol' chess"),
    GUELPHGRYPHON ("Guelph Gryphon", "Each piece cycles through promotions after each move"),
    DUNSANY ("Dunsany's Chess","White has 32 pawns and Black has standard chess set");
    
    private final String name;
    private final String description;

    private GameType (String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    @Override
    public String toString () {
        return name;
    }
    
    public String getDescription () {
        return description;
    }
}