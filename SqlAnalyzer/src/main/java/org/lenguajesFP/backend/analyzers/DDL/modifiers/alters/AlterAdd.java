package org.lenguajesFP.backend.analyzers.DDL.modifiers.alters;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.DDL.creates.tableParts.DataTypeAnalyzer;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;
import org.lenguajesFP.backend.enums.Kind;

public class AlterAdd extends SyntaxAnalyzer {

    public AlterAdd(Data data ) {
        super(data);
    }

    @Override
    public void analyze() {
        if (data.validateLexeme("COLUMN")){
            data.next();
            columnNameStatus();
        } else if (data.validateLexeme("CONSTRAINT")) {
            data.next();
            AlterConstraint alterConstraint = new AlterConstraint(data);
            alterConstraint.analyze();
        } else {
            errorStatus("Se esperaba un token COLUMN");
        }
    }

    private void columnNameStatus(){
        if (data.validateName(Kind.Identificador)){
            data.setModifiedTableColumn();
            data.next();
            DataTypeAnalyzer dataTypeAnalyzer = new DataTypeAnalyzer(data,new EndAlter(data), false);
            dataTypeAnalyzer.analyze();
        } else {
            errorStatus("Se esperaba un token Identificador");
        }
    }
}
