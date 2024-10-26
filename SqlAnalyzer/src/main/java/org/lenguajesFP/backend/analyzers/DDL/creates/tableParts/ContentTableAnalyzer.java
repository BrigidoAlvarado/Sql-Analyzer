package org.lenguajesFP.backend.analyzers.DDL.creates.tableParts;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;
import org.lenguajesFP.backend.enums.Kind;
import org.lenguajesFP.backend.tables.Column;
import org.lenguajesFP.backend.tables.Table;

public class ContentTableAnalyzer extends SyntaxAnalyzer {

    private final KeyStructureAnalyze keyStructureAnalyze;
    private final DataTypeAnalyzer dataTypeAnalyzer;
    private Table table;
    private Column column;

    public ContentTableAnalyzer(Data data, Table table) {
        super(data);
        this.table = table;
        this.column = new Column();
        this.keyStructureAnalyze = new KeyStructureAnalyze(data);
        this.dataTypeAnalyzer = new DataTypeAnalyzer(data, table, column);
    }

    @Override
    public void analyze() {
        if (data.validateName(Kind.Identificador)){
            column.addPart(data.currentToken());
            data.next();
            dataTypeAnalyzer.analyze();
        } else if (data.validateLexeme("CONSTRAINT")){
            data.next();
            keyStructureAnalyze.analyze();
        } else {
            data.addSyntaxError("Secuencia de token invalida se espera un Identificador o CONSTRAINT");
        }
    }
}
