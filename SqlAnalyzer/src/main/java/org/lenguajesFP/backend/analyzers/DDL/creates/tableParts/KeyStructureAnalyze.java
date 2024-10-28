package org.lenguajesFP.backend.analyzers.DDL.creates.tableParts;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;
import org.lenguajesFP.backend.enums.Kind;

public class KeyStructureAnalyze extends SyntaxAnalyzer {

    private final SyntaxAnalyzer endAnalyzer;


    public KeyStructureAnalyze(Data data, SyntaxAnalyzer endAnalyzer) {
        super(data);
        this.endAnalyzer = endAnalyzer;
    }

    @Override
    public void analyze() {
        if (data.validateName(Kind.Identificador)){
            data.next();
            foreignStatus();
        } else {
            data.addSyntaxError("Se esperaba un token de tipo Identificador");
        }
    }

    private void foreignStatus(){
        if (data.validateLexeme("FOREIGN")){
            data.next();
            keyStatus();
        } else {
            data.addSyntaxError("Se esperaba un token FOREIGN");
        }
    }

    private void keyStatus(){
        if (data.validateLexeme("KEY")){
            data.next();
            keyNameStatus();
        } else {
            data.addSyntaxError("Se esperaba un token KEY");
        }
    }

    private void keyNameStatus(){
        if (data.betweenParenthesis(Kind.Identificador)){
            data.next();
            referenceStatus();
        } else {
            data.addSyntaxError("Se esperaba un token entre parentesis");
        }
    }

    private void referenceStatus(){
        if (data.validateLexeme("REFERENCES")){
            data.next();
            identifierStatus();
        } else {
            data.addSyntaxError("Se esperaba un token REFERENCE");
        }
    }

    private void identifierStatus(){
        if (data.validateName(Kind.Identificador)){
            data.next();
            identifierBetween();
        } else {
            data.addSyntaxError("Se esperaba un token Identificador");
        }
    }

    private void identifierBetween(){
        if (data.betweenParenthesis(Kind.Identificador)){
            data.next();
            endAnalyzer.analyze();
        } else {
            data.addSyntaxError("Se esperaba un token Identificador entre parentesis");
        }
    }


}
