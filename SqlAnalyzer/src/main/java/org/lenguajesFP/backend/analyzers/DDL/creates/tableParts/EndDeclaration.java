package org.lenguajesFP.backend.analyzers.DDL.creates.tableParts;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;

public class EndDeclaration extends SyntaxAnalyzer {

    private final ContentTableAnalyzer contentTableAnalyzer;

    public EndDeclaration(Data data) {
        super(data);
        contentTableAnalyzer = new ContentTableAnalyzer(data);
    }

    @Override
    public void analyze() {
        if (data.validateLexeme("PRIMARY")){
            data.addPartColumn();
            data.next();
            primaryStatus();
        } else if (data.validateLexeme("NOT")){
            data.addPartColumn();
            data.next();
            notStatus();
        } else if (data.validateLexeme("UNIQUE")){
            data.addPartColumn();
            data.next();
            quoteStatus();
        } else if (data.validateLexeme(",")){
            data.saveColumn();
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
            data.addPartColumn();
            data.next();
            quoteStatus();
        } else {
            data.addSyntaxError("Se esperaba un token: KEY");
        }
    }

    private void notStatus(){
        if (data.validateLexeme("NULL")){
            data.addPartColumn();
            data.next();
            quoteStatus();
        } else {
            data.addSyntaxError("Se esperaba un token: NULL");
        }
    }

    private void quoteStatus(){
        if (data.validateLexeme(",")){
            data.saveColumn();
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
        data.saveColumn();
        contentTableAnalyzer.analyze();
    }

    private void endTable(){
        if (data.validateLexeme(";")){
            data.saveColumn();
            data.saveTable();
            data.increaseCreates();
        } else {
            data.addSyntaxError("Se esperaba un token: ;");
        }
    }
}
