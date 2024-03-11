/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package gui;

import java.awt.Font;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.Vector;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import model.MySQL;

/**
 *
 * @author Thinuka
 */
public class PaymentDetails extends javax.swing.JFrame {

    ClassRegister clr = new ClassRegister();
    SimpleDateFormat sdf = new SimpleDateFormat("MMMM");
    String monthNow = sdf.format(new Date());

    /**
     * Creates new form Address
     */
    public PaymentDetails(java.awt.Frame parent, boolean modal) {

        initComponents();

        JTableHeader tableHeader = jTable1.getTableHeader();
        Font headerFont = new Font("Century Gothic", Font.PLAIN, 18);
        tableHeader.setFont(headerFont);
        jTable1.setRowHeight(30);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        loadInvoice();
        loadMonths();
    }

    ResultSet rs;

    public void loadInvoice() {
        String month = jComboBox1.getSelectedItem().toString();

        try {

            if (month.equals("Select")) {

                rs = MySQL.search("SELECT * FROM student_payment JOIN student_has_class ON student_payment.student_has_class_id=student_has_class.id JOIN `month` ON student_payment.month_id=`month`.id  JOIN payment_status ON student_payment.payment_status_id=payment_status.id JOIN student ON student_has_class.student_id=student.id JOIN class ON student_has_class.class_id=class.id JOIN teacher ON class.teacher_id=teacher.id JOIN subject ON subject.id=teacher.subject_id ORDER BY student_payment.id ASC ");
            } else {

                rs = MySQL.search("SELECT * FROM student_payment JOIN student_has_class ON student_payment.student_has_class_id=student_has_class.id JOIN `month` ON student_payment.month_id=`month`.id  JOIN payment_status ON student_payment.payment_status_id=payment_status.id JOIN student ON student_has_class.student_id=student.id JOIN class ON student_has_class.class_id=class.id JOIN teacher ON class.teacher_id=teacher.id JOIN subject ON subject.id=teacher.subject_id WHERE month.name='" + month + "' ORDER BY student_payment.id ASC ");
            }

            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);

            while (rs.next()) {

                Vector v = new Vector();
                v.add(rs.getString("student_payment.invoiceNo"));
                v.add(rs.getString("student.id"));
                v.add(rs.getString("student.name"));
                v.add(rs.getString("teacher.name"));
                v.add(rs.getString("month.name"));
                v.add(rs.getString("student_payment.date_time"));
                v.add(rs.getString("subject.name"));
                v.add(rs.getString("student_payment.value"));
                v.add(rs.getString("payment_status.name"));
                dtm.addRow(v);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    ResultSet rs1;

    public void loadInvoice(String text) {

        String month = jComboBox1.getSelectedItem().toString();

        try {

            if (month.equals("Select")) {

                rs1 = MySQL.search("SELECT * FROM student_payment JOIN student_has_class ON student_payment.student_has_class_id=student_has_class.id JOIN `month` ON student_payment.month_id=`month`.id  JOIN payment_status ON student_payment.payment_status_id=payment_status.id JOIN student ON student_has_class.student_id=student.id JOIN class ON student_has_class.class_id=class.id JOIN teacher ON class.teacher_id=teacher.id JOIN subject ON subject.id=teacher.subject_id WHERE student.name LIKE '" + text + "%' OR student.id LIKE '" + text + "%' OR student_payment.id LIKE '" + text + "%' OR teacher.name LIKE '" + text + "%' ORDER BY student_payment.id ASC ");
            } else {
                rs1 = MySQL.search("SELECT * FROM student_payment JOIN student_has_class ON student_payment.student_has_class_id=student_has_class.id JOIN `month` ON student_payment.month_id=`month`.id  JOIN payment_status ON student_payment.payment_status_id=payment_status.id JOIN student ON student_has_class.student_id=student.id JOIN class ON student_has_class.class_id=class.id JOIN teacher ON class.teacher_id=teacher.id JOIN subject ON subject.id=teacher.subject_id WHERE (student.name LIKE '" + text + "%' OR student.id LIKE '" + text + "%' OR student_payment.id LIKE '" + text + "%' OR teacher.name LIKE '" + text + "%') and month.name='" + month + "'  ORDER BY student_payment.id ASC ");
            }

            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);

            while (rs1.next()) {

                Vector v = new Vector();
                v.add(rs1.getString("student_payment.invoiceNo"));
                v.add(rs1.getString("student.id"));
                v.add(rs1.getString("student.name"));
                v.add(rs1.getString("teacher.name"));
                v.add(rs1.getString("month.name"));
                v.add(rs1.getString("student_payment.date_time"));
                v.add(rs1.getString("subject.name"));
                v.add(rs1.getString("student_payment.value"));
                v.add(rs1.getString("payment_status.name"));
                dtm.addRow(v);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadMonths() {
        try {
            ResultSet rs2 = MySQL.search("SELECT * FROM `month`");

            Vector v = new Vector();
            v.add("Select");

            while (rs2.next()) {
                v.add(rs2.getString("name"));

            }

            DefaultComboBoxModel dcm = new DefaultComboBoxModel(v);
            jComboBox1.setModel(dcm);

            jComboBox1.setSelectedItem(monthNow);
//            System.out.println(monthNow);
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

        jTextField3 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Student Payment Details");

        jTextField3.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel16.setText("Search ");

        jTable1.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Invoice No", "Student Id", "Student Name", "Teacher Name", "Month", "Date & Time", "Subject", "Value", "Payment Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel18.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel18.setText("Select Month");

        jComboBox1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(102, 102, 102));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/reset_sync_arrow_icon.png"))); // NOI18N
        jButton7.setText("  Switch Payment Status");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1158, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton7)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel18)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton7)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        // TODO add your handling code here:

        String text = jTextField3.getText();
        loadInvoice(text);

        if (text.equals("")) {
            loadInvoice();
        } else {

        }
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:

        loadInvoice();
        jTextField3.setText("");


    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:

        int i = jTable1.getSelectedRow();

        String tc0 = jTable1.getValueAt(i, 0).toString();

        MySQL.iud("UPDATE `student_payment` SET `date_time`= '0000-00-00 00:00:00', `payment_status_id`='2',`invoiceNo`='Unpaid'  WHERE `invoiceNo`='" + tc0 + "' AND `payment_status_id`='1' ");

        String text = jTextField3.getText();
        loadInvoice(text);

    }//GEN-LAST:event_jButton7ActionPerformed

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
            java.util.logging.Logger.getLogger(PaymentDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaymentDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaymentDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaymentDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PaymentDetails dialog = new PaymentDetails(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
