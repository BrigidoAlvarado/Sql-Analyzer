package org.lenguajesFP.backend.analyzers.DDL.creates;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.DDL.creates.tableParts.DataTypeAnalyzer;
import org.lenguajesFP.backend.analyzers.DDL.creates.tableParts.EndDeclaration;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;
import org.lenguajesFP.backend.enums.Kind;
import org.lenguajesFP.backend.tables.Column;
import org.lenguajesFP.backend.tables.Table;

public class TableAnalyzer extends SyntaxAnalyzer {
    private final DataTypeAnalyzer dataTypeAnalyzer;

    public static final String KEYWORD = "TABLE";

    public TableAnalyzer(Data data) {
        super(data);
        dataTypeAnalyzer = new DataTypeAnalyzer(data, new EndDeclaration(data), true );
    }

    @Override
    public void analyze() {
        if (data.validateName(Kind.Identificador)) {
            data.setTableName();
            data.next();
            openParenthesisStatus();
        } else {
            data.addSyntaxError("Se esparaba un token de tipo Identificador");
        }
    }

    private void openParenthesisStatus() {
        if (data.validateLexeme("(")) {
            data.next();
            identifierStatus();
        } else {
            data.addSyntaxError("Se esperaba: (");
        }
    }

    private void identifierStatus() {
        if (data.validateName(Kind.Identificador)) {
            data.newColumnAndPart();
            data.next();
            dataTypeAnalyzer.analyze();
        } else {
            data.addSyntaxError("Se esparaba un token de tipo Identificador");
        }
    }
}