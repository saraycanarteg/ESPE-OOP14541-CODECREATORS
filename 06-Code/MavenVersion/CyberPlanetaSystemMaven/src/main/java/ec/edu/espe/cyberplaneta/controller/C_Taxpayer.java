package ec.edu.espe.cyberplaneta.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import ec.edu.espe.cyberplaneta.model.TaxPayer;
import utils.MongoDBUtil;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author Andres Cedeno & Saray  Cañarte,Code Creators,DCCO-ESPE
 */
public class C_Taxpayer implements I_Table{

    public static boolean isRucExist(String ruc) {
        MongoDatabase database = MongoDBUtil.getDatabase();
        MongoCollection<Document> collection = database.getCollection("TaxPayer");
        Document query = new Document("id", ruc);
        Document result = collection.find(query).first();
        return result != null;
    }

    public static void saveTaxPayerToDatabase(TaxPayer taxpayer) {
        MongoDatabase database = MongoDBUtil.getDatabase();
        MongoCollection<Document> collection = database.getCollection("TaxPayer");

        Document document = new Document("id", taxpayer.getId())
                .append("email", taxpayer.getEmail())
                .append("name", taxpayer.getName())
                .append("password", taxpayer.getPassword())
                .append("accountingDocumentation", taxpayer.isAccountingDocumentation())
                .append("startDate", taxpayer.getStartDate())
                .append("deliveryDate", taxpayer.getdeliveryDate())
                .append("cellNumber", taxpayer.getCellNumber());

        collection.insertOne(document);
    }
     
    @Override
    public void loadDataToTable(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); 

        List<Document> taxPayers = MongoDBUtil.getAllTaxPayers(); 
        for (Document taxPayer : taxPayers) {
            Object[] rowData = new Object[8];
            rowData[0] = taxPayer.getString("id");
            rowData[1] = taxPayer.getString("email");
            rowData[2] = taxPayer.getString("name");
            rowData[3] = utils.EncryptData.decryptData(taxPayer.getString("password"));
            rowData[4] = taxPayer.getBoolean("accountingDocumentation");
            rowData[5] = taxPayer.getString("startDate");
            rowData[6] = taxPayer.getString("deliveryDate");
            rowData[7] = taxPayer.getString("cellNumber");

            model.addRow(rowData);
        }
    }
}
