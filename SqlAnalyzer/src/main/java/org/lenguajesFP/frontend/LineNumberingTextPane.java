/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.lenguajesFP.frontend;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import java.awt.*;

/**
 *
 * @author brigidoalvarado
 */
public class LineNumberingTextPane extends JPanel {

    private final JTextPane textPane;
    private final JTextArea lineNumbers;

    public LineNumberingTextPane() {
        setLayout(new BorderLayout());

        // Panel de texto
        textPane = new JTextPane();
        textPane.setFont(new Font("Monospaced", Font.PLAIN, 12));

        // Área de numeración de líneas
        lineNumbers = new JTextArea("1");
        lineNumbers.setFont(new Font("Monospaced", Font.PLAIN, 12));
        lineNumbers.setEditable(false);
        lineNumbers.setBackground(Color.LIGHT_GRAY);
        lineNumbers.setForeground(Color.BLACK);

        // Ajustar el JTextPane y el área de numeración en un JScrollPane
        JScrollPane scrollPane = new JScrollPane(textPane);
        scrollPane.setRowHeaderView(lineNumbers);

        add(scrollPane, BorderLayout.CENTER);

        // Agregar un CaretListener para actualizar los números de línea
        textPane.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                updateLineNumbers();
            }
        });

        // Agregar un DocumentListener para cambios en el documento
        textPane.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateLineNumbers();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateLineNumbers();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateLineNumbers();
            }
        });
    }

    // Método para actualizar los números de línea
    private void updateLineNumbers() {
        int caretPosition = textPane.getDocument().getLength();
        Element root = textPane.getDocument().getDefaultRootElement();
        StringBuilder lineNumberText = new StringBuilder("1\n");

        // Generar números de línea según la cantidad de líneas en el texto
        for (int i = 2; i <= root.getElementIndex(caretPosition) + 1; i++) {
            lineNumberText.append(i).append("\n");
        }

        lineNumbers.setText(lineNumberText.toString());
    }

    public JTextPane getTextPane() {
        return textPane;
    }
}