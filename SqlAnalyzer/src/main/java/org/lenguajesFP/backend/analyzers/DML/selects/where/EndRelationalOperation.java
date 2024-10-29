package org.lenguajesFP.backend.analyzers.DML.selects.where;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;
import org.lenguajesFP.backend.enums.Kind;

public class EndRelationalOperation extends SyntaxAnalyzer {

    private final SyntaxAnalyzer endAnalyzer;

    public EndRelationalOperation(Data data, SyntaxAnalyzer endAnalyzer) {
        super(data);
        this.endAnalyzer = endAnalyzer;
    }

    @Override
    public void analyze() {
        andStatus();
    }



    private void andStatus(){
        if (data.validateLexeme("AND")){
            data.next();
            identifierStatus2();
        } else {
            errorStatus("Se esperaba un token AND");
        }
    }

    private void identifierStatus2(){
        if (data.validateName(Kind.Identificador)){
            data.next();
            equalsStatus();
        } else {
            errorStatus("Se esperaba un token Identificador");
        }
    }

    private void equalsStatus(){
        if (data.validateLexeme("=")){
            data.next();
            identifierStatus3();
        } else {
            errorStatus("Se esperaba un token =");
        }
    }

    private void identifierStatus3(){
        if (data.identifierIdentifier()){
            data.next();
            endAnalyzer.analyze();
        } else {
            errorStatus("Se esperaba un token Identificador");
        }
    }
}
