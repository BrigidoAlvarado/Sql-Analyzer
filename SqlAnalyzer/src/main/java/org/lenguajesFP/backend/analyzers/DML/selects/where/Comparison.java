package org.lenguajesFP.backend.analyzers.DML.selects.where;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;
import org.lenguajesFP.backend.enums.Kind;

public class Comparison extends SyntaxAnalyzer {

    private final SyntaxAnalyzer end;

    public Comparison(Data data, SyntaxAnalyzer end) {
        super(data);
        this.end = end;
    }

    @Override
    public void analyze() {
        if (data.validateName(Kind.Relacionales) || data.validateLexeme("=")){
            data.next();
            SpecialData specialData = new SpecialData(data, new EndComparison(data, end));
            specialData.analyze();
        } else {
            errorStatus("Se esperaba un token de comparacion");
        }
    }
}
