package org.lenguajesFP.backend.analyzers.DDL.modifiers.alters;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;
import org.lenguajesFP.backend.enums.Kind;
import org.lenguajesFP.backend.tables.ModifiedTable;

public class AltersAnalyzer extends SyntaxAnalyzer {

    public static final String KEYWORD = "ALTER";

    private final AlterAlter alterAlter;
    private final AlterAdd alterAdd;

    public AltersAnalyzer(Data data) {
        super(data);
        this.alterAlter = new AlterAlter(data);
        this.alterAdd = new AlterAdd(data);
    }

    @Override
    public void analyze() {
        if (data.validateLexeme("TABLE")){
            data.next();
            identifierStatus();
        } else {
            errorStatus("Se esperaba un token TABLE");
        }
    }

    private void identifierStatus(){
        if (data.validateName(Kind.Identificador)){
            data.setModifiedTableName();
            data.next();
            alterTypeStatus();
        }  else {
            errorStatus("Se esperaba un Identificador");
        }
    }

    private void alterTypeStatus(){
        if (data.validateLexeme("ADD")){
            data.setModifiedTableKind();
            data.next();
            alterAdd.analyze();
        } else if (data.validateLexeme("DROP")) {
            data.setModifiedTableKind();
            data.next();
            columnStatus();
        } else if (data.validateLexeme("ALTER")) {
            data.setModifiedTableKind();
            data.next();
            alterAlter.analyze();
        } else {
            errorStatus("Secuencia de token invalido");
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
            data.setModifiedTableColumn();
            data.next();
            finalStatus();
        } else {
            errorStatus("Se esperaba un token Identificador");
        }
    }

    private void finalStatus(){
        if (data.validateLexeme(";")){
            data.saveModifiedTable();
            data.increaseAlters();
        } else {
            errorStatus("Se esperaba un token ;");
        }
    }
}