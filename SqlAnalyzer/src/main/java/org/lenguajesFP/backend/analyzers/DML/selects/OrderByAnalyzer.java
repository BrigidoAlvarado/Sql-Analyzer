package org.lenguajesFP.backend.analyzers.DML.selects;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;
import org.lenguajesFP.backend.enums.Kind;

public class OrderByAnalyzer extends SyntaxAnalyzer {

    private final EndSelectAnalyzer endSelectAnalyzer;

    public OrderByAnalyzer(Data data) {
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
            orderStatus();
        }
    }

    private void lastIdentifierStatus(){
        if (data.validateName(Kind.Identificador)){
            data.next();
            orderStatus();
        } else {
            errorStatus("Se esperaba un token Identificador");
        }
    }

    private void orderStatus(){
        if (data.validateLexeme("ASC") || data.validateLexeme("DESC")){
            data.next();
            endSelectAnalyzer.analyze();
        } else {
            errorStatus("Se esperaba un token ASC o DESC");
        }
    }

}
