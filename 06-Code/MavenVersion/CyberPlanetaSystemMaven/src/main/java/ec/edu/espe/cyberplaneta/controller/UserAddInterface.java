
package ec.edu.espe.cyberplaneta.controller;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Christian Bonifaz, Code Creators, DCCO-ESPE
 */
public interface UserAddInterface {
    void saveUserData(JTextField txtUser, JPasswordField pwdUserPassword);
    void validateField(String field, JButton btnSave, JLabel lblPassIncorrect);
    void validatePasswordField(JTextField txtUser, JPasswordField pwdUserPassword, JButton btnSave, JLabel lblPassIncorrect);
    void validateUserText(JTextField txtUser, JLabel lblPassIncorrect);
    void clearFields(JTextField txtUser, JPasswordField pwdUserPassword);
}
