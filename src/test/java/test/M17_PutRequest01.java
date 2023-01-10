package test;

import baseUrl.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.JsonplaceholderTestData;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

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
        Assert.assertEquals(expData.get("userId"), json.getInt("userId"));
        Assert.assertEquals(expData.get("title"), json.getString("title"));
        Assert.assertEquals(expData.get("completed"), json.getBoolean("completed"));
        Assert.assertEquals(expData.get("id"), json.getInt("id"));
    }

    // Deserialization
    @Test
    public void test04(){
        spec03.pathParams("p1", "todos", "p2", "198");

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
        spec03.pathParams("p1", "todos", "p2", "198");

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
