package org.lenguajesFP.backend.tables;

import org.lenguajesFP.backend.Token;

public class ModifiedTable extends Table {

    private Token column;

    public void setColumn(Token column) {
        this.column = column;
    }

    public Token getColumn() {
        return column;
    }
}
