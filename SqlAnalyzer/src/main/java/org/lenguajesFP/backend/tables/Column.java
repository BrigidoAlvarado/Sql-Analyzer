package org.lenguajesFP.backend.tables;

import org.lenguajesFP.backend.Token;

import java.util.ArrayList;
import java.util.List;

public class Column {
    private final List<Token> parts = new ArrayList<>();

    public void addPart(Token token) {
        parts.add(token);
    }

    public void reset(){
        parts.clear();
    }

    public List<Token> getParts() {
        return parts;
    }
}
