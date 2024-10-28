package org.lenguajesFP.backend.analyzers.DML.inserts;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;
import org.lenguajesFP.backend.enums.Kind;

public class InsertAnalyzer extends SyntaxAnalyzer {
    public static final String KEYWORD = "INSERT";

    public InsertAnalyzer(Data data) {
        super(data);
    }

    @Override
    public void analyze() {
        if (data.validateLexeme("INTO")){
            data.next();
            identifierStatus();
        } else {
            errorStatus("Se esperaba un token INTO");
        }
    }

    private void identifierStatus(){
        if (data.validateName(Kind.Identificador)){
            data.next();
            openParenthesis();
        } else {
            errorStatus("Se esperaba un token Identificador");
        }
    }

    private void openParenthesis(){
        if (data.validateLexeme("(")){
            data.next();
            columnNameStatus();
        } else {
            errorStatus("Se esperaba un token (");
        }
    }

    private void columnNameStatus(){
        if (data.validateName(Kind.Identificador)){
            data.next();
            finalColumnNameStatus();
        } else {
            errorStatus("Se esperaba un token Identificador");
        }
    }

    private void finalColumnNameStatus(){
        if (data.validateLexeme(",")){
            data.next();
            addColumnName();
        } else if (data.validateLexeme(")")) {
            data.next();
            valuesStatus();
        } else {
            errorStatus("Se esperaba un token ,");
        }
    }

    private void addColumnName(){
        if (data.validateName(Kind.Identificador)){
            data.next();
            finalColumnNameStatus();
        } else {
            errorStatus("Se esperaba un token Identificador");
        }
    }

    private void valuesStatus(){
        if (data.validateLexeme("VALUES")){
            data.next();
            openParenthesisToData();
        } else {
            errorStatus("Se esperaba un token VALLUES");
        }
    }

    public void openParenthesisToData() {
        if (data.validateLexeme("(")) {
            data.next();
            DataAnalyzer dataAnalyzer = new DataAnalyzer(data, new EndInsertAnanlyzer(data));
            dataAnalyzer.analyze();
        } else {
            errorStatus("Se esperaba un token (");
        }
    }
}
