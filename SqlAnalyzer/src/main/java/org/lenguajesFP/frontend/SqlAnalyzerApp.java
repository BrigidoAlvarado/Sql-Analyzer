/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/Application.java to edit this template
 */
package org.lenguajesFP.frontend;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextPane;
import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.ErrorToken;
import org.lenguajesFP.backend.SyntaxError;
import org.lenguajesFP.backend.Token;
import org.lenguajesFP.backend.analyzers.StateAnalyzer;
import org.lenguajesFP.backend.exceptions.SyntaxException;
import org.lenguajesFP.backend.jflex.LexycalAnalyzer;
import org.lenguajesFP.backend.tables.Table;

/**
 *
 * @author brigidoalvarado
 */
public class SqlAnalyzerApp extends javax.swing.JFrame {

    private final SyntaxHighlighter syntaxHighlighther;

    /**
     * Creates new form SqlAnalyzerApp
     */
    private Data data;

    public SqlAnalyzerApp() {
        initComponents();
        syntaxHighlighther = new SyntaxHighlighter(inputjTxtPn);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        containerjPnl = new javax.swing.JPanel();
        containerButtonsjPnl = new javax.swing.JPanel();
        analyzejBttn = new javax.swing.JButton();
        cleanjButton = new javax.swing.JButton();
        rowjLabel = new javax.swing.JLabel();
        columnJLabel = new javax.swing.JLabel();
        principaljScrllPn = new javax.swing.JScrollPane();
        inputjTxtPn = new javax.swing.JTextPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        ReportMenu = new javax.swing.JMenu();
        TablesFoundMenuItem = new javax.swing.JMenuItem();
        ModifiedTablesFounMenuItem = new javax.swing.JMenuItem();
        OpertationsNumberMenuItem = new javax.swing.JMenuItem();
        ErrorsTokenMenuItem = new javax.swing.JMenuItem();
        SyntaxErrorReportsMenuItem = new javax.swing.JMenuItem();
        graphicMenu = new javax.swing.JMenu();
        tablesGraphicMenuItem = new javax.swing.JMenuItem();
        modifiedTablesGraphicMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        containerjPnl.setBackground(java.awt.SystemColor.controlHighlight);

        analyzejBttn.setText("Analizar");
        analyzejBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analyzejBttnActionPerformed(evt);
            }
        });

        cleanjButton.setText("Limpiar");
        cleanjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cleanjButtonActionPerformed(evt);
            }
        });

        rowjLabel.setText("fila: 0");

        columnJLabel.setText("columna: 0");

        javax.swing.GroupLayout containerButtonsjPnlLayout = new javax.swing.GroupLayout(containerButtonsjPnl);
        containerButtonsjPnl.setLayout(containerButtonsjPnlLayout);
        containerButtonsjPnlLayout.setHorizontalGroup(
            containerButtonsjPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerButtonsjPnlLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(analyzejBttn)
                .addGap(18, 18, 18)
                .addComponent(cleanjButton)
                .addGap(18, 18, 18)
                .addComponent(rowjLabel)
                .addGap(18, 18, 18)
                .addComponent(columnJLabel)
                .addContainerGap(340, Short.MAX_VALUE))
        );
        containerButtonsjPnlLayout.setVerticalGroup(
            containerButtonsjPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerButtonsjPnlLayout.createSequentialGroup()
                .addGroup(containerButtonsjPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(analyzejBttn)
                    .addComponent(cleanjButton)
                    .addComponent(rowjLabel)
                    .addComponent(columnJLabel))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        inputjTxtPn.setBackground(new java.awt.Color(254, 254, 254));
        principaljScrllPn.setViewportView(inputjTxtPn);

        javax.swing.GroupLayout containerjPnlLayout = new javax.swing.GroupLayout(containerjPnl);
        containerjPnl.setLayout(containerjPnlLayout);
        containerjPnlLayout.setHorizontalGroup(
            containerjPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerjPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(containerjPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(containerButtonsjPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(principaljScrllPn, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        containerjPnlLayout.setVerticalGroup(
            containerjPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerjPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(containerButtonsjPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(principaljScrllPn, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(containerjPnl, java.awt.BorderLayout.CENTER);

        fileMenu.setMnemonic('f');
        fileMenu.setText("Archivo");

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Abrir");
        fileMenu.add(openMenuItem);

        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Guardar");
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Guardar como..");
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Salir");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        ReportMenu.setMnemonic('e');
        ReportMenu.setText("Reportes");

        TablesFoundMenuItem.setMnemonic('d');
        TablesFoundMenuItem.setText("Tablas Encontradas");
        TablesFoundMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TablesFoundMenuItemActionPerformed(evt);
            }
        });
        ReportMenu.add(TablesFoundMenuItem);

        ModifiedTablesFounMenuItem.setText("Tablas Modificadas");
        ReportMenu.add(ModifiedTablesFounMenuItem);

        OpertationsNumberMenuItem.setText("Numero de Operaciones");
        ReportMenu.add(OpertationsNumberMenuItem);

        ErrorsTokenMenuItem.setMnemonic('y');
        ErrorsTokenMenuItem.setText("Errores Lexicos");
        ErrorsTokenMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ErrorsTokenMenuItemActionPerformed(evt);
            }
        });
        ReportMenu.add(ErrorsTokenMenuItem);

        SyntaxErrorReportsMenuItem.setMnemonic('p');
        SyntaxErrorReportsMenuItem.setText("Errores Sintacticos");
        ReportMenu.add(SyntaxErrorReportsMenuItem);

        menuBar.add(ReportMenu);

        graphicMenu.setMnemonic('h');
        graphicMenu.setText("Grafico");

        tablesGraphicMenuItem.setMnemonic('c');
        tablesGraphicMenuItem.setText("Tablas");
        graphicMenu.add(tablesGraphicMenuItem);

        modifiedTablesGraphicMenuItem.setMnemonic('a');
        modifiedTablesGraphicMenuItem.setText("Tablas Modificadas");
        graphicMenu.add(modifiedTablesGraphicMenuItem);

        menuBar.add(graphicMenu);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void analyzejBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analyzejBttnActionPerformed
        // TODO add your handling code here:
        analizar();
    }//GEN-LAST:event_analyzejBttnActionPerformed

    private void cleanjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cleanjButtonActionPerformed
        // TODO add your handling code here:
        inputjTxtPn.setText("");
    }//GEN-LAST:event_cleanjButtonActionPerformed

    private void ErrorsTokenMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ErrorsTokenMenuItemActionPerformed
        // TODO add your handling code here:
        List<String> columns = List.of("Token", "Linea", "Columna", "Descripcion");
        List<List<Object>> rows = new ArrayList<>();
        for (ErrorToken error : data.getErrorsTokens()) {
            List<Object> row = new ArrayList<>();
            row.add(error.getLexeme());
            row.add(error.getRow());
            row.add(error.getColumn());
            row.add(error.getDescription());
            rows.add(row);
        }
        DynamicTableFrame dynamicTableFrame = new DynamicTableFrame(rows, columns);
        dynamicTableFrame.setVisible(true);
    }//GEN-LAST:event_ErrorsTokenMenuItemActionPerformed

    private void TablesFoundMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TablesFoundMenuItemActionPerformed
        // TODO add your handling code here:
        int cont = 0;
        List<String> columns = List.of("Numero", "Tabla", "Fila", "Columna");
        List<List<Object>> rows = new ArrayList<>();
        for (Table table : data.getTables()) {
            cont++;
            List<Object> row = new ArrayList<>();
            row.add(cont);
            row.add(table.getName().getLexeme());
            row.add(table.getKey().getRow());
            row.add(table.getKey().getColumn());
            rows.add(row);
        }
        DynamicTableFrame dynamicTableFrame = new DynamicTableFrame(rows, columns);
        dynamicTableFrame.setVisible(true);
    }//GEN-LAST:event_TablesFoundMenuItemActionPerformed

    private void analizar() {
        System.out.println("analizando");
        LexycalAnalyzer analyzer = new LexycalAnalyzer(new StringReader(inputjTxtPn.getText()));
        try {
            while (analyzer.yylex() != LexycalAnalyzer.YYEOF) {
            }
            List<Token> lista = analyzer.getTokensList();
            //pintar el text pain
            syntaxHighlighther.highlightTokens(lista);
            // se realiza el analisis sintactico
            sintactic(lista);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sintactic(List<Token> lista) {
        try {
            data = new Data(lista);
            StateAnalyzer stateAnalyzer = new StateAnalyzer(data);
            stateAnalyzer.analyze();
        } catch (SyntaxException e) {
            System.out.println("Analisis Finalizado");
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ErrorsTokenMenuItem;
    private javax.swing.JMenuItem ModifiedTablesFounMenuItem;
    private javax.swing.JMenuItem OpertationsNumberMenuItem;
    private javax.swing.JMenu ReportMenu;
    private javax.swing.JMenuItem SyntaxErrorReportsMenuItem;
    private javax.swing.JMenuItem TablesFoundMenuItem;
    private javax.swing.JButton analyzejBttn;
    private javax.swing.JButton cleanjButton;
    private javax.swing.JLabel columnJLabel;
    private javax.swing.JPanel containerButtonsjPnl;
    private javax.swing.JPanel containerjPnl;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu graphicMenu;
    private javax.swing.JTextPane inputjTxtPn;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem modifiedTablesGraphicMenuItem;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JScrollPane principaljScrllPn;
    private javax.swing.JLabel rowjLabel;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JMenuItem tablesGraphicMenuItem;
    // End of variables declaration//GEN-END:variables

}
