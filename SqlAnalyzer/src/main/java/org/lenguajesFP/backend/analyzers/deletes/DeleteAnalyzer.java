package org.lenguajesFP.backend.analyzers.deletes;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.DML.selects.where.WhereAnalyzer;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;
import org.lenguajesFP.backend.enums.Kind;

public class DeleteAnalyzer extends SyntaxAnalyzer {

    public static final String  KEYWORD = "DELETE";

    private final EndDelete end;

    public DeleteAnalyzer(Data data) {
        super(data);
        end = new EndDelete(data);
    }

    @Override
    public void analyze() {
        if (data.validateLexeme("FROM")){
            data.next();
            identifierStatus();
        } else {
            errorStatus("Se esperaba un token FROM");
        }
    }

    private void identifierStatus(){
        if (data.validateName(Kind.Identificador)){
            data.next();
            selectStatus();
        } else {
            errorStatus("Se esperaba un token Identificador");
        }
    }

    private void selectStatus(){
        if (data.validateLexeme(";")){
            end.analyze();
        } else if (data.validateLexeme("WHERE")) {
            data.next();
            WhereAnalyzer whereAnalyzer = new WhereAnalyzer(data, end);
            whereAnalyzer.analyze();
        } else {
            errorStatus("Se esperaba un token WHERE o ;");
        }
    }
}
