package org.lenguajesFP.backend.analyzers.DDL.modifiers.drops;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;

public class DropAnalyze extends SyntaxAnalyzer {

    public static final String KEYWORD = "DROP";

    public DropAnalyze(Data data) {
        super(data);
    }

    @Override
    public void analyze() {
        if (data.validateLexeme("TABLE")){
            data.next();

        } else {
            errorStatus("Se esperaba un token TABLE");
        }
    }

    public void
}
