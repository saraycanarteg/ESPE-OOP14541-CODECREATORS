/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.espe.cyberplaneta.controller;

/**
 *
 * @author Andres Cedeno,Code Creators,DCCO-ESPE
 */
public interface I_AddTaxPayer {
    void saveTaxPayer(String id, String email, String name, String password, boolean documentation, String initDateStr, String finishDateStr, String cellNumber);
}
