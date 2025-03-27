import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class GetHeadersHomeworkTest {
    @Test
    public void testGetHeadersMethod(){
        Response responseGetHeaders = RestAssured
                .get("https://playground.learnqa.ru/api/homework_header")
                .andReturn();
        Headers headers = responseGetHeaders.getHeaders();
        System.out.println(headers);
        assertTrue(headers.exist(), "There are no headers in response");
        assertTrue(headers.hasHeaderWithName("x-secret-homework-header"),
                "There's no header with name 'x-secret-homework-header'");
        assertEquals(
                "Some secret value",
                headers.get("x-secret-homework-header").getValue(),
                " Wrong value for 'x-secret-homework-header'; value must be 'Some secret value'."
        );
        //assertTrue(cookies.containsKey("HomeWork"), "There's no obligatory cookie 'Homework'");
        //assertEquals("hw_value", responseGetCookie.getCookie("HomeWork"), "Incorrect value for cookie 'Homework'");
    }
}
