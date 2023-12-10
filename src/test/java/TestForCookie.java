import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class TestForCookie {
    @Test
    public void testRestAssured(){
        Map<String,String> data = new HashMap<>();
        data.put("login","secret_login");
        data.put("password","secret_pass");
        Response response = RestAssured
                .given()
                .body(data)
                .when()
                .post("https://playground.learnqa.ru/api/get_auth_cookie")
                .andReturn();
        System.out.println("\n Pretty test");
        response.prettyPrint();
        System.out.println("\n Headers:");
        Headers responseHeaders = response.getHeaders();
        System.out.println(responseHeaders);
        System.out.println("\n Cookies:");
        Map<String,String> responseCookies = response.getCookies();
        System.out.println(responseCookies);
    }
    @Test
    public void testForCookie(){
        Map<String,String> data = new HashMap<>();
        data.put("login","secret_login");
        data.put("password","secret_pass");
        Response response = RestAssured
                .given()
                .body(data)
                .when()
                .post("https://playground.learnqa.ru/api/get_auth_cookie")
                .andReturn();

        String responseCookie = response.getCookie("auth_cookie");
        System.out.println(responseCookie);
    }
    @Test
    public void testForCookie2(){
        Map<String,String> data = new HashMap<>();
        data.put("login","secret_login");
        data.put("password","secret_pass");
        Response responseForGet = RestAssured
                .given()
                .body(data)
                .when()
                .post("https://playground.learnqa.ru/api/get_auth_cookie")
                .andReturn();

        String responseCookie = responseForGet.getCookie("auth_cookie");
        System.out.println(responseCookie);
        Map<String,String> cookies = new HashMap<>();
        if (responseCookie !=null){
            cookies.put("auth_cookie",responseCookie);
        }
        Response responseForCheck = RestAssured
                .given()
                .body(data)
                .cookies(cookies)
                .when()
                .post("https://playground.learnqa.ru/api/get_auth_cookie")
                .andReturn();
        responseForCheck.print();
    }
}
