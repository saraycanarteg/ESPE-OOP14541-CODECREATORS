
package utils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import ec.edu.espe.cyberplaneta.model.Calendar;
import ec.edu.espe.cyberplaneta.model.TaxPayer;

import java.lang.reflect.Type;

public class TaxPayerDeserializer implements JsonDeserializer<TaxPayer> {

    @Override
    public TaxPayer deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        String id = jsonObject.get("id").getAsString();
        String email = jsonObject.get("email").getAsString();
        String name = jsonObject.get("name").getAsString();
        String password = jsonObject.get("password").getAsString();
        boolean accountingDocumentation = jsonObject.get("accountingDocumentation").getAsBoolean();
        String deliveryDate = jsonObject.get("deliveryDate").getAsString();
        String startDate = jsonObject.get("startDate").getAsString();

        Calendar calendar = new Calendar(deliveryDate, startDate);

        return new TaxPayer(id, email, name, password, accountingDocumentation, calendar);
    }
}
