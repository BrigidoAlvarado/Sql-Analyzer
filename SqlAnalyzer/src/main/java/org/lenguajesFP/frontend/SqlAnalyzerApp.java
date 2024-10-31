/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/Application.java to edit this template
 */
package org.lenguajesFP.frontend;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.lenguajesFP.backend.Data;
import org.lenguajesFP.backend.ErrorToken;
import org.lenguajesFP.backend.FileController;
import org.lenguajesFP.backend.generator.ImageModifiedTableGenerator;
import org.lenguajesFP.backend.generator.ImageTableGeneretor;
import org.lenguajesFP.backend.SyntaxError;
import org.lenguajesFP.backend.Token;
import org.lenguajesFP.backend.analyzers.StateAnalyzer;
import org.lenguajesFP.backend.exceptions.SyntaxException;
import org.lenguajesFP.backend.jflex.LexycalAnalyzer;
import org.lenguajesFP.backend.tables.ModifiedTable;
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
    private String path;

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
        positionjLabel = new javax.swing.JLabel();
        inputjScrllPn = new javax.swing.JScrollPane();
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

        positionjLabel.setText("Linera: Columna: ");

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
                .addComponent(positionjLabel)
                .addContainerGap(436, Short.MAX_VALUE))
        );
        containerButtonsjPnlLayout.setVerticalGroup(
            containerButtonsjPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerButtonsjPnlLayout.createSequentialGroup()
                .addGroup(containerButtonsjPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(analyzejBttn)
                    .addComponent(cleanjButton)
                    .addComponent(positionjLabel))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        inputjTxtPn.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                inputjTxtPnCaretUpdate(evt);
            }
        });
        inputjScrllPn.setViewportView(inputjTxtPn);

        javax.swing.GroupLayout containerjPnlLayout = new javax.swing.GroupLayout(containerjPnl);
        containerjPnl.setLayout(containerjPnlLayout);
        containerjPnlLayout.setHorizontalGroup(
            containerjPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerjPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(containerjPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(containerButtonsjPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputjScrllPn))
                .addContainerGap())
        );
        containerjPnlLayout.setVerticalGroup(
            containerjPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerjPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(containerButtonsjPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(inputjScrllPn, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(containerjPnl, java.awt.BorderLayout.CENTER);

        fileMenu.setMnemonic('f');
        fileMenu.setText("Archivo");

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Abrir");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem);

        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Guardar");
        saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Guardar como..");
        saveAsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsMenuItemActionPerformed(evt);
            }
        });
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
        ModifiedTablesFounMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifiedTablesFounMenuItemActionPerformed(evt);
            }
        });
        ReportMenu.add(ModifiedTablesFounMenuItem);

        OpertationsNumberMenuItem.setText("Numero de Operaciones");
        OpertationsNumberMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpertationsNumberMenuItemActionPerformed(evt);
            }
        });
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
        SyntaxErrorReportsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SyntaxErrorReportsMenuItemActionPerformed(evt);
            }
        });
        ReportMenu.add(SyntaxErrorReportsMenuItem);

        menuBar.add(ReportMenu);

        graphicMenu.setMnemonic('h');
        graphicMenu.setText("Grafico");

        tablesGraphicMenuItem.setMnemonic('c');
        tablesGraphicMenuItem.setText("Tablas");
        tablesGraphicMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tablesGraphicMenuItemActionPerformed(evt);
            }
        });
        graphicMenu.add(tablesGraphicMenuItem);

        modifiedTablesGraphicMenuItem.setMnemonic('a');
        modifiedTablesGraphicMenuItem.setText("Tablas Modificadas");
        modifiedTablesGraphicMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifiedTablesGraphicMenuItemActionPerformed(evt);
            }
        });
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
        data = null;
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
        DynamicTableFrame dynamicTableFrame = new DynamicTableFrame(rows, columns, "Errores Lexicos");
        dynamicTableFrame.setVisible(true);
    }//GEN-LAST:event_ErrorsTokenMenuItemActionPerformed

    private void TablesFoundMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TablesFoundMenuItemActionPerformed
        // TODO add your handling code here:
        int cont = 0;
        List<String> columns = List.of("Numero", "Tabla", "Linea", "Columna");
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
        DynamicTableFrame dynamicTableFrame = new DynamicTableFrame(rows, columns, "Tablas Encontradas");
        dynamicTableFrame.setVisible(true);
    }//GEN-LAST:event_TablesFoundMenuItemActionPerformed

    private void ModifiedTablesFounMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifiedTablesFounMenuItemActionPerformed
        // TODO add your handling code here:
        int cont = 0;
        List<String> columns = List.of("Numero", "Modificacion", "Tabla", "Linea", "Columna");
        List<List<Object>> rows = new ArrayList<>();

        for (ModifiedTable modifiedTable : data.getModifiedTables()) {
            cont++;
            List<Object> row = new ArrayList<>();

            row.add(cont);

            String modifier = modifiedTable.getKey().getLexeme();
            if (!modifiedTable.getKey().getLexeme().equalsIgnoreCase("DROP")) {
                modifier += " - " + modifiedTable.getKind().getLexeme();
            }

            row.add(modifier);
            row.add(modifiedTable.getName().getLexeme());
            row.add(modifiedTable.getKey().getRow());
            row.add(modifiedTable.getKey().getColumn());
            rows.add(row);
        }
        DynamicTableFrame dynamicTableFrame = new DynamicTableFrame(rows, columns, "Tablas Modificadas");
        dynamicTableFrame.setVisible(true);
    }//GEN-LAST:event_ModifiedTablesFounMenuItemActionPerformed

    private void SyntaxErrorReportsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SyntaxErrorReportsMenuItemActionPerformed
        // TODO add your handling code here:
        List<String> columns = List.of("Token", "Tipo Token", "Linea", "Columna", "Descripcioin");
        List<List<Object>> rows = new ArrayList<>();
        for (SyntaxError syntaxError : data.getSyntaxErrors()) {
            List<Object> row = new ArrayList<>();
            row.add(syntaxError.getErrorToken().getLexeme());
            row.add(syntaxError.getErrorToken().getName());
            row.add(syntaxError.getErrorToken().getRow());
            row.add(syntaxError.getErrorToken().getColumn());
            row.add(syntaxError.getDescription());
            rows.add(row);
        }
        DynamicTableFrame dynamicTableFrame = new DynamicTableFrame(rows, columns, "Errores Sintacticos");
        dynamicTableFrame.setVisible(true);
    }//GEN-LAST:event_SyntaxErrorReportsMenuItemActionPerformed

    private void tablesGraphicMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tablesGraphicMenuItemActionPerformed
        // TODO add your handling code here:        
        ImageTableGeneretor fileController = new ImageTableGeneretor(data.getTables());
        fileController.generateImages();
        ImageGallery gallery = new ImageGallery(ImageTableGeneretor.TABLES_PATH, "Tablas Encontradas", 200, 300);
        gallery.setVisible(true);
    }//GEN-LAST:event_tablesGraphicMenuItemActionPerformed

    private void modifiedTablesGraphicMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifiedTablesGraphicMenuItemActionPerformed
        // TODO add your handling code here:
        ImageModifiedTableGenerator generator = new ImageModifiedTableGenerator(data.getModifiedTables());
        generator.generateImages();
        ImageGallery gallery = new ImageGallery(ImageModifiedTableGenerator.MODIFIED_TABLES_PATH, " Modificaciones", 250, 100);
        gallery.setVisible(true);
    }//GEN-LAST:event_modifiedTablesGraphicMenuItemActionPerformed

    private void OpertationsNumberMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpertationsNumberMenuItemActionPerformed
        // TODO add your handling code here:
        OperationCounters operationCounters = new OperationCounters(this, true, data);
        operationCounters.setVisible(true);
    }//GEN-LAST:event_OpertationsNumberMenuItemActionPerformed

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        // TODO add your handling code here:
        try {
            path = readFile(false);
            FileController fileController = new FileController();
            String input = fileController.open(path);
            inputjTxtPn.setText(input);
        } catch (SyntaxException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void saveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuItemActionPerformed
        // TODO add your handling code here:
        try {
            FileController fileController = new FileController();
            fileController.save(path, inputjTxtPn.getText());
            JOptionPane.showMessageDialog(this, "El archivo se guardo exitosamente", "Archivo Guardado", JOptionPane.INFORMATION_MESSAGE);
        } catch (SyntaxException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
        } catch (NullPointerException e){
            saveAs();
        }
    }//GEN-LAST:event_saveMenuItemActionPerformed

    private void saveAsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsMenuItemActionPerformed
        // TODO add your handling code here:
        saveAs();
    }//GEN-LAST:event_saveAsMenuItemActionPerformed

    private void inputjTxtPnCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_inputjTxtPnCaretUpdate
        // TODO add your handling code here:
        try {
            int caretPos = inputjTxtPn.getCaretPosition(); // Obtiene la posición del cursor
            int line = inputjTxtPn.getDocument().getDefaultRootElement().getElementIndex(caretPos); // Calcula la línea actual (fila)
            int column = caretPos - inputjTxtPn.getDocument().getDefaultRootElement().getElement(line).getStartOffset(); // Calcula la columna actual
            // Actualiza el label con la fila y columna
            positionjLabel.setText("Linea: " + (line + 1) + ", Columna: " + (column + 1));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al actualizar la línea y columna", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_inputjTxtPnCaretUpdate

    private void analizar() {
        LexycalAnalyzer analyzer = new LexycalAnalyzer(new StringReader(inputjTxtPn.getText() + "\n  "));
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
            JOptionPane.showMessageDialog(this, "Analisis Finalizado", "", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private String readFile(boolean directoriesOnly) {
        JFileChooser fileChooser = new JFileChooser();
        if (directoriesOnly) {
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        }
        int selection = fileChooser.showOpenDialog(this);
        if (selection == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile().getAbsolutePath();
        } else {
            throw new NullPointerException();
        }
    }

    private void saveAs(){
        try {
            path = readFile(true);
            FileController fileController = new FileController();
            String name = fileController.saveAs(path, inputjTxtPn.getText());
            JOptionPane.showMessageDialog(this, "El archivo se guardo como: " + name,"Archivo Guardado Exitosamente" , JOptionPane.INFORMATION_MESSAGE);
        } catch (SyntaxException e) {
            JOptionPane.showMessageDialog(this, "error", e.getMessage(), JOptionPane.ERROR_MESSAGE);
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
    private javax.swing.JPanel containerButtonsjPnl;
    private javax.swing.JPanel containerjPnl;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu graphicMenu;
    private javax.swing.JScrollPane inputjScrllPn;
    private javax.swing.JTextPane inputjTxtPn;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem modifiedTablesGraphicMenuItem;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JLabel positionjLabel;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JMenuItem tablesGraphicMenuItem;
    // End of variables declaration//GEN-END:variables

}
