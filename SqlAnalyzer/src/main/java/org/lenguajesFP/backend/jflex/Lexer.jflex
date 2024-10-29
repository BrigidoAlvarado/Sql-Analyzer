package org.lenguajesFP.backend.jflex;

//Seccion de imports
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

import org.lenguajesFP.backend.Token;
import org.lenguajesFP.backend.ErrorToken;
import org.lenguajesFP.backend.enums.Kind;

%%
%{

// Codigo Java

    private List<Token> tokensList = new ArrayList<>();

    public void addTokenList(Token token) {
        tokensList.add(token);
    }

    public List<Token> getTokensList(){
        return tokensList;
    }

%}

// Configuracion
%public
%class LexycalAnalyzer
%unicode
%line
%column
%standalone

// Expresiones Regulares
CREATE = ("CREATE"|"DATABASE"|"TABLE"|"KEY"|"NULL"|"PRIMARY"|"UNIQUE"|"FOREIGN"|"REFERENCES"|"ALTER"|"ADD"|"COLUMN"|"TYPE"|"DROP"|"CONSTRAINT"|"IF"|"EXISTS"|"CASCADE"|"ON"|"DELETE"|"SET"|"UPDATE"|"INSERT"|"INTO"|"VALUES"|"SELECT"|"FROM"|"WHERE"|"AS"|"GROUP"|"ORDER"|"BY"|"ASC"|"DESC"|"LIMIT"|"JOIN")
TIPO_DE_DATO = ("INTEGER"|"BIGINT"|"VARCHAR"|"DECIMAL"|"DATE"|"TEXT"|"BOOLEAN"|"SERIAL"|"NUMERIC")
BOOLEANO = ("TRUE"|"FALSE")
FUN_AGREG = ("SUM"|"AVG"|"COUNT"|"MAX"|"MIN")
LOGICOS = ("AND"|"OR"|"NOT")
SIGNOS = ("("|")"|","|";"|"."|"=")
ARITMETICOS = ("+"|"-"|"*"|"/")
RELACIONALES = ("<"|">"|"<="|">=")
ENTERO = [0-9]+
DECIMAL = [0-9]+"."[0-9]+
FECHA = "'"[0-9]{4}"-"[0-9]{2}"-"[0-9]{2}"'"
ESPACIOS = [" "\r\t\b\n]
CADENA = \'[^\']*\'
IDENTIFICADOR = [a-z][a-z0-9_]*
COMENTARIO = "- -"[^\n]*\n

%%
// Reglas de Escaneo de Expresiones
{CREATE}                          { addTokenList( new Token( yytext(), Kind.CREATE, new Color(255, 165, 0) ,yyline,yycolumn));}
{TIPO_DE_DATO}                    { addTokenList( new Token( yytext(), Kind.TIPO_DE_DATO, new Color(128, 0, 128) , yyline, yycolumn));}
{BOOLEANO}                        { addTokenList( new Token( yytext(), Kind.Booleano, Color.BLUE, yyline, yycolumn));}
{FUN_AGREG}                       { addTokenList( new Token( yytext(), Kind.Funciones_de_agregacion, Color.BLUE, yyline, yycolumn));}
{LOGICOS}                         { addTokenList( new Token( yytext(), Kind.Logicos, new Color(255, 165, 0) , yyline, yycolumn));}
{ENTERO}                          { addTokenList( new Token( yytext(), Kind.Entero, Color.BLUE , yyline, yycolumn));}
{DECIMAL}                         { addTokenList( new Token( yytext(), Kind.Decimal, Color.BLUE , yyline, yycolumn));}
{FECHA}                           { addTokenList( new Token( yytext(), Kind.Fecha, Color.YELLOW, yyline, yycolumn));}
{CADENA}                          { addTokenList( new Token( yytext(), Kind.Cadena, Color.GREEN, yyline, yycolumn));}
{IDENTIFICADOR}                   { addTokenList( new Token( yytext(), Kind.Identificador, new Color(255, 0, 255), yyline, yycolumn));}
{RELACIONALES}                    { addTokenList( new Token( yytext(), Kind.Relacionales, Color.BLACK, yyline, yycolumn));}
{SIGNOS}                          { addTokenList( new Token( yytext(), Kind.Signos, Color.BLACK, yyline, yycolumn));}
{ARITMETICOS}                     { addTokenList( new Token( yytext(), Kind.Aritmeticos, Color.BLACK, yyline, yycolumn));}
{COMENTARIO}                      { addTokenList( new Token( yytext(), Kind.Comentario, Color.GRAY, yyline, yycolumn));}
{ESPACIOS}                        { addTokenList( new Token( yytext(), Kind.Espacio, Color.BLACK, yyline, yycolumn));}
//ERRORES
[a-zA-Z]+                         { addTokenList( new ErrorToken( yytext(), Color.BLACK, yyline, yycolumn, "Token invalido"));}
.                                 { addTokenList( new ErrorToken( yytext(), Color.BLACK, yyline, yycolumn, "Caracter invalido"));}