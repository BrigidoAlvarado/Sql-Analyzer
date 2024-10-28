package org.lenguajesFP.backend.analyzers.DML.selects;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;
import org.lenguajesFP.backend.enums.Kind;

public class SelectorSentence extends SyntaxAnalyzer {

    public SelectorSentence(Data data) {
        super(data);
    }

    @Override
    public void analyze() {
        if (data.validateName(Kind.Identificador)){
            data.next();
            selectSentenceStatus();
        } else {
            errorStatus("Se esperaba un token Identificador");
        }
    }

    private void selectSentenceStatus(){
        if (data.validateLexeme("JOIN")){
            data.next();
            JoinAnalyzer joinAnalyzer = new JoinAnalyzer(data);
            joinAnalyzer.analyze();
        } else if (data.validateLexeme("WHERE")) {
            data.next();
        } else if (data.validateLexeme("GROUP")) {
            data.next();
        } else if (data.validateLexeme("ORDER")) {
            data.next();
        } else if (data.validateLexeme("LIMIT")) {
            data.next();
        } else{
            errorStatus("Secuencia de token invalida");
        }
    }
}
