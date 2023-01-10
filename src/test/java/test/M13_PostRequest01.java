package test;

import baseUrl.DummyBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.DummyTestData;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class M13_PostRequest01 extends DummyBaseUrl {
    /*
    http://dummy.restapiexample.com/api/v1/create url ine, Request Body olarak
    {
        "name":"Ahmet Aksoy",
        "salary":"1000",
        "age":"18"
    }
    gönderildiğinde,Status kodun 200 olduğunu ve dönen response body nin ,
    {
    "status": "success",
    "data": {
        "name": "Ahmet Aksoy",
        "salary": "1000",
        "age": "18",
    },
    "message": "Successfully! Record has been added."
    }   olduğunu test edin
    */


    // Matchers without Testdata class
    @Test
    public void test01(){
        spec02.pathParams("p1", "api", "p2", "v1", "p3", "create");

            JSONObject postRequestData = new JSONObject();
            postRequestData.put("name", "Ahmet Aksoy");
            postRequestData.put("salary", "1000");
            postRequestData.put("age", "18");
            postRequestData.put("status", "success");
            postRequestData.put("message", "Successfully! Record has been added.");

        Response response = given()
                .spec(spec02)
                .contentType(ContentType.JSON)
                .body(postRequestData.toString())
                .when()
                .post("{p1}/{p2}/{p3}");

        response.then().assertThat().statusCode(200).
                body("data.name", equalTo(postRequestData.get("name")),
                        "data.salary", equalTo(postRequestData.get("salary")),
                        "data.age", equalTo(postRequestData.get("age")),
                        "status", equalTo(postRequestData.get("status")),
                        "message", equalTo(postRequestData.get("message")));
    }

    // Jsonpath
    @Test
    public void test03(){
        spec02.pathParams("p1", "api", "p2", "v1", "p3", "create");

        DummyTestData dummyTestData = new DummyTestData();
        HashMap<String, Object> expData = dummyTestData.postAhmetHashMapSetup();
        Response response = given().spec(spec02).body(expData.toString()).when().post("{p1}/{p2}/{p3}");

        /*
        "status": "success",
        "message": "Successfully! Record has been added."
        }   olduğunu test edin
        */

        JsonPath json = response.jsonPath();
        Assert.assertEquals(expData.get("status"), json.getString("status"));
        Assert.assertEquals(expData.get("message"), json.getString("message"));
    }

    // Deserialization
    @Test
    public void test04(){
        spec02.pathParams("p1", "api", "p2", "v1", "p3", "create");
        /*
        http://dummy.restapiexample.com/api/v1/create url ine, Request Body olarak
        {
        "name":"Ahmet Aksoy",
        "salary":"1000",
        "age":"18"
        }
        gönderildiğinde,Status kodun 200 olduğunu ve dönen response body nin ,
        {
        "status": "success",
        "data": {
        "name": "Ahmet Aksoy",
        "salary": "1000",
        "age": "18",
        },
        "message": "Successfully! Record has been added."
        }   olduğunu test edin
    */


    }

    // Pojo
    @Test
    public void test05(){
        spec02.pathParams("p1", "api", "p2", "v1", "p3", "create");
        /*
        http://dummy.restapiexample.com/api/v1/create url ine, Request Body olarak
        {
        "name":"Ahmet Aksoy",
        "salary":"1000",
        "age":"18"
        }
        gönderildiğinde,Status kodun 200 olduğunu ve dönen response body nin ,
        {
        "status": "success",
        "data": {
        "name": "Ahmet Aksoy",
        "salary": "1000",
        "age": "18",
        },
        "message": "Successfully! Record has been added."
        }   olduğunu test edin
        */


    }

    // ObjectMapper
    @Test
    public void test06(){
        spec02.pathParams("p1", "api", "p2", "v1", "p3", "create");

        /*
        http://dummy.restapiexample.com/api/v1/create url ine, Request Body olarak
        {
        "name":"Ahmet Aksoy",
        "salary":"1000",
        "age":"18"
        }
        gönderildiğinde,Status kodun 200 olduğunu ve dönen response body nin ,
        {
        "status": "success",
        "data": {
        "name": "Ahmet Aksoy",
        "salary": "1000",
        "age": "18",
        },
        "message": "Successfully! Record has been added."
        }   olduğunu test edin
        */
    }

}
