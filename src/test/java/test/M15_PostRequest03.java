package test;

import baseUrl.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.JsonplaceholderTestData;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

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

        Assert.assertEquals(expData.get("id"), json.getInt("id"));
        Assert.assertEquals(expData.get("userId"), json.getInt("userId"));
        Assert.assertEquals(expData.get("statusCode"), json.getInt("statusCode"));
        Assert.assertEquals(expData.get("title"), json.getString("title"));
        Assert.assertEquals(expData.get("completed"), json.getBoolean("completed"));

        /* tidyPostData.put("userId", 55);
           tidyPostData.put("title", "Tidy your room");
           tidyPostData.put("completed", false); */
    }

    // Deserialization
    @Test
    public void test04(){
        spec03.pathParams("p1", "todos");

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
        spec03.pathParams("p1", "todos");

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
