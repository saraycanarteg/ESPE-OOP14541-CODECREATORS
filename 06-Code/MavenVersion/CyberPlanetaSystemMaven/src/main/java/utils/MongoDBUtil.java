package utils;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import ec.edu.espe.cyberplaneta.model.TaxPayer;
import ec.edu.espe.cyberplaneta.model.TaxProcess;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @authors Saray Canarte, Christian Bonifaz, Andres Cedeno. Code Creators, DCCO-ESPE
 */
public class MongoDBUtil {

    private static final String DATABASE_NAME = "CyberPlaneta";

    public static MongoDatabase getDatabase() {
        MongoClient mongoClient = MongoClientSingleton.getInstance();
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

    public static boolean validateUser(String username, String password) {
        boolean isValid = false;

        MongoDatabase database = getDatabase();
        MongoCollection<Document> collection = database.getCollection("usuarios");
        Document user = collection.find(eq("user", username)).first();
        if (user != null) {
            String storedPassword = user.getString("password");
            if (storedPassword.equals(password)) {
                isValid = true;
            }
        }
        return isValid;
    }

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static String[] notificaionTaxPayer(String idTaxPayer) {
        String msm = null;
        String[] data = new String[6];

        MongoDatabase database = getDatabase();
        MongoCollection<Document> collection = database.getCollection("TaxPayer");
        Document user = collection.find(eq("id", idTaxPayer)).first();

        String id = user.getString("id");
        String nameTaxpayer = user.getString("name");
        String deliveryDate = user.getString("deliveryDate");
        String startDate = user.getString("startDate");
        LocalDate deliveryDates = LocalDate.parse(deliveryDate, DATE_FORMATTER);
        long remainingDays = ec.edu.espe.cyberplaneta.controller.NotificationControl.getDaysBetweenDates(LocalDate.now(), deliveryDates);
        msm = ec.edu.espe.cyberplaneta.controller.NotificationControl.displayNotification(nameTaxpayer, deliveryDate, remainingDays);

        data[0] = id;
        data[1] = nameTaxpayer;
        data[2] = startDate;
        data[3] = deliveryDate;
        data[4] = Long.toString(remainingDays);
        data[5] = msm;

        return data;
    }

    public static String[] DeleteTaxPayer(String idTaxPayer) {
        String msm = null;
        String[] data = new String[5];

        MongoDatabase database = getDatabase();
        MongoCollection<Document> collection = database.getCollection("TaxPayer");
        Document user = collection.find(eq("id", idTaxPayer)).first();

        String id = user.getString("id");
        String nameTaxpayer = user.getString("name");
        String email = user.getString("email");
        String password = user.getString("password");

        data[0] = id;
        data[1] = nameTaxpayer;
        data[2] = email;
        data[3] = password;

        return data;
    }

    public static boolean verificationIdTaxpayer(String id) {
        boolean verification = false;
        MongoDatabase database = getDatabase();
        MongoCollection<Document> collection = database.getCollection("TaxPayer");
        Document user = collection.find(eq("id", id)).first();
        if (user == null) {
            verification = true;
        }
        return verification;
    }

    public static void deleteDocumentById(String id) {
        MongoDatabase database = getDatabase();
        MongoCollection<Document> collection = database.getCollection("TaxPayer");
        collection.deleteOne(eq("id", id));
    }

    public static void saveTaxPayer(TaxPayer taxPayer) {
        MongoDatabase database = getDatabase();
        MongoCollection<Document> collection = database.getCollection("TaxPayer");

        Document document = new Document("id", taxPayer.getId())
                .append("email", taxPayer.getEmail())
                .append("name", taxPayer.getName())
                .append("password", taxPayer.getPassword())
                .append("accountingDocumentation", taxPayer.isAccountingDocumentation())
                .append("deliveryDate", taxPayer.getdeliveryDate())
                .append("startDate", taxPayer.getStartDate());

        collection.insertOne(document);
    }

    public static List<Document> getAllTaxPayers() {
        MongoDatabase database = getDatabase();
        MongoCollection<Document> collection = database.getCollection("TaxPayer");
        List<Document> documents = new ArrayList<>();

        try (MongoCursor<Document> cursor = collection.find().iterator()) {
            while (cursor.hasNext()) {
                documents.add(cursor.next());
            }
        }

        return documents;
    }

    public static Document getTaxPayerById(String id) {
        MongoDatabase database = getDatabase();
        MongoCollection<Document> collection = database.getCollection("TaxPayer");
        return collection.find(eq("id", id)).first();
    }

    public static void updateTaxPayer(Document updatedTaxPayer) {
        MongoDatabase database = getDatabase();
        MongoCollection<Document> collection = database.getCollection("TaxPayer");
        collection.replaceOne(eq("id", updatedTaxPayer.getString("id")), updatedTaxPayer);
    }

    public static void createCollection(String collectionName, int idProcess, String nameProcess, float priceProcess, float rateTax) {
        MongoDatabase database = getDatabase();

        boolean collectionExists = database.listCollectionNames()
                .into(new ArrayList<>())
                .contains(collectionName);

        if (!collectionExists) {
            database.createCollection(collectionName);
        }

        MongoCollection<Document> collection = database.getCollection(collectionName);

        Document document = new Document("processId", idProcess)
                .append("processName", nameProcess)
                .append("price", priceProcess)
                .append("taxRate", rateTax);

        collection.insertOne(document);
    }
}
