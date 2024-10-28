package org.lenguajesFP.backend.analyzers.DML.selects;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;
import org.lenguajesFP.backend.enums.Kind;

public class ColumnAnalyzer extends SyntaxAnalyzer {

    private final SyntaxAnalyzer endAnalyze;
    public ColumnAnalyzer(Data data, SyntaxAnalyzer endAnalyzer) {
        super(data);
        this.endAnalyze = endAnalyzer;

    }

    @Override
    public void analyze() {
        if (data.validateName(Kind.Identificador)){
            data.next();
            finalSimpleStatus();
        } else  if (
                data.validateLexeme("SUM") ||
                data.validateLexeme("AVG") ||
                data.validateLexeme("COUNT") ||
                data.validateLexeme("MIN") ||
                data.validateLexeme("MAX") ){
            data.next();
            identifierBetweenParenthesisStatus();
        } else {
            errorStatus("Secuencia de token invalido");
        }
    }

    private void finalSimpleStatus(){
        if (data.validateLexeme(".")){
            data.next();
            identifierStatus2();
        }  else if (data.validateLexeme("AS")){
            data.next();
            identifierAsStatus();
        }else {
            endAnalyze.analyze();
        }
    }

    private void identifierStatus2(){
        if (data.validateName(Kind.Identificador)){
            data.next();
            finalComputesStatus();
        } else {
            errorStatus("Se esperaba un token identificador");
        }
    }

    private void finalComputesStatus(){
        if (data.validateLexeme("AS")){
            data.next();
            identifierAsStatus();
        } else{
            endAnalyze.analyze();
        }
    }

    private void identifierBetweenParenthesisStatus(){
        if (data.betweenParenthesis(Kind.Identificador)){
            data.next();
            finalComputesStatus();
        }
    }

    //VALIDACION DE LA AGREGACION DE AS
    public void identifierAsStatus(){
        if (data.validateName(Kind.Identificador)){
            data.next();
            endAnalyze.analyze();
        } else{
            errorStatus("Se esperaba un token identificador");
        }
    }
}
