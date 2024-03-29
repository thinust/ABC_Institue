/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import java.awt.Font;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import model.MySQL;

/**
 *
 * @author Thinuka
 */
public class Stock extends javax.swing.JFrame {

    Invoice inv;

    /**
     * Creates new form Stock
     */
    public Stock() {
        initComponents();
        JTableHeader tableHeader = jTable1.getTableHeader();
        Font headerFont = new Font("Century Gothic", Font.PLAIN, 18);
        tableHeader.setFont(headerFont);
        jTable1.setRowHeight(30);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        loadStocks();
    }

    public Stock(Invoice inv) {
        initComponents();
        JTableHeader tableHeader = jTable1.getTableHeader();
        Font headerFont = new Font("Century Gothic", Font.PLAIN, 18);
        tableHeader.setFont(headerFont);
        jTable1.setRowHeight(30);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        loadStocks();
        this.inv = inv;
    }

    public void loadStocks() {

        try {
            ResultSet rs = MySQL.search("SELECT DISTINCT stock.id,category.name,product.name,product.no,stock.quantity,grn_item.buing_price,stock.selling_price FROM stock JOIN product ON stock.product_id=product.id JOIN grn_item ON grn_item.stock_id=stock.id JOIN category ON product.category_id=category.id ORDER BY stock.id;");

            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {

                Vector v = new Vector();
                v.add(rs.getString("stock.id"));
                v.add(rs.getString("category.name"));
                v.add(rs.getString("product.name"));
                v.add(rs.getString("product.no"));
                v.add(rs.getString("stock.quantity"));
                v.add(rs.getString("grn_item.buing_price"));
                v.add(rs.getString("stock.selling_price"));
                dtm.addRow(v);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadStocks(String text) {

        try {
            ResultSet rs = MySQL.search("SELECT DISTINCT stock.id,category.name,product.name,product.no,stock.quantity,grn_item.buing_price,stock.selling_price FROM stock JOIN product ON stock.product_id=product.id JOIN grn_item ON grn_item.stock_id=stock.id JOIN category ON product.category_id=category.id WHERE product.no LIKE '" + text + "%' OR product.name LIKE '" + text + "%' ORDER BY stock.id;");

            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {

                Vector v = new Vector();
                v.add(rs.getString("stock.id"));
                v.add(rs.getString("category.name"));
                v.add(rs.getString("product.name"));
                v.add(rs.getString("product.no"));
                v.add(rs.getString("stock.quantity"));
                v.add(rs.getString("grn_item.buing_price"));
                v.add(rs.getString("stock.selling_price"));
                dtm.addRow(v);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Stock");

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel1.setText("Search");

        jTextField1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stock Id", "Category", "Book Name", "Book No", "Qty", "Buying Price", "Selling Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)
                        .addGap(44, 44, 44)
                        .addComponent(jTextField1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1451, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public int a1 = 0;

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:

        int i = jTable1.getSelectedRow();

        String stock_id = jTable1.getValueAt(i, 0).toString();
        String category = jTable1.getValueAt(i, 1).toString();
        String bname = jTable1.getValueAt(i, 2).toString();
        String bNo = jTable1.getValueAt(i, 3).toString();
        String qty = jTable1.getValueAt(i, 4).toString();
        String bPrice = jTable1.getValueAt(i, 5).toString();
        String sPrice = jTable1.getValueAt(i, 6).toString();

        if (evt.getClickCount() == 2) {

            if (i == -1) {

            } else {

                try {

                    if (a1 == 1) {

                        inv.jLabel3.setText(bNo);
                        inv.jLabel5.setText(bname);
                        inv.jLabel10.setText(category);
                        inv.jLabel11.setText(sPrice);
                        inv.jLabel12.setText(stock_id);
                        this.dispose();

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:

        String text = jTextField1.getText();
        loadStocks(text);

        if (text.equals("")) {
            loadStocks();
        } 
    }//GEN-LAST:event_jTextField1KeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Stock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
