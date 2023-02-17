package test;

import baseUrl.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.JsonplaceholderTestData;
import utilities.JsonUtil;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

public class M17_PutRequest01 extends JsonplaceholderBaseUrl {
    /*  https://jsonplaceholder.typicode.com/todos/198 URL ine aşağıdaki body gönerdiğimde
        {   "userId": 21,
            "title": "Wash the dishes",
            "completed": false  }
        Dönen response un status kodunun 200 ve body kısmının aşağıdaki gibi olduğunu test edin
        {   "userId": 21,
            "title": "Wash the dishes",
            "completed": false,
            "id": 198   }   */

    // Matchers without Testdata class
    @Test
    public void test01(){
        spec03.pathParams("p1", "todos", "p2", "198");

        JSONObject putRequest = new JSONObject();
        putRequest.put("userId", 21);
        putRequest.put("title", "Wash the dishes");
        putRequest.put("completed", false);

        Response response = given().contentType(ContentType.JSON).spec(spec03).
                            body(putRequest.toString()).when().put("{p1}/{p2}");

        response.then().assertThat().statusCode(200).body("userId", equalTo(putRequest.get("userId")),
                "title", equalTo(putRequest.get("title")),
                "completed", equalTo(putRequest.get("completed")));
    }

    // Jsonpath
    @Test
    public void test03(){
        spec03.pathParams("p1", "todos", "p2", "198");

        JsonplaceholderTestData jsonplaceholderTestData = new JsonplaceholderTestData();
        JSONObject expData = jsonplaceholderTestData.todos198PutData();
        Response response = given().contentType(ContentType.JSON).spec(spec03).body(expData.toString()).when().put("{p1}/{p2}");

        JsonPath json = response.jsonPath();
        assertEquals(expData.get("userId"), json.getInt("userId"));
        assertEquals(expData.get("title"), json.getString("title"));
        assertEquals(expData.get("completed"), json.getBoolean("completed"));
        assertEquals(expData.get("id"), json.getInt("id"));
    }

    // Deserialization
    @Test
    public void test04(){
        spec03.pathParams("p1", "todos", "p2", "198");
        JsonplaceholderTestData jsonplaceholderTestData = new JsonplaceholderTestData();
        JSONObject expData = jsonplaceholderTestData.todos198PutData();
        Response response = given().contentType(ContentType.JSON).spec(spec03).body(expData.toString()).when().put("{p1}/{p2}");
        HashMap<String, Object> actData = response.as(HashMap.class);
        System.out.println("actData = " + actData);
        assertEquals(200, response.statusCode());
        assertEquals(expData.get("userId"), actData.get("userId"));
        assertEquals(expData.get("title"), actData.get("title"));
        assertEquals(expData.get("completed"), actData.get("completed"));
        assertEquals(expData.get("id"), actData.get("id"));

        /*  public JSONObject todos198PutData () {
            JSONObject putData = new JSONObject();
            putData.put("userId", 21);
            putData.put("title", "Wash the dishes");
            putData.put("completed", false);
            putData.put("id", 198);
            return putData;  */

    /*  https://jsonplaceholder.typicode.com/todos/198 URL ine aşağıdaki body gönerdiğimde
        {   "userId": 21,
            "title": "Wash the dishes",
            "completed": false  }
        Dönen response un status kodunun 200 ve body kısmının aşağıdaki gibi olduğunu test edin
        {   "userId": 21,
            "title": "Wash the dishes",
            "completed": false,
            "id": 198   }   */
    }

    // Pojo
    @Test
    public void test05(){
        spec03.pathParams("p1", "todos", "p2", "198");

        //1) URL
        //2) EXPECTED DATA
        //3) REQUEST & RESPONSE
        //4) ASSERTION

    /*  https://jsonplaceholder.typicode.com/todos/198 URL ine aşağıdaki body gönerdiğimde
        {   "userId": 21,
            "title": "Wash the dishes",
            "completed": false  }
        Dönen response un status kodunun 200 ve body kısmının aşağıdaki gibi olduğunu test edin
        {   "userId": 21,
            "title": "Wash the dishes",
            "completed": false,
            "id": 198   }   */
    }

    // ObjectMapper
    @Test
    public void test06(){

        //1) URL
        spec03.pathParams("p1", "todos", "p2", "198");

        //2) EXPECTED DATA
        String putRequestdata = "{   \"userId\": 21,\n" +
                "            \"title\": \"Wash the dishes\",\n" +
                "            \"completed\": false  }";

        HashMap putRequestJsondata = JsonUtil.convertJsonToJava(putRequestdata, HashMap.class);

        String expJsonData = "{\n" +
                "    \"userId\": 21,\n" +
                "    \"title\": \"Wash the dishes\",\n" +
                "    \"completed\": false,\n" +
                "    \"id\": 198\n" +
                "}";

        HashMap expData = JsonUtil.convertJsonToJava(expJsonData, HashMap.class);

        //3) REQUEST & RESPONSE
        Response response = given().contentType(ContentType.JSON).spec(spec03).body(putRequestJsondata).when().put("{p1}/{p2}");

        //4) ASSERTION
        HashMap actData = JsonUtil.convertJsonToJava(response.asString(), HashMap.class);

        assertEquals(expData.get("userId"), actData.get("userId"));
        assertEquals(expData.get("title"), actData.get("title"));
        assertEquals(expData.get("completed"), actData.get("completed"));
        assertEquals(expData.get("id"), actData.get("id"));


    /*  https://jsonplaceholder.typicode.com/todos/198 URL ine aşağıdaki body gönerdiğimde
        {   "userId": 21,
            "title": "Wash the dishes",
            "completed": false  }
        Dönen response un status kodunun 200 ve body kısmının aşağıdaki gibi olduğunu test edin
        {   "userId": 21,
            "title": "Wash the dishes",
            "completed": false,
            "id": 198   }   */
    }

}
