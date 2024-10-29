package org.lenguajesFP.backend.analyzers.DML.selects;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;
import org.lenguajesFP.backend.enums.Kind;

public class GroupByAnalyzer extends SyntaxAnalyzer {

    private final EndSelectAnalyzer endSelectAnalyzer;

    public GroupByAnalyzer(Data data) {
        super(data);
        this.endSelectAnalyzer = new EndSelectAnalyzer(data);
    }

    @Override
    public void analyze() {
        if (data.validateLexeme("BY")){
            data.next();
            identifierStatus();
        } else {
            errorStatus("Se esperaba un token BY");
        }
    }

    private void identifierStatus(){
        if (data.validateName(Kind.Identificador)){
            data.next();
            finalStatus1();
        } else {
            errorStatus("Se esperaba un token Identificador");
        }
    }

    private void finalStatus1(){
        if (data.validateLexeme(".")){
            data.next();
            lastIdentifierStatus();
        } else {
            endSelectAnalyzer.analyze();
        }
    }

    private void lastIdentifierStatus(){
        if (data.validateName(Kind.Identificador)){
            data.next();
            endSelectAnalyzer.analyze();
        } else {
            errorStatus("Se esperaba un token Identificador");
        }
    }
}
