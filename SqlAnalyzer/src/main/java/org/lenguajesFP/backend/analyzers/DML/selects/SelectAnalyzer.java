package org.lenguajesFP.backend.analyzers.DML.selects;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;

public class SelectAnalyzer extends SyntaxAnalyzer {
    public static final String KEYWORD = "SELECT";

    public SelectAnalyzer(Data data) {
        super(data);
    }

    @Override
    public void analyze() {
        if (data.validateLexeme("*")){
            data.next();
            asteriskStatus();
        } else {
            ColumnAnalyzer columnAnalyzer = new ColumnAnalyzer(data, new ColumnsSelector(data));
            columnAnalyzer.analyze();
        }
    }

    private void asteriskStatus(){
        if (data.validateLexeme("FROM")){
            data.next();
            SelectorSentence selectorSentence = new SelectorSentence(data);
            selectorSentence.analyze();
        } else {
            errorStatus("Se esperaba un token FROM");
        }
    }
}
