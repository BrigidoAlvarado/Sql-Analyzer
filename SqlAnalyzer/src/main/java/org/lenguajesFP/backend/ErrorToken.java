package org.lenguajesFP.backend;

import java.awt.*;

public class ErrorToken extends Token {
    private String lexeme;
    private String description;
    private int row;
    private int column;

    public ErrorToken(String lexeme, Color color, int row, int column, String description){
        this.lexeme = lexeme;
        this.color = color;
        this.row = row;
        this.column = column;
        this.description = description;
    }

    @Override
    public String toString() {
        return "lexeme: " + lexeme + ", row: " + row + ", column: " + column + ", description: " + description;
    }

}
