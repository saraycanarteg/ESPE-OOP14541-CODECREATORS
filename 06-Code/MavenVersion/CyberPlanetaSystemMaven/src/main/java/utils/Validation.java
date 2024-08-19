package utils;

import javax.swing.JTextField;
import java.awt.Color;

public class Validation {

    public static boolean isValidMoney(JTextField textField) {
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

    public static boolean isValidPositiveInteger(JTextField textField) {
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
}