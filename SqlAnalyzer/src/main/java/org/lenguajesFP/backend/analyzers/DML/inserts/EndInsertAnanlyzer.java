package org.lenguajesFP.backend.analyzers.DML.inserts;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;

public class EndInsertAnanlyzer extends SyntaxAnalyzer {

    public EndInsertAnanlyzer(Data data) {
        super(data);
    }

    @Override
    public void analyze() {
        System.out.println("iniciando el final del insert");
        if (data.validateLexeme(",")){
            data.next();
            DataAnalyzer dataAnalyzer = new DataAnalyzer(data, this);
            dataAnalyzer.analyze();
        } else if (data.validateLexeme(")")){
            data.next();
            finalStatus();
        }
    }

    private void finalStatus(){
        if (data.validateLexeme(";")){
            data.increaseInserts();
        } else if (data.validateLexeme(",")){
            data.next();
            InsertAnalyzer insertAnalyzer = new InsertAnalyzer(data);
            insertAnalyzer.openParenthesisToData();
        } else {
            errorStatus("Se esperaba un toke de tipo ; ");
        }
    }
}
