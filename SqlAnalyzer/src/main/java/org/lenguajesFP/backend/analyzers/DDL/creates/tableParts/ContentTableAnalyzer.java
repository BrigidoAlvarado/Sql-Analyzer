package org.lenguajesFP.backend.analyzers.DDL.creates.tableParts;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;
import org.lenguajesFP.backend.enums.Kind;

public class ContentTableAnalyzer extends SyntaxAnalyzer {

    private final KeyStructureAnalyze keyStructureAnalyze;

    public ContentTableAnalyzer(Data data) {
        super(data);
        this.keyStructureAnalyze = new KeyStructureAnalyze(data, new EndTableAnalyzer(data));
    }

    @Override
    public void analyze() {
        if (data.validateName(Kind.Identificador)){
            data.newColumnAndPart();
            data.next();
            DataTypeAnalyzer dataTypeAnalyzer = new DataTypeAnalyzer(data, new EndDeclaration(data), true);
            dataTypeAnalyzer.analyze();
        } else if (data.validateLexeme("CONSTRAINT")){
            data.next();
            keyStructureAnalyze.analyze();
        } else {
            data.addSyntaxError("Secuencia de token invalida se espera un Identificador o CONSTRAINT");
        }
    }
}
