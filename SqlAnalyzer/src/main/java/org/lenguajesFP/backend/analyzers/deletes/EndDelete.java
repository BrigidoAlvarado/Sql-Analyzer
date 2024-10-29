package org.lenguajesFP.backend.analyzers.deletes;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;

public class EndDelete extends SyntaxAnalyzer {
    public EndDelete(Data data) {
        super(data);
    }

    @Override
    public void analyze() {
        if (data.validateLexeme(";")){
            data.increaseDeletes();
        } else {
            errorStatus("Se esperaba un token ; ");
        }
    }
}
