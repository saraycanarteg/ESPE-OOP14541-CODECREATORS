package ec.edu.espe.cyberplaneta.controller;

import java.util.List;
import org.bson.Document;

/**
 *
 * @author Nahomi Cedeño, Code Creators, DCCO-ESPE
 */
public interface IncomeService {
    List<Document> getAllIncomes();
    void deleteIncome(int processId);
    boolean updateIncome(int processId, String name, int numberOfDocumentation, float priceBase, float taxRate, float totalPrice);
}
