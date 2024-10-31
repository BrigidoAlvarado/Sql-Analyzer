package org.lenguajesFP.backend.analyzers;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.DDL.modifiers.drops.DropAnalyze;
import org.lenguajesFP.backend.analyzers.DDL.modifiers.alters.AltersAnalyzer;
import org.lenguajesFP.backend.analyzers.DDL.creates.CreateAnalyzer;
import org.lenguajesFP.backend.analyzers.deletes.DeleteAnalyzer;
import org.lenguajesFP.backend.analyzers.DML.inserts.InsertAnalyzer;
import org.lenguajesFP.backend.analyzers.DML.selects.SelectAnalyzer;
import org.lenguajesFP.backend.analyzers.updates.UpdateAnalyzer;

import org.lenguajesFP.backend.enums.Kind;
import org.lenguajesFP.backend.exceptions.SyntaxException;

public class StateAnalyzer {

    private final AltersAnalyzer altersAnalyzer;
    private final CreateAnalyzer createAnalyzer;
    private final DeleteAnalyzer deleteAnalyzer;
    private final InsertAnalyzer insertAnalyzer;
    private final SelectAnalyzer selectAnalyzer;
    private final UpdateAnalyzer updateAnalyzer;
    private final DropAnalyze dropAnalyzer;
    private final Data data;
    public StateAnalyzer(Data data) {
        this.data = data;
        this.altersAnalyzer = new AltersAnalyzer(data);
        this.createAnalyzer = new CreateAnalyzer(data);
        this.deleteAnalyzer = new DeleteAnalyzer(data);
        this.insertAnalyzer = new InsertAnalyzer(data);
        this.selectAnalyzer = new SelectAnalyzer(data);
        this.updateAnalyzer = new UpdateAnalyzer(data);
        this.dropAnalyzer = new DropAnalyze(data);
    }

    public void analyze() throws SyntaxException{
        validateStates();
    }

    private void validateStates() throws SyntaxException{
        if (data.validateLexeme(AltersAnalyzer.KEYWORD)) {
            data.setModifiedTableKey();
            data.next();
            altersAnalyzer.analyze();
            data.next();
            validateStates();
        } else if (data.validateLexeme(CreateAnalyzer.KEYWORD)) {
            data.next();
            createAnalyzer.analyze();
            data.next();
            validateStates();
        } else if (data.validateLexeme(DeleteAnalyzer.KEYWORD)) {
            data.next();
            deleteAnalyzer.analyze();
            data.next();
            validateStates();
        } else if (data.validateLexeme(InsertAnalyzer.KEYWORD)) {
            data.next();
            insertAnalyzer.analyze();
            data.next();
            validateStates();
        } else if (data.validateLexeme(SelectAnalyzer.KEYWORD)) {
            data.next();
            selectAnalyzer.analyze();
            data.next();
            validateStates();
        } else if (data.validateLexeme(UpdateAnalyzer.KEYWORD)) {
            data.next();
            updateAnalyzer.analyze();
            data.next();
            validateStates();
        } else if (data.validateLexeme(DropAnalyze.KEYWORD)) {
            data.setModifiedTableKey();
            data.next();
            dropAnalyzer.analyze();
            data.next();
            validateStates();
        } else {
            errorState();
        }
    }

    private void errorState() throws SyntaxException{
        validateFinal();
        data.addSyntaxError("Secuencia de token invalida !!");
        data.next();
        validateStates();
    }

    private void validateFinal() throws SyntaxException{
        if (data.currentToken().getName() == Kind.ERROR) {
            System.out.println("La lectura sintactica ha finalizado");
            throw new SyntaxException("La lectura ha finalizado");
        }
    }
}
