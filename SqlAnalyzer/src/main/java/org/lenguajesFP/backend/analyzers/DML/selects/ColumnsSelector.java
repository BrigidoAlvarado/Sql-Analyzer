package org.lenguajesFP.backend.analyzers.DML.selects;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;

public class ColumnsSelector extends SyntaxAnalyzer {

    public ColumnsSelector(Data data) {
        super(data);
    }

    @Override
    public void analyze() {
        if (data.validateLexeme(",")){
            data.next();
            ColumnAnalyzer columnAnalyzer = new ColumnAnalyzer(data, this);
            columnAnalyzer.analyze();
        } else if (data.validateLexeme("FROM")) {
            data.next();
            SelectorSentence selectorSentence = new SelectorSentence(data);
            selectorSentence.analyze();
        }
    }

}
