package org.lenguajesFP.backend.analyzers.updates;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;
import org.lenguajesFP.backend.enums.Kind;

public class SetElementAnalyzer extends SyntaxAnalyzer {

    public SetElementAnalyzer(Data data) {
        super(data);
    }

    @Override
    public void analyze() {
        if (data.validateName(Kind.Identificador)){
            data.next();
            equalStatus();
        } else {
            errorStatus("Se esperaba un token Identificador");
        }
    }

    private void equalStatus(){
        if (data.validateLexeme("=")){
            data.next();
            UpdateData updateData = new UpdateData(data, new EndSetElement(data));
            updateData.analyze();
        } else  {
            errorStatus("Se esperaba un token =");
        }
    }
}
