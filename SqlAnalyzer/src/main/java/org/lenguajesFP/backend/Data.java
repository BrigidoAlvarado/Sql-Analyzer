package org.lenguajesFP.backend;

import org.lenguajesFP.backend.enums.Kind;
import org.lenguajesFP.backend.tables.Column;
import org.lenguajesFP.backend.tables.ModifiedTable;
import org.lenguajesFP.backend.tables.Table;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private final List<Token> tokens = new ArrayList<>();
    private final List<ErrorToken> errorsTokens = new ArrayList<>();
    private final List<SyntaxError> syntaxErrors = new ArrayList<>();
    private final List<Table> tables = new ArrayList<>();
    private final List<ModifiedTable> modifiedTables = new ArrayList<>();

    private Table table;
    private ModifiedTable modifiedTable;
    private Column column;
    private int creates = 0;
    private int deletes = 0;
    private int updates = 0;
    private int inserts = 0;
    private int selects = 0;
    private int alters = 0;
    private int drops = 0;
    private int index = 0;

    public Data(List<Token> tokens) {
        for (Token token : tokens) {
            if (token instanceof ErrorToken){
                errorsTokens.add((ErrorToken) token);
            } else if (token.getName() != Kind.Comentario) {
                this.tokens.add(token);
            }
        }
        System.out.println("tokens encontrados");
        for (Token token : tokens) {
            System.out.print(token.getLexeme());
        }
    }

    public boolean identifierIdentifier(){
        if (validateName(Kind.Identificador)){
            next();
            if (validateLexeme(".")){
                next();
                if (validateName(Kind.Identificador)){
                    return true;
                } else  {
                    addSyntaxError("Se esperaba un token Identificador");
                }
            } else {
                addSyntaxError("Se esperaba un token .");
            }
        } else {
            addSyntaxError("Se esperaba un token Identificador");
        }
        return false;
    }

    //////////////////////
    /*Lectura de datos*/
    public boolean isData(){
        Kind kind = currentToken().getName();
        return (kind == Kind.Entero ||
                kind == Kind.Decimal ||
                kind == Kind.Fecha ||
                kind == Kind.Cadena ||
                kind == Kind.Booleano);
    }

    public boolean isOperator(){
        Kind kind = currentToken().getName();
        return (kind == Kind.Aritmeticos ||
                kind == Kind.Relacionales ||
                kind == Kind.Logicos);
    }

    /////////////////////////////////////
    /* Modificadores de Tabla*/
    public void setTableKey(){
        table = new Table();
        table.setKey(tokens.get(index - 1));
    }

    public void setTableName(){
        table.setName(currentToken());
    }

    public void saveTable(){
        tables.add(table);
        table = new Table();
    }

    /*Modificadores de Column*/
    public void newColumnAndPart(){
        column = new Column();
        column.addPart(currentToken());
    }

    public void saveColumn(){
        table.addColumn(column);
        column = new Column();
    }

    public void addPartColumn(){
        column.addPart(currentToken());
    }

    /* Modificadores de Tabla Modificada */
    public void setModifiedTableKey(){
        modifiedTable = new ModifiedTable();
        modifiedTable.setKey(currentToken());
    }

    public void saveModifiedTable(){
        modifiedTables.add(modifiedTable);
        modifiedTable = new ModifiedTable();
    }

    public void setModifiedTableName(){
        modifiedTable.setName(currentToken());
    }

    public void setModifiedTableColumn(){
        modifiedTable.setColumn(currentToken());
    }

    //validar si el token es el esperado
    public boolean validateLexeme(String lexeme){
        return lexeme.equalsIgnoreCase(currentToken().getLexeme());
    }

    //valida si un tipo de token esta entre paretesis
    public boolean validateName(Kind name){
        return currentToken().getName() == name;
    }

    //valida si un tipo de lexema esta entre parentesis
    public boolean betweenParenthesis(Kind kind){
        if (validateLexeme("(")){
            next();
            if (validateName(kind)){
                next();
                if (validateLexeme(")")){
                    return true;
                } else {
                    addSyntaxError("Se esperaba un token )");
                    return false;
                }
            } else {
                addSyntaxError("Se esperaba un token "+kind);
                return false;
            }
        } else{
            addSyntaxError("Se esperaba un token (");
            return false;
        }
    }

    //avanzar en la lectura del arreglo
    public void next(){
        System.out.println("avanzando desde: " + currentToken().getLexeme());
        do {
            index++;
        } while (currentToken().getName() == Kind.Espacio || currentToken().getName() == Kind.Comentario);
    }

    public void back(){
        System.out.println("retrocediendo desde: " + currentToken().getLexeme());
        do {
            index--;
        } while (currentToken().getName() == Kind.Espacio || currentToken().getName() == Kind.Comentario);
    }

    //aniadir el token actual a los errores
    public void addSyntaxError(String description){
        System.out.println("se encontro un error "+description);
        syntaxErrors.add(new SyntaxError(currentToken(), description));
    }

    //obtener el token actual
    public Token currentToken(){
        return tokens.get(index);
    }

    //AUMENTAR CONTADORES
    public void increaseCreates(){
        creates++;
        System.out.println("se encontro una produccion de CREATE");
    }

    public void increaseAlters(){
        System.out.println("Se encontro una produccion de ALTER");
        alters++;
    }

    public void increaseDrops(){
        System.out.println("se encontro una produccion de DROP");
        drops++;
    }

    public void increaseSelects(){
        selects++;
        System.out.println("Se encontro una produccion de SELECT");
    }

    public void increaseInserts(){
        System.out.println("se encontro un produccion de INSERT");
        inserts++;
    }

    //GETTERS DE LAS VARIABLES
    public int getAlters() {
        return alters;
    }

    public int getSelects() {
        return selects;
    }

    public int getInserts() {
        return inserts;
    }

    public int getUpdates() {
        return updates;
    }

    public int getDeletes() {
        return deletes;
    }

    public int getDrops(){
        return drops;
    }

    public int getCreates() {
        return creates;
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public List<ErrorToken> getErrorsTokens() {
        return errorsTokens;
    }

    public List<ModifiedTable> getModifiedTables() {
        return modifiedTables;
    }

    public List<Table> getTables() {
        return tables;
    }

    public List<SyntaxError> getSyntaxErrors() {
        return syntaxErrors;
    }

}
