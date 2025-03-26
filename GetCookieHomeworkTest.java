import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class GetCookieHomeworkTest {
    @Test
    public void testGetCookieMethod(){
        Response responseGetCookie = RestAssured
                .get("https://playground.learnqa.ru/api/homework_cookie")
                .andReturn();
        Map<String, String> cookies = responseGetCookie.getCookies();
        //System.out.println(cookies);
        assertFalse(cookies.isEmpty(), "There's no cookie in response");
        assertTrue(cookies.containsKey("HomeWork"), "There's no obligatory cookie 'Homework'");
        assertEquals("hw_value", responseGetCookie.getCookie("HomeWork"), "Incorrect value for cookie 'Homework'");
    }
}
