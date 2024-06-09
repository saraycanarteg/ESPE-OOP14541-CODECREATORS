package utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import ec.edu.espe.cyberplaneta.model.TaxPayer;

import java.lang.reflect.Type;

public class TaxPayerSerializer implements JsonSerializer<TaxPayer> {
    @Override
    public JsonElement serialize(TaxPayer taxPayer, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", taxPayer.getId());
        jsonObject.addProperty("email", taxPayer.getEmail());
        jsonObject.addProperty("name", taxPayer.getName());
        jsonObject.addProperty("password", taxPayer.getPassword());
        jsonObject.addProperty("accountingDocumentation", taxPayer.isAccountingDocumentation());

        if (taxPayer.getCalendar() != null) {
            jsonObject.addProperty("deliveryDate", taxPayer.getCalendar().getDeliveryDate());
            jsonObject.addProperty("startDate", taxPayer.getCalendar().getStartDate());
        } else {
            jsonObject.addProperty("deliveryDate", "No date");
            jsonObject.addProperty("startDate", "No date");
        }

        return jsonObject;
    }
}
