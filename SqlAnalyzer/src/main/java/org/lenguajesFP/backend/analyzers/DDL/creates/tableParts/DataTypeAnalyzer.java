package org.lenguajesFP.backend.analyzers.DDL.creates.tableParts;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;
import org.lenguajesFP.backend.enums.Kind;

public class DataTypeAnalyzer extends SyntaxAnalyzer {

    private final SyntaxAnalyzer finalAnalyzer;

    private boolean adColumn = false;

    public DataTypeAnalyzer(Data data, SyntaxAnalyzer finalAnalyzer, boolean adColumn) {
        super(data);
        this.adColumn = adColumn;
        this.finalAnalyzer = finalAnalyzer;
    }

    @Override
    public void analyze() {
        if (data.validateLexeme("VARCHAR") ){
            adPart();
            data.next();
            openParenthesis();
        } else if (data.validateLexeme("DECIMAL")) {
            adPart();
            data.next();
            openPar2();
        } else if (data.validateName(Kind.TIPO_DE_DATO)) {
            adPart();
            data.next();
            finalStatus();
        } else{
            data.addSyntaxError("se esperaba un tipo de dato");
        }
    }

    private void openParenthesis(){
        if (data.validateLexeme("(")){
            adPart();
            data.next();
            intStatus();
        } else {
            data.addSyntaxError("se esperaba un: (");
        }
    }

    private void intStatus(){
        if (data.validateName(Kind.Entero)){
            adPart();
            data.next();
            endParenthesis();
        } else {
            data.addSyntaxError("se esperaba un entero");
        }
    }

    private void endParenthesis(){
        if (data.validateLexeme(")")){
            adPart();
            data.next();
            finalStatus();
        } else {
            data.addSyntaxError("se esperaba un: )");
        }
    }

    private void openPar2(){
        if (data.validateLexeme("(")){
            adPart();
            data.next();
            int1();
        } else{
            data.addSyntaxError("se esperaba un: (");
        }
    }

    private void int1(){
        if (data.validateName(Kind.Entero)){
            adPart();
            data.next();
            quoteStatus();
        } else {
            data.addSyntaxError("se esperaba un: Entero");
        }
    }

    private void quoteStatus(){
        if (data.validateLexeme(",")){
            adPart();
            data.next();
            int2();
        }else{
            data.addSyntaxError("se esperaba un: ,");
        }
    }

    private void int2(){
        if (data.validateName(Kind.Entero)){
            adPart();
            data.next();
            endParenthesis();
        } else {
            data.addSyntaxError("se esperaba un: Entero");
        }
    }

    private void finalStatus(){
        finalAnalyzer.analyze();
    }

    private void adPart(){
        if (adColumn){
            data.addPartColumn();
        }
    }
}
