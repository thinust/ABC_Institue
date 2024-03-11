/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package gui;

import java.awt.Font;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import model.MySQL;

/**
 *
 * @author Thinuka
 */
public class AddressRegister extends javax.swing.JDialog {

    StudentRegistration str = new StudentRegistration();
    TeacherRegister tr = new TeacherRegister();

    /**
     * Creates new form Address
     */
    public AddressRegister(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        JTableHeader tableHeader = jTable1.getTableHeader();
        Font headerFont = new Font("Century Gothic", Font.PLAIN, 18);
        tableHeader.setFont(headerFont);
        jTable1.setRowHeight(30);
        loadcities();
        loadAddress();

    }

    public AddressRegister(StudentRegistration parent, boolean modal) {
        super(parent, modal);
        initComponents();
        JTableHeader tableHeader = jTable1.getTableHeader();
        Font headerFont = new Font("Century Gothic", Font.PLAIN, 18);
        tableHeader.setFont(headerFont);
        jTable1.setRowHeight(30);
        this.str = parent;
        loadcities();
        loadAddress();

    }

    public AddressRegister(TeacherRegister parent, boolean modal) {
        super(parent, modal);
        initComponents();
        JTableHeader tableHeader = jTable1.getTableHeader();
        Font headerFont = new Font("Century Gothic", Font.PLAIN, 18);
        tableHeader.setFont(headerFont);
        jTable1.setRowHeight(30);
        this.tr = parent;
        loadcities();
        loadAddress();

    }

    public void loadcities() {

        try {
            ResultSet rs = MySQL.search("SELECT * FROM `city`");

            Vector v = new Vector();
            v.add("Select");

            while (rs.next()) {
                v.add(rs.getString("name"));
            }

            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            jComboBox1.setModel(dcm);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadAddress() {

        try {
            ResultSet rs = MySQL.search("SELECT * FROM address JOIN city ON address.city_id=city.id");

            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {

                Vector v = new Vector();
                v.add(rs.getString("id"));
                v.add(rs.getString("line1"));
                v.add(rs.getString("line2"));
                v.add(rs.getString("city.name"));
                dtm.addRow(v);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void resetfield() {
        jTextField1.setText("");
        jTextField2.setText("");
        jComboBox1.setSelectedItem("Select");
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Address");

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel1.setText("Address Line 1");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel2.setText("Address Line 2");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel3.setText("City");

        jTextField1.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N

        jTextField2.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jButton1.setText("Add Address");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Address Id", "Line 1", "Line 2", "City"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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

        jButton3.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jButton3.setText("Update Address");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 102, 153));
        jButton4.setText("Reset");
        jButton4.setToolTipText("");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(35, 35, 35)
                                .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(35, 35, 35)
                                .addComponent(jTextField1))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(35, 35, 35)
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 762, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(31, 31, 31)
                        .addComponent(jButton3))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        String adLine1 = jTextField1.getText();
        String adLine2 = jTextField2.getText();
        String city = jComboBox1.getSelectedItem().toString();

        if (adLine1.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Address Line 1", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (adLine2.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Address Line 2", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (city.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select City", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            try {
                ResultSet rs1 = MySQL.search("SELECT `id` FROM `city` WHERE `name`='" + city + "'");
                rs1.next();
                String city_id = rs1.getString("id");

                ResultSet rs2 = MySQL.search("SELECT * FROM address WHERE line1 = '" + adLine1 + "' AND line2 = '" + adLine2 + "' AND city_id = '" + city_id + "'");

                if (rs2.next()) {
                    JOptionPane.showMessageDialog(this, "Address already added", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    MySQL.iud("INSERT INTO `address` (`line1`,`line2`,`city_id`) VALUES ('" + adLine1 + "','" + adLine2 + "','" + city_id + "')");
                    JOptionPane.showMessageDialog(this, "Address added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            loadAddress();
            jButton1.setEnabled(false);
            jButton3.setEnabled(false);

            resetfield();
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    public int a1 = 0;
    public int a2 = 0;

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:

        if (evt.getClickCount() == 2) {
            int r = jTable1.getSelectedRow();

            if (r == -1) {

            } else {
                String aid = jTable1.getValueAt(r, 0).toString();
                String adl1 = jTable1.getValueAt(r, 1).toString();
                String adl2 = jTable1.getValueAt(r, 2).toString();
                String city = jTable1.getValueAt(r, 3).toString();

                try {
                    System.out.println(a1);
                    System.out.println(a2);

                    if (a1 == 1) {

                        str.jLabel7.setText(aid);
                        str.jLabel8.setText(adl1);
                        str.jLabel10.setText(adl2);
                        str.jLabel9.setText(city);

                    }

                    if (a2 == 1) {

                        tr.jLabel7.setText(aid);
                        tr.jLabel8.setText(adl1);
                        tr.jLabel10.setText(adl2);
                        tr.jLabel9.setText(city);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

                this.dispose();
            }
        }

        if (evt.getClickCount() == 1) {
            int r = jTable1.getSelectedRow();

            if (r == -1) {

            } else {
                String adl1 = jTable1.getValueAt(r, 1).toString();
                String adl2 = jTable1.getValueAt(r, 2).toString();
                String city = jTable1.getValueAt(r, 3).toString();

                jTextField1.setText(adl1);
                jTextField2.setText(adl2);
                jComboBox1.setSelectedItem(city);

                jButton1.setEnabled(false);
                jButton3.setEnabled(true);

            }
        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        String uadl1 = jTextField1.getText();
        String uadl2 = jTextField2.getText();
        String ucity = jComboBox1.getSelectedItem().toString();

        int tr = jTable1.getSelectedRow();

        String adid = jTable1.getValueAt(tr, 0).toString();

        if (uadl1.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Address Line 1", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (uadl2.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter Address Line 2", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (ucity.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please Select City", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            try {
                ResultSet rs1 = MySQL.search("SELECT `id` FROM `city` WHERE `name`='" + ucity + "'");
                rs1.next();
                String ucity_id = rs1.getString("id");

                ResultSet rs2 = MySQL.search("SELECT * FROM address WHERE line1 = '" + uadl1 + "' AND line2 = '" + uadl2 + "' AND city_id = '" + ucity_id + "'");

                if (rs2.next()) {
                    JOptionPane.showMessageDialog(this, "Address already added", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    MySQL.iud("UPDATE `address` SET `line1`= '" + uadl1 + "', `line2`='" + uadl2 + "' , `city_id`='" + ucity_id + "' WHERE `id`='" + adid + "'");
                    JOptionPane.showMessageDialog(this, "Address update successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            loadAddress();
            resetfield();

            jButton3.setEnabled(false);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:

        jComboBox1.getSelectedItem();

        if (jComboBox1.getSelectedItem().equals("Select")) {
            jButton1.setEnabled(false);
        } else {
            jButton1.setEnabled(true);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

        resetfield();
        jButton1.setEnabled(false);
        jButton3.setEnabled(false);

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2KeyTyped

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddressRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddressRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddressRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddressRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddressRegister dialog = new AddressRegister(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
