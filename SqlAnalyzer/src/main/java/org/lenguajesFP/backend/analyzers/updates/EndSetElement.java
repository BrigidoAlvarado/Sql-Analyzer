package org.lenguajesFP.backend.analyzers.updates;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.DML.selects.where.WhereAnalyzer;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;

public class EndSetElement extends SyntaxAnalyzer {

    private final EndUpdate endUpdate;

    public EndSetElement(Data data) {
        super(data);
        this.endUpdate = new EndUpdate(data);
    }

    @Override
    public void analyze() {
        if (data.validateLexeme(",")){
            data.next();
            SetElementAnalyzer setElementAnalyzer = new SetElementAnalyzer(data);
            setElementAnalyzer.analyze();
        } else if (data.validateLexeme(";")) {
            endUpdate.analyze();
        } else if (data.validateLexeme("WHERE")) {
            data.next();
            WhereAnalyzer whereAnalyzer = new WhereAnalyzer(data, endUpdate);
            whereAnalyzer.analyze();
        } else {
            errorStatus("Secuencia de token invalida");
        }
    }
}
