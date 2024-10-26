package org.lenguajesFP.backend.analyzers.DDL.creates;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.DDL.creates.tableParts.DataTypeAnalyzer;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;
import org.lenguajesFP.backend.enums.Kind;
import org.lenguajesFP.backend.tables.Column;
import org.lenguajesFP.backend.tables.Table;

public class TableAnalyzer extends SyntaxAnalyzer {
    private final Table table = new Table();
    private final Column column = new Column();
    private final DataTypeAnalyzer dataTypeAnalyzer;

    public static final String KEYWORD = "TABLE";

    public TableAnalyzer(Data data) {
        super(data);
        dataTypeAnalyzer = new DataTypeAnalyzer(data, table, column);
    }

    @Override
    public void analyze() {
        if (data.validateName(Kind.Identificador)) {
            table.setName(data.currentToken());
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
            column.addPart(data.currentToken());
            data.next();
            dataTypeAnalyzer.analyze();
        } else {
            data.addSyntaxError("Se esparaba un token de tipo Identificador");
        }
    }
}