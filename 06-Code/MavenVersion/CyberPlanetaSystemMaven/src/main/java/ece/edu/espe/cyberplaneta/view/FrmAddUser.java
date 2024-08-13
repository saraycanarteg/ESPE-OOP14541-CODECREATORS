/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ece.edu.espe.cyberplaneta.view;

import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Christian Bonifaz, Code Creators, DCCO-ESPE
 */
public class FrmAddUser extends javax.swing.JFrame {

    /**
     * Creates new form FrmAddUser
     */
    public FrmAddUser() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTitle = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblIcon = new javax.swing.JLabel();
        pnlData = new javax.swing.JPanel();
        lblNewUser = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        lblNewPassword = new javax.swing.JLabel();
        pwdUserPassword = new javax.swing.JPasswordField();
        lblPassIncorrect = new javax.swing.JLabel();
        pnlButton = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlTitle.setBackground(new java.awt.Color(255, 255, 255));
        pnlTitle.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(7, 81, 203));
        lblTitle.setText("Agregar Usuario");
        pnlTitle.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 320, -1));

        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg2 - copia.jpg"))); // NOI18N
        pnlTitle.add(lblIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(-200, 0, -1, 100));

        pnlData.setBackground(new java.awt.Color(255, 255, 255));

        lblNewUser.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblNewUser.setForeground(new java.awt.Color(7, 81, 203));
        lblNewUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N
        lblNewUser.setText("Nuevo Usuario:");

        txtUser.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(159, 246, 70), 1, true));
        txtUser.setMaximumSize(new java.awt.Dimension(64, 18));
        txtUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUserFocusLost(evt);
            }
        });
        txtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUserKeyTyped(evt);
            }
        });

        lblNewPassword.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblNewPassword.setForeground(new java.awt.Color(7, 81, 203));
        lblNewPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lock.png"))); // NOI18N
        lblNewPassword.setText("Nueva Contraseña:");

        pwdUserPassword.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(159, 246, 70), 1, true));
        pwdUserPassword.setMaximumSize(new java.awt.Dimension(64, 18));
        pwdUserPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                pwdUserPasswordFocusLost(evt);
            }
        });
        pwdUserPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pwdUserPasswordKeyTyped(evt);
            }
        });

        lblPassIncorrect.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPassIncorrect.setForeground(new java.awt.Color(255, 0, 0));
        lblPassIncorrect.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlDataLayout = new javax.swing.GroupLayout(pnlData);
        pnlData.setLayout(pnlDataLayout);
        pnlDataLayout.setHorizontalGroup(
            pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDataLayout.createSequentialGroup()
                .addContainerGap(244, Short.MAX_VALUE)
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblPassIncorrect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlDataLayout.createSequentialGroup()
                        .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNewPassword)
                            .addComponent(lblNewUser))
                        .addGap(18, 18, 18)
                        .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pwdUserPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(248, 248, 248))
        );
        pnlDataLayout.setVerticalGroup(
            pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDataLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNewUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pwdUserPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNewPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPassIncorrect, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                .addGap(58, 58, 58))
        );

        pnlButton.setBackground(new java.awt.Color(7, 81, 203));

        btnSave.setBackground(new java.awt.Color(159, 246, 70));
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSave.setForeground(new java.awt.Color(7, 81, 203));
        btnSave.setText("Guardar");
        btnSave.setBorder(null);
        btnSave.setBorderPainted(false);
        btnSave.setEnabled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(255, 101, 98));
        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Regresar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlButtonLayout = new javax.swing.GroupLayout(pnlButton);
        pnlButton.setLayout(pnlButtonLayout);
        pnlButtonLayout.setHorizontalGroup(
            pnlButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlButtonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(292, 292, 292)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
        );
        pnlButtonLayout.setVerticalGroup(
            pnlButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlButtonLayout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(pnlButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(pnlData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                .addComponent(pnlButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(105, Short.MAX_VALUE)
                    .addComponent(pnlData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(106, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserFocusLost
        validateUserText();
    }//GEN-LAST:event_txtUserFocusLost

    private void txtUserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyTyped
        char typedChar = evt.getKeyChar();
        if (isInvalidCharacter(typedChar)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtUserKeyTyped

    private void pwdUserPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pwdUserPasswordFocusLost
        validatePasswordField();
    }//GEN-LAST:event_pwdUserPasswordFocusLost

    private void pwdUserPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pwdUserPasswordKeyTyped
        btnSave.setEnabled(true);
    }//GEN-LAST:event_pwdUserPasswordKeyTyped

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        saveUserData();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        FrmMenu frmMenu = new FrmMenu();
        this.setVisible(false);
        frmMenu.setVisible(true);
    }//GEN-LAST:event_btnCancelActionPerformed

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
            java.util.logging.Logger.getLogger(FrmAddUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAddUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAddUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAddUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAddUser().setVisible(true);
            }
        });
    }

    private void validatePasswordField() {
        if (isPasswordEmpty()) {
            displayErrorMessage("Campos vacíos");
        } else {
            clearErrorMessage();
        }
    }

    private void validateUserText() {
        if (containsInvalidCharacters(getUsername())) {
            displayErrorMessage("Formato de usuario incorrecto");
        } else if (isUsernameEmpty()) {
            displayErrorMessage("Campos vacíos");
        } else {
            clearErrorMessage();
        }
    }

    private void saveUserData() {
        try {
            String rawPassword = getPassword();
            String encryptedPassword = encryptPassword(rawPassword);
            String username = getUsername();

            if (isUserValid(username)) {
                saveUser(username, encryptedPassword);
                clearFields();
                showSuccessMessage();
            } else {
                showErrorMessage("El usuario ya existe");
            }
        } catch (Exception e) {
            showErrorMessage("Ocurrió un error al guardar los datos: " + e.getMessage());
        }
    }

    private boolean isUsernameEmpty() {
        return getUsername().isEmpty();
    }

    private boolean isPasswordEmpty() {
        return new String(pwdUserPassword.getPassword()).isEmpty();
    }

    private void displayErrorMessage(String message) {
        lblPassIncorrect.setText(message);
    }

    private void clearErrorMessage() {
        lblPassIncorrect.setText(null);
    }

    public static boolean containsInvalidCharacters(String text) {
        String regex = "[\\s!@#$%^&*(),.?\":{}|<>]";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(text).find();
    }

    private boolean isInvalidCharacter(char c) {
        return !Character.isLetterOrDigit(c) && !isAllowedKey(c);
    }

    private boolean isAllowedKey(char c) {
        return c == java.awt.event.KeyEvent.VK_BACK_SPACE || c == java.awt.event.KeyEvent.VK_DELETE;
    }

    private String getPassword() {
        return new String(pwdUserPassword.getPassword());
    }

    private String encryptPassword(String password) {
        return utils.EncryptData.encriptionData(password);
    }

    private String getUsername() {
        return txtUser.getText().trim();
    }

    private boolean isUserValid(String username) {
        return !utils.MongoDBUtil.validateNameUser(username);
    }

    private void saveUser(String username, String encryptedPassword) {
        utils.MongoDBUtil.saveUser(encryptedPassword, username);
    }

    private void clearFields() {
        txtUser.setText("");
        pwdUserPassword.setText("");
    }

    private void showSuccessMessage() {
        JOptionPane.showMessageDialog(this, "Datos guardados en la nube.", "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblNewPassword;
    private javax.swing.JLabel lblNewUser;
    private javax.swing.JLabel lblPassIncorrect;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlButton;
    private javax.swing.JPanel pnlData;
    private javax.swing.JPanel pnlTitle;
    private javax.swing.JPasswordField pwdUserPassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
