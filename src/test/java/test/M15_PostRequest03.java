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

public class M15_PostRequest03 extends JsonplaceholderBaseUrl {

    /* https://jsonplaceholder.typicode.com/todos URL ine aşağıdaki body gönderildiğinde,
     {  "userId": 55,
        "title": "Tidy your room",
        "completed": false  }
    Dönen response un Status kodunun 201 ve response body nin aşağıdaki gibi olduğunu test edin
   {    "userId": 55,
        "title": "Tidy your room",
        "completed": false,
        "id": 201   }   */

    // Matchers without Testdata class
    @Test
    public void test01(){
        spec03.pathParams("p1", "todos");

        JSONObject tidyPostData = new JSONObject();
        tidyPostData.put("userId", 55);
        tidyPostData.put("title", "Tidy your room");
        tidyPostData.put("completed", false);

        Response response = given().spec(spec03).contentType(ContentType.JSON).
                            body(tidyPostData.toString()).when().post("{p1}");

        response.then().assertThat().statusCode(201).body("userId", equalTo(tidyPostData.get("userId")),
                "title", equalTo(tidyPostData.get("title")),
                "completed", equalTo(tidyPostData.get("completed")));
    }

    // Jsonpath
    @Test
    public void test03(){
        spec03.pathParams("p1", "todos");
        JsonplaceholderTestData jsonplaceholderTestData = new JsonplaceholderTestData();
        JSONObject expData = jsonplaceholderTestData.setUpTidyPostData();

        Response response = given().contentType(ContentType.JSON).spec(spec03).body(expData.toString()).when().post("{p1}");
        JsonPath json = response.jsonPath();

        assertEquals(expData.get("id"), json.getInt("id"));
        assertEquals(expData.get("userId"), json.getInt("userId"));
        assertEquals(expData.get("statusCode"), json.getInt("statusCode"));
        assertEquals(expData.get("title"), json.getString("title"));
        assertEquals(expData.get("completed"), json.getBoolean("completed"));

        /* tidyPostData.put("userId", 55);
           tidyPostData.put("title", "Tidy your room");
           tidyPostData.put("completed", false); */
    }

    // Deserialization
    @Test
    public void test04(){
        spec03.pathParams("p1", "todos");
        JSONObject postData = new JSONObject();
        postData.put("userId", 55);
        postData.put("title", "Tidy your room");
        postData.put("completed", false);

        Response response = given().contentType(ContentType.JSON).spec(spec03).body(postData.toString()).when().post("{p1}");

        HashMap<String, Object> actData = response.as(HashMap.class);
        System.out.println("actData = " + actData);
        assertEquals(postData.get("userId"), actData.get("userId") );
        assertEquals(postData.get("title"), actData.get("title"));
        assertEquals(postData.get("completed"), actData.get("completed"));
        assertEquals(201, actData.get("id"));

    /* https://jsonplaceholder.typicode.com/todos URL ine aşağıdaki body gönderildiğinde,
     {  "userId": 55,
        "title": "Tidy your room",
        "completed": false  }
    Dönen response un Status kodunun 201 ve response body nin aşağıdaki gibi olduğunu test edin
   {    "userId": 55,
        "title": "Tidy your room",
        "completed": false,
        "id": 201   }   */
    }

    // Pojo
    @Test
    public void test05(){
        spec03.pathParams("p1", "todos");

        //1) URL
        //2) EXPECTED DATA
        //3) REQUEST & RESPONSE
        //4) ASSERTION

    /* https://jsonplaceholder.typicode.com/todos URL ine aşağıdaki body gönderildiğinde,
     {  "userId": 55,
        "title": "Tidy your room",
        "completed": false  }
    Dönen response un Status kodunun 201 ve response body nin aşağıdaki gibi olduğunu test edin
   {    "userId": 55,
        "title": "Tidy your room",
        "completed": false,
        "id": 201   }   */
    }

    // ObjectMapper
    @Test
    public void test06(){

        //1) URL
        spec03.pathParams("p1", "todos");

        //2) EXPECTED DATA
        String postRequestdata = "{  \"userId\": 55,\n" +
                "        \"title\": \"Tidy your room\",\n" +
                "        \"completed\": false  }";

        HashMap postData = JsonUtil.convertJsonToJava(postRequestdata, HashMap.class);

        String expJsonData = "{\n" +
                "    \"userId\": 55,\n" +
                "    \"title\": \"Tidy your room\",\n" +
                "    \"completed\": false,\n" +
                "    \"id\": 201\n" +
                "}";

        HashMap expdata = JsonUtil.convertJsonToJava(expJsonData, HashMap.class);

        //3) REQUEST & RESPONSE
        Response response = given().contentType(ContentType.JSON).spec(spec03).body(postData).when().post("{p1}");

        //4) ASSERTION
        HashMap actdata = JsonUtil.convertJsonToJava(response.asString(), HashMap.class);

        assertEquals(expdata.get("userId"), actdata.get("userId"));
        assertEquals(expdata.get("title"), actdata.get("title"));
        assertEquals(expdata.get("completed"), actdata.get("completed"));
        assertEquals(expdata.get("id"), actdata.get("id"));

    /* https://jsonplaceholder.typicode.com/todos URL ine aşağıdaki body gönderildiğinde,
     {  "userId": 55,
        "title": "Tidy your room",
        "completed": false  }
    Dönen response un Status kodunun 201 ve response body nin aşağıdaki gibi olduğunu test edin
   {    "userId": 55,
        "title": "Tidy your room",
        "completed": false,
        "id": 201   }   */
    }

}
