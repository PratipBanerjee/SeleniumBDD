package scenariocontext;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import io.restassured.response.Response;

public class ScenarioContext {

    public Response response;

    public String petID;

    public int availablePetCount;

    public String getGMTDateTime()
    {
        String dateTime = Instant.now().toString();
        return dateTime;
    }

    public Map<String, Object> getAddPetRequestBody(String petName)
    {
        Map<String, Object> jsonMainBody = new HashMap<String, Object>();
        jsonMainBody.put("id", "0");

        Map<String, String> jsonCategory = new HashMap<>();
        jsonCategory.put("id", "0");
        jsonCategory.put("name", "string");

        jsonMainBody.put("name", petName);
        jsonMainBody.put("status", "available");

        return jsonMainBody;
    }

    public Map<String, Object> getOrderPetRequestBody(String petId, String shipmentDate)
    {
        Map<String, Object> jsonMainBody = new HashMap<String, Object>();
        jsonMainBody.put("id", "0");
        jsonMainBody.put("petId", petId);
        jsonMainBody.put("quantity", "0");
        jsonMainBody.put("shipDate", shipmentDate);
        jsonMainBody.put("status", "placed");
        jsonMainBody.put("complete", true);

        return jsonMainBody;
    }
    
}
