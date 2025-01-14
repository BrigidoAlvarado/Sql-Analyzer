package org.lenguajesFP.backend.analyzers.updates;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;
import org.lenguajesFP.backend.enums.Kind;

public class UpdateAnalyzer extends SyntaxAnalyzer {
    public static final String KEYWORD = "UPDATE";

    public UpdateAnalyzer(Data data) {
        super(data);
    }

    @Override
    public void analyze() {
        if (data.validateName(Kind.Identificador)){
            data.next();
            setStatus();
        } else {
            errorStatus("Se esperaba un token Identificador");
        }
    }

    private void setStatus(){
        if (data.validateLexeme("SET")){
            data.next();
            SetElementAnalyzer setElementAnalyzer = new SetElementAnalyzer(data);
            setElementAnalyzer.analyze();
        } else {
            errorStatus("Se esperaba un token SET");
        }
    }
}
