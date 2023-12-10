import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetJsonHomework {
    @Test
    public void testGetJsonHomework2(){
        JsonPath response = RestAssured
                .get("https://playground.learnqa.ru/api/get_json_homework")
                .jsonPath();
        String message = response.getString("messages.message[1]");
        System.out.println("text in the second message is : " + message);
    }
} 
