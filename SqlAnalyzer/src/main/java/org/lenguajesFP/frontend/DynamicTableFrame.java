/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.lenguajesFP.frontend;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class DynamicTableFrame extends JFrame {
    private final JTable table;

    public DynamicTableFrame(List<List<Object>> rows, List<String> columns, String title) {
        setTitle(title);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(true); // Permitir redimensionar la ventana

        // Convertir los nombres de las columnas a un array de Object
        Object[] columnNames = columns.toArray();

        // Crear el modelo de la tabla
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        
        // Agregar las filas al modelo
        for (List<Object> rowData : rows) {
            tableModel.addRow(rowData.toArray());
        }

        // Crear la tabla con el modelo
        table = new JTable(tableModel);
        
        // Ajustar las columnas al contenido
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        // Agregar la tabla a un JScrollPane para el desplazamiento
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Ajustar el tamaño de la ventana al contenido
        pack();
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
    }
}

