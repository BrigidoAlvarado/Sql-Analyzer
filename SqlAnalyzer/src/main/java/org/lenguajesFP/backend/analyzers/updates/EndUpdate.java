package org.lenguajesFP.backend.analyzers.updates;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;

public class EndUpdate extends SyntaxAnalyzer {

    public EndUpdate(Data data) {
        super(data);
    }

    @Override
    public void analyze() {
        if (data.validateLexeme(";")){
            data.increaseUpdates();
        } else {
            errorStatus("Se esperaba un token ;");
        }
    }
}
