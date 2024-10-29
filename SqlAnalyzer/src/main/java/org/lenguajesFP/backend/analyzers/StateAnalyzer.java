package org.lenguajesFP.backend.analyzers;

import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.analyzers.DDL.modifiers.drops.DropAnalyze;
import org.lenguajesFP.backend.analyzers.adds.AddAnalyzer;
import org.lenguajesFP.backend.analyzers.DDL.modifiers.alters.AltersAnalyzer;
import org.lenguajesFP.backend.analyzers.DDL.creates.CreateAnalyzer;
import org.lenguajesFP.backend.analyzers.deletes.DeleteAnalyzer;
import org.lenguajesFP.backend.analyzers.DML.inserts.InsertAnalyzer;
import org.lenguajesFP.backend.analyzers.DML.selects.SelectAnalyzer;
import org.lenguajesFP.backend.analyzers.updates.UpdateAnalyzer;
import org.lenguajesFP.backend.tables.ModifiedTable;
import org.lenguajesFP.backend.tables.Table;

import java.util.List;

public class StateAnalyzer extends SyntaxAnalyzer {
    private final AddAnalyzer addAnalyzer;
    private final AltersAnalyzer altersAnalyzer;
    private final CreateAnalyzer createAnalyzer;
    private final DeleteAnalyzer deleteAnalyzer;
    private final InsertAnalyzer insertAnalyzer;
    private final SelectAnalyzer selectAnalyzer;
    private final UpdateAnalyzer updateAnalyzer;
    private final DropAnalyze dropAnalyzer;

    public StateAnalyzer(Data data) {
        super(data);
        this.addAnalyzer = new AddAnalyzer(data);
        this.altersAnalyzer = new AltersAnalyzer(data);
        this.createAnalyzer = new CreateAnalyzer(data);
        this.deleteAnalyzer = new DeleteAnalyzer(data);
        this.insertAnalyzer = new InsertAnalyzer(data);
        this.selectAnalyzer = new SelectAnalyzer(data);
        this.updateAnalyzer = new UpdateAnalyzer(data);
        this.dropAnalyzer = new DropAnalyze(data);
    }

    @Override
    public void analyze() {
        try {
            validateStates();
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("El proceso ha finalizado");
            System.out.println("tablas encontradas");
            List<Table> tables = data.getTables();
            for (Table table : tables) {
                System.out.println(table);
            }
            List<ModifiedTable> modifiedTables = data.getModifiedTables();
            for (ModifiedTable modifiedTable : modifiedTables) {
                System.out.println(modifiedTable);
            }
            e.printStackTrace();
        }
    }

    private void validateStates() throws ArrayIndexOutOfBoundsException{
        if (data.validateLexeme(AddAnalyzer.KEYWORD)){
            data.next();
            addAnalyzer.analyze();
            data.next();
            validateStates();
        } else if (data.validateLexeme(AltersAnalyzer.KEYWORD)){
            data.setModifiedTableKey();
            data.next();
            altersAnalyzer.analyze();
            data.next();
            validateStates();
        } else if (data.validateLexeme(CreateAnalyzer.KEYWORD)){
            data.next();
            createAnalyzer.analyze();
            data.next();
            validateStates();
        } else if (data.validateLexeme(DeleteAnalyzer.KEYWORD)){
            data.next();
            deleteAnalyzer.analyze();
            data.next();
            validateStates();
        } else if (data.validateLexeme(InsertAnalyzer.KEYWORD)){
            data.next();
            insertAnalyzer.analyze();
            data.next();
            validateStates();
        } else if (data.validateLexeme(SelectAnalyzer.KEYWORD)){
            data.next();
            selectAnalyzer.analyze();
            data.next();
            validateStates();
        } else if (data.validateLexeme(UpdateAnalyzer.KEYWORD)){
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

    private void errorState(){
        errorStatus("Secuencia de token invalida !!");
        data.next();
        validateStates();
    }
}
