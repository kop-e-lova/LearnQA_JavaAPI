import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

public class ParsingJsonTest {
    @Test
    public void testParsingJson() {
        JsonPath response = RestAssured
                .get("https://playground.learnqa.ru/api/get_json_homework")
                .jsonPath();
        //        response.prettyPrint();

        System.out.println(response.getList("messages.message").get(1));
    }
}