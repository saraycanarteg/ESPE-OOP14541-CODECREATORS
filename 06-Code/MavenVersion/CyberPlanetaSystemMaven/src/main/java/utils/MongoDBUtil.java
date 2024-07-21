package utils;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import ec.edu.espe.cyberplaneta.model.TaxProcess;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class MongoDBUtil {

    private static final String URI = "mongodb+srv://canarte:canarte@cluster0.devwm9s.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    private static final String DATABASE_NAME = "CyberPlaneta";

    private static MongoDatabase getDatabase() {
        MongoClient mongoClient = MongoClients.create(URI);
        return mongoClient.getDatabase(DATABASE_NAME);
    }

    public static void saveTaxProcess(TaxProcess taxProcess, int numberOfDocumentation) {
        MongoDatabase database = getDatabase();
        MongoCollection<Document> collection = database.getCollection("Incomes");

        BigDecimal price = BigDecimal.valueOf(taxProcess.getPriceList().getPrice()).setScale(2, RoundingMode.HALF_UP);
        BigDecimal total = BigDecimal.valueOf(taxProcess.getTotal()).setScale(2, RoundingMode.HALF_UP);

        Document document = new Document("processId", taxProcess.getPriceList().getProcessId())
                .append("processName", taxProcess.getPriceList().getProcessName())
                .append("price", price.doubleValue())
                .append("taxRate", taxProcess.getPriceList().getTaxRate())
                .append("numberOfDocumentation", numberOfDocumentation)
                .append("total", total.doubleValue());

        collection.insertOne(document);
    }

    public static List<Document> getAllIncomes() {
        MongoDatabase database = getDatabase();
        MongoCollection<Document> collection = database.getCollection("Incomes");
        List<Document> documents = new ArrayList<>();

        try (MongoCursor<Document> cursor = collection.find().iterator()) {
            while (cursor.hasNext()) {
                documents.add(cursor.next());
            }
        }

        return documents;
    }
}




