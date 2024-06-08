package utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import ec.edu.espe.cyberplaneta.model.TaxPayer;

import java.lang.reflect.Type;

public class TaxPayerSerializer implements JsonSerializer<TaxPayer> {
@Override
public JsonElement serialize(TaxPayer taxPayer, Type typeOfSrc, JsonSerializationContext context) {
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("id", taxPayer.getId());
    jsonObject.addProperty("email", taxPayer.getEmail());
    jsonObject.addProperty("name", taxPayer.getName());
    jsonObject.addProperty("password", taxPayer.getPassword());
    jsonObject.addProperty("accountingDocumentation", taxPayer.isAccountingDocumentation());
    jsonObject.addProperty("deliveryDate", taxPayer.getDeliveryDate());
    jsonObject.addProperty("startDate", taxPayer.getStartDate());
    return jsonObject;
}

}