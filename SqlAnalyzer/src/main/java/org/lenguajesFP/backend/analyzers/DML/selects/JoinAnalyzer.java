package org.lenguajesFP.backend.analyzers.DML.selects;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;
import org.lenguajesFP.backend.enums.Kind;

public class JoinAnalyzer extends SyntaxAnalyzer {

    public JoinAnalyzer(Data data) {
        super(data);
    }

    @Override
    public void analyze() {
        if (data.validateName(Kind.Identificador)){
            data.next();
            identifierStatus();
        } else {
            errorStatus("Se esperaba un token identificador");
        }
    }

    private void identifierStatus(){
        if (data.validateName(Kind.Identificador)){
            data.next();
            onStatus();
        } else {
            errorStatus("Se esperaba un token identificador");
        }
    }

    private void onStatus(){
        if (data.validateLexeme("ON")){
            data.next();
            identifierOnStatus();
        } else {
            errorStatus("Se esperaba un token ON");
        }
    }

    private  void  identifierOnStatus(){
        if (data.validateName(Kind.Identificador)) {
            data.next();
            identifierTypeStatus();
        } else {
            errorStatus("Se esperaba un token identificador");
        }
    }

    private void identifierTypeStatus(){
        if (data.validateLexeme(".")){
            data.next();
            identifierDotStatus();
        } else {
            equalStatus();
        }
    }

    private void identifierDotStatus(){
        if (data.validateName(Kind.Identificador)){
            data.next();
            equalStatus();
        } else {
            errorStatus("Se esperaba un token identificador");
        }
    }

    private void equalStatus(){
        if (data.validateLexeme("=")){
            data.next();
            identifierIdentifierStatus();
        } else  {
            errorStatus("Se esperaba un token =");
        }
    }

    private void identifierIdentifierStatus(){
        if (data.identifierIdentifier()){
            data.next();
            EndSelectAnalyzer endSelectAnalyzer = new EndSelectAnalyzer(data);
            endSelectAnalyzer.analyze();
        }
    }
}
