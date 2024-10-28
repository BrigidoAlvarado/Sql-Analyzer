package org.lenguajesFP.backend.tables;

import org.lenguajesFP.backend.Token;

import java.util.ArrayList;
import java.util.List;

public class Table {

    private final List<Column> columns = new ArrayList<>();
    protected Token key;
    protected Token name;

    @Override
    public String toString() {
        return "nombre: "+ name +" \n columns: "+ columns;
    }

    public void reset(){
        name = null;
        key = null;
        columns.clear();
    }

    public void setKey(Token token){
        key = token;
    }

    public Token getKey(){
        return key;
    }

    public void setName(Token name) {
        this.name = name;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void addColumn(Column column) {
        columns.add(column);
    }

    public Token getName() {
        return name;
    }
}
