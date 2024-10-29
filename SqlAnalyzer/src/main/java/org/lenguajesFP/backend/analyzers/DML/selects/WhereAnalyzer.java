package org.lenguajesFP.backend.analyzers.DML.selects;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.DML.inserts.DataAnalyzer;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;
import org.lenguajesFP.backend.enums.Kind;

public class WhereAnalyzer extends SyntaxAnalyzer {

    public WhereAnalyzer(Data data) {
        super(data);
    }

    @Override
    public void analyze() {
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
            WhereIdentifier SimpleWhere = new WhereIdentifier(data);
            SimpleWhere.analyze();
        } else if (data.validateName(Kind.Relacionales)) {
            data.next();
            DataAnalyzer dataAnalyzer = new DataAnalyzer(data, new EndRelationalOperation(data));
            dataAnalyzer.analyze();
        }
    }
}
