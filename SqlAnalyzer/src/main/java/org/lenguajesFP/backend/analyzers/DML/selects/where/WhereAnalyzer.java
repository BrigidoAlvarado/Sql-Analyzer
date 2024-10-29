package org.lenguajesFP.backend.analyzers.DML.selects.where;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.DML.inserts.DataAnalyzer;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;
import org.lenguajesFP.backend.enums.Kind;

public class WhereAnalyzer extends SyntaxAnalyzer {

    private final SyntaxAnalyzer end;

    public WhereAnalyzer(Data data, SyntaxAnalyzer endAnalyzer) {
        super(data);
        this.end = endAnalyzer;
    }

    @Override
    public void analyze() {
        SpecialData specialData = new SpecialData(data, new Comparison(data, end));
        specialData.analyze();
    }

    private void mm (){
        if (data.validateName(Kind.Identificador)){
            data.next();
            selectTypeStatus();
        } else {
            errorStatus("Se esperaba un token Identificador");
        }
    }

    private void selectTypeStatus(){
        if (data.validateLexeme("=")){
            data.next();
            WhereIdentifier SimpleWhere = new WhereIdentifier(data, end);
            SimpleWhere.analyze();
        } else if (data.validateName(Kind.Relacionales)) {
            data.next();
            DataAnalyzer dataAnalyzer = new DataAnalyzer(data, new EndRelationalOperation(data, end));
            dataAnalyzer.analyze();
        }
    }
}
