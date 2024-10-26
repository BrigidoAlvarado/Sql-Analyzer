package org.lenguajesFP.backend.analyzers.deletes;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;

public class DeleteAnalyzer extends SyntaxAnalyzer {
    public static final String  KEYWORD = "DELETE";

    public DeleteAnalyzer(Data data) {
        super(data);
    }

    @Override
    public void analyze() {

    }
}
