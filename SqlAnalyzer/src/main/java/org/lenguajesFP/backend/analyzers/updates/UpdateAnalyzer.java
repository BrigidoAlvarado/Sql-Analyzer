package org.lenguajesFP.backend.analyzers.updates;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;

public class UpdateAnalyzer extends SyntaxAnalyzer {
    public static final String KEYWORD = "UPDATE";

    public UpdateAnalyzer(Data data) {
        super(data);
    }

    @Override
    public void analyze() {

    }
}
