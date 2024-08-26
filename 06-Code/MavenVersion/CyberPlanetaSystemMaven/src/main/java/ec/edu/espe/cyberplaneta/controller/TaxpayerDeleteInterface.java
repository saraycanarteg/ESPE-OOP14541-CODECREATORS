
package ec.edu.espe.cyberplaneta.controller;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Christian Bonifaz, Code Creators, DCCO-ESPE
 */
public interface TaxpayerDeleteInterface {
    void cleanRow(JButton btnDelete, DefaultTableModel modelo);
    void handleSearch(JTextField txtId, JButton btnDelete, DefaultTableModel modelo);
    void addDataToModel(String[] data, DefaultTableModel modelo);
    void handleDelete(JTextField txtId, JButton btnDelete, DefaultTableModel modelo);
}
