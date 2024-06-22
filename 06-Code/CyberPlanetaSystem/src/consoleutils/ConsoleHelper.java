
package consoleutils;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Code Creators
 */
public class ConsoleHelper {
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void clearScreen() {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }
    
public static int getValidIntegerInput(int min, int max, String errorMessage, String retryPrompt) {
        Scanner scanner = new Scanner(System.in);
        int input = -1;
        boolean isValid = false;

        while (!isValid) {
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input >= min && input <= max) {
                    isValid = true;
                } else {
                    System.out.println(errorMessage);
                    System.out.println(retryPrompt);
                }
            } else {
                System.out.println(errorMessage);
                System.out.println(retryPrompt);
                scanner.next(); 
            }
        }

        return input;
    }

}
