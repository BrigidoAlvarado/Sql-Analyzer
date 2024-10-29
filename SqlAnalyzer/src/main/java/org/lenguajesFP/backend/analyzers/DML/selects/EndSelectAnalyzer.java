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
        } else if (
                data.validateLexeme("WHERE") ||
                        data.validateLexeme("JOIN") ||
                        data.validateLexeme("LIMIT")||
                        data.validateLexeme("GROUP")||
                        data.validateLexeme("ORDER")
            ) {
            SelectorSentence selectorSentence = new SelectorSentence(data);
            selectorSentence.selectSentenceStatus();
        } else {
            errorStatus("Secuencia de token invalida se esperaba un token , o ; ");
        }
    }
}
