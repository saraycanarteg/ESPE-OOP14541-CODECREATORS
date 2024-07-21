package utils;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;
import ec.edu.espe.cyberplaneta.model.TaxProcess;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
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
    
    
    
    
    public static boolean validateUser(String username, String password) {
        boolean isValid = false;

        try (MongoClient mongoClient = MongoClients.create(URI)) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> collection = database.getCollection("usuarios");
            Document user = collection.find(eq("user", username)).first();
            if (user != null) {
                String storedPassword = user.getString("password");
                if (storedPassword.equals(password)) {
                    isValid = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isValid;
    }

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static String[] notificaionTaxPayer(String idTaxPayer) {
        String msm = null;
        String[] data = new String[6];
     
        try (MongoClient mongoClient = MongoClients.create(URI)) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> collection = database.getCollection("TaxPayerData");
            Document user = collection.find(eq("id", idTaxPayer)).first();

            String id = user.getString("id");
            String nameTaxpayer = user.getString("name");
            String deliveryDate = user.getString("deliveryDate");
            String startDate = user.getString("startDate");
            LocalDate deliveryDates = LocalDate.parse(deliveryDate, DATE_FORMATTER);
            long remainingDays = getDaysBetweenDates(LocalDate.now(), deliveryDates);
            msm = displayNotification(nameTaxpayer, deliveryDate, remainingDays);

            data[0] = id;
            data[1] = nameTaxpayer;
            data[2] = startDate;
            data[3] = deliveryDate;
            data[4] = Long.toString(remainingDays);
            data[5] = msm;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    private static long getDaysBetweenDates(LocalDate startDate, LocalDate endDate) {
        return ChronoUnit.DAYS.between(startDate, endDate);
    }

    private static String displayNotification(String nameTaxpayer, String deliveryDate, long remainingDays) {
        String msm = null;
        if (remainingDays > 0) {
            msm = "Tienes " + remainingDays + " días para la entrega";
        } else if (remainingDays == 0) {
            msm = "El proceso se entrega hoy";
        } else {
            msm = "El proceso ha sido entregado o está retrasado en su entrega";
        }
        return msm;
    }
}




