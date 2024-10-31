package org.lenguajesFP.frontend;

import org.lenguajesFP.backend.Token;
import org.lenguajesFP.backend.tables.Column;
import org.lenguajesFP.backend.tables.Table;

public class GraphvizTableGenerator {

    public  String generateDot(Table table) {

        StringBuilder dot = new StringBuilder();

        // Inicio del archivo DOT
        dot.append("digraph G {\n");
        dot.append("node [shape=record, fontname=\"Helvetica\"];\n");

        // Inicio de la definición del nodo con el nombre de la tabla
        dot.append(table.getName().getLexeme()).append(" [label=\"{").append(table.getName().getLexeme()).append("|");

        // Agregar cada columna con sus partes
        for (Column column : table.getColumns()) {
            int cont = 0;
            for (Token element : column.getParts()) {
                if (cont == 0) {
                    dot.append(element.getLexeme()).append(" : "); // Título de la columna
                    cont++;
                } else {
                    dot.append(element.getLexeme()).append(" "); // Valores de la columna
                }
            }
            dot.append("\\l|"); // Separador entre columnas y salto de línea para Graphviz
        }

        // Eliminar el último separador "|"
        dot.setLength(dot.length() - 1);

        // Cierre de la definición de la tabla
        dot.append("}\"];\n");

        // Cierre del archivo DOT
        dot.append("}\n");

        return dot.toString();
    }
}
