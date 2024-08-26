/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ece.edu.espe.cyberplaneta.view;

import ec.edu.espe.cyberplaneta.controller.EditTaxPayerController;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import org.bson.Document;
import utils.MongoDBUtil;
import utils.Validation;

/**
 *
 * @author Andres Cedeno,Code Creators,DCCO-ESPE
 */
public class FrmEditTaxpayer extends javax.swing.JFrame {

    private EditTaxPayerController controller = new EditTaxPayerController();
    
    public FrmEditTaxpayer() {
        initComponents();
    }

    private Date parseDate(String dateString) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(dateString);
        } catch (Exception e) {
            return null;
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

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtContrasenia = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnCargar = new javax.swing.JButton();
        chkDocumentacion = new javax.swing.JCheckBox();
        dateChooserEnd = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        dateChooserStart = new com.toedter.calendar.JDateChooser();
        txtInvalidId = new javax.swing.JLabel();
        txtInvalidName = new javax.swing.JLabel();
        txtInvalidEmail = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtCelular1 = new javax.swing.JTextField();
        txtInvalidCell = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnCancelIncomeCalc = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(7, 81, 203));
        jLabel1.setText("Editar Contribuyente");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 380, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg2 - copia.jpg"))); // NOI18N
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-200, 0, -1, 100));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 204));
        jLabel6.setText("Documentación:");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 204));
        jLabel4.setText("Nombre:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 204));
        jLabel7.setText("Contraseña:");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, -1, -1));

        txtId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIdFocusLost(evt);
            }
        });
        jPanel4.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 170, -1));
        jPanel4.add(txtContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, 170, -1));

        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreFocusLost(evt);
            }
        });
        jPanel4.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 170, -1));

        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });
        jPanel4.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, 170, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 204));
        jLabel2.setText("ID:");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 204));
        jLabel3.setText("Email:");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, -1, -1));

        btnCargar.setBackground(new java.awt.Color(159, 246, 70));
        btnCargar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCargar.setForeground(new java.awt.Color(7, 81, 203));
        btnCargar.setText("Cargar");
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });
        jPanel4.add(btnCargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 30, -1, -1));

        chkDocumentacion.setForeground(new java.awt.Color(7, 81, 203));
        chkDocumentacion.setText("Se entregó documentación");
        jPanel4.add(chkDocumentacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, -1, -1));
        jPanel4.add(dateChooserEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, 170, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 204));
        jLabel9.setText("Fecha de inicio:");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 204));
        jLabel10.setText("Fecha de entrega:");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, -1, -1));
        jPanel4.add(dateChooserStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, 170, -1));

        txtInvalidId.setForeground(new java.awt.Color(204, 0, 0));
        jPanel4.add(txtInvalidId, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 30, 160, 23));

        txtInvalidName.setForeground(new java.awt.Color(204, 0, 0));
        jPanel4.add(txtInvalidName, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 140, 160, 23));

        txtInvalidEmail.setForeground(new java.awt.Color(204, 0, 0));
        jPanel4.add(txtInvalidEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 180, 160, 23));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 204));
        jLabel11.setText("Numero de Celular:");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, -1, -1));

        txtCelular1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCelular1FocusLost(evt);
            }
        });
        jPanel4.add(txtCelular1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 290, 180, -1));

        txtInvalidCell.setForeground(new java.awt.Color(204, 0, 0));
        jPanel4.add(txtInvalidCell, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 290, 210, 20));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 106, 920, 321));

        jPanel5.setBackground(new java.awt.Color(7, 81, 203));

        btnGuardar.setBackground(new java.awt.Color(159, 246, 70));
        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(7, 81, 203));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelIncomeCalc.setBackground(new java.awt.Color(255, 101, 98));
        btnCancelIncomeCalc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancelIncomeCalc.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelIncomeCalc.setText("Cancelar");
        btnCancelIncomeCalc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelIncomeCalcActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(200, Short.MAX_VALUE)
                .addComponent(btnCancelIncomeCalc, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(203, 203, 203)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(205, 205, 205))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelIncomeCalc)
                    .addComponent(btnGuardar))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 439, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdFocusLost
        validId();
    }//GEN-LAST:event_txtIdFocusLost

    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
        validName();
    }//GEN-LAST:event_txtNombreFocusLost

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        validEmal();
    }//GEN-LAST:event_txtEmailFocusLost

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        loadTaxPayer();
    }//GEN-LAST:event_btnCargarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        saveTaxPayerChanges();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelIncomeCalcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelIncomeCalcActionPerformed
        goToMenu();
    }//GEN-LAST:event_btnCancelIncomeCalcActionPerformed

    private void txtCelular1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCelular1FocusLost
        validPhone();
    }//GEN-LAST:event_txtCelular1FocusLost

    private void goToMenu(){
        FrmMenu frmMenu = new FrmMenu();
        this.setVisible(false);
        frmMenu.setVisible(true);
    }
    private void validName(){
        String PATTERN = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(txtNombre.getText().trim());

        if (!match.matches()) {
            txtInvalidName.setText("Nombre Inválido");
        } else {
            txtInvalidName.setText(null); // Limpiar el texto si es válido
        }
    }
    private void validId(){
        String id = txtId.getText().trim();
    
    if (!Validation.isIdValid(id)) {
        txtInvalidId.setText("ID (RUC) Inválido");
    } else {
        txtInvalidId.setText(null); 
    }
    }
    private void validEmal(){
        String PATTERN = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(txtEmail.getText().trim()); // Añadir trim() para manejar espacios en blanco

        if (!match.matches()) {
            txtInvalidEmail.setText("Correo Inválido");
        } else {
            txtInvalidEmail.setText(null); // Limpiar el texto si es válido
        }
    }
    private void validPhone(){
        if (txtCelular1.getText().trim().length() != 10) {
            txtInvalidCell.setText("Debe tener 10 dígitos");
        } else if (!txtCelular1.getText().trim().startsWith("09")) {
            txtInvalidCell.setText("Debe empezar con 09");
        } else {
            txtInvalidCell.setText(null);
        }
    }
    private void loadTaxPayer(){
        String id = txtId.getText().trim();
        if (!id.isEmpty()) {
            controller.cargarTaxPayer(id, txtEmail, txtNombre, txtContrasenia, chkDocumentacion, dateChooserStart, dateChooserEnd, txtCelular1);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un ID.");
        }
    }
    private void saveTaxPayerChanges(){
    String id = txtId.getText().trim();
        String email = txtEmail.getText().trim();
        String name = txtNombre.getText().trim();
        String password = txtContrasenia.getText().trim();
        boolean documentation = chkDocumentacion.isSelected();
        Date startDate = dateChooserStart.getDate();
        Date deliveryDate = dateChooserEnd.getDate();
        String cellNumber = txtCelular1.getText().trim();

        controller.saveTaxPayerChanges(id, email, name, password, documentation, startDate, deliveryDate, cellNumber);
    }
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
            java.util.logging.Logger.getLogger(FrmEditTaxpayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmEditTaxpayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmEditTaxpayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEditTaxpayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmEditTaxpayer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelIncomeCalc;
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JCheckBox chkDocumentacion;
    private com.toedter.calendar.JDateChooser dateChooserEnd;
    private com.toedter.calendar.JDateChooser dateChooserStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField txtCelular1;
    private javax.swing.JTextField txtContrasenia;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JLabel txtInvalidCell;
    private javax.swing.JLabel txtInvalidEmail;
    private javax.swing.JLabel txtInvalidId;
    private javax.swing.JLabel txtInvalidName;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
