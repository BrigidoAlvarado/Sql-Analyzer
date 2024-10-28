package org.lenguajesFP.backend.analyzers.DDL.modifiers.alters;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;
import org.lenguajesFP.backend.enums.Kind;

public class ConstraintUnique extends SyntaxAnalyzer {

    public ConstraintUnique(Data data) {
        super(data);
    }

    @Override
    public void analyze() {
        if (data.validateLexeme("(")){
            data.next();
            identifierStatus();
        } else {
            errorStatus("Se esperaba un token (");
        }
    }

    private void identifierStatus(){
        if (data.validateName(Kind.Identificador)){
            data.setModifiedTableColumn();
            data.next();
            endParth();
        } else {
            errorStatus("Se esperaba un token Identificador");
        }
    }

    private void endParth(){
        if (data.validateLexeme(")")){
            data.next();
            finalStatus();
        } else {
            errorStatus("Se esperaba un token )");
        }
    }

    private void finalStatus(){
        if (data.validateLexeme(";")){
            data.saveModifiedTable();
            data.increaseAlters();
        } else{
            errorStatus("Se esperaba un token ;");
        }
    }
}
