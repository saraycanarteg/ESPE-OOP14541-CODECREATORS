/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.espe.cyberplaneta.controller;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Christian Bonifaz, Code Creators, DCCO-ESPE
 */
public interface IncomeFrmInterface {
    void recalculateTotal(DefaultTableModel model);
    void generateExcelReport(JTable table);
    void generatePdfReport(JTable table);
    void deleteSelectedRow(JTable table);
    void searchInTable(JTable table, String searchTerm);
}
