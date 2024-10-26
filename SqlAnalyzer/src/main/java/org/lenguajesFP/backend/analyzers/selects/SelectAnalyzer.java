package org.lenguajesFP.backend.analyzers.selects;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;

public class SelectAnalyzer extends SyntaxAnalyzer {
    public static final String KEYWORD = "SELECT";

    public SelectAnalyzer(Data data) {
        super(data);
    }

    @Override
    public void analyze() {

    }
}
