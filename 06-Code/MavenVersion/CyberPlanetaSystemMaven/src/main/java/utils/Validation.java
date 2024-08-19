package utils;

import javax.swing.JTextField;
import java.awt.Color;
import java.util.regex.Pattern;

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

    public static boolean containsInvalidCharacters(String text) {
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
}
