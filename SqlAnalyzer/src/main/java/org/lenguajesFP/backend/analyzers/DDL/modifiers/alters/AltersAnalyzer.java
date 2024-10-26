package org.lenguajesFP.backend.analyzers.DDL.modifiers.alters;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;
import org.lenguajesFP.backend.enums.Kind;
import org.lenguajesFP.backend.tables.ModifiedTable;

public class AltersAnalyzer extends SyntaxAnalyzer {

    public static final String KEYWORD = "ALTER";

    private final ModifiedTable modifiedTable = new ModifiedTable();

    public AltersAnalyzer(Data data) {
        super(data);
    }

    @Override
    public void analyze() {
        if (data.validateLexeme("TABLE")){
            data.next();
            identifierStatus();
        } else {
            errorStatus("Se esperaba un toke TABLE");
        }
    }

    private void identifierStatus(){
        if (data.validateName(Kind.Identificador)){
            modifiedTable.setName(data.currentToken());
            data.next();
            addOrDropStatus();
        } else {
            errorStatus("Se esperaba un Identificador");
        }
    }

    private void addOrDropStatus(){
        if (data.validateLexeme("AD")){
            data.next();
        } else if (data.validateLexeme("DROP")) {
            data.next();
            columnStatus();
        } else {
            errorStatus("Se esperaba un token AD o uno DROP");
        }
    }

    private void columnStatus(){
        if (data.validateLexeme("COLUMN")){
            data.next();
            columnNameStatus();
        } else {
            errorStatus("Se esperaba un token COLUMN");
        }
    }

    private void columnNameStatus(){
        if (data.validateName(Kind.Identificador)){
            modifiedTable.setColumn(data.currentToken());
            data.next();
            finalStatus();
        } else {
            errorStatus("Se esperaba un token Identificador");
        }
    }

    private void finalStatus(){
        if (data.validateLexeme(";")){
            data.addModifiedTables(modifiedTable);
            data.increaseAlters();
        } else {
            errorStatus("Se esperaba un token ;");
        }
    }
}