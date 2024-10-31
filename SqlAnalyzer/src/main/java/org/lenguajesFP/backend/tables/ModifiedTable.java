package org.lenguajesFP.backend.tables;

import org.lenguajesFP.backend.Token;

public class ModifiedTable extends Table {

    private Token column;
    private Token kind;

    @Override
    public String toString(){
        return "name: "+name+" \n column: "+column;
    }

    @Override
    public void reset(){
        super.reset();
        column = null;
    }
    
    public void setKind(Token kind){
        this.kind = kind;
    }
    
    public Token getKind(){
        return kind;
    }

    public void setColumn(Token column) {
        this.column = column;
    }

    public Token getColumn() {
        return column;
    }
}
