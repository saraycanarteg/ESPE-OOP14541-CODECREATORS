/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.cyberplaneta.controller;

/**
 *
 * @author Nahomi Cedeño, CODECREATORS, DCCO-ESPE
 */
public class InvalidInputException extends Exception {
    private int errorIndex;

    public InvalidInputException(String message, int errorIndex) {
        super(message);
        this.errorIndex = errorIndex;
    }

    public int getErrorIndex() {
        return errorIndex;
    }
}
