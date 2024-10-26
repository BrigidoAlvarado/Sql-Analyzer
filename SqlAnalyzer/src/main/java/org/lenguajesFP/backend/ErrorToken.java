package org.lenguajesFP.backend;

import java.awt.*;

public class ErrorToken extends Token {
    private final String description;

    public ErrorToken(String lexeme, Color color, int row, int column, String description){
        this.lexeme = lexeme;
        this.color = color;
        this.row = row;
        this.column = column;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "lexeme: " + lexeme + ", row: " + row + ", column: " + column + ", description: " + description;
    }

}
