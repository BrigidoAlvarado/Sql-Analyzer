package org.lenguajesFP.backend.analyzers.DDL.modifiers.alters;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;
import org.lenguajesFP.backend.tables.ModifiedTable;

public class AlterAddConstraint extends SyntaxAnalyzer {

    private final ModifiedTable modifiedTable;

    public AlterAddConstraint(Data data, ModifiedTable modifiedTable) {
        super(data);
        this.modifiedTable = modifiedTable;
    }

    @Override
    public void analyze() {

    }
}
