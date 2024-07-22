/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.cyberplaneta.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import ec.edu.espe.cyberplaneta.model.PriceList;
import ec.edu.espe.cyberplaneta.model.TaxPayer;
import ec.edu.espe.cyberplaneta.model.TaxProcess;
import org.bson.Document;
import utils.MongoDBUtil;

/**
 *
 * @author Andres Cedeno,Code Creators,DCCO-ESPE
 */
public class TaxPayerManager {
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
                .append("deliveryDate", taxpayer.getdeliveryDate());

        collection.insertOne(document);
    }
}

