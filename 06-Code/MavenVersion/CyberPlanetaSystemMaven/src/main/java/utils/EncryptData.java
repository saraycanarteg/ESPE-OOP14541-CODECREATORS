/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author Christian Bonifaz, Code Creators, DCCO-ESPE
 */
public class EncryptData {

    public static String encriptionData(String text) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);

            if (Character.isLetter(letter)) {
                if (letter == 'z') {
                    result.append('a');
                } else if (letter == 'Z') {
                    result.append('A');
                } else {
                    result.append((char) (letter + 1));
                }
            } else if (Character.isDigit(letter)) {
                if (letter == '9') {
                    result.append('0');
                } else {
                    result.append((char) (letter + 1));
                }
            } else {
                result.append(letter);
            }
        }

        return result.toString();
    }

    public static String decryptData(String texto) {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);

            if (Character.isLetter(caracter)) {
                if (caracter == 'a') {
                    resultado.append('z');
                } else if (caracter == 'A') {
                    resultado.append('Z');
                } else {
                    resultado.append((char) (caracter - 1));
                }
            } else if (Character.isDigit(caracter)) {
                if (caracter == '0') {
                    resultado.append('9');
                } else {
                    resultado.append((char) (caracter - 1));
                }
            } else {
                resultado.append(caracter);
            }
        }

        return resultado.toString();
    }

}
