package org.lenguajesFP.backend.analyzers.DDL.creates;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;
import org.lenguajesFP.backend.enums.Kind;

public class DataBaseAnalyzer extends SyntaxAnalyzer {

    public static final String KEYWORD = "DATABASE";

    public DataBaseAnalyzer(Data data) {
        super(data);
    }

    @Override
    public void analyze() {
        if (data.validateName(Kind.Identificador)){
            data.next();
            identifierStatus();
        } else {
            errorStatus("se esperaba un token: Identificador");
        }
    }

    private void identifierStatus(){
        if (data.validateLexeme(";")){
            data.increaseCreates();
        }
    }

}
