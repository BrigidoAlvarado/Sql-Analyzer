/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.lenguajesFP.frontend;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.util.List;
import org.lenguajesFP.backend.Token;

public class SyntaxHighlighter {
    private JTextPane textPane;
    
    public SyntaxHighlighter(JTextPane textPane){
        this.textPane = textPane;
    }
    /*
    public SyntaxHighlighter() {
        textPane.setEditable(false); // Para evitar que el usuario edite el texto estilizado
    }*/
    //colorear
    public void highlightTokens(List<Token> tokens) {
        StyledDocument doc = textPane.getStyledDocument();
        textPane.setText(""); // Limpiar el contenido previo

        for (Token token : tokens) {
            String lexeme = token.getLexeme();
            Color color = token.getColor();
            // Crear un estilo para el color del token
            Style style = textPane.addStyle("ColorStyle", null);
            StyleConstants.setForeground(style, color);

            try {
                // Insertar el texto con el estilo adecuado
                doc.insertString(doc.getLength(), lexeme, style);
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        }
         // Restablecer el estilo predeterminado para el texto nuevo (color negro)
        Style defaultStyle = textPane.addStyle("DefaultStyle", null);
        StyleConstants.setForeground(defaultStyle, Color.BLACK);
        textPane.setCharacterAttributes(defaultStyle, true);
    }
}
 