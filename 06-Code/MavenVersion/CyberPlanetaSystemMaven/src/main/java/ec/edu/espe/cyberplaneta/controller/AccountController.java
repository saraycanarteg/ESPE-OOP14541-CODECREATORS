package ec.edu.espe.cyberplaneta.controller;

import ece.edu.espe.cyberplaneta.view.FrmMenu;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Saray Cañarte
 */
public class AccountController {

    
    public void handleLogin(JTextField txtUser, JPasswordField btnPassword, javax.swing.JLabel txtPassIncorrect) {
        String password = new String(btnPassword.getPassword());
        String user = txtUser.getText().trim();

        if (containsInvalidCharacters(user) || password.isEmpty()) {
            txtPassIncorrect.setText("Campos vacios");
        } else if (utils.MongoDBUtil.validateUser(user, password)) {
            FrmMenu frmMain = new FrmMenu();
            frmMain.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    private static boolean containsInvalidCharacters(String text) {
        String regex = "[\\s!@#$%^&*(),.?\":{}|<>]";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(text).find();
    }
}
