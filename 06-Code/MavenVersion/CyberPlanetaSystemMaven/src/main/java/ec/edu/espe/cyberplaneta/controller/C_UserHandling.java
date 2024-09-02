
package ec.edu.espe.cyberplaneta.controller;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Christian Bonifaz, Code Creators, DCCO-ESPE
 */
public class C_UserHandling implements I_UserHandling{
    @Override
    public void saveUserData(JTextField txtUser, JPasswordField pwdUserPassword) {
        String passwor = new String(pwdUserPassword.getPassword());
        String password = utils.EncryptData.encriptionData(passwor);
        String user = txtUser.getText().trim();

        if (!utils.MongoDBUtil.validateNameUser(user) && !user.isEmpty() && !passwor.isEmpty()) {
            utils.MongoDBUtil.saveUser(password, user);
            clearFields(txtUser, pwdUserPassword);
            JOptionPane.showMessageDialog(null, "Datos guardados en la nube.", "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "El usuario ya existe", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void validateField(String field, JButton btnSave, JLabel lblPassIncorrect) {
        if (!field.isEmpty()) {
            btnSave.setEnabled(true);
            lblPassIncorrect.setText(null);
        } else {
            btnSave.setEnabled(false);
        }
    }

    @Override
    public void validatePasswordField(JTextField txtUser, JPasswordField pwdUserPassword, JButton btnSave, JLabel lblPassIncorrect) {
        if (new String(pwdUserPassword.getPassword()).isEmpty() || txtUser.getText().trim().isEmpty()) {
            lblPassIncorrect.setText("Campos vacíos");
            btnSave.setEnabled(false);
        } else {
            lblPassIncorrect.setText(null);
            btnSave.setEnabled(true);
        }
    }

    @Override
    public void validateUserText(JTextField txtUser, JLabel lblPassIncorrect) {
        if (utils.Validation.validateInvalidCharacters(txtUser.getText().trim())) {
            lblPassIncorrect.setText("Formato de usuario incorrecto");
        } else {
            lblPassIncorrect.setText(null);
        }
    }

    @Override
    public void clearFields(JTextField txtUser, JPasswordField pwdUserPassword) {
        txtUser.setText("");
        pwdUserPassword.setText("");
    }
}
