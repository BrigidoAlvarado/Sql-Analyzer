package org.lenguajesFP.backend.analyzers;

import org.lenguajesFP.backend.Data;

public abstract class SyntaxAnalyzer {
    protected Data data;

    public SyntaxAnalyzer(Data data) {
        this.data = data;
    }

    public abstract void analyze();

    protected void errorStatus(String description) {
        data.addSyntaxError(description);
    }

    public Data getData(){
        return data;
    }
}
