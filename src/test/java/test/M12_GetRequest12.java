package test;

import baseUrl.DummyBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import testData.RestfulTestData;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

public class M12_GetRequest12 extends DummyBaseUrl {

    /*
    http://dummy.restapiexample.com/api/v1/employee/1
    Status code is 200
        "status": "success",
        "data": {
            "id": 1,
            "employee_name": "Tiger Nixon",
            "employee_salary": 320800,
            "employee_age": 61,
            "profile_image": ""
            },
        "message": "Successfully! Record has been fetched."
    */

    // Matchers without Testdata class
    @Test
    public void test01(){
        spec02.pathParams("p1", "api", "p2", "v1", "p3", "employee", "p4", "1");
        Response response = given().spec(spec02).when().get("{p1}/{p2}/{p3}/{p4}");

        response.then().assertThat().statusCode(200).
                body("status", equalTo("success"),
                "data.id", equalTo(1),
                        "data.employee_name", equalTo("Tiger Nixon"),
                        "data.employee_salary", equalTo(320800),
                        "data.employee_age", equalTo(61),
                        "data.profile_image", equalTo(""),
                        "message", equalTo("Successfully! Record has been fetched."));
    }

    // Jsonpath
    @Test
    public void test03(){
        spec02.pathParams("p1", "api", "p2", "v1", "p3", "employee", "p4", "1");
        Response response = given().spec(spec02).when().get("{p1}/{p2}/{p3}/{p4}");
        RestfulTestData restfulTestData = new RestfulTestData();
        HashMap<String, Object> expData = restfulTestData.ExpEmployee1DataSetUp();

        response.then().assertThat().statusCode(equalTo(expData.get("statusCode")));
        JsonPath json = response.jsonPath();
        assertEquals(expData.get("status"), json.getString("status"));
        assertEquals(expData.get("id"), json.getInt("data.id"));
        assertEquals(expData.get("employee_name"), json.getString("data.employee_name"));
        assertEquals(expData.get("employee_salary"), json.getInt("data.employee_salary"));
        assertEquals(expData.get("employee_age"), json.getInt("data.employee_age"));
        assertEquals(expData.get("profile_image"), json.getString("data.profile_image"));
        assertEquals(expData.get("message"), json.getString("message"));

        /*
        HashMap<String, Object> expEmployee1Data = new HashMap<>();
        expEmployee1Data.put("statusCode", 200);
        expEmployee1Data.put("status", "success");
        expEmployee1Data.put("id", 1);
        expEmployee1Data.put("employee_name", "Tiger Nixon");
        expEmployee1Data.put("employee_salary", 320800);
        expEmployee1Data.put("employee_age", 61);
        expEmployee1Data.put("profile_image", "");
        expEmployee1Data.put("message", "Successfully! Record has been fetched.");
         */
    }

    // Deserialization
    @Test
    public void test04(){
        spec02.pathParams("p1", "api", "p2", "v1", "p3", "employee", "p4", "1");
        Response response = given().spec(spec02).when().get("{p1}/{p2}/{p3}/{p4}");


        /*
        http://dummy.restapiexample.com/api/v1/employee/1
        Status code is 200
        "status": "success",
        "data": {
            "id": 1,
            "employee_name": "Tiger Nixon",
            "employee_salary": 320800,
            "employee_age": 61,
            "profile_image": ""
            },
        "message": "Successfully! Record has been fetched."
        */
        /*
        HashMap<String, Object> expEmployee1Data = new HashMap<>();
        expEmployee1Data.put("statusCode", 200);
        expEmployee1Data.put("status", "success");
        expEmployee1Data.put("id", 1);
        expEmployee1Data.put("employee_name", "Tiger Nixon");
        expEmployee1Data.put("employee_salary", 320800);
        expEmployee1Data.put("employee_age", 61);
        expEmployee1Data.put("profile_image", "");
        expEmployee1Data.put("message", "Successfully! Record has been fetched.");
         */
    }

    // Pojo
    @Test
    public void test05(){
        spec02.pathParams("p1", "api", "p2", "v1", "p3", "employee", "p4", "1");
        Response response = given().spec(spec02).when().get("{p1}/{p2}/{p3}/{p4}");

        /*
        http://dummy.restapiexample.com/api/v1/employee/1
        Status code is 200
        "status": "success",
        "data": {
            "id": 1,
            "employee_name": "Tiger Nixon",
            "employee_salary": 320800,
            "employee_age": 61,
            "profile_image": ""
            },
        "message": "Successfully! Record has been fetched."
        */
        /*
        HashMap<String, Object> expEmployee1Data = new HashMap<>();
        expEmployee1Data.put("statusCode", 200);
        expEmployee1Data.put("status", "success");
        expEmployee1Data.put("id", 1);
        expEmployee1Data.put("employee_name", "Tiger Nixon");
        expEmployee1Data.put("employee_salary", 320800);
        expEmployee1Data.put("employee_age", 61);
        expEmployee1Data.put("profile_image", "");
        expEmployee1Data.put("message", "Successfully! Record has been fetched.");
        */
    }

    // ObjectMapper
    @Test
    public void test06(){
        spec02.pathParams("p1", "api", "p2", "v1", "p3", "employee", "p4", "1");
        Response response = given().spec(spec02).when().get("{p1}/{p2}/{p3}/{p4}");

        /*
        http://dummy.restapiexample.com/api/v1/employee/1
        Status code is 200
        "status": "success",
        "data": {
            "id": 1,
            "employee_name": "Tiger Nixon",
            "employee_salary": 320800,
            "employee_age": 61,
            "profile_image": ""
            },
        "message": "Successfully! Record has been fetched."
        */
        /*
        HashMap<String, Object> expEmployee1Data = new HashMap<>();
        expEmployee1Data.put("statusCode", 200);
        expEmployee1Data.put("status", "success");
        expEmployee1Data.put("id", 1);
        expEmployee1Data.put("employee_name", "Tiger Nixon");
        expEmployee1Data.put("employee_salary", 320800);
        expEmployee1Data.put("employee_age", 61);
        expEmployee1Data.put("profile_image", "");
        expEmployee1Data.put("message", "Successfully! Record has been fetched.");
        */
    }

}