package test;

import baseUrl.DummyBaseUrl;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.DummyTestData;
import utilities.JsonUtil;

import java.util.HashMap;

import static io.restassured.path.json.JsonPath.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

public class M19_DeleteRequest01 extends DummyBaseUrl {
    /*  http://dummy.restapiexample.com/api/v1/delete/2 bir DELETE request gönderdiğimde
        Dönen response un status kodunun 200 ve body kısmının aşağıdaki gibi olduğunu test edin
        {   "status": "success",
            "data": "2",
            "message": "Successfully! Record has been deleted"  }   */

    // Matchers without Testdata class
    @Test
    public void test01(){
        spec02.pathParams("p1", "api", "p2", "v1", "p3", "delete", "p4", "2");

        Response response = RestAssured.given().spec(spec02).when().delete("{p1}/{p2}/{p3}/{p4}");

        JSONObject expData = new JSONObject();
        expData.put("status", "success");
        expData.put("data", "2");
        expData.put("message", "Successfully! Record has been deleted");

        response.then().assertThat().statusCode(200).body("status", equalTo(expData.get("status")),
                "data", equalTo(expData.get("data")),
                "message", equalTo(expData.get("message")));
    }

    // Jsonpath
    @Test
    public void test03(){
        spec02.pathParams("p1", "api", "p2", "v1", "p3", "delete", "p4", "2");
        DummyTestData dummyTestData = new DummyTestData();
        JSONObject expData = dummyTestData.expDeleteDataObject();
        Response response = RestAssured.given().contentType(ContentType.JSON).spec(spec02).when().delete("{p1}/{p2}/{p3}/{p4}");

        JsonPath json = response.jsonPath();
        assertEquals(expData.get("status"), json.getString("status"));
        assertEquals(expData.get("data"), json.getString("data"));
        assertEquals(expData.get("message"), json.getString("message"));
    }

    // Deserialization
    @Test
    public void test04(){
        spec02.pathParams("p1", "api", "p2", "v1", "p3", "delete", "p4", "2");
        spec02.pathParams("p1", "api", "p2", "v1", "p3", "delete", "p4", "2");
        DummyTestData dummyTestData = new DummyTestData();
        JSONObject expData = dummyTestData.expDeleteDataObject();
        Response response = RestAssured.given().contentType(ContentType.JSON).spec(spec02).when().delete("{p1}/{p2}/{p3}/{p4}");
        HashMap<String, Object> actData = response.as(HashMap.class);

        assertEquals(200, response.statusCode());
        assertEquals(expData.get("status"), actData.get("status"));
        assertEquals(expData.get("data"), actData.get("data"));
        assertEquals(expData.get("message"), actData.get("message"));

    /*  public  JSONObject expDeleteDataObject() {
        JSONObject expDeleteData = new JSONObject();
        expDeleteData.put("status", "success");
        expDeleteData.put("data", "2");
        expDeleteData.put("message", "Successfully! Record has been deleted");
        return expDeleteData;   */

    /*  http://dummy.restapiexample.com/api/v1/delete/2 bir DELETE request gönderdiğimde
        Dönen response un status kodunun 200 ve body kısmının aşağıdaki gibi olduğunu test edin
        {   "status": "success",
            "data": "2",
            "message": "Successfully! Record has been deleted"  }   */
    }

    // Pojo
    @Test
    public void test05(){
        spec02.pathParams("p1", "api", "p2", "v1", "p3", "delete", "p4", "2");

        //1) URL
        //2) EXPECTED DATA
        //3) REQUEST & RESPONSE
        //4) ASSERTION

    /*  http://dummy.restapiexample.com/api/v1/delete/2 bir DELETE request gönderdiğimde
        Dönen response un status kodunun 200 ve body kısmının aşağıdaki gibi olduğunu test edin
        {   "status": "success",
            "data": "2",
            "message": "Successfully! Record has been deleted"  }   */
    }

    // ObjectMapper
    @Test
    public void test06(){

        // { "message": "Error Occured! Page Not found, contact rstapi2example@gmail.com" }

        //1) URL
        spec02.pathParams("p1", "api", "p2", "v1", "p3", "delete", "p4", "2");

        //2) EXPECTED DATA
        String deleteJsonData = "{   \"status\": \"success\",\n" +
                "            \"data\": \"2\",\n" +
                "            \"message\": \"Successfully! Record has been deleted\"  }";

        HashMap expData = JsonUtil.convertJsonToJava(deleteJsonData, HashMap.class);

        //3) REQUEST & RESPONSE
        Response response = RestAssured.given().contentType(ContentType.JSON).spec(spec02).when().delete("{p1}/{p2}/{p3}/{p4}");
        //4) ASSERTION
        HashMap actData = JsonUtil.convertJsonToJava(response.asString(), HashMap.class);

        assertEquals(expData.get("status"), actData.get("status"));
        assertEquals(expData.get("data"), actData.get("data"));
        assertEquals(expData.get("message"), actData.get("message"));

    /*  http://dummy.restapiexample.com/api/v1/delete/2 bir DELETE request gönderdiğimde
        Dönen response un status kodunun 200 ve body kısmının aşağıdaki gibi olduğunu test edin
        {   "status": "success",
            "data": "2",
            "message": "Successfully! Record has been deleted"  }   */
    }

}
