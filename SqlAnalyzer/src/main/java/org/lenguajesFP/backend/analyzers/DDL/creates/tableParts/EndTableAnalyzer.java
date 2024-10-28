package org.lenguajesFP.backend.analyzers.DDL.creates.tableParts;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;

public class EndTableAnalyzer extends SyntaxAnalyzer {

    public EndTableAnalyzer(Data data) {
        super(data);
    }

    @Override
    public void analyze() {
        if (data.validateLexeme(")")){
            data.next();
            finalStatus();
        } else{
            data.addSyntaxError("Se esperaba un token )");
        }
    }

    private void finalStatus(){
        if (data.validateLexeme(";")){
            data.saveTable();
            data.increaseCreates();
        } else{
            data.addSyntaxError("Se esperaba un token ; ");
        }
    }
}
