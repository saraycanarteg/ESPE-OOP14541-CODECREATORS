package utils;

import ece.edu.espe.cyberplaneta.view.FrmMenu;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Component;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Validation {

    public static boolean validateMoneyFields(JTextField textField) {
        String input = textField.getText().trim();
        String regex = "^(\\d+(\\.\\d{1,2})?)$";

        if (input.matches(regex)) {
            double value = Double.parseDouble(input);
            if (value > 0) {
                textField.setBackground(Color.WHITE);
                return true;
            }
        }
        highlightError(textField);
        return false;
    }

    public static boolean validatePositiveInteger(JTextField textField) {
        String input = textField.getText().trim();

        try {
            int value = Integer.parseInt(input);
            if (value > 0) {
                textField.setBackground(Color.WHITE);
                return true;
            }
        } catch (NumberFormatException e) {

        }
        highlightError(textField);
        return false;
    }

    private static void highlightError(JTextField textField) {
        textField.setBackground(Color.PINK);
    }

    public static boolean validateInvalidCharacters(String text) {
        String regex = "[\\s!@#$%^&*(),.?\":{}|<>]";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(text).find();
    }

    public static boolean isInvalidCharacter(char c) {
        return !Character.isLetterOrDigit(c) && !isAllowedKey(c);
    }

    public static boolean isAllowedKey(char c) {
        return c == java.awt.event.KeyEvent.VK_BACK_SPACE || c == java.awt.event.KeyEvent.VK_DELETE;
    }

    public static boolean isIdValid(String id) {
        return id.length() == 13 && id.endsWith("001");
    }

    public static boolean isTaxpayerExist(String id) {
        return MongoDBUtil.verificationIdTaxpayer(id);
    }

    public static void restrictInputToProcessId(java.awt.event.KeyEvent evt, String text) {
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || text.length() >= 1 || (c < '1' || c > '5')) {
            evt.consume();
        }
    }

    public static void restrictInputToDigits(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) && !isAllowedKey(c)) {
            evt.consume();
        }
    }

    public static void showMessage(Component parentComponent, String message, String title, int messageType) {
        JOptionPane.showMessageDialog(parentComponent, message, title, messageType);
    }

    public static boolean validateEmail(String email) {
    String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    if (email.matches(emailRegex)) {
        return true;
    }
    System.out.println("Correo electrónico no válido.");
    
    return false;
}

    public static boolean validateName(String name) {
        return name.matches("[a-zA-Z\\s]+");
    }

    public static boolean isValidName(String name) {
        String regex = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public static boolean areDatesValid(Date initDate, Date finishDate) {
        if (initDate == null || finishDate == null) {
            return false;
        }
        return !finishDate.before(initDate);
    }

    public static boolean isValidCellNumber(String cellNumber) {
        return cellNumber.length() == 10 && cellNumber.startsWith("09");
    }
    
    public static void goToMenu(JFrame currentFrame) {
    FrmMenu frmMenu = new FrmMenu();
    currentFrame.setVisible(false);
    frmMenu.setVisible(true);
}

}
