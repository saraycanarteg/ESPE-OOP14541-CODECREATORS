/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.espe.cyberplaneta.controller;

import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Christian Bonifaz, Code Creators, DCCO-ESPE
 */
public interface AccountSettingInterface {
    void onSaveUser(JTextField txtUser, JTextField txtNewUser, JTextField txtNewPassword, JTextField txtPassword, JButton btnGuardar);
    void onSearchUser(JTextField txtUser, JTextField txtPassword, JTextField txtNewUser, JTextField txtNewPassword, JButton btnGuardar);
    void showUpdateResult(boolean isUpdated);
    void handleUserValidation(boolean isUserValid, JTextField txtUser, JTextField txtPassword, JTextField txtNewUser, JTextField txtNewPassword, JButton btnGuardar);
    void enableUserEditing(JTextField txtNewUser, JTextField txtNewPassword, JButton btnGuardar, JTextField txtUser, JTextField txtPassword);
    void disableUserEditing(JTextField txtNewUser, JTextField txtNewPassword, JButton btnGuardar);
    void clearFields(JTextField txtNewUser, JTextField txtNewPassword, JTextField txtUser, JTextField txtPassword);
}
