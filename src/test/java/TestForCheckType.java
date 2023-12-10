import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class TestForCheckType {
    @Test
    public void testRestAssured() {
        Response response = RestAssured
                .get("https://playground.learnqa.ru/api/check_type")
                .andReturn();
        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
    }

    @Test
    public void test500() {
        Response response = RestAssured
                .get("https://playground.learnqa.ru/api/get_500")
                .andReturn();
        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
    }

    @Test
    public void test303() {
        Response response = RestAssured
                .given()
                .redirects()
                .follow(false)
                .when()
                .get("https://playground.learnqa.ru/api/get_303")
                .andReturn();
        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
    }

    @Test
    public void testForHeaders() {
        Map<String,String> headers = new HashMap<>();
        headers.put("myHeader1", "myValue1");
        headers.put("myHeader2", "myValue2");
        Response response = RestAssured
                .given()
                .headers(headers)
                .when()
                .get("https://playground.learnqa.ru/api/show_all_headers")
                .andReturn();
        response.prettyPrint();

        Headers responseHeaders = response.getHeaders();
        System.out.println(responseHeaders);
    }
    @Test
    public void testForHLocation() {
        Map<String,String> headers = new HashMap<>();
        headers.put("myHeader1", "myValue1");
        headers.put("myHeader2", "myValue2");
        Response response = RestAssured
                .given()
                .redirects()
                .follow(false)
                .when()
                .get("https://playground.learnqa.ru/api/get_303")
                .andReturn();
        response.prettyPrint();

        String locationHeader = response.getHeader("location");
        System.out.println(locationHeader);
    }
}