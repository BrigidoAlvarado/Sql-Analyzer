/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package org.lenguajesFP.frontend;

import org.lenguajesFP.backend.Data;

/**
 *
 * @author brigidoalvarado
 */
public class OperationCounters extends javax.swing.JDialog {

    /**
     * Creates new form OperationCounters
     * @param parent
     * @param modal
     * @param data
     */
    public OperationCounters(java.awt.Frame parent, boolean modal, Data data) {
        super(parent, modal);
        initComponents();
        creates.setText("CREATE: "+data.getCreates());
        deletes.setText("DELETE: "+data.getDeletes());
        updates.setText("UPDATE: "+data.getUpdates());
        inserts.setText("INSERT: "+data.getUpdates());
        selects.setText("SELECT: "+data.getSelects());
        alters.setText("ALTER: "+data.getAlters());
        drops.setText("DROP: "+data.getDrops());
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        creates = new javax.swing.JLabel();
        deletes = new javax.swing.JLabel();
        updates = new javax.swing.JLabel();
        inserts = new javax.swing.JLabel();
        selects = new javax.swing.JLabel();
        alters = new javax.swing.JLabel();
        drops = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));
        jPanel1.setLayout(new java.awt.GridLayout(7, 1, 20, 20));

        creates.setForeground(new java.awt.Color(1, 1, 1));
        creates.setText("jaaaaaaaaLabel1");
        jPanel1.add(creates);

        deletes.setForeground(new java.awt.Color(1, 1, 1));
        deletes.setText("jLabel1");
        jPanel1.add(deletes);

        updates.setForeground(new java.awt.Color(1, 1, 1));
        updates.setText("jLabel1");
        jPanel1.add(updates);

        inserts.setForeground(new java.awt.Color(1, 1, 1));
        inserts.setText("jLabel1");
        jPanel1.add(inserts);

        selects.setForeground(new java.awt.Color(1, 1, 1));
        selects.setText("jLabel1");
        jPanel1.add(selects);

        alters.setForeground(new java.awt.Color(1, 1, 1));
        alters.setText("jLabel1");
        jPanel1.add(alters);

        drops.setForeground(new java.awt.Color(1, 1, 1));
        drops.setText("jLabel1");
        jPanel1.add(drops);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alters;
    private javax.swing.JLabel creates;
    private javax.swing.JLabel deletes;
    private javax.swing.JLabel drops;
    private javax.swing.JLabel inserts;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel selects;
    private javax.swing.JLabel updates;
    // End of variables declaration//GEN-END:variables
}
