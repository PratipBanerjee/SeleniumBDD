package scenariocontext;

import java.util.HashMap;
import java.util.Map;

import io.restassured.response.Response;

public class ScenarioContext {

    public Response response;

    public String petID;

    public int availablePetCount;

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
    
}
