package test;

import baseUrl.DummyBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testData.RestfulTestData;
import utilities.JsonUtil;

import java.util.HashMap;
import java.util.List;

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
        HashMap<String, Object> actData = response.as(HashMap.class);

        RestfulTestData restfulTestData = new RestfulTestData();
        HashMap<String, Object> expData = restfulTestData.ExpEmployee1DataSetUp();

        Assert.assertEquals(expData.get("statusCode"), response.statusCode());
        Assert.assertEquals(expData.get("status"), actData.get("status"));
        Assert.assertEquals(expData.get("id"), (Integer) ((HashMap) actData.get("data")).get(("id")));
        Assert.assertEquals(expData.get("employee_name"), ((HashMap) actData.get("data")).get(("employee_name")));
        Assert.assertEquals(expData.get("employee_salary"), (Integer) ((HashMap) actData.get("data")).get(("employee_salary")));
        Assert.assertEquals(expData.get("employee_age"), (Integer) ((HashMap) actData.get("data")).get(("employee_age")));
        Assert.assertEquals(expData.get("profile_image"), ((HashMap) actData.get("data")).get(("profile_image")));
        Assert.assertEquals(expData.get("message"),  actData.get("message"));
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

        //1) URL
        //2) EXPECTED DATA
        //3) REQUEST & RESPONSE
        //4) ASSERTION

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

        //1) URL
        spec02.pathParams("p1", "api", "p2", "v1", "p3", "employee", "p4", "1");

        //2) EXPECTED DATA
        String jsonData = "{\n" +
                "    \"status\": \"success\",\n" +
                "    \"data\": {\n" +
                "        \"id\": 1,\n" +
                "        \"employee_name\": \"Tiger Nixon\",\n" +
                "        \"employee_salary\": 320800,\n" +
                "        \"employee_age\": 61,\n" +
                "        \"profile_image\": \"\"\n" +
                "    },\n" +
                "    \"message\": \"Successfully! Record has been fetched.\"\n" +
                "}";

        HashMap expdata = JsonUtil.convertJsonToJava(jsonData, HashMap.class);

        //3) REQUEST & RESPONSE
        Response response = given().spec(spec02).when().get("{p1}/{p2}/{p3}/{p4}");

        //4) ASSERTION
        HashMap actdata = JsonUtil.convertJsonToJava(response.asString(), HashMap.class);

        assertEquals(expdata.get("status"), actdata.get("status"));
        assertEquals(expdata.get("data.id"), actdata.get("data.id"));
        assertEquals(expdata.get("data.employee_name"), actdata.get("data.employee_name"));
        assertEquals(expdata.get("data.employee_salary"), actdata.get("data.employee_salary"));
        assertEquals(expdata.get("data.employee_age"), actdata.get("data.employee_age"));
        assertEquals(expdata.get("data.profile_image"), actdata.get("data.profile_image"));
        assertEquals(expdata.get("message"), actdata.get("message"));

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
    }

}