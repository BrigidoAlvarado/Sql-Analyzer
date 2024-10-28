package org.lenguajesFP.backend.tables;

import org.lenguajesFP.backend.Token;

public class ModifiedTable extends Table {

    private Token column;

    @Override
    public String toString(){
        return "name: "+name+" \n column: "+column;
    }

    @Override
    public void reset(){
        super.reset();
        column = null;
    }

    public void setColumn(Token column) {
        this.column = column;
    }

    public Token getColumn() {
        return column;
    }
}
