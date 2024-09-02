
package ec.edu.espe.cyberplaneta.controller;

import ece.edu.espe.cyberplaneta.view.FrmMenu;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import utils.MongoDBUtil;

/**
 *
 * @author Christian Bonifaz, Code Creators, DCCO-ESPE
 */
public class C_AccountSetting implements I_AccountSetting {

    private static boolean containsInvalidCharacters(String text) {
        String regex = "[\\s!@#$%^&*(),.?\":{}|<>]";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(text).find();
    }

    @Override
    public void onSaveUser(JTextField txtUser, JTextField txtNewUser, JTextField txtNewPassword, JTextField txtPassword, JButton btnGuardar) {
        String oldUsername = txtUser.getText();
        String newUsername = txtNewUser.getText();
        String newPassword = txtNewPassword.getText();

        boolean isUpdated = MongoDBUtil.updateUser(oldUsername, newUsername, utils.EncryptData.encriptionData(newPassword));
        showUpdateResult(isUpdated);
        clearFields(txtNewUser, txtNewPassword, txtUser, txtPassword);
        disableUserEditing(txtNewUser, txtNewPassword, btnGuardar);
    }

    @Override
    public void onSearchUser(JTextField txtUser, JTextField txtPassword, JTextField txtNewUser, JTextField txtNewPassword, JButton btnGuardar) {
        String username = txtUser.getText();
        String password = txtPassword.getText();

        boolean isUserValid = MongoDBUtil.validateUser(username, password);
        handleUserValidation(isUserValid, txtUser,  txtPassword,  txtNewUser,  txtNewPassword,  btnGuardar);
    }

    @Override
    public void showUpdateResult(boolean isUpdated) {
        if (isUpdated) {
            utils.Validation.showMessage(null, "Usuario actualizado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            utils.Validation.showMessage(null, "Error al actualizar el usuario", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void handleUserValidation(boolean isUserValid, JTextField txtUser, JTextField txtPassword, JTextField txtNewUser, JTextField txtNewPassword, JButton btnGuardar) {
        if (isUserValid) {
            enableUserEditing(txtNewUser, txtNewPassword, btnGuardar, txtUser, txtPassword);
        } else {
            disableUserEditing(txtNewUser, txtNewPassword, btnGuardar);
            utils.Validation.showMessage(null, "Usuario no encontrado o contraseña incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void enableUserEditing(JTextField txtNewUser, JTextField txtNewPassword, JButton btnGuardar, JTextField txtUser, JTextField txtPassword) {
        txtNewUser.setText(txtUser.getText());
        txtNewPassword.setText(txtPassword.getText());
        txtNewUser.setEnabled(true);
        txtNewPassword.setEnabled(true);
        btnGuardar.setEnabled(true);
    }

    @Override
    public void disableUserEditing(JTextField txtNewUser, JTextField txtNewPassword, JButton btnGuardar) {
        txtNewUser.setEnabled(false);
        txtNewPassword.setEnabled(false);
        btnGuardar.setEnabled(false);
    }

    @Override
    public void clearFields(JTextField txtNewUser, JTextField txtNewPassword, JTextField txtUser, JTextField txtPassword) {
        txtNewPassword.setText("");
        txtNewUser.setText("");
        txtPassword.setText("");
        txtUser.setText("");
    }

    public void handleLogin(JTextField txtUser, JPasswordField btnPassword, JLabel txtPassIncorrect) {
        String password = new String(btnPassword.getPassword());
        String user = txtUser.getText().trim();
        if (containsInvalidCharacters(user) || password.isEmpty()) {
            txtPassIncorrect.setText("Campos vacios");
        } else if (MongoDBUtil.validateUser(user, password)) {
            FrmMenu frmMain = new FrmMenu();
            frmMain.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Usuario o contrase\u00f1a incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
