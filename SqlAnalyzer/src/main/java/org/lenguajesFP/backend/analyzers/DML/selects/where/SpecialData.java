package org.lenguajesFP.backend.analyzers.DML.selects.where;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;
import org.lenguajesFP.backend.enums.Kind;

public class SpecialData extends SyntaxAnalyzer {

    private final SyntaxAnalyzer end;

    public SpecialData(Data data, SyntaxAnalyzer end) {
        super(data);
        this.end = end;
    }

    @Override
    public void analyze() {
        inisState();
    }

    private void inisState(){
        if (data.isSpecialData()){
            data.next();
            arithmeticStatus();
        } else if (data.validateName(Kind.Identificador)){
            data.next();
            identifierStatus1();
        } else if (data.isParenthesis()) {
            data.next();
            inisState();
        } else {
            end.analyze();
        }
    }

    private void arithmeticStatus(){
        if (data.validateName(Kind.Aritmeticos)){
            data.next();
            inisState();
        } else if (data.isParenthesis()) {
            data.next();
            arithmeticStatus();
        } else {
            end.analyze();
        }
    }

    private void identifierStatus1(){
        if (data.validateName(Kind.Aritmeticos)){
            data.next();
            inisState();
        } else if (data.validateLexeme(".")) {
            data.next();
            identifierStatus2();
        } else {
            end.analyze();
        }
    }

    private void identifierStatus2(){
        if (data.validateName(Kind.Identificador)){
            data.next();
            arithmeticStatus();
        } else {
            errorStatus("Se espereba un token identificador");
        }
    }
}
