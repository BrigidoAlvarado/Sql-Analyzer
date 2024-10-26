package org.lenguajesFP.backend.analyzers.inserts;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;

public class InsertAnalyzer extends SyntaxAnalyzer {
    public static final String KEYWORD = "INSERT";

    public InsertAnalyzer(Data data) {
        super(data);
    }

    @Override
    public void analyze() {

    }
}
