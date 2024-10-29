package org.lenguajesFP.backend.analyzers.DML.selects;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.DML.selects.where.WhereAnalyzer;
import org.lenguajesFP.backend.analyzers.SyntaxAnalyzer;
import org.lenguajesFP.backend.enums.Kind;

public class SelectorSentence extends SyntaxAnalyzer {

    public SelectorSentence(Data data) {
        super(data);
    }

    @Override
    public void analyze() {
        if (data.validateName(Kind.Identificador)){
            data.next();
            selectSentenceStatus();
        } else {
            errorStatus("Se esperaba un token Identificador");
        }
    }

    public void selectSentenceStatus(){
        if (data.validateLexeme("JOIN")){
            data.next();
            JoinAnalyzer joinAnalyzer = new JoinAnalyzer(data);
            joinAnalyzer.analyze();
        } else if (data.validateLexeme("WHERE")) {
            data.next();
            WhereAnalyzer whereAnalyzer = new WhereAnalyzer(data, new EndSelectAnalyzer(data));
            whereAnalyzer.analyze();
        } else if (data.validateLexeme("GROUP")) {
            data.next();
            GroupByAnalyzer groupByAnalyzer = new GroupByAnalyzer(data);
            groupByAnalyzer.analyze();
        } else if (data.validateLexeme("ORDER")) {
            data.next();
            OrderByAnalyzer orderByAnalyzer = new OrderByAnalyzer(data);
            orderByAnalyzer.analyze();
        } else if (data.validateLexeme("LIMIT")) {
            data.next();
            LimitAnalyzer limitAnalyzer = new LimitAnalyzer(data);
            limitAnalyzer.analyze();
        } else{
            EndSelectAnalyzer endSelectAnalyzer = new EndSelectAnalyzer(data);
            endSelectAnalyzer.analyze();
        }
    }
}
