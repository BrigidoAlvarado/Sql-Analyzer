package org.lenguajesFP.backend.analyzers.DML.selects.where;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.DML.inserts.DataAnalyzer;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;
import org.lenguajesFP.backend.enums.Kind;

public class WhereIdentifier extends SyntaxAnalyzer {

    private final SyntaxAnalyzer endSelectAnalyzer;

    public WhereIdentifier(Data data, SyntaxAnalyzer endSelectAnalyzer) {
        super(data);
        this.endSelectAnalyzer = endSelectAnalyzer;
    }

    @Override
    public void analyze() {
        selectTypeStatus();
    }

    private void selectTypeStatus(){
        if (data.validateName(Kind.Identificador)){
            data.next();
            identifierTypeStatus();
        } else {
            DataAnalyzer dataAnalyzer = new DataAnalyzer(data, endSelectAnalyzer);
            dataAnalyzer.analyze();
        }
    }

    private void  identifierTypeStatus(){
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
            errorStatus("Se esperaba un token Identificador ");
        }
    }

}
