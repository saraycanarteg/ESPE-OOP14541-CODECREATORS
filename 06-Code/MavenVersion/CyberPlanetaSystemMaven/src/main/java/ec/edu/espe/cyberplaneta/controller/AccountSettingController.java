
package ec.edu.espe.cyberplaneta.controller;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import utils.MongoDBUtil;

/**
 *
 * @author Christian Bonifaz, Code Creators, DCCO-ESPE
 */
public class AccountSettingController implements AccountSettingInterface {

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
}
