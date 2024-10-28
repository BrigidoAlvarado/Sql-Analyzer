package org.lenguajesFP.backend.analyzers.DDL.modifiers.alters;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.DDL.creates.tableParts.DataTypeAnalyzer;
import org.lenguajesFP.backend.analyzers.DDL.creates.tableParts.KeyStructureAnalyze;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;
import org.lenguajesFP.backend.enums.Kind;

public class AlterConstraint extends SyntaxAnalyzer {

    public AlterConstraint(Data data) {
        super(data);
    }

    @Override
    public void analyze() {
        if (data.validateName(Kind.Identificador)){
            data.setModifiedTableColumn();
            data.next();
            finalStatus();
        } else{
            errorStatus("Se esperaba un token Identificador");
        }
    }

    private void finalStatus(){
        if (data.validateName(Kind.TIPO_DE_DATO)){
            DataTypeAnalyzer dataTypeAnalyzer = new DataTypeAnalyzer(data, new EndAlter(data), false);
            dataTypeAnalyzer.analyze();
        } else if (data.validateLexeme("UNIQUE")) {
            data.next();
            ConstraintUnique constraintUnique = new ConstraintUnique(data);
            constraintUnique.analyze();
        } else if (data.validateLexeme("FOREIGN")) {
            data.back();
            KeyStructureAnalyze keyStructureAnalyze = new KeyStructureAnalyze(data, new EndAlter(data));
            keyStructureAnalyze.analyze();

        } else {
            errorStatus("Se de token invalida");
        }
    }
}
