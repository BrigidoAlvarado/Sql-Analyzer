package org.lenguajesFP.backend.analyzers.DDL.creates;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;

public class CreateAnalyzer extends SyntaxAnalyzer {
    public static final String KEYWORD = "CREATE";

    private final TableAnalyzer tableAnalyzer;
    private final DataBaseAnalyzer dataBaseAnalyzer;

    public CreateAnalyzer(Data data) {
        super(data);
        this.tableAnalyzer = new TableAnalyzer(data);
        this.dataBaseAnalyzer = new DataBaseAnalyzer(data);
    }

    @Override
    public void analyze() {
        if (data.validateLexeme(TableAnalyzer.KEYWORD)){
            data.next();
            tableAnalyzer.analyze();
        } else if (data.validateLexeme(DataBaseAnalyzer.KEYWORD)){
            data.next();
            dataBaseAnalyzer.analyze();
        } else {
            errorStatus();
        }
    }

    private void errorStatus(){
        data.addSyntaxError("se esperaba <"+TableAnalyzer.KEYWORD+"> o <"+DataBaseAnalyzer.KEYWORD+">");
    }
}
