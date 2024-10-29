package org.lenguajesFP.backend.analyzers.DML.selects;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;
import org.lenguajesFP.backend.enums.Kind;

public class LimitAnalyzer extends SyntaxAnalyzer {

    private final EndSelectAnalyzer endSelectAnalyzer;

    public LimitAnalyzer(Data data) {
        super(data);
        this.endSelectAnalyzer = new EndSelectAnalyzer(data);
    }

    @Override
    public void analyze() {
        if (data.validateName(Kind.Entero)){
            data.next();
            endSelectAnalyzer.analyze();
        } else {
            errorStatus("Se esperaba un token Entero");
        }
    }
}
