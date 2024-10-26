package org.lenguajesFP.backend;

import java.awt.Color;
import org.lenguajesFP.backend.enums.Kind;

public class Token {
    protected String lexeme;
    protected Kind name;
    protected Color color;
    protected int row;
    protected int column;

    @Override
    public String toString() {

        return "lexeme: "+lexeme+" name: "+name+" color: "+color+" row: "+row+" column: "+column;
    }

    public Token(){}

    public Token(String lexeme, Kind name, Color color, int row, int column) {
        this.lexeme = lexeme;
        this.name = name;
        this.color = color;
        this.row = row;
        this.column = column;
    }

    public String getLexeme() {
        return lexeme;
    }

    public Kind getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
