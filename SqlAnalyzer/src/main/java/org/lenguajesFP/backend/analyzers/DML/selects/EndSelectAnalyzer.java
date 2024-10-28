package org.lenguajesFP.backend.analyzers.DML.selects;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;

public class EndSelectAnalyzer extends SyntaxAnalyzer {

    public EndSelectAnalyzer(Data data) {
        super(data);
    }

    @Override
    public void analyze() {
        if (data.validateLexeme(";")){
            data.increaseSelects();
        } else  {
            errorStatus("Se esperaba un token ;");
        }
    }
}
