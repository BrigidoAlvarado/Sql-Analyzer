package org.lenguajesFP.backend.analyzers.DDL.modifiers.drops;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;
import org.lenguajesFP.backend.enums.Kind;
import org.lenguajesFP.backend.tables.ModifiedTable;

public class DropAnalyze extends SyntaxAnalyzer {

    public static final String KEYWORD = "DROP";

    public DropAnalyze(Data data) {
        super(data);
    }

    @Override
    public void analyze() {
        if (data.validateLexeme("TABLE")){
            data.next();
            ifStatus();
        } else {
            errorStatus("Se esperaba un token TABLE");
        }
    }

    private void ifStatus(){
        if (data.validateLexeme("IF")){
            data.next();
            existStatus();
        } else {
            errorStatus("Se esperaba un token IF");
        }
    }

    private void existStatus(){
        if (data.validateLexeme("EXISTS")){
            data.next();
            identifierStatus();
        } else {
            errorStatus("Se esperaba un token EXISTS");
        }
    }

    private void identifierStatus(){
        if (data.validateName(Kind.Identificador)){
            data.setModifiedTableName();
            data.next();
            cascadeStatus();
        } else {
            errorStatus("Se esperaba un token Identificador");
        }
    }

    private void cascadeStatus(){
        if (data.validateLexeme("CASCADE")){
            data.next();
            finalStatus();
        } else {
            errorStatus("Se esperaba un token CASCADE");
        }
    }

    private void finalStatus(){
        if (data.validateLexeme(";")){
            data.saveModifiedTable();
            data.increaseDrops();
        } else {
            errorStatus("Se esperaba un token ;");

        }
    }
}
