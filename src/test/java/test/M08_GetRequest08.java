package test;

import baseUrl.JsonplaceholderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testData.JsonplaceholderTestData;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

public class M08_GetRequest08 extends JsonplaceholderBaseUrl {

    /*
    https://jsonplaceholder.typicode.com/todos/2 url ‘ine istek gönderildiğinde,
    Dönen response un
    Status kodunun 200, dönen body de,
    "completed": değerinin false
    "title”: değerinin “quis ut nam facilis et officia qui”
    "userId" sinin 1 ve
    header değerlerinden
    "Via" değerinin “1.1 vegur” ve
    "Server" değerinin “cloudflare” olduğunu test edin…
    */


    // Matchers without Testdata class
    @Test
    public void test01(){
        spec03.pathParams("p1", "todos", "p2", "2");
        Response response = given().spec(spec03).when().get("{p1}/{p2}");

        response.then().assertThat().statusCode(200).body("completed", equalTo(false),
                "title", equalTo("quis ut nam facilis et officia qui"),
                "userId", equalTo(1)).
                headers("Via", equalTo("1.1 vegur"),
                "Server", equalTo("cloudflare"));
    }

    // Matchers with Testdata class
    @Test
    public void test02(){
        spec03.pathParams("p1", "todos", "p2", "2");
        Response response = given().spec(spec03).when().get("{p1}/{p2}");

        JsonplaceholderTestData todos2Object = new JsonplaceholderTestData();
        HashMap<String, Object> expData = todos2Object.todos2Data();

        response.then().assertThat().statusCode(equalTo(expData.get("statusCode"))).
                        body("completed", equalTo(expData.get("completed")),
                        "title", equalTo(expData.get("title")),
                        "userId", equalTo(expData.get("userId"))).
                headers("Via", equalTo(expData.get("Via")),
                        "Server", equalTo(expData.get("Server")));
    }

    // Jsonpath
    @Test
    public void test03(){
        spec03.pathParams("p1", "todos", "p2", "2");
        Response response = given().spec(spec03).when().get("{p1}/{p2}");

        JsonPath json = response.jsonPath();
        assertEquals(false, json.getBoolean("completed"));
        assertEquals("quis ut nam facilis et officia qui", json.getString("title"));
        assertEquals(1, json.getInt("userId"));
    }

    // Deserialization
    @Test
    public void test04(){
        spec03.pathParams("p1", "todos", "p2", "2");
        Response response = given().spec(spec03).when().get("{p1}/{p2}");

    /*  Status kodunun 200, dönen body de,
            "completed": değerinin false
            "title”: değerinin “quis ut nam facilis et officia qui”
            "userId" sinin 1 ve
        header değerlerinden
            "Via" değerinin “1.1 vegur” ve
            "Server" değerinin “cloudflare” olduğunu test edin…   */
    }

    // Pojo
    @Test
    public void test05(){
        spec03.pathParams("p1", "todos", "p2", "2");
        Response response = given().spec(spec03).when().get("{p1}/{p2}");

    /*  Status kodunun 200, dönen body de,
            "completed": değerinin false
            "title”: değerinin “quis ut nam facilis et officia qui”
            "userId" sinin 1 ve
        header değerlerinden
            "Via" değerinin “1.1 vegur” ve
            "Server" değerinin “cloudflare” olduğunu test edin…   */
    }

    // ObjectMapper
    @Test
    public void test06(){
        spec03.pathParams("p1", "todos", "p2", "2");
        Response response = given().spec(spec03).when().get("{p1}/{p2}");

    /*  Status kodunun 200, dönen body de,
            "completed": değerinin false
            "title”: değerinin “quis ut nam facilis et officia qui”
            "userId" sinin 1 ve
        header değerlerinden
            "Via" değerinin “1.1 vegur” ve
            "Server" değerinin “cloudflare” olduğunu test edin…   */
    }

}
