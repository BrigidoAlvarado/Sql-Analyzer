package org.lenguajesFP.backend.analyzers.DDL.modifiers.alters;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;

public class EndAlter extends SyntaxAnalyzer {

    public EndAlter(Data data) {
        super(data);
    }

    @Override
    public void analyze() {
        if (data.validateLexeme(";")){
            data.saveModifiedTable();
            data.increaseAlters();
        } else {
            data.addSyntaxError("Se esperaba un token ;");
        }
    }
}
