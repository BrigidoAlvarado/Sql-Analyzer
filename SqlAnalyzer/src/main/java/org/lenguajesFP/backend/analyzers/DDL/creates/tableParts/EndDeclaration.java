package org.lenguajesFP.backend.analyzers.DDL.creates.tableParts;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;
import org.lenguajesFP.backend.tables.Column;
import org.lenguajesFP.backend.tables.Table;

public class EndDeclaration extends SyntaxAnalyzer {

    private final ContentTableAnalyzer contentTableAnalyzer;
    private final Table table;
    private final Column column;

    public EndDeclaration(Data data, Table table, Column column) {
        super(data);
        this.table = table;
        this.column = column;
        contentTableAnalyzer = new ContentTableAnalyzer(data, table);
    }

    @Override
    public void analyze() {
        if (data.validateLexeme("PRIMARY")){
            column.addPart(data.currentToken());
            data.next();
            primaryStatus();
        } else if (data.validateLexeme("NOT")){
            column.addPart(data.currentToken());
            data.next();
            notStatus();
        } else if (data.validateLexeme("UNIQUE")){
            column.addPart(data.currentToken());
            data.next();
            quoteStatus();
        } else if (data.validateLexeme(",")){
            table.addColumn(column);
            quoteStatus();
        } else if (data.validateLexeme(")")){
            data.next();
            endTable();
        }else{
            data.addSyntaxError("Secuencia de token invalida");
        }
    }

    private void primaryStatus(){
        if (data.validateLexeme("KEY")){
            column.addPart(data.currentToken());
            data.next();
            quoteStatus();
        } else {
            data.addSyntaxError("Se esperaba un token: KEY");
        }
    }

    private void notStatus(){
        if (data.validateLexeme("NULL")){
            column.addPart(data.currentToken());
            data.next();
            quoteStatus();
        } else {
            data.addSyntaxError("Se esperaba un token: NULL");
        }
    }

    private void quoteStatus(){
        if (data.validateLexeme(",")){
            data.next();
            finalStatus();
        } else if (data.validateLexeme(")")){
            data.next();
            endTable();
        }else{
            data.addSyntaxError("Se esperaba un token: ,");
        }
    }

    private void finalStatus(){
        table.addColumn(column);
        contentTableAnalyzer.analyze();
    }

    private void endTable(){
        if (data.validateLexeme(";")){
            table.addColumn(column);
            data.addTable(table);
            data.increaseCreates();
        } else {
            data.addSyntaxError("Se esperaba un token: ;");
        }
    }
}
