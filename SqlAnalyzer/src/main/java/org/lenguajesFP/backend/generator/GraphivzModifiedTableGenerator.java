/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.lenguajesFP.backend.generator;

import org.lenguajesFP.backend.tables.ModifiedTable;

/**
 *
 * @author brigidoalvarado
 */
public class GraphivzModifiedTableGenerator {

    public String generateDot(ModifiedTable modifiedTable) {

        StringBuilder dot = new StringBuilder();

        // Inicio del archivo DOT
        dot.append("digraph G {\n");
        dot.append("node [shape=record, fontname=\"Helvetica\"];\n");

        // Inicio de la definición del nodo con el nombre de la tabla
        dot.append(modifiedTable.getName().getLexeme()).append(" [label=\"{").append(modifiedTable.getName().getLexeme()).append("|");

        // Agregar cada columna con sus partes
        dot.append("Tipo Modificacion: ").append(modifiedTable.getKey().getLexeme());
        if (!modifiedTable.getKey().getLexeme().equalsIgnoreCase("DROP")) {
            dot.append(" - ").append(modifiedTable.getKind().getLexeme());
        }
        dot.append("\\l|");
        dot.append("Columna Modificada: ").append(modifiedTable.getColumn().getLexeme()).append("\\l|");
        // Eliminar el último separador "|"
        dot.setLength(dot.length() - 1);

        // Cierre de la definición de la tabla
        dot.append("}\"];\n");

        // Cierre del archivo DOT
        dot.append("}\n");

        return dot.toString();
    }
}
