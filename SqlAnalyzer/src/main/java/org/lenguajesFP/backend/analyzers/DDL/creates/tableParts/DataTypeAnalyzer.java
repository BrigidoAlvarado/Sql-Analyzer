package org.lenguajesFP.backend.analyzers.DDL.creates.tableParts;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;
import org.lenguajesFP.backend.enums.Kind;
import org.lenguajesFP.backend.tables.Column;
import org.lenguajesFP.backend.tables.Table;

public class DataTypeAnalyzer extends SyntaxAnalyzer {

    private final Table table;
    private final Column column;

    public DataTypeAnalyzer(Data data, Table table, Column column) {
        super(data);
        this.table = table;
        this.column = column;
    }

    @Override
    public void analyze() {
        if (data.validateLexeme("VARCHAR") ){
            column.addPart(data.currentToken());
            data.next();
            openParenthesis();
        } else if (data.validateLexeme("DECIMAL")) {
            column.addPart(data.currentToken());
            data.next();
            openPar2();
        } else if (data.validateName(Kind.TIPO_DE_DATO)) {
            data.next();
            finalStatus();
        } else{
            data.addSyntaxError("se esperaba un tipo de dato");
        }
    }

    private void openParenthesis(){
        if (data.validateLexeme("(")){
            column.addPart(data.currentToken());
            data.next();
            intStatus();
        } else {
            data.addSyntaxError("se esperaba un: (");
        }
    }

    private void intStatus(){
        if (data.validateName(Kind.Entero)){
            column.addPart(data.currentToken());
            data.next();
            endParenthesis();
        } else {
            data.addSyntaxError("se esperaba un entero");
        }
    }

    private void endParenthesis(){
        if (data.validateLexeme(")")){
            column.addPart(data.currentToken());
            data.next();
            finalStatus();
        } else {
            data.addSyntaxError("se esperaba un: )");
        }
    }

    private void openPar2(){
        if (data.validateLexeme("(")){
            column.addPart(data.currentToken());
            data.next();
            int1();
        } else{
            data.addSyntaxError("se esperaba un: (");
        }
    }

    private void int1(){
        if (data.validateName(Kind.Entero)){
            column.addPart(data.currentToken());
            data.next();
            quoteStatus();
        } else {
            data.addSyntaxError("se esperaba un: Entero");
        }
    }

    private void quoteStatus(){
        if (data.validateLexeme(",")){
            column.addPart(data.currentToken());
            data.next();
            int2();
        }else{
            data.addSyntaxError("se esperaba un: ,");
        }
    }

    private void int2(){
        if (data.validateName(Kind.Entero)){
            column.addPart(data.currentToken());
            data.next();
            endParenthesis();
        } else {
            data.addSyntaxError("se esperaba un: Entero");
        }
    }

    private void finalStatus(){
        EndDeclaration endDeclaration = new EndDeclaration(data,table,column);
        endDeclaration.analyze();
    }
}
