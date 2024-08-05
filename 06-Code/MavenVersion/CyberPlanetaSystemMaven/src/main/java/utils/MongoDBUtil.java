package utils;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.Updates;
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
 * @authors Saray Canarte, Christian Bonifaz, Andres Cedeno. Code Creators,
 * DCCO-ESPE
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
            String paswordds = decryptData(storedPassword);
            if (paswordds.equals(password)) {
                isValid = true;
            }
        }
        return isValid;
    }

    public static boolean validateNameUser(String username) {
        boolean isValid = false;
        MongoDatabase database = getDatabase();
        MongoCollection<Document> collection = database.getCollection("usuarios");
        Document user = collection.find(eq("user", username)).first();
        if (user != null) {
            isValid = true;
        }
        return isValid;
    }

    public static boolean updateUser(String oldUsername, String newUsername, String newPassword) {
        MongoDatabase database = getDatabase();
        MongoCollection<Document> collection = database.getCollection("usuarios");
        Document user = collection.find(eq("user", oldUsername)).first();
        if (user != null) {
            collection.updateOne(eq("user", oldUsername), Updates.combine(
                    Updates.set("user", newUsername),
                    Updates.set("password", newPassword)
            ));
            return true;
        }
        return false;
    }

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static String[] notificaionTaxPayer(String idTaxPayer) {
        String msm = null;
        String[] data = new String[7];

        MongoDatabase database = getDatabase();
        MongoCollection<Document> collection = database.getCollection("TaxPayer");
        Document user = collection.find(eq("id", idTaxPayer)).first();

        String id = user.getString("id");
        String nameTaxpayer = user.getString("name");
        String deliveryDate = user.getString("deliveryDate");
        String startDate = user.getString("startDate");
        String cellNumber = user.getString("cellNumber");
        LocalDate deliveryDates = LocalDate.parse(deliveryDate, DATE_FORMATTER);
        long remainingDays = ec.edu.espe.cyberplaneta.controller.NotificationControl.getDaysBetweenDates(LocalDate.now(), deliveryDates);
        msm = ec.edu.espe.cyberplaneta.controller.NotificationControl.displayNotification(nameTaxpayer, deliveryDate, remainingDays);

        data[0] = id;
        data[1] = nameTaxpayer;
        data[2] = startDate;
        data[3] = deliveryDate;
        data[4] = Long.toString(remainingDays);
        data[5] = cellNumber;
        data[6] = msm;

        return data;
    }

    public static String[] DeleteTaxPayer(String idTaxPayer) {
        String msm = null;
        String[] data = new String[6];

        MongoDatabase database = getDatabase();
        MongoCollection<Document> collection = database.getCollection("TaxPayer");
        Document user = collection.find(eq("id", idTaxPayer)).first();

        String id = user.getString("id");
        String nameTaxpayer = user.getString("name");
        String email = user.getString("email");
        String password = user.getString("password");
        String cellNumber = user.getString("cellNumber");

        data[0] = id;
        data[1] = nameTaxpayer;
        data[2] = email;
        data[3] = password;
        data[4] = cellNumber;

        return data;
    }

    public static String decryptData(String texto) {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);

            if (Character.isLetter(caracter)) {
                if (caracter == 'a') {
                    resultado.append('z');
                } else if (caracter == 'A') {
                    resultado.append('Z');
                } else {
                    resultado.append((char) (caracter - 1));
                }
            } else if (Character.isDigit(caracter)) {
                if (caracter == '0') {
                    resultado.append('9');
                } else {
                    resultado.append((char) (caracter - 1));
                }
            } else {
                resultado.append(caracter);
            }
        }

        return resultado.toString();
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

    public static void saveUser(String password, String NameUser) {
        MongoDatabase database = getDatabase();
        MongoCollection<Document> collection = database.getCollection("usuarios");

        Document document = new Document("user", NameUser)
                .append("password", password);

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

    public static void createCollection(String collectionName,String id, int idProcess, String nameProcess, float priceProcess, float rateTax) {
        MongoDatabase database = getDatabase();

    boolean collectionExists = database.listCollectionNames()
            .into(new ArrayList<>())
            .contains(collectionName);

    if (!collectionExists) {
        database.createCollection(collectionName);
    }

    MongoCollection<Document> collection = database.getCollection(collectionName);

    long count = collection.countDocuments();

    Document document = new Document("id", id)
            .append("processId", idProcess)
            .append("processName", nameProcess)
            .append("price", priceProcess)
            .append("taxRate", rateTax);

    collection.insertOne(document);
    }
    public static Document getProcessById(String id,String colection) {
    MongoDatabase database = getDatabase();
    MongoCollection<Document> collection = database.getCollection(colection);
    return collection.find(eq("id", id)).first();
}

    public static void deleteDocumentById(String id,String colection) {
    MongoDatabase database = getDatabase();
    MongoCollection<Document> collection = database.getCollection(colection);
    collection.deleteOne(eq("id", id));
}
    
    public static List<Document> getAllProcess(String contributorId) {
        MongoDatabase database = getDatabase();
        MongoCollection<Document> collection = database.getCollection(contributorId);
        List<Document> documents = new ArrayList<>();

        try (MongoCursor<Document> cursor = collection.find().iterator()) {
            while (cursor.hasNext()) {
                documents.add(cursor.next());
            }
        }

        return documents;
    }
    public static void updateCollection(String collectionName, String id, int idProcess, String nameProcess, float priceProcess, float rateTax) {
        MongoDatabase database = getDatabase();
        MongoCollection<Document> collection = database.getCollection(collectionName);

        Document query = new Document("id", id);
        Document newDocument = new Document()
                .append("id", id)
                .append("processId", idProcess)
                .append("processName", nameProcess)
                .append("price", priceProcess)
                .append("taxRate", rateTax);

        Document updateObject = new Document("$set", newDocument);
        collection.updateOne(query, updateObject);
    }
    public static boolean generalIdExists(String collectionName, String id) {
        MongoDatabase database = getDatabase();
        MongoCollection<Document> collection = database.getCollection(collectionName);
        Document query = new Document("id", id);
        return collection.countDocuments(query) > 0;
       
    }
    public static boolean verificationIdTaxProcess(String id) {
        MongoDatabase database = getDatabase();
        MongoCollection<Document> collection = database.getCollection(id);
        Document query = new Document("id", id);
        return collection.countDocuments(query) > 0;
    }
    
}
