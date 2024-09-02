package ec.edu.espe.cyberplaneta.controller;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Christian Bonifaz, Code Creators, DCCO-ESPE
 */
public interface I_Income {
    void recalculateIncomeTotal(DefaultTableModel model);
    void deleteSelectedRow(JTable table);
    void searchInIncomeTable(JTable table, String searchTerm);
}
