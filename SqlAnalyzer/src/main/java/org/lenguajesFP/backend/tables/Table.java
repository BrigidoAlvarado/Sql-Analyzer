package org.lenguajesFP.backend.tables;

import org.lenguajesFP.backend.Token;

import java.util.ArrayList;
import java.util.List;

public class Table {

    protected   Token name;
    private final List<Column> columns = new ArrayList<>();

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
