package org.lenguajesFP.backend.analyzers.DML.selects.where;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;
import org.lenguajesFP.backend.enums.Kind;

public class EndComparison extends SyntaxAnalyzer {

    private final SyntaxAnalyzer end;

    public EndComparison(Data data, SyntaxAnalyzer end) {
        super(data);
        this.end = end;
    }

    @Override
    public void analyze() {
        if (data.validateName(Kind.Logicos)){
            data.next();
            SpecialData specialData = new SpecialData(data, new Comparison(data, end));
            specialData.analyze();
        } else {
            if (data.validateStackFinalState()){
                end.analyze();
            } else {
                errorStatus("Secuencia de token invalida parentesis abiertos");
            }
        }
    }
}
