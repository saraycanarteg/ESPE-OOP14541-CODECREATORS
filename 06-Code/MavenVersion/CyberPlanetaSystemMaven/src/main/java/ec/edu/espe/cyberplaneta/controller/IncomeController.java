package ec.edu.espe.cyberplaneta.controller;

import ec.edu.espe.cyberplaneta.model.PriceList;
import ec.edu.espe.cyberplaneta.model.TaxProcess;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import utils.MongoDBUtil;
import java.util.List;
import org.bson.Document;


/**
 *
 * @author Saray Cañarte
 */
public class IncomeController implements TableInterface{

    public static void saveTaxProcessToDatabase(PriceList selectedProcess, float totalPrice, int numberOfDocumentation) {
        TaxProcess taxProcess = new TaxProcess(selectedProcess, totalPrice);
        MongoDBUtil.saveTaxProcess(taxProcess, numberOfDocumentation);
    }

    @Override
    public void loadDataToTable(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        List<Document> documents = MongoDBUtil.getAllIncomes();
        float totalSum = 0;
       
        for (Document doc : documents) {
            int id = doc.getInteger("processId");
            String name = doc.getString("processName");
            int numberOfDocumentation = doc.getInteger("numberOfDocumentation");
            float priceBase = doc.getDouble("price").floatValue();
            float taxRate = doc.getDouble("taxRate").floatValue();
            float totalPrice = doc.getDouble("total").floatValue();

        model.addRow(new Object[]{
            id,
            name,
            numberOfDocumentation,
            String.format("%.2f", priceBase),
            String.format("%.2f", taxRate),
            String.format("%.2f", totalPrice)
        });

            totalSum += totalPrice;
        }

        model.addRow(new Object[]{"", "", "TOTAL:", "", "", String.format("%.2f", totalSum)}); 
    }
    
}
