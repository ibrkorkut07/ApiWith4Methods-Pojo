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


public class M18_PatchRequest01 extends JsonplaceholderBaseUrl {

    /*  https://jsonplaceholder.typicode.com/todos/198 URL ine aşağıdaki body gönderdiğimde
        { "title": "API calismaliyim" }
        Dönen response un status kodunun 200 ve body kısmının aşağıdaki gibi olduğunu test edin
        {   "userId": 10,
            "title": "API calismaliyim"
            "completed": true,
            "id": 198   }   */

    // Matchers without Testdata class
    @Test
    public void test01(){
        spec03.pathParams("p1", "todos", "p2", "198");

        JSONObject patchData = new JSONObject();
        patchData.put("title", "API calismaliyim");

        JSONObject expData = new JSONObject();
        expData.put("userId", 10);
        expData.put("title", "API calismaliyim");
        expData.put("completed", true);
        expData.put("id", 198);

        Response response = given().spec(spec03).body(patchData.toString()).when().patch("{p1}/{p2}");

        response.then().assertThat().statusCode(200).body("userId", equalTo(expData.get("userId")),
                "title", equalTo(expData.get("title")),
                "completed", equalTo(expData.get("completed")),
                "id", equalTo(expData.get("id")));
    }

    // Jsonpath
    @Test
    public void test03(){
        spec03.pathParams("p1", "todos", "p2", "198");

        JSONObject patchData = new JSONObject();
        patchData.put("title", "API calismaliyim");
        JsonplaceholderTestData jsonplaceholderTestData = new JsonplaceholderTestData();
        JSONObject expData = jsonplaceholderTestData.expStudyPatchData();

        Response response = given().contentType(ContentType.JSON).spec(spec03).body(patchData.toString()).when().patch("{p1}/{p2}");

        response.then().assertThat().statusCode(200);

        JsonPath json = response.jsonPath();
        Assert.assertEquals(expData.get("userId"), json.getInt("userId"));
        Assert.assertEquals(expData.get("id"), json.getInt("id"));
        Assert.assertEquals(expData.get("title"), json.getString("title"));
        Assert.assertEquals(expData.get("completed"), json.getBoolean("completed"));
    }

    // Deserialization
    @Test
    public void test04(){
        spec03.pathParams("p1", "todos", "p2", "198");
        JSONObject patchData = new JSONObject();
        patchData.put("title", "API calismaliyim");
        JsonplaceholderTestData jsonplaceholderTestData = new JsonplaceholderTestData();
        JSONObject expData = jsonplaceholderTestData.expStudyPatchData();

        Response response = given().contentType(ContentType.JSON).spec(spec03).body(patchData.toString()).when().patch("{p1}/{p2}");
        HashMap<String, Object> actData = response.as(HashMap.class);

        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals(expData.get("userId"), actData.get("userId"));
        Assert.assertEquals(expData.get("title"), actData.get("title"));
        Assert.assertEquals(expData.get("completed"), actData.get("completed"));
        Assert.assertEquals(expData.get("id"), actData.get("id"));

        /*  public JSONObject expStudyPatchData() {
            JSONObject patchData = new JSONObject();
            patchData.put("userId", 10);
            patchData.put("title", "API calismaliyim");
            patchData.put("completed", true);
            patchData.put("id", 198);
            return patchData;   */
    /*  https://jsonplaceholder.typicode.com/todos/198 URL ine aşağıdaki body gönderdiğimde
        { "title": "API calismaliyim" }
        Dönen response un status kodunun 200 ve body kısmının aşağıdaki gibi olduğunu test edin
        {   "userId": 10,
            "title": "API calismaliyim"
            "completed": true,
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

    /*  https://jsonplaceholder.typicode.com/todos/198 URL ine aşağıdaki body gönderdiğimde
        { "title": "API calismaliyim" }
        Dönen response un status kodunun 200 ve body kısmının aşağıdaki gibi olduğunu test edin
        {   "userId": 10,
            "title": "API calismaliyim"
            "completed": true,
            "id": 198   }   */
    }

    // ObjectMapper
    @Test
    public void test06(){

        //1) URL
        spec03.pathParams("p1", "todos", "p2", "198");

        //2) EXPECTED DATA
        String patchRequestdata = "{ \"title\": \"API calismaliyim\" }";

        HashMap patchRequestJsondata = JsonUtil.convertJsonToJava(patchRequestdata, HashMap.class);

        String expJsonData = "{\n" +
                "    \"userId\": 10,\n" +
                "    \"id\": 198,\n" +
                "    \"title\": \"API calismaliyim\",\n" +
                "    \"completed\": true\n" +
                "}";

        HashMap expData = JsonUtil.convertJsonToJava(expJsonData, HashMap.class);

        //3) REQUEST & RESPONSE
        Response response = given().contentType(ContentType.JSON).spec(spec03).body(patchRequestJsondata).when().patch("{p1}/{p2}");

        //4) ASSERTION
        HashMap actData = JsonUtil.convertJsonToJava(response.asString(), HashMap.class);

        assertEquals(expData.get("userId"), actData.get("userId"));
        assertEquals(expData.get("title"), actData.get("title"));
        assertEquals(expData.get("completed"), actData.get("completed"));
        assertEquals(expData.get("id"), actData.get("id"));

    /*  https://jsonplaceholder.typicode.com/todos/198 URL ine aşağıdaki body gönderdiğimde
        { "title": "API calismaliyim" }
        Dönen response un status kodunun 200 ve body kısmının aşağıdaki gibi olduğunu test edin
        {
            "userId": 10,
            "id": 198,
            "title": "API calismaliyim",
            "completed": true
        }   */
    }

}



